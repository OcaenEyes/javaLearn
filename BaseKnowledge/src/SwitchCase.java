public class SwitchCase {
    //switch case语句  判断一个变量与一系列值中某个值是否相等，每个值称为一个分支
    // switch case 执行时，一定会先进行匹配，匹配成功返回当前 case 的值，再根据是否有 break，判断是否继续输出，或是跳出判断。
    /*
        switch(expression){
            case value :
                //语句
                break; //可选
            case value :
                //语句
                break; //可选
            //你可以有任意数量的case语句
            default : //可选
                //语句   不需要break
        }
     */

    public static void main(String[]args){
        char grade ='C';
        switch (grade)
        {
            case 'A':
                System.out.println("优秀");
                break;
            case 'B':
            case 'C':
                System.out.println("良好");
                break;
            case 'D':
                System.out.println("及格");
                break;
            case 'F':
                System.out.println("你还需要继续努力");
                break;
            default:
                System.out.println("未知等级");
        }
        System.out.println("你的等级是" + grade);
    }
}
