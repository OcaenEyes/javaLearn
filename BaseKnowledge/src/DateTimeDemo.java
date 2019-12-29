import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;

public class DateTimeDemo {
    //日期时间
    public static void main(String[] args){
        //获取当前时间
        Date date = new Date();
        System.out.println(date.toString());


        //格式化日期
        /*
            日期和时间的格式化编码
时间模式字符串用来指定时间格式。在此模式中，所有的 ASCII 字母被保留为模式字母，定义如下：

字母	描述	示例
G	纪元标记	AD
y	四位年份	2001
M	月份	July or 07
d	一个月的日期	10
h	 A.M./P.M. (1~12)格式小时	12
H	一天中的小时 (0~23)	22
m	分钟数	30
s	秒数	55
S	毫秒数	234
E	星期几	Tuesday
D	一年中的日子	360
F	一个月中第几周的周几	2 (second Wed. in July)
w	一年中第几周	40
W	一个月中第几周	1
a	A.M./P.M. 标记	PM
k	一天中的小时(1~24)	24
K	 A.M./P.M. (0~11)格式小时	10
z	时区	Eastern Standard Time
'	文字定界符	Delimiter
"	单引号	`
         */
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println("SimpleDateFormat时间格式转换");
        System.out.println(ft.format(date));


        //printf格式化时间  以%t 开头
        /*
            转  换  符             说    明              示    例
                c           包括全部日期和时间信息         星期六 十月 27 14:21:20 CST 2007
                F           "年-月-日"格式               2007-10-27
                D           "月/日/年"格式               10/27/07
                r           "HH:MM:SS PM"格式（12时制）   02:25:51 下午
                T           "HH:MM:SS"格式（24时制）   14:28:16
                R           "HH:MM"格式（24时制）         14:28
         */
        System.out.println("printf时间格式转换");
        System.out.printf("全部日期和时间信息：%tc%n",date);
        System.out.printf("年-月-日格式：%tF%n",date);
        System.out.printf("月/日/年格式：%tD%n",date);
        System.out.printf("HH:MM:SS PM(12小时)：%tr%n",date);
        System.out.printf("HH:MM:SS (24小时)：%tT%n",date);
        System.out.printf("HH:MM (24小时)：%tR%n",date);


        //定义日期转换字符，抽取转换为新字符串
        System.out.println("使日期转换生成新字符串");
        //b的使用，月份简称
        String str=String.format(Locale.US,"英文月份简称：%tb",date);
        System.out.println(str);
        System.out.printf("本地月份简称：%tb%n",date);
        //B的使用，月份全称
        str=String.format(Locale.US,"英文月份全称：%tB",date);
        System.out.println(str);
        System.out.printf("本地月份全称：%tB%n",date);
        //a的使用，星期简称
        str=String.format(Locale.US,"英文星期的简称：%ta",date);
        System.out.println(str);
        //A的使用，星期全称
        System.out.printf("本地星期的简称：%tA%n",date);
        //C的使用，年前两位
        System.out.printf("年的前两位数字（不足两位前面补0）：%tC%n",date);
        //y的使用，年后两位
        System.out.printf("年的后两位数字（不足两位前面补0）：%ty%n",date);
        //j的使用，一年的天数
        System.out.printf("一年中的天数（即年的第几天）：%tj%n",date);
        //m的使用，月份
        System.out.printf("两位数字的月份（不足两位前面补0）：%tm%n",date);
        //d的使用，日（二位，不够补零）
        System.out.printf("两位数字的日（不足两位前面补0）：%td%n",date);
        //e的使用，日（一位不补零）
        System.out.printf("月份的日（前面不补0）：%te",date);

        //Calendar 对象
        /*
            常量	                    描述
            Calendar.YEAR	        年份
            Calendar.MONTH	        月份
            Calendar.DATE	        日期
            Calendar.DAY_OF_MONTH	日期，和上面的字段意义完全相同
            Calendar.HOUR	        12小时制的小时
            Calendar.HOUR_OF_DAY	24小时制的小时
            Calendar.MINUTE	        分钟
            Calendar.SECOND	        秒
            Calendar.DAY_OF_WEEK	星期几

         */
        //GregorianCalendar类
        /*
            序号	构造函数和说明
1	GregorianCalendar()
在具有默认语言环境的默认时区内使用当前时间构造一个默认的 GregorianCalendar。
2	GregorianCalendar(int year, int month, int date)
在具有默认语言环境的默认时区内构造一个带有给定日期设置的 GregorianCalendar
3	GregorianCalendar(int year, int month, int date, int hour, int minute)
为具有默认语言环境的默认时区构造一个具有给定日期和时间设置的 GregorianCalendar。
4	GregorianCalendar(int year, int month, int date, int hour, int minute, int second)
  为具有默认语言环境的默认时区构造一个具有给定日期和时间设置的 GregorianCalendar。
5	GregorianCalendar(Locale aLocale)
在具有给定语言环境的默认时区内构造一个基于当前时间的 GregorianCalendar。
6	GregorianCalendar(TimeZone zone)
在具有默认语言环境的给定时区内构造一个基于当前时间的 GregorianCalendar。
7	GregorianCalendar(TimeZone zone, Locale aLocale)
 在具有给定语言环境的给定时区内构造一个基于当前时间的 GregorianCalendar。
这里是GregorianCalendar 类提供的一些有用的方法列表：

序号	方法和说明
1	void add(int field, int amount)
根据日历规则，将指定的（有符号的）时间量添加到给定的日历字段中。
2	protected void computeFields()
转换UTC毫秒值为时间域值
3	protected void computeTime()
覆盖Calendar ，转换时间域值为UTC毫秒值
4	boolean equals(Object obj)
比较此 GregorianCalendar 与指定的 Object。
5	int get(int field)
获取指定字段的时间值
6	int getActualMaximum(int field)
返回当前日期，给定字段的最大值
7	int getActualMinimum(int field)
返回当前日期，给定字段的最小值
8	int getGreatestMinimum(int field)
 返回此 GregorianCalendar 实例给定日历字段的最高的最小值。
9	Date getGregorianChange()
获得格里高利历的更改日期。
10	int getLeastMaximum(int field)
返回此 GregorianCalendar 实例给定日历字段的最低的最大值
11	int getMaximum(int field)
返回此 GregorianCalendar 实例的给定日历字段的最大值。
12	Date getTime()
获取日历当前时间。
13	long getTimeInMillis()
获取用长整型表示的日历的当前时间
14	TimeZone getTimeZone()
获取时区。
15	int getMinimum(int field)
返回给定字段的最小值。
16	int hashCode()
重写hashCode.
17	boolean isLeapYear(int year)
确定给定的年份是否为闰年。
18	void roll(int field, boolean up)
在给定的时间字段上添加或减去（上/下）单个时间单元，不更改更大的字段。
19	void set(int field, int value)
用给定的值设置时间字段。
20	void set(int year, int month, int date)
设置年、月、日的值。
21	void set(int year, int month, int date, int hour, int minute)
设置年、月、日、小时、分钟的值。
22	void set(int year, int month, int date, int hour, int minute, int second)
设置年、月、日、小时、分钟、秒的值。
23	void setGregorianChange(Date date)
设置 GregorianCalendar 的更改日期。
24	void setTime(Date date)
用给定的日期设置Calendar的当前时间。
25	void setTimeInMillis(long millis)
用给定的long型毫秒数设置Calendar的当前时间。
26	void setTimeZone(TimeZone value)
用给定时区值设置当前时区。
27	String toString()
返回代表日历的字符串。
         */
        String months[] = {
                "Jan", "Feb", "Mar", "Apr",
                "May", "Jun", "Jul", "Aug",
                "Sep", "Oct", "Nov", "Dec"};

        int year;
        // 初始化 Gregorian 日历
        // 使用当前时间和日期
        // 默认为本地时间和时区
        GregorianCalendar gcalendar = new GregorianCalendar();
        // 显示当前时间和日期的信息
        System.out.print("Date: ");
        System.out.print(months[gcalendar.get(Calendar.MONTH)]);
        System.out.print(" " + gcalendar.get(Calendar.DATE) + " ");
        System.out.println(year = gcalendar.get(Calendar.YEAR));
        System.out.print("Time: ");
        System.out.print(gcalendar.get(Calendar.HOUR) + ":");
        System.out.print(gcalendar.get(Calendar.MINUTE) + ":");
        System.out.println(gcalendar.get(Calendar.SECOND));

        // 测试当前年份是否为闰年
        if(gcalendar.isLeapYear(year)) {
            System.out.println("当前年份是闰年");
        }
        else {
            System.out.println("当前年份不是闰年");
        }

    }
}
