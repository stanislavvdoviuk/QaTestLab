package data;

public enum CurrencySymbol {
    EURO("€"),
    US_DOLLAR("$"),
    UA_HRYVNIA("₴");

    //
    private String name;

    private CurrencySymbol(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
