public class MyDate {

    //属性
    public int year;
    public int month;
    public int day;

    //方法：计算两个日期相差天数
    //静态方法
//    public static int 相差天数(MyDate from, MyDate to){
//
//        return -1;
//    }

    //普通方法
    public int 相差天数(MyDate from){

        //要求：from < this
        if(this.compare(from) <= 0){
            throw new RuntimeException("from 的日期应在当前日期之前");
        }

        //用 from 的复制计算，以免下面的计算把 from对象 修改掉
        MyDate fromCopy = new MyDate(from);
        //MyDate fromCopy = from;     错误：让 fromCopy 指向 from所指向的对象，引用的”共享特性“

        int count = 0;
        while (this.compare(fromCopy) != 0){
            fromCopy.dayAdd();
            count++;
        }

        return count;
    }

    public void dayAdd(){
        day++;
        if (day <= getMonthDay(year,month)){
            return;
        }
        month++;
        day = 1;
        if (month <= 12){
            return;
        }
        year++;
        month = 1;
    }

    public int compare(MyDate from){

        if(year != from.year){
            return year- from.year;
        }
        //走到这里说明：year == from.year
        if(month != from.month){
            return month - from.month;
        }
        //走到这里说明：year == from.year  &&  month == from.month
        if(day != from.day){
            return day - from.day;
        }
        //走到这里说明：year == from.year  &&  month == from.month  &&  day == from.day
        return 0;

        //一般思路：
//        if(year > from.year){
//            return 1;
//        }else if(year < from.year){
//            return -1;
//        }else{
//            if(month > from.month){
//                return 1;
//            }else if(month < from.month){
//                return -1;
//            }else{
//                if(day > from.day){
//                    return 1;
//                }else if(day < from.day){
//                    return -1;
//                }else{
//                    return 0;
//                }
//        }

    }

    public MyDate(MyDate from) {
        this.year = from.year;
        this.month = from.month;
        this.day = from.day;
    }

    public MyDate(int year, int month, int day) {

        //日期合法性
        if(month < 1 || month > 12){
            throw new RuntimeException ("month 参数异常");
        }

        if(day < 1 || day > getMonthDay(year,month)){
            throw new RuntimeException ("day 参数异常");
        }

        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getMonthDay(int year,int month){
        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return isLeapyear(year)? 29 : 28;
            default:
                return -1;
        }
    }

    public boolean isLeapyear(int year){
//        if((year%4 == 0 && year%100 != 0) || year%400 ==0)
//            return true;
//        else
//            return false;
        return (year%4 == 0 && year%100 != 0) || year%400 ==0 ;
    }

    @Override
    public String toString() {
        return String.format("%04d-%02d-%02d",year,month,day);
    }
}
