package data;

public enum Currency {
    EURO("EUR €"),
    US_DOLLAR("USD $"),
    UA_HRYVNIA("UAH ₴");

    //
    private String name;

    private Currency(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
