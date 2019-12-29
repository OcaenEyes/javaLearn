import java.util.*;

public class DataStructureDemo {
    /*
        枚举       （Enumeration）
        位集合     （BitSet）
        向量       （Vector）
        栈         （Stack）
        字典       （Dictionary）
        哈希表     （Hashtable）
        属性       （Properties）
     */
    public void EnumerationTest() {
        //枚举值
        /*
            序号	            方法描述
            1	            boolean hasMoreElements( )
                            测试此枚举是否包含更多的元素。
            2	            Object nextElement( )
                            如果此枚举对象至少还有一个可提供的元素，则
         */
        Enumeration<String> days;
        Vector<String> dayNames = new Vector<String>();
        dayNames.add("Sunday");
        dayNames.add("Monday");
        dayNames.add("Tuesday");
        dayNames.add("Wednesday");
        dayNames.add("Thursday");
        dayNames.add("Friday");
        dayNames.add("Saturday");
        days = dayNames.elements();
        while (days.hasMoreElements()) {
            System.out.println(days.nextElement());
        }
    }

    public void BitSetTest() {
        // 位集合
        /*
            序号	 方法描述
            1	 void and(BitSet set)
对此目标位 set 和参数位 set 执行逻辑与操作。
            2	void andNot(BitSet set)
清除此 BitSet 中所有的位，其相应的位在指定的 BitSet 中已设置。
            3	int cardinality( )
返回此 BitSet 中设置为 true 的位数。
            4	void clear( )
将此 BitSet 中的所有位设置为 false。
            5	void clear(int index)
将索引指定处的位设置为 false。
            6	void clear(int startIndex, int endIndex)
将指定的 startIndex（包括）到指定的 toIndex（不包括）范围内的位设置为 false。
            7	Object clone( )
复制此 BitSet，生成一个与之相等的新 BitSet。
            8	boolean equals(Object bitSet)
将此对象与指定的对象进行比较。
            9	void flip(int index)
将指定索引处的位设置为其当前值的补码。
            10	void flip(int startIndex, int endIndex)
将指定的 fromIndex（包括）到指定的 toIndex（不包括）范围内的每个位设置为其当前值的补码。
            11	boolean get(int index)
返回指定索引处的位值。
            12	BitSet get(int startIndex, int endIndex)
返回一个新的 BitSet，它由此 BitSet 中从 fromIndex（包括）到 toIndex（不包括）范围内的位组成。
            13	int hashCode( )
返回此位 set 的哈希码值。
            14	boolean intersects(BitSet bitSet)
如果指定的 BitSet 中有设置为 true 的位，并且在此 BitSet 中也将其设置为 true，则返回 true。
            15	boolean isEmpty( )
如果此 BitSet 中没有包含任何设置为 true 的位，则返回 true。
            16	int length( )
返回此 BitSet 的"逻辑大小"：BitSet 中最高设置位的索引加 1。
            17	int nextClearBit(int startIndex)
返回第一个设置为 false 的位的索引，这发生在指定的起始索引或之后的索引上。
            18	int nextSetBit(int startIndex)
返回第一个设置为 true 的位的索引，这发生在指定的起始索引或之后的索引上。
            19	void or(BitSet bitSet)
对此位 set 和位 set 参数执行逻辑或操作。
            20	void set(int index)
将指定索引处的位设置为 true。
            21	void set(int index, boolean v)
 将指定索引处的位设置为指定的值。
            22	void set(int startIndex, int endIndex)
将指定的 fromIndex（包括）到指定的 toIndex（不包括）范围内的位设置为 true。
            23	void set(int startIndex, int endIndex, boolean v)
将指定的 fromIndex（包括）到指定的 toIndex（不包括）范围内的位设置为指定的值。
            24	int size( )
返回此 BitSet 表示位值时实际使用空间的位数。
            25	String toString( )
返回此位 set 的字符串表示形式。
            26	void xor(BitSet bitSet)
对此位 set 和位 set 参数执行逻辑异或操作。
         */
        BitSet bits1 = new BitSet(16);
        BitSet bits2 = new BitSet(16);

        // set some bits
        for (int i = 0; i < 16; i++) {
            if ((i % 2) == 0) bits1.set(i);
            if ((i % 5) != 0) bits2.set(i);
        }
        System.out.println("Initial pattern in bits1: ");
        System.out.println(bits1);
        System.out.println("\nInitial pattern in bits2: ");
        System.out.println(bits2);

        // AND bits
        bits2.and(bits1);
        System.out.println("\nbits2 AND bits1: ");
        System.out.println(bits2);

        // OR bits
        bits2.or(bits1);
        System.out.println("\nbits2 OR bits1: ");
        System.out.println(bits2);

        // XOR bits
        bits2.xor(bits1);
        System.out.println("\nbits2 XOR bits1: ");
        System.out.println(bits2);
    }


