package es.esy.practikality.t_pin;

public class Word {
    private String mName;
    private String mDay;
    private String mDate;
    private String mTime;
    public Word(String Name, String Day, String Date, String Time){
        mName = Name;
        mDay = Day;
        mDate = Date;
        mTime = Time;
    }
    public String getName(){
        return mName;
    }
    public String getDay(){
        return mDay;
    }
    public String getDate(){
        return mDate;
    }
    public String getTime(){
        return mTime;
    }
}
