package advisor;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

public class PrintData {
    static void printNewAlbums(String jsonNewAlbums) {
        Gson gson = new Gson();
        JsonObject jsonObject = JsonParser.parseString(jsonNewAlbums).getAsJsonObject();
        NewAlbums newAlbums = gson.fromJson(jsonObject, NewAlbums.class);
        System.out.println("here");
    }
}
