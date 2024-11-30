import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Order {

    private final int orderId;
    private final List<String> items;

    public Order(int orderId, List<String> items) {
        this.orderId = orderId;
        this.items = List.copyOf(items);
    }

    public int getOrderId() {
        return orderId;
    }

    public List<String> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", items=" + items +
                '}';
    }
}
