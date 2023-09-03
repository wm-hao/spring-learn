public class Climbing {


    public static int func(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return func(n - 1) + func(n - 2);
    }

    public static int cacheFunc(int n, int[] arr) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (arr[n] > 0) {
            return arr[n];
        }
        arr[n] = cacheFunc(n - 1, arr) + cacheFunc(n - 2, arr);
        return arr[n];
    }


    public static int dynamicPlan(int n) {

        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    public static int fibonacci(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int a = 1;
        int b = 2;
        int c = 0;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static int fibonacciBetter(int n) {
        if (n == 1) {
            return 1;
        }
        int a = 1;
        int b = 1;
        while (--n > 0) {
            b = a + b;
            a = b - a;
        }
        return b;
    }

    public static int nb(int n) {
        double sqrt5 = Math.sqrt(5d);
        double f = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
        return (int) (f / sqrt5);
    }

    public static int mn(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        int[][] map = new int[m][n];
        for (int i = 0; i < m; i++) {
            map[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            map[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                map[i][j] = map[i - 1][j] + map[i][j - 1];
            }
        }
        return map[m - 1][n - 1];
    }

    public static int mnMin(int[][] arr) {
        if (null == arr || arr.length <= 0) {
            return 0;
        }
        int m = arr.length;
        int n = arr[0].length;
        if (m <= 0 || n <= 0) {
            return 0;
        }
        int[][] map = new int[m][n];
        map[0][0] = arr[0][0];
        for (int i = 1; i < m; i++) {
            map[i][0] = map[i - 1][0] + arr[i][0];
        }
        for (int i = 1; i < n; i++) {
            map[0][i] = map[0][i - 1] + arr[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                map[i][j] = Math.min(map[i - 1][j], map[i][j - 1]) + arr[i][j];
            }
        }
        return map[m - 1][n - 1];
    }

    public static int minWords(String w1, String w2) {
        int a = w1.length();
        int b = w2.length();
        int[][] m= new int[a+1][b+1];
        for (int i = 1; i <= b ; i++) {
            m[0][i] = m[0][i-1] +1;
        }
        for (int i = 1; i <= a ; i++) {
            m[i][0] = m[i-1][0] +1;
        }
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b ; j++) {
                if (w1.charAt(i-1) == w2.charAt(j-1)) {
                    m[i][j] = m[i-1][j-1];
                } else {
                    m[i][j] = Math.min(Math.min(m[i-1][j], m[i][j-1]), m[i-1][j-1]) + 1;
                }
            }
        }
        return m[a][b];
    }

    public static void lastRepeatStr(String a, String b) {
        int l = a.length();
        int r = b.length();
        int[][] m = new int[l][r];
        int maxLen = 0;
        int end = 0;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < r; j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    if (i ==0 || j==0) {
                        m[i][j] = 1;
                    } else {
                        m[i][j] = m[i-1][j-1] + 1;
                    }
                }
                if (maxLen < m[i][j]) {
                    maxLen = m[i][j];
                    end = i;
                }
            }

        }
        System.out.println(end);
        System.out.println(a.substring(end,end+maxLen));
    }

    public static String findCommonSubStr(String str1, String str2) {
        int str1lenth = str1.length(), str2lenth = str2.length();
        int[][] dp = new int[str1lenth + 1][str2lenth + 1];
        int maxLength = 0; //公共子串的最大长度
        int pos = -1;//因为我们的最长公共子串是从s2中截取的，所以这里用pos来标识s2中公共子串的结束位置索引
        for (int i = str1lenth - 1; i >= 0; i--) {
            for (int j = str2lenth - 1; j >= 0; j--) {
                dp[i][j] = str1.charAt(i) == str2.charAt(j) ? dp[i + 1][j + 1] + 1 : 0;
                if (dp[i][j] > maxLength) {
                    maxLength = dp[i][j];
                    pos = j;
                }
            }
        }
        return str2.substring(pos, pos + maxLength);
    }


    public static void main(String[] args) {
//        long start = System.currentTimeMillis();
        System.out.println(func(20));
//        System.out.println(System.currentTimeMillis() - start);
        int[] arr = new int[1000];
//        long start1 = System.currentTimeMillis();
//        System.out.println(cacheFunc(100, arr));
//        System.out.println(System.currentTimeMillis() - start1);
        System.out.println(dynamicPlan(20));
        System.out.println(fibonacci(3));
        System.out.println(fibonacciBetter(2));
        System.out.println(fibonacciBetter(3));
        System.out.println(fibonacciBetter(20));
        System.out.println(nb(1));
        System.out.println(nb(2));
        System.out.println(nb(3));
        System.out.println(nb(20));
        System.out.println(mn(3, 2));
//        2,3,4
//        2,4,5
//        3,1,7
        int[][] aaa = {{2, 3, 4},{2, 4, 5},{3,1,7}};
        System.out.println(mnMin(aaa));
        System.out.println(minWords("nihao","wwwwwe"));
        System.out.println(findCommonSubStr("acbcds", "rtbcdef"));
        lastRepeatStr("acbcds", "rtbcdef");
    }

}
