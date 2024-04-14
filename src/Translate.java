import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Translate {
    public static String en2Vi(String text) {
        String res = "";
        try {
            res = translate("en", "vi", text);
        } catch (Exception e) {
            System.out.println("Server didn't response");
        }
        return res;
    }

    public static String vi2En(String text) {
        String res = "";
        try {
            res = translate("vi", "en", text);
        } catch (Exception e) {
            System.out.println("Server didn't response");
        }
        return res;
    }

    private static String translate(String langFrom, String langTo, String text) throws IOException {
        String API_Key = System.getenv("TRANSLATE_API_KEY");
        String urlStr = "https://script.google.com/macros/s/" + API_Key + "/exec" +
                "?q=" + URLEncoder.encode(text, "UTF-8") +
                "&target=" + langTo +
                "&source=" + langFrom;
        URL url = new URL(urlStr);
        StringBuilder response = new StringBuilder();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }
}
