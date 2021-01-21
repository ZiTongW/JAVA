public class Time {

    public int hour;
    public int minute;
    public int second;

    public int interval_second(Time from){
        //要求：from < this
        if(this.compare(from) <= 0){
            throw new RuntimeException("from 的时刻应在当前时刻之前");
        }

        Time fromCopy = new Time(from);
        int count = 0;
        while(this.compare(fromCopy) != 0){
            fromCopy.timeAdd();
            count++;
        }
        return count;
    }

//    public String interval(Time from){
//        //要求：from < this
//        if(this.compare(from) <= 0){
//            throw new RuntimeException("from 的时刻应在当前时刻之前");
//        }
//
//        Time fromCopy = new Time(from);
//        int count = 0;
//        while(this.compare(fromCopy) != 0){
//            fromCopy.timeAdd();
//            count++;
//        }
//
//        return String.format("%d小时%d分钟%d秒",count/3600,count%3600/60,count%60);
//    }

    public String interval(Time from){
        //要求：from < this
        if(this.compare(from) <= 0){
            throw new RuntimeException("from 的时刻应在当前时刻之前");
        }

        int h = 0;
        int m = 0;
        int s = 0;

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
        h = this.hour - from.hour;
        return String.format("%d小时%d分钟%d秒",h,m,s);
    }

    private void timeAdd() {
        second++;

        if(second < 60){
            return;
        }
        minute++;
        second=0;

        if(minute < 60){
            return;
        }
        hour++;
        minute=0;
    }

    public int compare(Time from) {

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

    public Time(Time from) {
        this.hour = from.hour;
        this.minute = from.minute;
        this.second = from.second;
    }

    public Time(int hour, int minute, int second) {

        if(hour < 0 || hour >= 24){
            throw new RuntimeException ("hour 参数异常");
        }
        if(minute < 0 || minute >= 60){
            throw new RuntimeException ("minute 参数异常");
        }
        if(second < 0 || second >= 60){
            throw new RuntimeException ("second 参数异常");
        }

        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d",hour,minute,second);
    }
}
