import java.util.ArrayList;

public class ReaPackageMain {
    public static void main(String[] args) {
        User a = new User("gzy", 100);
        User b = new User("z", 0);
        User c = new User("y", 0);
        User d = new User("zy", 0);
        User e = new User("yz", 0);

//        System.out.println(a.toString());
//        System.out.println(b.toString());
//        System.out.println(c.toString());
//        System.out.println(d.toString());
//        System.out.println(e.toString());
//        System.out.println("==========");

        ArrayList<Integer> redList = a.send(40,5);
        b.receive(redList);
        c.receive(redList);
        d.receive(redList);
        e.receive(redList);
        a.receive(redList);

        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(c.toString());
        System.out.println(d.toString());
        System.out.println(e.toString());
        System.out.println("==========");

    }
}
