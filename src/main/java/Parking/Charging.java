package Parking;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Charging {
    private Map<String,Date> entryCar;
    private Map<String,Date> leaveCar;
    private Date date;
    private Map<String, Long> stayTime;


    public Charging(){
        this.entryCar = new HashMap<>();
        this.leaveCar = new HashMap<>();
        this.date= new Date();
        this.stayTime= new HashMap<>();
    }
    public void addCar (String number , Date time){
        System.out.printf("Number %s entered at %s %n",number, time);
        entryCar.put(number,time);
    }

    public void leaveCar(String number, Date time)  {
          leaveCar.put(number,time);
        System.out.printf("Number %s leaved at %s %n",number,time);
        long miliseconds = time.getTime() - this.entryCar.get(number).getTime();
        long minutes = TimeUnit.MILLISECONDS.toMinutes(miliseconds);
        Tax tax = new Tax(number,minutes);

    }
}

