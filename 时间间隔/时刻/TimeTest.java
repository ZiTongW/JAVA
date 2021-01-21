public class TimeTest {
    public static void main(String[] args) {
        Time from = new Time(9,10,23);
        System.out.println(from);
        Time to = new Time(12,5,38);
        System.out.println(to);
        System.out.println("相差 "+ to.interval_second(from) +"秒");
        System.out.println("相差 "+ to.interval(from));

    }
}
