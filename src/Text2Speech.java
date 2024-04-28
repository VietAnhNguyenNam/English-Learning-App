import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

//import javax.speech.Central;
//import javax.speech.synthesis.Synthesizer;
//import javax.speech.synthesis.SynthesizerModeDesc;
//import java.util.Locale;

public class Text2Speech {
    public static void speak(String text) {
//        try {
//            System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_time_awb.AlanVoiceDirectory");
//
//            // Initialize the VoiceManager
//            VoiceManager voiceManager = VoiceManager.getInstance();
//
//            // Choose Alan's voice
//            Voice alanVoice = voiceManager.getVoice("alan");
//
//            if (alanVoice == null) {
//                System.err.println("Cannot find Alan's voice. Please check if the voice name is correct.");
//                System.exit(1);
//            }
//
//            Voice []voices = voiceManager.getVoices();
//            for (Voice voice : voices) {
//                System.out.println("# voice: " + voice.getName());
//                System.out.println("# voice: " + voice.getDescription());
//                System.out.println("# voice: " + voice.getVolume());
//                System.out.println("# voice: " + voice.getPitch());
//                System.out.println("# voice: " + voice.getRate());
//                System.out.println("# voice: " + voice.getDomain());
//            }
//
//            // Allocate the chosen voice
//            alanVoice.allocate();
//
//            // Say something in Alan's voice
//            alanVoice.speak(text);
//
//            // Deallocate the voice
//            alanVoice.deallocate();
//
//        }
//
//        catch (Exception e) {
//            e.printStackTrace();
//        }

        String voiceName = "kevin16";

//        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_time_awb.AlanVoiceDirectory");
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");

        VoiceManager voiceManager = VoiceManager.getInstance();

        Voice voice = voiceManager.getVoice(voiceName);

        if (voice == null) {
            System.err.println("Cannot find a voice named " + voiceName + ". Please check the available voices.");
            System.exit(1);
        }

        voice.allocate();

        voice.speak(text);

        voice.deallocate();
    }
}

//import java.io.*;
//
//public class Text2Speech {
//    public static void speak(String text) {
//        try {
//            String[] command = {
//                    "cmd",
//                    "/c",
//                    "%espeak%",
//                    "-ven+m3",
//                    "\"" + text + "\""
//            };
//
//            ProcessBuilder pb = new ProcessBuilder(command);
//            pb.redirectErrorStream(true);
//
//            pb.environment().put("espeak", "\"C:\\Program Files (x86)\\eSpeak\\command_line\\espeak\"");
//
//            Process process = pb.start();
//
//            int exitCode = process.waitFor();
//            if (exitCode != 0) {
//                System.out.println("Error executing eSpeak command. Exit code: " + exitCode);
//            }
//
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//
//}