public class Time {
    private int hours;
    private int minutes;
    private int seconds;
    private int day;
    private int month;
    private int year;
    
    Time(String time, String date) {
        // what if some of the components is missing?
        String[] timeElements = time.split(":");
        setHours(Integer.parseInt(timeElements[0]));
        setMinutes(Integer.parseInt(timeElements[1]));
        setSeconds(Integer.parseInt(timeElements[2]));
        
        String[] dateElements = date.split(".");
        setDay(Integer.parseInt(dateElements[0]));
        setMonth(Integer.parseInt(dateElements[1]));
        setYear(Integer.parseInt(dateElements[2]));
    }

    public void setHours(int hours) {
        if (hours >= 0 && hours < 24) {
            this.hours = hours;
        }
    }

    public void setMinutes(int minutes) {
        if (minutes >= 0 && minutes < 60) {
            this.minutes = minutes;
        }
    }

    public void setSeconds(int seconds) {
        if (seconds >= 0 && seconds < 60) {
            this.seconds = seconds;
        }
    }

    public void setDay(int day) {
        // proper check?
        if (day >= 1 && day <= 31) {
            this.day = day;
        }
    }

    public void setMonth(int month) {
        if (month >= 1 && month <= 12) {
            this.month = month;
        }
    }
    
    public void setYear(int year) {
        // proper check - actually can we set future dates?
        if (year <= 2015) {
            this.year = year;
        }
    }
    
    // is it overriding something or not?
    public String toString() {
        return String.format("%02d:%02d:%02d %02d.%02d.%02d", hours, minutes, seconds, day, month, year);
    }
}
