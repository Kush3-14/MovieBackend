package com.tickets;

/**
 * The main.Tax class helps in
 * calculation of different taxes.
 */

class Tax {

    private final static float SRATE = 14;
    private final static float ORATE = 0.5f;

    /* Method to calculate Service main.Tax*/
    float calSTax(int number){
        return number * (SRATE/100);
    }

    /* Method to calculate Swachh Bharat Cess */
    float calSBC(int number){
        return number * (ORATE/100);
    }

   /* Method to calculate Krishi Kalyan Cess */
   float calKC(int number){
        return number * (ORATE/100);

    }

}
