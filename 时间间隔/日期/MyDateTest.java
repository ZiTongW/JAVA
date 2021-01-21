public class MyDateTest {
    public static void main(String[] args) {


        MyDate from = new MyDate(2021,1,1);
        System.out.println(from);
        MyDate to = new MyDate(2021,3,31);
        System.out.println(to);
        System.out.println("相差 "+ to.相差天数(from) +"天");


    }

}
