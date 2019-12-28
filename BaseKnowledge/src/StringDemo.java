public class StringDemo {
    public static void main(String[] args) {
        char[] hello = {'g', 'z', 'y'};
        String helloString = new String(hello);
        System.out.println(helloString);
        System.out.println(helloString.length());
    }
}
