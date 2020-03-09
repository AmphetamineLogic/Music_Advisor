package advisor;

import java.util.Arrays;

public class Artist {
    String name;
    public Artist (String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
