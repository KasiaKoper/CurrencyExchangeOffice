
public enum Currency {

    USD("USD"),
    EUR("EUR"),
    PLN("PLN");

    private String name;

    Currency(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
