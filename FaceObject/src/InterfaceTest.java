public class InterfaceTest implements InterfaceDemo{
    public void say(){
        System.out.println("hello");
    }
    public void sleep(){
        System.out.println("好困哦");
    }

    public static void main(String[] args){
        InterfaceTest in1 = new InterfaceTest();
        in1.say();
        in1.sleep();
    }
}
