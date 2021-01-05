package me.uwu.colapte.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class CancerUtils {
    public static String decancer(String cancer){
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("decancer.txt"), StandardCharsets.UTF_8))) {

            String cLine;
            while ((cLine = br.readLine()) != null) {
                sb.append(cLine).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] lines = sb.toString().split("\n");
        for (String line : lines){
            String[] characters = line.split(",");
            cancer = cancer.replace(characters[0], characters[1]);
        }

        return cancer;
    }
}
