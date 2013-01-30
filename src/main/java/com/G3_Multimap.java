package com;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Stanislav  Kurilin
 */
public class G3_Multimap {
    class PureKeaper {
        final Map<Integer, List<String>> data
                = new HashMap<Integer, List<String>>();

        void put(Integer key, String value) {
            if (!data.containsKey(key))
                data.put(key, new ArrayList<String>());
            data.get(key).add(value);
        }
    }

    class GuavaKeaper {
        final Multimap<Integer, String> data
                = ArrayListMultimap.create();

        void put(Integer key, String value) {
            data.put(key, value);
        }
    }
}
