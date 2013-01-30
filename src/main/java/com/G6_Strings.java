package com;

import com.google.common.base.Splitter;

import java.util.Arrays;

/**
 * @author Stanislav  Kurilin
 */
public class G6_Strings {
    void testSplit(){
        System.out.println(Arrays.toString(",a,,b,".split(",")));
    }

    public static void main(String[] args) {
        new G6_Strings().testSplit();
    }

    {
        Splitter.on(',')
                .trimResults()
                .omitEmptyStrings()
                .split("foo,bar,,   qux");
    }



}
