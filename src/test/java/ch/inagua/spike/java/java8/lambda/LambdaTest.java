package ch.inagua.spike.java.java8.lambda;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

/**
 * Created by couvreuj on 16.11.2016.
 */
public class LambdaTest {

    @Test
    public void test_getAge() throws Exception {
        assertThat(new Lambda().getAge(), equalTo(33));
    }
}