package ch.inagua.spike.java.java8.trait;

/**
 * See http://www.journaldev.com/2752/java-8-interface-changes-static-method-default-method
 */
public interface MyInterface {

    String doItAsYouWant();

    default String doItWithDefault() {
        return "Hello from Interface";
    }

    // Not overridden by method of child class with same signature
    static int compute(int a, int b) {
        // System.out.println("INTERFACE");
        return a + b;
    }
}