    public void VectorTest(){
        //向量
        /*
            序号	方法描述
1	void add(int index, Object element)
 在此向量的指定位置插入指定的元素。
2	boolean add(Object o)
 将指定元素添加到此向量的末尾。
3	boolean addAll(Collection c)
将指定 Collection 中的所有元素添加到此向量的末尾，按照指定 collection 的迭代器所返回的顺序添加这些元素。
4	boolean addAll(int index, Collection c)
在指定位置将指定 Collection 中的所有元素插入到此向量中。
5	void addElement(Object obj)
 将指定的组件添加到此向量的末尾，将其大小增加 1。
6	int capacity()
返回此向量的当前容量。
7	void clear()
从此向量中移除所有元素。
8	Object clone()
返回向量的一个副本。
9	boolean contains(Object elem)
如果此向量包含指定的元素，则返回 true。
10	boolean containsAll(Collection c)
如果此向量包含指定 Collection 中的所有元素，则返回 true。
11	void copyInto(Object[] anArray)
 将此向量的组件复制到指定的数组中。
12	Object elementAt(int index)
返回指定索引处的组件。
13	Enumeration elements()
返回此向量的组件的枚举。
14	void ensureCapacity(int minCapacity)
增加此向量的容量（如有必要），以确保其至少能够保存最小容量参数指定的组件数。
15	boolean equals(Object o)
比较指定对象与此向量的相等性。
16	Object firstElement()
返回此向量的第一个组件（位于索引 0) 处的项）。
17	Object get(int index)
返回向量中指定位置的元素。
18	int hashCode()
返回此向量的哈希码值。
19	int indexOf(Object elem)
 返回此向量中第一次出现的指定元素的索引，如果此向量不包含该元素，则返回 -1。
20	int indexOf(Object elem, int index)
 返回此向量中第一次出现的指定元素的索引，从 index 处正向搜索，如果未找到该元素，则返回 -1。
21	void insertElementAt(Object obj, int index)
将指定对象作为此向量中的组件插入到指定的 index 处。
22	boolean isEmpty()
测试此向量是否不包含组件。
23	Object lastElement()
返回此向量的最后一个组件。
24	int lastIndexOf(Object elem)
 返回此向量中最后一次出现的指定元素的索引；如果此向量不包含该元素，则返回 -1。
25	int lastIndexOf(Object elem, int index)
返回此向量中最后一次出现的指定元素的索引，从 index 处逆向搜索，如果未找到该元素，则返回 -1。
26	Object remove(int index)
 移除此向量中指定位置的元素。
27	boolean remove(Object o)
移除此向量中指定元素的第一个匹配项，如果向量不包含该元素，则元素保持不变。
28	boolean removeAll(Collection c)
从此向量中移除包含在指定 Collection 中的所有元素。
29	void removeAllElements()
从此向量中移除全部组件，并将其大小设置为零。
30	boolean removeElement(Object obj)
从此向量中移除变量的第一个（索引最小的）匹配项。
31	void removeElementAt(int index)
删除指定索引处的组件。
32	protected void removeRange(int fromIndex, int toIndex)
从此 List 中移除其索引位于 fromIndex（包括）与 toIndex（不包括）之间的所有元素。
33	boolean retainAll(Collection c)
在此向量中仅保留包含在指定 Collection 中的元素。
34	Object set(int index, Object element)
 用指定的元素替换此向量中指定位置处的元素。
35	void setElementAt(Object obj, int index)
将此向量指定 index 处的组件设置为指定的对象。
36	void setSize(int newSize)
 设置此向量的大小。
37	int size()
 返回此向量中的组件数。
38	List subList(int fromIndex, int toIndex)
返回此 List 的部分视图，元素范围为从 fromIndex（包括）到 toIndex（不包括）。
39	Object[] toArray()
 返回一个数组，包含此向量中以恰当顺序存放的所有元素。
40	Object[] toArray(Object[] a)
返回一个数组，包含此向量中以恰当顺序存放的所有元素；返回数组的运行时类型为指定数组的类型。
41	String toString()
返回此向量的字符串表示形式，其中包含每个元素的 String 表示形式。
42	void trimToSize()
  对此向量的容量进行微调，使其等于向量的当前大小。
         */
        Vector v = new Vector(3, 2);
        System.out.println("Initial size: " + v.size());
        System.out.println("Initial capacity: " +
                v.capacity());
        v.addElement(new Integer(1));
        v.addElement(new Integer(2));
        v.addElement(new Integer(3));
        v.addElement(new Integer(4));
        System.out.println("Capacity after four additions: " +
                v.capacity());

        v.addElement(new Double(5.45));
        System.out.println("Current capacity: " +
                v.capacity());
        v.addElement(new Double(6.08));
        v.addElement(new Integer(7));
        System.out.println("Current capacity: " +
                v.capacity());
        v.addElement(new Float(9.4));
        v.addElement(new Integer(10));
        System.out.println("Current capacity: " +
                v.capacity());
        v.addElement(new Integer(11));
        v.addElement(new Integer(12));
        System.out.println("First element: " +
                (Integer)v.firstElement());
        System.out.println("Last element: " +
                (Integer)v.lastElement());
        if(v.contains(new Integer(3)))
            System.out.println("Vector contains 3.");
        // enumerate the elements in the vector.
        Enumeration vEnum = v.elements();
        System.out.println("\nElements in vector:");
        while(vEnum.hasMoreElements())
            System.out.print(vEnum.nextElement() + " ");
        System.out.println();

    }

    //字典
    /*
        序号	方法描述
1	Enumeration elements( )
返回此 dictionary 中值的枚举。
2	Object get(Object key)
返回此 dictionary 中该键所映射到的值。
3	boolean isEmpty( )
测试此 dictionary 是否不存在从键到值的映射。
4	Enumeration keys( )
返回此 dictionary 中的键的枚举。
5	Object put(Object key, Object value)
将指定 key 映射到此 dictionary 中指定 value。
6	Object remove(Object key)
从此 dictionary 中移除 key （及其相应的 value）。
7	int size( )
返回此 dictionary 中条目（不同键）的数量。
     */



    public static void main(String[] args) {
        DataStructureDemo ds1 = new DataStructureDemo();
        ds1.EnumerationTest();
        ds1.BitSetTest();
        ds1.VectorTest();

    }
}
