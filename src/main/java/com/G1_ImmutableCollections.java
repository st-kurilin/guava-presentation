package com;

import com.google.common.collect.*;

import java.util.*;

import static com.google.common.collect.Maps.newHashMap;

/**
 * @author Stanislav  Kurilin
 */
public class G1_ImmutableCollections {
    public static final Set<Integer> LUCKY_NUMBERS;

    static {
        Set<Integer> set = new LinkedHashSet<Integer>();
        set.add(3);
        set.add(7);
        set.add(12);
        LUCKY_NUMBERS = Collections.unmodifiableSet(set);
    }


    public static final Set<Integer> LUCKY_NUMBERS2
            = Collections.unmodifiableSet(
            new LinkedHashSet<Integer>(
                    Arrays.asList(3, 7, 12)));

    public static final Set<Integer> LUCKY_NUMBERS3
            = Collections.unmodifiableSet(
            new LinkedHashSet<Integer>() {{
                add(3);
                add(7);
                add(12);
            }});

    public static final ImmutableSet<Integer> LUCKY_NUMBERS_F
            = ImmutableSet.of(3, 7, 12);


    public static final Map<String, Integer> ENGLISH_TO_INT;

    static {
        final Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("three", 3);
        map.put("seven", 7);
        map.put("twelve", 12);
        ENGLISH_TO_INT = Collections.unmodifiableMap(map);
    }


    public static final Map<String, Integer> ENGLISH_TO_INT_F
            = ImmutableMap.of("three", 3, "seven", 7, "twelve", 12);


    public class PureDoer {
        private final Set<Integer> luckyNumbers;

        public PureDoer(Set<Integer> luckyNumbers) {
            this.luckyNumbers = Collections.unmodifiableSet(
                    new HashSet<Integer>(luckyNumbers));
        }
        /*It's immutable set. I've done all in right way.
        I will never change it. I promise.*/
        public Set<Integer> getLuckyNumbers() {
            return luckyNumbers;
        }
    }

    public class GuavaDoer {
        private final ImmutableSet<Integer> luckyNumbers;

        public GuavaDoer(Set<Integer> luckyNumbers) {
            this.luckyNumbers = ImmutableSet.copyOf(luckyNumbers);
        }

        public ImmutableSet<Integer> getLuckyNumbers() {
            return luckyNumbers;
        }
    }
    public List<String> read(Scanner data){
        final ImmutableList.Builder<String> builder = ImmutableList.builder();
        while (data.hasNext())
            builder.add(data.next());
        return builder.build();
    }

    {
        Lists.newLinkedList();
        newHashMap();
        Lists.newArrayListWithCapacity(10);
        Map<String, List<String>> a
                = new HashMap<String, List<String>>();
        Map<String, List<String>> b = newHashMap();


    }

}
