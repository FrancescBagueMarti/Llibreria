/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llibreria.lectors;
//Creates the neadded imports for the class
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Read is a Java class Which is able to read any type of value that the user 
 * introduces in the program.
 * 
 * <p>This is the "Read" class with messages</p>
 * @version 1.0 <p>01/15/2021</p>
 * @version 1.2 <p>01/15/2021</p>
 * @author Francesc Bagué Martí
 */
public class Read{
    //==================================== TEXT ====================================

    /**
     * Scans the whole token input as a String.
     * <p>If the scanned token in't from the expected type, it lunches an arror and returns a null value</p>
     * 
     * @return Returns the String
     */
    public static String _String(){
        return new Scanner(System.in).nextLine();
    }
//==================================== CHAR ====================================

    /**
     * <p>
     * Scans the next input as a character. If the user introduces a string, the 
     * program throws an "InputMismatchException" and then the loop starts again 
     * until the user introduces a correct character
     * </p>
     * 
     * @return Returns a character
     */
    public static char _char(){
        String aux = new Scanner(System.in).nextLine();

        if (aux.length() > 1) // si detecta que es una cadenallença un error
            throw new InputMismatchException("\u001B[31m" + "The input value must be a single character." + "\u001B[30m");
        else 
            return aux.charAt(0);
    }
//=================================== BOOLEAN ==================================

    /**
     * Asks the user if he wants to turn a boolean true or false.
     * 
     * @return Returns true or false depending on what the user wants
     */
    @Deprecated
    public static boolean _boolean_OLD(){
        System.out.print("(true or false): ");
        String  option = new Scanner(System.in).nextLine();
        boolean ret;
        /* Reads if the user wants to turn the boolean true or false */
        if (option.contains("true")){
            ret = true;
        }else if (option.contains("false")){
            ret = false;
        /*
            If the user hasn't entered neither true nor false, 
            the program lunches an error message and turns automatically 
            the boolean false
        */
        }else{
            ret = false;
            System.err.println(""
                    + "¡ERROR!"
                    + "\nUnidentified value detected.\n"
                    + "Automatically turning the boolean false");
        }

        return ret;
    }

    /**
     * <p>
     * Asks the user how he wants to turn a boolean through a character.<br>
     * The character, will be also introduced by the user through the use of a 
     * method from this class {@link #_char(java.lang.String) }
     * </p>
     * <p>If the scanned token in't from the expected type, it lunches an arror and returns a <b>o</b> value</p>
     * @return Returns a 'true' or a 'false' depending on the user wants
     */
    public static boolean _boolean(){
        char opcion;
        
        // calls the method _char for reading a character
        System.out.print("(y - n)");
        opcion = _char();
        
        opcion = Character.toLowerCase(opcion);
        /*
        This switch urns the boolean true or false depending on the 
        introduced character.
        If the character isn't one of the two options, the program 
        throws an 'InputMismatchException'and asks the user to introduce 
        an another character to read
        */
        switch (opcion) {
            case 'y': // Turns the boolean true
                return true;
            case 'n': // Turns the boolean false
                return false;
            default:// Throws the exception
                throw new InputMismatchException("\u001B[31m"+"The input must be one of the previously specified options"+"\u001B[30m");
        }
    }
//=================================== NUMBER ===================================

    /**
     * Scans the next token of the input as an integer.
     * <p>If the scanned token in't from the expected type, it lunches an arror and returns a <b>o</b> value</p>
     * 
     * @return Returns the integer
     */
    public static int _int(){
        return new Scanner(System.in).nextInt();
    }

    /**
     * <p>
     * Scans the next token of the input as a BigInteger
     *  - 
     * BigIntegers are used when extremely large values are to be 
     * stored or needed.
     * </p>
     * <p>If the scanned token in't from the expected type, it lunches an arror and returns a null value</p>
     * 
     * @return Returns a BigInteger
     */
    public static BigInteger _BigInteger() {
        return new Scanner(System.in).nextBigInteger();
    }

    /**
     * Scans the next token of the input as a float.
     * <p>If the scanned token in't from the expected type, it lunches an arror and returns a <b>o</b> value</p>
     * 
     * @return Returns a float
     */
    public static float _float(){
        return new Scanner(System.in).nextFloat();
    }

    /**
     * Scans the next token of the input as a double.
     * <p>If the scanned token in't from the expected type, it lunches an arror and returns a <b>o</b> value</p>
     * 
     * @return Returns a double
     */
    public static double _double(){
        return new Scanner(System.in).nextDouble();
    }

    /**
     * <p>
     * Scans the next token of the input as a BigDecimal
     *  - 
     * BigDecimals are used when there is a need for high precision calculations.
     * </p>
     * <p>If the scanned token in't from the expected type, it lunches an arror and returns a null value</p>
     * 
     * @return Returns a BigDecimal
     */
    public static BigDecimal _BigDecimal(){
        return new Scanner(System.in).nextBigDecimal();
    }

    /**
     * Scans the next token of the input as a Short.
     * <p>If the scanned token in't from the expected type, it lunches an arror and returns a <b>o</b> value</p>
     * 
     * @return Returns a "short"
     */
    public static short _short(){
        return new Scanner(System.in).nextShort();
    }

    /**
     * Scans the next token of the input as a long.
     * <p>If the scanned token in't from the expected type, it lunches an arror and returns a <b>o</b> value</p>
     * 
     * @return Returns a long
     */
    public static long _long(){
        return new Scanner(System.in).nextLong();
    }
//==================================== BYTE ====================================

    /**
     * Scans the next token of the input as a byte.
     * <p>If the scanned token in't from the expected type, it lunches an arror and returns a <b>o</b> value</p>
     * 
     * @return Returns a byte
     */
    public static byte _byte(){
        return new Scanner(System.in).nextByte();
    }
}
