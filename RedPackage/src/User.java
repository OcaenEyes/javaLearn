import java.util.ArrayList;
import java.util.Random;

public class User {
    private String name;
    private int money;

    public User() {
    }

    public User(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", money=" + money +
                '}';
    }

    /**
     * 
     * @param totalMoney
     * @param count
     * @return
     */
    public ArrayList<Integer> send(int totalMoney, int count) {

        ArrayList<Integer> redList = new ArrayList<>();
        int leftMoney = getMoney();
        if (totalMoney > leftMoney) {
            System.out.println("余额不足");
            return redList;
        }
        setMoney(leftMoney - totalMoney);

        int avg = totalMoney / count;
        int mod = totalMoney % count;
        for (int i = 0; i < count - 1; i++) {
            redList.add(avg);
        }

        int last = avg + mod;
        redList.add(last);
        return redList;
    }

    /**
     *
     * @param list
     */
    public void receive(ArrayList<Integer> list) {
        int index = new Random().nextInt(list.size());

        int delta = list.remove(index);
        int money = getMoney();
        setMoney(money + delta);
    }
}
