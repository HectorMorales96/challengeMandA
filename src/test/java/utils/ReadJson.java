package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.JsonObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJson {
    public JSONArray getDataFromJson(String pathToJson) {
        JSONParser jsonParser = new JSONParser();
        JSONArray json = null;
        try {
            FileReader reader = new FileReader(pathToJson);
            //Read JSON file
            JsonObject obj = (JsonObject) jsonParser.parse(reader);
            System.out.println(obj.getAsJsonArray());
            //json = (JSONArray) obj;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return json;
    }
}
