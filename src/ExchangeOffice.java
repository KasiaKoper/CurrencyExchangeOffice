
import java.util.HashMap;
import java.util.Map;

public class ExchangeOffice {

    private Map<Currency, Double> availableFunds;                //zawsze w kolekcjach uzywamy zmiennych zlozonych (tutaj Double zamiast double)

    //konstruktor
    public ExchangeOffice(double startFunds) {
        this.availableFunds = new HashMap<>();            //inicjalizujemy mape tworzac obiekt, a nie wczesniej, zeby nie zabierac niepotrzebnie pamieci, jesli obiekt nie zostanie stworzony
        for (Currency c : Currency.values()) {                 //values to metoda przypisana domyslnie do enumów
            availableFunds.put(c, startFunds);
        }
    }

    public void showFunds() {
        System.out.println("Currency funds: ");
        for (Map.Entry<Currency, Double> entry : availableFunds.entrySet()) {
            Currency key = entry.getKey();
            Double value = entry.getValue();
            System.out.println(value + " " + key.getName());
        }
    }

    public void exchange(double amount, Currency from, Currency to) {

        double available = availableFunds.get(to);            //todo *
        double needed = amount * 0.8 * CurrencyConverter.convert(from, to);

        if (available >= needed) {
            availableFunds.put(from,availableFunds.get(from)+amount);
            availableFunds.put(to,availableFunds.get(to)-needed);

            System.out.println("Exchanging "+amount + " "+from.getName()+ " to "+ needed+" "+to.getName());
        }else{
            System.out.println("Cannot exchange "+amount + " "+from.getName()+ " to "+ needed+" "+to.getName() );
        }
    }

}
