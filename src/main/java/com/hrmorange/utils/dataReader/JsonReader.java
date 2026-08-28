package com.hrmorange.utils.dataReader;

import com.jayway.jsonpath.JsonPath;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class JsonReader {

    private final String TEST_DATA_PATH = "src/test/resources/test-data/";

    String jsonReader;
    String jsonFileName;

    public JsonReader(String jsonFileName) {
        this.jsonFileName = jsonFileName;
        try {
            JSONObject data = (JSONObject) new JSONParser().parse(new FileReader(TEST_DATA_PATH + jsonFileName + ".json"));
            jsonReader = data.toJSONString();
        } catch (Exception e) {
            System.out.println("Error reading json file");
        }
    }


    /**
     *
     * @param jsonPath
     * @return
     */
    public String getJsonData(String jsonPath) {
        try {
            return JsonPath.read(jsonReader, jsonPath);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Failed to read JSON path: " + jsonPath, e
            );
        }
    }
}