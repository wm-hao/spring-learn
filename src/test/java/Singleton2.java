public class Singleton2 {

    private Singleton2() {

    }

    private static final Singleton2 singleton = new Singleton2();

    public static Singleton2 getInstance() {
        return singleton;
    }

}
