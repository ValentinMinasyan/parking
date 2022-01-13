package Parking;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class ParkingEntry {
    private int freeCarSeats;
    private int freeMotorcycleSeats;
    private Charging charging;
    private List<String> motorcycleOnSeCar ;


    public ParkingEntry(int freeCarSeats, int freeMotorcycleSeats){
       this.freeCarSeats= freeCarSeats;
       this.freeMotorcycleSeats= freeMotorcycleSeats;
       this.charging = new Charging();
        this.motorcycleOnSeCar = new ArrayList<>();
    }


    public void enters(String machine, String number, Date time) {

        switch (machine) {
            case "car":
                if (freeCarSeats > 0) {
                    freeCarSeats = freeCarSeats - 1;
                   // System.out.println("the car entered successfully");
                    this.charging.addCar(number,time);
                } else {
                    System.out.println("there are no free seats");
                }
                break;
            case "motorcycle":
                if (freeMotorcycleSeats > 0) {
                    freeMotorcycleSeats = freeMotorcycleSeats - 1;
                    System.out.println("the motorcycle entered successfully" +
                            " and parked in the motorcycle spot");
                    charging.addCar(number,time);
                } else if (freeMotorcycleSeats <= 0 && freeCarSeats > 0) {
                    freeCarSeats = freeCarSeats - 1;
                    this.motorcycleOnSeCar.add(number);
                    System.out.println("the motorcycle entered successfully and parked in the car spot");
                    this.charging.addCar(number,time);
                } else {
                    System.out.println("there are no free seats");
                }
                break;
        }
    }

    public void leaves(String machine,String number, Date time)  {
        switch (machine){
            case "car":
                freeCarSeats = freeCarSeats + 1;
                this.charging.leaveCar(number,time);
                break;
            case "motorcycle":
                if (motorcycleOnSeCar.stream().anyMatch((c ->c.getClass() == number.getClass()))){
                    freeCarSeats = freeCarSeats + 1;
                    this.motorcycleOnSeCar.remove(number);
                }else {
                    freeMotorcycleSeats = freeMotorcycleSeats + 1;
                }

                this.charging.leaveCar(number,time);
                break;
        }

    }
}

