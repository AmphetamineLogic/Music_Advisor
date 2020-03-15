package advisor;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class PrintData {
    static Gson gson = new Gson();

    static void printNewAlbums(String jsonAlbumsReponse) {
        JsonObject jsonObject = JsonParser.parseString(jsonAlbumsReponse).getAsJsonObject();
        AlbumsResponse albumsResponse = gson.fromJson(jsonObject, AlbumsResponse.class);
        for (Album album: albumsResponse.albums.items
             ) {
            System.out.println(album);
        }
    }

    static void printPlaylists(String jsonPlaylistsResponse) {
        JsonObject jsonObject = JsonParser.parseString(jsonPlaylistsResponse).getAsJsonObject();
        PlaylistsResponse playlistsResponse = gson.fromJson(jsonObject, PlaylistsResponse.class);
        if (jsonPlaylistsResponse.contains("\"message\" : \"Specified id doesn't exist\"")) {
            System.out.println("Unknown category name.");
        }
        else {
            for (Playlist playlist : playlistsResponse.playlists.items
            ) {
                System.out.println(playlist);
            }
        }
    }

    static void printCategories(String jsonCategories) {
        JsonObject jsonObject = JsonParser.parseString(jsonCategories).getAsJsonObject();
        CategoriesResponse categoriesResponse = gson.fromJson(jsonObject, CategoriesResponse.class);
        for (Category category: categoriesResponse.categories.items
             ) {
            System.out.println(category.getName());
        }
    }

}
