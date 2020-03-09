package advisor;

import java.util.Arrays;

public class Album {
    String name;
    Artist[] artists;
    String href;

    public Album (String name, Artist[] artists, String href) {
        this.name = name;
        this.artists = artists.clone();
        this.href = href;
    }

    @Override
    public String toString() {
        return name + "\n" + Arrays.toString(artists) + "\n" + href;
    }
}
