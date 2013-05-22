package sigito.coherence.processor;

import com.tangosol.util.InvocableMap;
import sigito.coherence.entity.Order;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author sigito
 */
public class DiscountProcessor implements InvocableMap.EntryProcessor {
    private static final double DISCOUNT_LIMIT = 25.0;
    private static final double DISCOUNT = 0.05; // 5%

    @Override
    public Double process(InvocableMap.Entry entry) {
        Order order = (Order) entry.getValue();
        if(order.getPrize() >= DISCOUNT_LIMIT) {
            double newPrize = order.getPrize() * (1 - DISCOUNT);
            order.setPrize(newPrize);
        }
        return order.getPrize();
    }

    @Override
    public Map processAll(Set setEntries) {
        Map mapResults = new HashMap();
        for (InvocableMap.Entry entry : (Set<InvocableMap.Entry>) setEntries) {
            mapResults.put(entry.getKey(), process(entry));
        }
        return mapResults;
    }
}
