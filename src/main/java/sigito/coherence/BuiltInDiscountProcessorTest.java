package sigito.coherence;

import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;
import com.tangosol.util.Filter;
import com.tangosol.util.InvocableMap;
import com.tangosol.util.filter.GreaterEqualsFilter;
import com.tangosol.util.processor.NumberMultiplier;
import sigito.coherence.entity.Orders;
import sigito.util.ToString;

import java.util.Map;

/**
 * @author sigito
 */
public class BuiltInDiscountProcessorTest {
    public static void main(String[] args) {
        NamedCache orders = CacheFactory.getCache("orders");
        Orders.fill(orders);
        System.out.println("Prices before discount: " + ToString.mapToString(Orders.getPrices(orders)));

        Filter allOrdersFilter = new GreaterEqualsFilter("getPrize", 25.0);
        InvocableMap.EntryProcessor discountProcessor = new NumberMultiplier("Prize", 1 - 0.1, false);
        Map<Long, Double> afterDiscount = orders.invokeAll(allOrdersFilter, discountProcessor);

        System.out.println("Prices after discount: " + ToString.mapToString(afterDiscount));
    }
}
