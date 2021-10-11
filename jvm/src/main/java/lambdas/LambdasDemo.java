package lambdas;

import static support.PrintSupport.print;

public class LambdasDemo {

    public static void main(String[] args) {
        print("Constructed object reference is eager", LambdasDemo::constructedObjectReference);
    }

    private static void constructedObjectReference() {
        @SuppressWarnings("unused") Runnable useless = new Useless()::doSomethingUseful;
        System.out.println("The runnable above is never called but Useless instance was instantiated nonetheless");
    }

    private static final class Useless {

        private Useless() {
            System.out.println("I am absolutely useless");
        }

        void doSomethingUseful() {
            throw new UnsupportedOperationException();
        }
    }
}
