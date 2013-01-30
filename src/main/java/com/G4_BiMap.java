package com;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;

/**
 * @author Stanislav  Kurilin
 */
public class G4_BiMap {
    BiMap<String, Integer> data
            = ImmutableBiMap.of("three", 3, "seven", 7, "twelve", 12);
    Integer getByString(String key){
        return data.get(key);
    }
    String getByInt(Integer key){
        return data.inverse().get(key);
    }

}
