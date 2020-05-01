package data;

public enum SortBy {
    RELEVANCE("Релевантность"),
    NAME_AZ("Названию: от А к Я"),
    NAME_ZA("Названию: от Я к А"),
    PRICE_LOW_HIGH("Цене: от низкой к высокой"),
    PRICE_HIGH_LOW("Цене: от высокой к низкой");

    private String filter;

    SortBy(String filter) {
        this.filter = filter;
    }

    @Override
    public String toString() {
        return filter;
    }
}
