public class Singleton {

    private Singleton() {

    }

    private static volatile Singleton singleton;

    public static Singleton getInstance() {
        if (null == singleton) {
            synchronized (Singleton.class) {
                if (null == singleton) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

}
