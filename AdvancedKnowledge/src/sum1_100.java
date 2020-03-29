public class sum1_100 {
    public static void main(String[] args) {
        getSum();
    }

    public static void getSum() {
        int s = 0;
        for (int i = 1; i <= 100; i++) {
            s = s + i;
        }
        System.out.println(s);
    }
}
