public class Date {

    public int year;
    public int month;
    public int day;
    public int hour;
    public int minute;
    public int second;

    public String interval(Date from){
        //要求：from < this
        if(this.compare(from) <= 0){
            throw new RuntimeException("from 的时刻应在当前时刻之前");
        }

        Date fromCopy = new Date(from);
        int d = 0;
        int h = 0;
        int m = 0;
        int s = 0;
        while(this.compare_day(fromCopy) != 0){
            fromCopy.dayAdd();
            d++;
        }

        if(this.second >= from.second){
            s = this.second - from.second;
        }else{
            this.minute--;
            s = 60 + this.second - from.second;
        }
        if(this.minute >= from.minute){
            m = this.minute - from.minute;
        }else{
            this.hour--;
            m = 60 + this.minute - from.minute;
        }
        if(this.hour >= from.hour){
            h = this.hour - from.hour;
        }else{
            d--;
            h = 24 + this.hour - from.hour;
        }

        return String.format("%d天%d小时%d分钟%d秒",d,h,m,s);//8天2小时55分钟49秒
    }

    private int compare_day(Date from) {
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
        return 0;
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

    public int compare(Date from) {

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

        if (hour != from.hour) {
            return hour - from.hour;
        }
        //走到这里说明：hour == from.hour
        if (minute != from.minute) {
            return minute - from.minute;
        }
        //走到这里说明：hour == from.hour  &&  minute == from.minute
        if (second != from.second) {
            return second - from.second;
        }
        //走到这里说明：hour == from.hour  &&  minute == from.minute  &&  second == from.second
        return 0;
    }

    public Date(Date from) {
        this.year = from.year;
        this.month = from.month;
        this.day = from.day;
        this.hour = from.hour;
        this.minute = from.minute;
        this.second = from.second;
    }

    public Date(int year, int month, int day, int hour, int minute, int second) {

        //日期合法性
        if(month < 1 || month > 12){
            throw new RuntimeException ("month 参数异常");
        }
        if(day < 1 || day > getMonthDay(year,month)){
            throw new RuntimeException ("day 参数异常");
        }
        if(hour < 0 || hour >= 24){
            throw new RuntimeException ("hour 参数异常");
        }
        if(minute < 0 || minute >= 60){
            throw new RuntimeException ("minute 参数异常");
        }
        if(second < 0 || second >= 60){
            throw new RuntimeException ("second 参数异常");
        }

        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
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
        return (year%4 == 0 && year%100 != 0) || year%400 ==0 ;
    }

    @Override
    public String toString() {
        return String.format("%04d-%02d-%02d %02d:%02d:%02d",year,month,day,hour,minute,second);
    }
}
