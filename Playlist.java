package advisor;

class Playlist {
    String name;
    String href;

    public Playlist (String name, String href) {
        this.name = name;
        this.href = href;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name);
        stringBuilder.append("\n");
        stringBuilder.append(href);
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
