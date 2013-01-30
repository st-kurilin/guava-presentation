package com;

import com.google.common.base.Optional;

/**
 * @author Stanislav  Kurilin
 */
public class G5_Optional {
    void foo() {
        Optional<Integer> possible
                = Optional.of(5);
        possible.isPresent();   // returns true
        possible.get();         // returns 5
    }
    void bar() {
        Optional<Integer> possible = Optional.fromNullable(null);
        possible.isPresent();   // returns false
        possible.get();         // throws ISE
    }

}
