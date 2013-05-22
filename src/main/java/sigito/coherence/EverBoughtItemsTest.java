package sigito.coherence;

import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;
import com.tangosol.util.Filter;
import com.tangosol.util.InvocableMap;
import com.tangosol.util.filter.AlwaysFilter;
import sigito.coherence.aggregator.BoughtItemsAggregator;
import sigito.coherence.entity.Orders;
import sigito.util.ToString;

import java.util.Set;

/**
 * @author sigito
 */
public class EverBoughtItemsTest {
    public static void main(String[] args) {
        NamedCache orders = CacheFactory.getCache("orders");
        Orders.fill(orders);
        System.out.println("Cache state: " + ToString.mapToString(orders));

        Filter allOrdersFilter = AlwaysFilter.INSTANCE;
        InvocableMap.EntryAggregator boughtItemsAggregator = new BoughtItemsAggregator();
        Set<String> boughtItems = (Set<String>) orders.aggregate(allOrdersFilter, boughtItemsAggregator);

        System.out.println("Ever bought items: " + boughtItems);
    }
}
