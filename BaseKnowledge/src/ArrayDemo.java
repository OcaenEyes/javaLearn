public class ArrayDemo {
    //声明数组
    // 数据类型[] 数组名称;  dataType[] arrayName;

    //创建数组
    // 数据名称 = new dataType[arraySize];

    //dataType[] arrayName = {value0,value1,value2,...,valuek};
    public static void main(String[] args){
        //数组大小
        int size =4;
        //定义数组
        double[] TestList = new double[size];
        TestList[0] = 3.2;
        TestList[1] = 2.6;
        TestList[2] = 4.7;
        TestList[3] = 5.6;

        double total =0;
        for (int i=0; i<size; i++){
            total = total + TestList[i];
        }
        System.out.println(total);


        double[] list1 = {1.4,2.8,3.6,4.9};
        //打印所有数组元素
        for (int i=0;i<list1.length;i++){
            System.out.println(list1[i]);
        }
        //计算所有元素的和
        double sum = 0;
        for (int i =0;i<list1.length;i++){
            sum = sum + list1[i];
        }
        System.out.println(sum);

        //查找最大元素
        double max = list1[0];
        for (int i=0; i<list1.length;i++){
            if (list1[i] > max){
                max = list1[i];
            }
        }
        System.out.println(max);
    }
}
