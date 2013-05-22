package sigito.coherence.entity;

import com.tangosol.net.NamedCache;
import com.tangosol.util.aggregator.ReducerAggregator;
import com.tangosol.util.filter.AlwaysFilter;

import java.util.Arrays;
import java.util.Map;

/**
 * @author sigito
 */
public class Orders {
    public static final String MR_JONES = "Mr. Jones";
    public static final String MRS_PITERSON = "Mrs. Piterson";
    public static final String MR_KARD = "Mr. Kard";

    public static void fill(NamedCache orders) {
        Order order1 = new Order(1);
        order1.setClient(MR_JONES);
        order1.setItems(Arrays.asList("Potatoes", "Peaches", "Tomatoes"));
        order1.setPrize(33.47);
        orders.put(order1.getKey(), order1);
        Order order2 = new Order(2);
        order2.setClient(MRS_PITERSON);
        order2.setItems(Arrays.asList("Coconuts", "Cabbage", "Cherries"));
        order2.setPrize(65.5);
        orders.put(order2.getKey(), order2);
        Order order3 = new Order(3);
        order3.setClient(MRS_PITERSON);
        order3.setItems(Arrays.asList("Plates", "Forks"));
        order3.setPrize(12.49);
        orders.put(order3.getKey(), order3);
        Order order4 = new Order(4);
        order4.setClient(MR_KARD);
        order4.setItems(Arrays.asList("Peaches", "Apples", "Cherries"));
        order4.setPrize(42.24);
        orders.put(order4.getKey(), order4);
    }

    public static Map<Long, Double> getPrices(NamedCache orders) {
        return (Map<Long, Double>) orders.aggregate(AlwaysFilter.INSTANCE, new ReducerAggregator("getPrize"));
    }
}
