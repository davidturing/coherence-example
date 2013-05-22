package sigito.coherence;

import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;
import com.tangosol.util.Filter;
import com.tangosol.util.InvocableMap;
import com.tangosol.util.filter.AlwaysFilter;
import sigito.coherence.entity.Orders;
import sigito.coherence.processor.DiscountProcessor;
import sigito.util.ToString;

import java.util.Map;

/**
 * @author sigito
 */
public class OwnDiscountProcessorTest {
    public static void main(String[] args) {
        NamedCache orders = CacheFactory.getCache("orders");
        Orders.fill(orders);
        System.out.println("Prices before discount: " + ToString.mapToString(Orders.getPrices(orders)));

        Filter allOrdersFilter = AlwaysFilter.INSTANCE;
        InvocableMap.EntryProcessor discountProcessor = new DiscountProcessor();
        Map<Long, Double> afterDiscount = orders.invokeAll(allOrdersFilter, discountProcessor);

        System.out.println("Prices after discount: " + ToString.mapToString(afterDiscount));
    }
}
