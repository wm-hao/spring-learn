import java.util.Arrays;

public class SingletonTest {

    public static void main(String[] args) {
        Singleton a = Singleton.getInstance();
        Singleton b = Singleton.getInstance();
        Singleton c = Singleton.getInstance();
        Singleton d = Singleton.getInstance();
        System.out.println(a == b);
        for (int i = 0; i < 100; i++) {
            Singleton e = Singleton.getInstance();
            System.out.println(e);
        }
        Singleton2 a2 = Singleton2.getInstance();
        Singleton2 a3 = Singleton2.getInstance();
        System.out.println(a2 == a3);
        int[] arr = {23,12,35,3,5,56,32,57};
        bubbleSort(arr);
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0;i<arr.length-1;i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j] > arr[j+1]) {
                    int t = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = t;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
