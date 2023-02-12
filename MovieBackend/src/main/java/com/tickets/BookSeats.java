package com.tickets;

import java.text.DecimalFormat;
import java.util.*;

/**
 * The Book class helps to book tickets
 * ,and it also calculates revenues and taxes.
 */

public class BookSeats extends Tax{

    private final int no; // show number
    private final String[] seats; // array to store the seats chosen by the user

    // these variables store the revenue and texes for a specific show
    private static int total;
    private static int subTotal;
    private static double sTax;
    private static double swatchBharatCess;
    private static  double krishiCess;

    /* these variables store the total revenue and taxes
     for the theatre owner */
    private static int totalRev;
    private static  double totalSTax;
    private static  double totalSwatchBharatCess;
    private static  double totalKrishiCess;

    // price of different seats
    private static final int A = 320;
    private static final int B = 280;
    private static final int C = 240;

    /* three arraylists to store the previously booked seats
     and to their availability */
    private static final ArrayList<String> s1 = new ArrayList<>();
    private static final ArrayList<String> s2 = new ArrayList<>();
    private static final ArrayList<String> s3 = new ArrayList<>();


    BookSeats(int no, String seat){
        this.no = no;
        seats = seat.split(",");
    }

    // DecimalFormat class is used to format the tax generated in correct manner
    DecimalFormat f = new DecimalFormat("##.00");


    /* This method books tickets and also checks if they are available to book or not
    it also calculates the subtotal according to the seats booked.
     */
    void bookTicket(){

        if (no == 1){
            for (String str : seats){
                if (s1.contains(str)){
                    System.out.println(str + " Not available, Please select different seats");
                    return;
                }else{
                    s1.add(str);
                    if (str.contains("A")){
                        subTotal += A;
                    }else if (str.contains("B")){
                        subTotal += B;
                    }else if (str.contains("C")){
                        subTotal += C;
                    }
                }
            }
            calculateT(subTotal);
            show(no,subTotal,sTax,swatchBharatCess,krishiCess,total);
        }else if (no == 2){
            for (String str : seats){
                if (s2.contains(str)){
                    System.out.println(str + " Not available, Please select different seats");
                    return;
                }else{
                    s2.add(str);
                    if (str.contains("A")){
                        subTotal += A;
                    }else if (str.contains("B")){
                        subTotal += B;
                    }else if (str.contains("C")){
                        subTotal += C;
                    }
                }
            }
            calculateT(subTotal);
            show(no,subTotal,sTax,swatchBharatCess,krishiCess,total);
        }else if (no == 3){
            for (String str : seats){
                if (s3.contains(str)){
                    System.out.println(str + " Not available, Please select different seats");
                    return;
                }
                else{
                    s3.add(str);
                    if (str.contains("A")){
                        subTotal += A;
                    }else if (str.contains("B")){
                        subTotal += B;
                    }else if (str.contains("C")){
                        subTotal += C;
                    }
                }
            }
            calculateT(subTotal);
            show(no,subTotal,sTax,swatchBharatCess,krishiCess,total);
        }else{
            System.out.println("Please enter a valid show number");
        }

        // adding the revenues and taxes to overall revenues and taxes for the owner
        totalRev += subTotal;
        totalSTax += sTax;
        totalSwatchBharatCess += swatchBharatCess;
        totalKrishiCess += krishiCess;

        // Initializing all variables to 0, if users continues to book seats.
        subTotal = 0;
        total = 0;
        sTax = 0;
        swatchBharatCess = 0;
        krishiCess = 0;
    }

    // This method prints the total, subtotal and all texes for a specific show
    void show(int no, int sub, double st,double sb, double kc, int t){
        System.out.println("Successfully Booked - Show "+no);
        System.out.println("Subtotal: Rs. "+sub);
        System.out.println("Service Tax @14%: Rs. "+f.format(st));
        System.out.println("Swachh Bharat Cess @0.5%: Rs. "+f.format(sb));
        System.out.println("Krishi Kalyan Cess @0.5%: Rs. "+f.format(kc));
        System.out.println("Total: Rs. "+t);
    }

    // This method calculates taxes and price for a specific show
    void calculateT(int subt){
        sTax += calSTax(subt);
        swatchBharatCess += calSBC(subt);
        krishiCess += calKC(subt);
        total += Math.round(subt + sTax + swatchBharatCess + krishiCess);
    }

    // This method prints the total revenue and taxes to the theatre owner.
    void showTotal(){
        System.out.println("Total Sales:");
        System.out.println("Revenue: Rs. "+totalRev);
        System.out.println("Service Tax: Rs."+ f.format(totalSTax));
        System.out.println("Swachh Bharat Cess: Rs." + f.format(totalSwatchBharatCess));
        System.out.print("Krishi Kalyan Cess: Rs." + f.format(totalKrishiCess));
    }

}