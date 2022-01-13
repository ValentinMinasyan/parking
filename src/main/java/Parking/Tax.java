package Parking;

public class Tax {
    private int profitWithVAT;
    private double profitWithoutVAT;
    private double VAT;

    public Tax(String number, long minutes) {
        if (minutes <= 60){
            System.out.println("Parking is free%n");
        }else if (minutes <= 120){
            System.out.printf("%s paid 2 leva%n",number);
            profitWithVAT += 2;
            profitWithoutVAT += 2 / 1.2;
            VAT = VAT + (profitWithVAT- profitWithoutVAT);
        }else if (minutes <= 180){
            System.out.printf("%s paid 4 leva%n", number);
            profitWithVAT += 4;
            profitWithoutVAT += 4 / 1.2;
            VAT = VAT + (profitWithVAT- profitWithoutVAT);
        }else if (minutes <=240){
            System.out.printf("%s paid 6 leva%n", number);
            profitWithVAT += 6;
            profitWithoutVAT += 6 / 1.2;
            VAT = VAT + (profitWithVAT- profitWithoutVAT);
        }else if (minutes <= 1440){
            System.out.printf("%s paid 20 leva for daily fee%n", number);
            profitWithVAT += 20;
            profitWithoutVAT += 20 / 1.2;
            VAT = VAT + (profitWithVAT- profitWithoutVAT);
        }else {
            System.out.printf("%s paid 50 leva for monthly fee%n", number);
            profitWithVAT += 50;
            profitWithoutVAT += 50 / 1.2;
            VAT = VAT + (profitWithVAT- profitWithoutVAT);
        }
       // Profit profit= new Profit(profitWithVAT,profitWithoutVAT,VAT);
        Profit.totalProfitWithVAT += profitWithVAT;
        Profit.totalProfitWithoutVAT += profitWithoutVAT;
        Profit.totalVAT += VAT;
    }



}
