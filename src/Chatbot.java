import com.mysql.cj.xdevapi.JsonParser;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Chatbot {
    public static String responseTo(int userId, String message) {
        try {
            // URL to send the POST request
            URL url = new URL("https://generativelanguage.googleapis.com/v1beta/models/gemini-pro:generateContent?key=" + System.getenv("GEMINI_API_KEY"));

            // Open a connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set request method to POST
            connection.setRequestMethod("POST");

            // Set Content-Type header
            connection.setRequestProperty("Content-Type", "application/json");

            // Enable output and set request body
            connection.setDoOutput(true);

//            String requestBody = "{\"contents\": [" + formatConversation(userId) + "{\"role\": \"user\", \"parts\": [{\"text\": \"" + message + "\"}]}]}";
            JSONArray contents = formatConversation(userId);
            JSONObject object = new JSONObject();
            object.put("role", "user");
            JSONArray parts = new JSONArray();
            JSONObject partsObj = new JSONObject();
            partsObj.put("text", message);
            parts.put(partsObj);
            object.put("parts", parts);
            contents.put(object);
            String requestBody = "{\"contents\": " + contents.toString() + "}";
            try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
                wr.write(requestBody.getBytes());
            }
//            System.out.println(requestBody);

            // Get the response code
            int responseCode = connection.getResponseCode();
//            System.out.println("Response Code: " + responseCode);

            // Read the response
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Close the connection
            connection.disconnect();

            JSONObject jsonObject = new JSONObject(response.toString());
            String res = jsonObject.getJSONArray("candidates").getJSONObject(0).getJSONObject("content").
                    getJSONArray("parts").getJSONObject(0).getString("text");

//            appendConversationLog("user", message);
//            appendConversationLog("model", res);
            Account.addMessage(userId, "user", message);
            Account.addMessage(userId, "model", res);

            return res;
        } catch (IOException e) {
            e.printStackTrace();
            return "An error occurred.";
        }
    }

//    private static String getConversation() {
//        StringBuilder res = new StringBuilder();
//
////        {\"role\": \"user\", \"parts\": [{\"text\": \"" + message + "\"}]}
//
//        try (BufferedReader reader = new BufferedReader(new FileReader("conversation.txt"))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                Matcher matcher = Pattern.compile("\\\"(.*)\\\",\\\"(.*)\\\"").matcher(line);
//                if (matcher.find()) {
//                    res.append("{\"role\": \"").append(matcher.group(1)).append("\", \"parts\": [{\"text\": \"").append(matcher.group(2)).append("\"}]}, ");
//                }
//            }
//            return res.toString();
//        } catch (IOException e) {
//            System.out.println("Error reading conversation log.");
//            e.printStackTrace();
//            return "";
//        }
//    }
//
//    private static void appendConversationLog(String role, String message) {
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter("conversation.txt", true))) {
//            writer.write("\"" + role + "\",\"" + message + "\"\n");
//        } catch (IOException e) {
//            System.out.println("Error writing conversation log.");
//            e.printStackTrace();
//        }
//    }

//    {\"role\": \"user\", \"parts\": [{\"text\": \"" + message + "\"}]}

    private static JSONArray formatConversation(int userId) {
        List<String[]> list = Account.getConversation(userId);
        JSONArray resJson = new JSONArray();
//        StringBuilder res = new StringBuilder();

        for (final String[] strings : list) {
            JSONObject object = new JSONObject();
            object.put("role", strings[0]);
            JSONArray parts = new JSONArray();
            JSONObject partsObj = new JSONObject();
            partsObj.put("text", strings[1]);
            parts.put(partsObj);
            object.put("parts", parts);
            resJson.put(object);
//            res.append("{\"role\": \"").append(strings[0]).append("\", \"parts\": [{\"text\": \"").append(strings[1].replace("\n", "\\n")).append("\"}]}, ");
        }

//        return res.toString();
        return resJson;
    }
}
