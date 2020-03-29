import java.util.ArrayList;
import java.util.Random;

public class RandomTest {
    public static void main(String[] args){
        Random r = new Random();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i=0;i<6;i++){
            int n = r.nextInt(33)+1;
            list.add(n);
        }
        for (Integer j : list) {
            System.out.println(j);
        }
    }
}
