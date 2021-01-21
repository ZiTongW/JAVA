public class DateTest {
    public static void main(String[] args) {
        Date from = new Date(2021,1,13,9,10,28);
        System.out.println(from);
        Date to = new Date(2021,1,21,12,6,17);
        System.out.println(to);
        System.out.println("相隔 "+ to.interval(from));
    }
}
