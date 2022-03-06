import java.util.Comparator;
import java.util.List;

class StockItem {
    private String name;
    private double pricePerUnit;
    private int quantity;

    public StockItem(String name, double pricePerUnit, int quantity) {
        this.name = name;
        this.pricePerUnit = pricePerUnit;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return name + ": " + pricePerUnit + ", " + quantity + ";";
    }

    public String getName() {
        return name;
    }

    public Double getPricePerUnit() {
        return pricePerUnit;
    }

    public Integer getQuantity() {
        return quantity;
    }
}

class Utils {
    public static List<StockItem> sort(List<StockItem> stockItems) {
        List<StockItem> ret = new java.util.ArrayList<>(List.copyOf(stockItems));
        Comparator<StockItem> comparator = Comparator
                .comparing(s -> s.getPricePerUnit() * s.getQuantity());
        ret.sort(comparator.reversed());
        return ret;
    }
}