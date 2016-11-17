package ch.inagua.spike.java.java8.trait;

/**
 * See http://www.journaldev.com/2752/java-8-interface-changes-static-method-default-method
 */
public interface MyInterface {

    String doItAsYouWant();

    default String doItWithDefault() {
        return "Hello from Interface";
    }

}
