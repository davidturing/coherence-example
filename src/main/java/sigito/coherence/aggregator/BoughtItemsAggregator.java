package sigito.coherence.aggregator;

import com.tangosol.util.InvocableMap;
import sigito.coherence.entity.Order;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sigito
 */
public class BoughtItemsAggregator implements InvocableMap.EntryAggregator {
    @Override
    public Set<String> aggregate(Set set) {
        Set<String> boughtItems = new HashSet<>();

        for (InvocableMap.Entry orderEntry : (Set<InvocableMap.Entry>)set) {
            Order order = (Order) orderEntry.getValue();
            boughtItems.addAll(order.getItems());
        }

        return boughtItems;
    }
}
