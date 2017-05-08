package tempconverter;

import java.util.Scanner;

/**
 *
 * @author Ali Haji
 */
public class TempConverter {

    static Scanner sc = new Scanner(System.in);
    static boolean usingk;

    public static void main(String[] args) {

        System.out.println("Welcome to the Temperature Converter!\n");

        usingk = getUsingK();

        int cvtype = getCVType();//cvtype has a value of 0, or 1, or 2, or 3, getting from getCVType method
        while (cvtype != 0) {  //checking the option for quit
            if (cvtype == 1) {
                FtoC(); //converting Fahrenheit to Celsius
            } else if (cvtype == 2) {
                CtoF();//converting Celsius to Fahrenheit 
            } else if (cvtype == 3) {
                
                sc.nextLine();
                usingk = getUsingK(); //stop/start the Kelvin temp
                
            } else {
                System.out.println("Invali input ");//How would we get invalid choice here while we did validation?
            }
            cvtype = getCVType();
        }//end of while
        System.out.println("Thanks for using the Temp Converter");
    }// end of main ////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static boolean getUsingK() {
        //process to let user show or stop display of K temp
        String kchoice;
        
        boolean k = true;
        boolean goodval = false;

        do {
        try {
            System.out.print("Would you also like to see degrees Kelvin(K) in the trsult? (Y/N): ");
            kchoice = sc.nextLine();

            if (!kchoice.isEmpty() && kchoice.substring(0, 1).equalsIgnoreCase("Y")) {
                k = true;
                goodval = true;

            } else {
                k = false;
                goodval = true;
            }
        } catch (Exception e) {
           System.out.println("bad value please say yes or no!");
           
        }
        }while(!goodval) ;
        
        return k;
    }//end of getUsingK/////////////////////////////////////////////////////////////////////////////////////

    public static int getCVType() {
        //obtain and validate input of conversision type (F-to-c, C-to-F, start/stop K, or Quit)
        int cv; //conversion type
        do {
            try {
                System.out.print("Select conversion type (1=F to C, 2=C to F, 3=stop/start K, 0=end)");
                cv = sc.nextInt();
                if (cv < 0 || cv > 3) {
                    System.out.println("Erorr: entry is not valid, please try again");
                }//end of if for erorr massage
            } catch (Exception e) {
                System.out.println("Iligal value entry, System erorr says: " + e.getMessage());
                sc.nextLine();//clear input buffer
                cv = -1; // force loop to repeat
            }//end of catch
        } while (cv < 0 || cv > 3);
        return cv; // here we have good value for convert type cv = 0 or 1 or 2 or 3
    }//end of CVType////////////////////////////////////////////////////////////////////////////////////////

    static void FtoC() {
        //obtain Fahrenheit temp and convert to Celsius (with out put)
        double tF, tC;//for fahrenhit and Celsius temp
        tF = getTemp("Fahrenheit");
        tC = (tF - 32) * (5 / 9); //Calculating the Celsius value
        System.out.println("A temp of " + tF + " Fahrenheit converted to Celsius = " + tC + " C");
        if (usingk ) {  //chcking if user asked for Kelvin too
            showDegreesK(tC); //calling showDereeK to print the K value as well      
        }//end of if for Kelvin result
    }//end of FtoC

    static void CtoF() {                                     
        //obtain Celsius temp and convert to Fahrenheit (with out put)
        double tF, tC;//for fahrenhit and Celsius temp
        tC = getTemp("Celsius");
        
        tF = (tC * 9 / 5) + 32;
        System.out.println("A temp of " + tC + " Celsius converted to Fahrenheit = " + tF + " F");
        if (usingk ) {  //chcking if user asked for Kelvin too
            showDegreesK(tC); //calling showDereeK to print the K value as well      
        }//end of if for Kelvin result
    }//end of CtoF//////////////////////////////////////////////////////////////////////////////////////////

    static double getTemp(String temptype) {
        //obtain the temp value to converted
        boolean badval2 = false; //for loop control
        double t = 0; //temp variable to be returned
        do {
            try {
                System.out.print("Enter your " + temptype + " temperature: ");
                t = sc.nextDouble();
                badval2 = true;

            } catch (Exception e) {
                System.out.println("bad value enterd");
                sc.nextLine();

            }//end of try/catch
        } while (!badval2);
        return t;

    }//end of getTemp///////////////////////////////////////////////////////////////////////////////////////

    static void showDegreesK(double c) {
        // method to display Kelvin temp when requasted
        double tK; // for temp in Kelvin
        tK = c + 273.15;
        if (tK < 0) {
            System.out.println("This temperature is not possible, as it is below 0 K");
        } else {
            System.out.println("This is also the temperature of: " + tK + " K");
        }//printing the result for Kelvin
    }//end of showDgreeK////////////////////////////////////////////////////////////////////////////////////

}//end of class /////////////////////////////////////////////////////////////////////////////////////////////
