package sigito.coherence;

import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;
import com.tangosol.util.Filter;
import com.tangosol.util.InvocableMap;
import com.tangosol.util.aggregator.DoubleAverage;
import com.tangosol.util.filter.EqualsFilter;
import sigito.coherence.entity.Orders;
import sigito.util.ToString;

/**
 * @author sigito
 */
public class AveragePrizeAggregatorTest {
    public static void main(String[] args) {
        NamedCache orders = CacheFactory.getCache("orders");
        Orders.fill(orders);
        System.out.println("Cache state: " + ToString.mapToString(orders));

        Filter selectByClientIdFilter = new EqualsFilter("getClient", Orders.MRS_PITERSON);
        InvocableMap.EntryAggregator averageBillAggregator = new DoubleAverage("getPrize");
        Double averageBill = (Double) orders.aggregate(selectByClientIdFilter, averageBillAggregator);

        System.out.println("Average " + Orders.MRS_PITERSON + " bill is " + averageBill);
    }
}
