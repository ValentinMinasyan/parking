package Parking;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

import static com.lowagie.text.pdf.PdfName.PV;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(";");
        int [] freePlaces = Arrays.stream(scanner.nextLine()
                          .split("\\s+"))
                          .mapToInt(Integer::parseInt)
                .toArray();

        int freeCarSeats = freePlaces[0];
        int freeMotorcycleSeats= freePlaces[1];


        ParkingEntry parkingEntry = new ParkingEntry(freeCarSeats,freeMotorcycleSeats);

        for (int i=0; i < input.length; i++){
            String[] token = input[i].split(",");
            String command = token[0];
            String machine = token[1];
            String number = token[2];
            String time2 = (token[3]
                    );

            Date time =new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(String.valueOf(time2));

          if (command.equals("enters")){
              parkingEntry.enters(machine,number, time);
          }else if(command.equals("leaves")){
            parkingEntry.leaves(machine,number,time);
            }
        }
        System.out.printf("Total profit = %d %n",Profit.totalProfitWithVAT);
        System.out.printf("Total profit without VAT = %.2f %n ",Profit.totalProfitWithoutVAT);
        System.out.printf("Total due VAT = %.2f %n",Profit.totalVAT);

    }


}
