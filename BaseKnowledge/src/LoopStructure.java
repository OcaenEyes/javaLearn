public class LoopStructure {
    /*
        while 循环
        do…while 循环
        for 循环
     */

    public static void main(String []args){
        //while循环 ，布尔表达式为true 就会一直执行下去， 不满足条件则无法进入循环
        System.out.println("while 循环");
        int x =10;
        while (x<20){
            System.out.println(x);
            x++;
        }

        // do…while 循环，至少执行一次
        /*
            do {
                //代码语句
            }while(布尔表达式);
         */
        System.out.println("do…while循环");
        int y=10;
        do {
            System.out.println(y);
            y++;
        }while (y<10);



        // for 循环，执行前就确定执行次数
        /*
            for(初始化; 布尔表达式; 更新) {
                //代码语句
            }
         */
        System.out.println("for 循环");
        for (int z=0; z<20; z = z+1){
            System.out.println(z);
        }


        //增强for循环
        /*
            for(声明语句 : 表达式)
            {
                //代码句子
            }
         */
        System.out.println("增强for 循环");
        int [] numbers = {10,20,30,40,50};
        for (int number : numbers){
            System.out.println(number);
        }

        String [] names ={"gzy","g","zy"};
        for (String name :names){
            System.out.println(name);
        }


        //break关键字
        /*
            break 主要用在循环语句或者 switch 语句中，用来跳出整个语句块。
            break 跳出最里层的循环，并且继续执行该循环下面的语句。
         */
        System.out.println("break关键字");
        int [] numbers1 = {10,20,30,40,50};
        for (int number : numbers1){
            if (number ==30){
                break;
            }
            System.out.println(number);

        }


        //continue关键字
        /*
            continue 适用于任何循环控制结构中。作用是让程序立刻跳转到下一次循环的迭代。
            在 for 循环中，continue 语句使程序立即跳转到更新语句。
            在 while 或者 do…while 循环中，程序立即跳转到布尔表达式的判断语句。
         */
        System.out.println("continue关键字");
        int [] numbers2 = {10,20,30,40,50};
        for (int number : numbers2){
            if (number ==30){
                continue;
            }
            System.out.println(number);

        }

    }
}
