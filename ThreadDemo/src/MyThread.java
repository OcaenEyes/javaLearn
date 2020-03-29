/**
 *
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        String name = getName();
        System.out.println(name);
    }
}
