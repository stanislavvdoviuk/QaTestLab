package data;

public enum Languages {
    UKRAINIAN("Українська"),
    RUSSIAN("Русский");

    //
    private String name;

    private Languages(String name) {

        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
