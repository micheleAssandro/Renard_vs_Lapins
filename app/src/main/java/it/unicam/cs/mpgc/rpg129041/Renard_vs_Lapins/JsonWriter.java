package it.unicam.cs.mpgc.rpg129041.Renard_vs_Lapins;


import java.io.FileWriter;
import java.io.IOException;

public class JsonWriter {

    public static void save(Result result) {
        String json = "{\n" +
                "  \"playerName\": \"" + result.playerName + "\",\n" +
                "  \"noOfRabbitSurvived\": \"" + result.noOfRabbitSurvived + "\",\n" +
                "  \"winner\": \"" + result.winner + "\"\n" +
                "}";

        try (FileWriter file = new FileWriter("result.json")) {
            file.write(json);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}