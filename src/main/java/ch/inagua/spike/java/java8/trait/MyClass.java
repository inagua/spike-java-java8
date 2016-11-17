package ch.inagua.spike.java.java8.trait;

/**
 * See http://www.journaldev.com/2752/java-8-interface-changes-static-method-default-method
 */
public class MyClass implements MyInterface {

    @Override public String doItAsYouWant() {
        return "Hello from Class";
    }

}
