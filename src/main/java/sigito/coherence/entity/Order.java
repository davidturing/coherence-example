package sigito.coherence.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author sigito
 */
public class Order implements Cacheable<Long>, Serializable {
    private final long id;

    private String client;
    private List<String> items;
    private double prize;

    public Order(long id) {
        this.id = id;
    }

    @Override
    public Long getKey() {
        return id;
    }

    public long getId() {
        return id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public double getPrize() {
        return prize;
    }

    public void setPrize(double prize) {
        this.prize = prize;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", client='" + client + '\'' +
                ", items=" + items +
                ", prize=" + prize +
                '}';
    }
}
