package sigito.util;

import java.util.Map;

/**
 * @author sigito
 */
public class ToString {
    public static String mapToString(Map<?, ?> map) {
        StringBuilder builder = new StringBuilder();
        builder.append("{\n");

        for (Map.Entry<?, ?> entry : map.entrySet()) {
            builder.append('\t').append(entry.getKey()).append(" => ").append(entry.getValue()).append('\n');
        }

        builder.append("}\n");
        return builder.toString();
    }
}
