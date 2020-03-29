public class StaticDemo {
    public static void main(String[] args){
        Student one = new Student("g",18);
        one.room = "101教";
        System.out.println(one.getName()+"年龄"+one.getAge()+one.room);

        Student two = new Student("gz",18);
        System.out.println(two.getName()+"年龄"+two.getAge()+two.room);
        Student three = new Student("gzy",18);
        System.out.println(three.getName()+"年龄"+three.getAge()+three.room);
    }
}
