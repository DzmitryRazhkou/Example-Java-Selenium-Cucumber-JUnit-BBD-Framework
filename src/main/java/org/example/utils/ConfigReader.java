package org.example.utils;

import org.example.constants.Paths;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class ConfigReader {

    private ConfigReader() throws Exception {
        throw new Exception();
    }

    public static Properties initializeProperties() {
        Properties prop = null;
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(Paths.CONFIG);
            try {
                prop.load(ip);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return prop;
    }

    public static Map<String, List<String>> getListFromJSONKey(String filename, String key) {
        Map<String, List<String>> testData = null;

        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(filename))    // lire de fichier JSON
        {
            Object object = jsonParser.parse(reader);
            JSONObject jsonObject = (JSONObject) object;

            testData = (Map<String, List<String>>) jsonObject.get(key);
        } catch (ParseException | IOException fnfe) {
            fnfe.printStackTrace();
        }

        return testData;
    }
}
