package ch.inagua.spike.java.java8.trait;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * See http://www.journaldev.com/2752/java-8-interface-changes-static-method-default-method
 */
public class TraitTest {

    @Test
    public void test_Iterable_forEach() throws Exception {
        List<String> names = Arrays.asList("John", "Tim", "Bob");

        final List<String> uppercaseNames = new ArrayList<>();
        names.forEach(n -> uppercaseNames.add(n.toUpperCase()));

        assertThat(uppercaseNames, hasSize(3));
        assertThat(uppercaseNames.get(0), equalTo("JOHN"));
        assertThat(uppercaseNames.get(1), equalTo("TIM"));
        assertThat(uppercaseNames.get(2), equalTo("BOB"));
   }

    @Test
    public void test_MyInterface() throws Exception {
        {
            MyInterface myInterface = new MyClass();
            assertThat(myInterface.doItAsYouWant(), equalTo("Hello from Class"));
            assertThat(myInterface.doItWithDefault(), equalTo("Hello from Interface"));
        }
        {
            MyClass myClass = new MyClass();
            assertThat(myClass.doItAsYouWant(), equalTo("Hello from Class"));
            assertThat(myClass.doItWithDefault(), equalTo("Hello from Interface"));
        }
        {
            MyInterface myInterface = new MyClass() {
                @Override public String doItWithDefault() {
                    return "Hello from Interface overriden in Class";
                }
            };
            assertThat(myInterface.doItAsYouWant(), equalTo("Hello from Class"));
            assertThat(myInterface.doItWithDefault(), equalTo("Hello from Interface overriden in Class"));
        }
   }
}