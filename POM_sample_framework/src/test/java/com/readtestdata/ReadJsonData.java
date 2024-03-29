package com.readtestdata;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;

public class ReadJsonData {
    public static JsonArray jsonArray;

    public static String testCase;

    public boolean loadJsonFile() {
        System.out.println("Loading json file ");
        boolean status = true;
        try {
            //parse json file
            Object obj = new JsonParser().parse(new FileReader("./Testdata/Test_Data.json"));
            JsonObject jsonObject = (JsonObject) obj;
            jsonArray = (JsonArray) jsonObject.get("Test_Data");
            System.out.println("Json File is loaded sucessfully...");

        } catch (Exception e) {
            status = false;
        }

        return status;
    }

    public String getData(String fieldName, int iteration) {
        String data = "";
        try {

            for (Object obj : jsonArray) {
                String currentTestcase = ((JsonObject) obj).get("TestCaseName").getAsString();
                String itr = ((JsonObject) obj).get("iteration").getAsString();
                if (currentTestcase.equals(testCase.trim()) && itr.equals(String.valueOf(iteration))) {
                    data = ((JsonObject) obj).get(fieldName).getAsString();
                }
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return data;

    }

}