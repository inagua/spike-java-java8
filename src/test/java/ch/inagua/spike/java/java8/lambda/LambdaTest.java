package ch.inagua.spike.java.java8.lambda;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

/**
 * http://www-igm.univ-mlv.fr/~dr/XPOSE2013/JDK18/lambdas.php
 * https://www.mkyong.com/java8/java-8-lambda-comparator-example/
 * http://www.jmdoudoux.fr/java/dej/chap-lambdas.htm
 */
public class LambdaTest {

    @Test
    public void test_comparator() {
        List<String> names = Arrays.asList("22", "55555", "1", "4444", "333");

        names.sort((a, b) -> a.length() - b.length());
        assertThat(names, equalTo(Arrays.asList("1", "22", "333", "4444", "55555")));
    }

    // ============================================================================================

    @Test
    public void test_immutable() throws Exception {
        List<String> names = Arrays.asList("22", "55555", "1", "4444", "333");

        Map<String, String> immutableMap = new HashMap<>();
        int immutableInt = 2;

        names.sort((a, b) -> {
            immutableMap.put(a, "" + new Date());
            immutableMap.put(b, "" + new Date());
            // immutableInt = 42;// DO NOT COMPILE!
            int count = immutableInt + 1;
            return a.length() - b.length();
        });
        assertThat(immutableMap.keySet(), hasSize(names.size()));
    }

    // ============================================================================================

    @FunctionalInterface // Optional
    public interface Operator {
        double operate(long x, long y);
    }

    public class Calculator {
        Operator add;
        Operator minus;
    }

    @Test
    public void test_operator() {
        Calculator calculator = new Calculator();

        calculator.add = (x, y) -> { return x + y; };
        assertThat(calculator.add.operate(1, 2), equalTo(3.));

        calculator.minus = (x, y) -> x - y ;
        assertThat(calculator.minus.operate(2, 1), equalTo(1.));
    }
}