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
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name);
        stringBuilder.append("\n");
        stringBuilder.append(Arrays.toString(artists));
        stringBuilder.append("\n");
        stringBuilder.append(href);
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
