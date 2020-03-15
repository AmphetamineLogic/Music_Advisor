package advisor;

class Category {
    private String name;
    private String id;
    private String href;

    Category (String name, String id, String href) {
        this.name = name;
        this.id = id;
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

    public String getName() {
        return this.name;
    }
}
