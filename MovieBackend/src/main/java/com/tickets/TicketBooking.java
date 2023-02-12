package com.tickets;

import java.util.*;

public class TicketBooking {

    public void showSeats(){
        SeatingArrangements show = new SeatingArrangements();
        show.showA1();
        show.showA2();
        show.showA3();
    }
    public void bookTickets() {

        String res; // variable to check if user wants to continue or not

        Scanner scn = new Scanner(System.in);

        BookSeats book = null;

        // to try and catch an exception if it occurs
        try {

            System.out.print("Enter Show No.: ");
            int showNo = scn.nextInt();
            System.out.print("Enter seats: ");
            String seats = scn.next();
            book = new BookSeats(showNo, seats);
            book.bookTicket();

            while (true) {
                System.out.print("Would you like to continue (Yes/No): ");
                res = scn.next();
                if (res.toLowerCase().equals("no")){ // run this loop until user writes no
                    return;
                }

                System.out.print("Enter Show No.: ");
                showNo = scn.nextInt();
                System.out.print("Enter seats: ");
                seats = scn.next();
                book = new BookSeats(showNo, seats);
                book.bookTicket();
            }
        }catch(Exception e){
            System.out.println(e.getCause());
        }
        finally {
            if (book != null) // check whether book is null of not before executing next line
             book.showTotal();
        }

    }

}
