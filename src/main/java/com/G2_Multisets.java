package com;

import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multiset;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Stanislav  Kurilin
 */
public class G2_Multisets {
    static interface WordCount {
        Set<String> distinct();

        int countForWord(String word);

        int totalCount();
    }

    static class PureWordCount implements WordCount {
        final Map<String, Integer> counts;

        PureWordCount(Collection<String> words) {
            counts = new HashMap<String, Integer>();
            for (String word : words) {
                Integer count = counts.get(word);
                if (count == null) {
                    counts.put(word, 1);
                } else {
                    counts.put(word, count + 1);
                }
            }
        }

        public Set<String> distinct() {
            return counts.keySet();
        }

        public int countForWord(String word) {
            return counts.containsKey(word)
                    ? counts.get(word)
                    : 0;
        }

        public int totalCount() {
            int total = 0;
            for (Integer each : counts.values()) {
                total += each;
            }
            return total;
        }
    }

    static class GuavaWordCount implements WordCount {
        final Multiset<String> wordsMultiset;

        GuavaWordCount(Collection<String> words) {
            wordsMultiset = ImmutableMultiset.copyOf(words);
        }

        public Set<String> distinct() {
            return wordsMultiset.elementSet();
        }

        public int countForWord(String word) {
            return wordsMultiset.count(word);
        }

        public int totalCount() {
            return wordsMultiset.size();
        }
    }

    public static void main(String[] args) {
        final ImmutableSet<String> strings = ImmutableSet.of("foo", "foo", "bar");

        final WordCount pureWordCount = new PureWordCount(strings);
        System.out.println(pureWordCount.distinct());
        System.out.println(pureWordCount.countForWord("foo"));
        System.out.println(pureWordCount.countForWord("FOO"));
        System.out.println(pureWordCount.totalCount());

        final WordCount guavaWordCount = new GuavaWordCount(strings);
        System.out.println(guavaWordCount.distinct());
        System.out.println(guavaWordCount.countForWord("foo"));
        System.out.println(guavaWordCount.countForWord("FOO"));
        System.out.println(guavaWordCount.totalCount());


    }
}
