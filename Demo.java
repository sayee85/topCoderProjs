import java.lang.*;
import java.util.Scanner;

/**
 * The Demo class gets the category as input from user and
 * accesses either Railway or Airline class
 */

public class Demo
{

    public static void main(String[] args) {

        Reservation valCat = new Reservation(); //object instantiation
        Scanner SysIn = new Scanner(System.in); //user input
        System.out.println("Enter the Category (Train or Flight) :");
        String category = SysIn.nextLine();


        if(valCat.validateCategory(category)) {

            /* Checks if the entered category is a valid one. */

            System.out.println("Congratulations, you have entered a valid category!");
            if (category.equalsIgnoreCase("train")){ //when the category is Train
                RailwayReservation objRailReservation = new RailwayReservation("Train",
                        "Ashok","rajdhani",
                        2,"AC2");

            }
            else {                                               //when the category is Flight
                AirTicketReservation objAirTicketReservation = new AirTicketReservation("Flight",
                        "Anjana ","airINDIA",
                        3,"economy");

            }


        } else {
            System.out.println("Wrong category entered!");
            System.exit(0);
        }


    }
}

/**
 * The Reservation class has methods - getTransactionNumber
 * and validateCategory
 */

class Reservation
{
    public static int transactionNumber = 0;

    public static int getTransactionNumber(){
        return ++transactionNumber;
    }

    public static boolean validateCategory(String category) {
        if (category.equalsIgnoreCase("train")
                || category.equalsIgnoreCase("flight"))
            return true;
        else
            return false;

    }
}

/**
 * The RailwayReservation class has a methods - calculateAmount
 * and a constructor - RailwayReservation defined
 */

class RailwayReservation {
    Reservation getTransNum = new Reservation();  //object instantiation

    public double calculateAmount(String bookingClass, int numberOfTickets) {
        double totalAmt = 0;
        if (bookingClass.equalsIgnoreCase("ac1")) {  //when the booking class is First Class AC
            totalAmt = numberOfTickets * 1500;
            return totalAmt;
        }
        else if (bookingClass.equalsIgnoreCase("ac2")) {  //when the booking class is Second Class AC
            totalAmt = numberOfTickets * 1100;
            return totalAmt;
        }
        else if (bookingClass.equalsIgnoreCase("ac3")) {  //when the booking class is Third Class AC
            totalAmt = numberOfTickets * 700;
            return totalAmt;
        }
        else
            return totalAmt;

    }
    public RailwayReservation(String category,
                              String customerName,
                              String trainName,
                              int numberOfTickets,
                              String bookingClass){

        System.out.println("Transaction Number    :"+"\t"+ getTransNum.getTransactionNumber());
        System.out.println("Ticket Category       :"+"\t"+ category);
        System.out.println("Customer Name         :"+"\t"+ customerName);
        System.out.println("Train Name            :"+"\t"+ trainName);
        System.out.println("Number of Tickets     :"+"\t"+ numberOfTickets);
        System.out.println("Amount                :"+"\t"+ calculateAmount(bookingClass, numberOfTickets));
    }


}

/**
 * The AirTicketReservation class has a method - calculateAmount
 * and a constructor - AirTicketReservation defined
 */

class AirTicketReservation {

    Reservation getTransNum = new Reservation();  //object instantiation

    public double calculateAmount(String bookingClass, int numberOfTickets) {
        double totalAmt = 0;
        if (bookingClass.equalsIgnoreCase("business")) {   //when the booking class is Business
            totalAmt = numberOfTickets * 4500;
            return totalAmt;
        } else if (bookingClass.equalsIgnoreCase("economy")) {  //when the booking class is Economy
            totalAmt = numberOfTickets * 3500;
            return totalAmt;
        } else
            return totalAmt;

    }

    public AirTicketReservation(String category,
                                String customerName,
                                String trainName,
                                int numberOfTickets,
                                String bookingClass) {
        System.out.println("Transaction Number    :"+"\t"+ getTransNum.getTransactionNumber());
        System.out.println("Ticket Category       :"+"\t"+ category);
        System.out.println("Customer Name         :"+"\t"+ customerName);
        System.out.println("Train Name            :"+"\t"+ trainName);
        System.out.println("Number of Tickets     :"+"\t"+ numberOfTickets);
        System.out.println("Amount                :"+"\t"+ calculateAmount(bookingClass, numberOfTickets));

    }
}







