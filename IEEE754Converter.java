package Assignment02;

import java.util.Scanner;
import java.lang.Math;

public class IEEE754Converter {

    static void validatingSign1(char sign) {
        if (sign == '+') {
            System.out.print("0");
        } else {
            System.out.print("1");
        }
    }

    static void decimToBin(int E) {

        int[] decimalArray = new int[50];
        int index = 0;

        while (E > 0) {
            decimalArray[index++] = E % 2;
            E = E / 2;
        }

        for (int i = index - 1; i >= 0; i--) {
            System.out.print((decimalArray[i]));
        }

    }

    static void validatingMantissaBits(int length) {
        if (length < 23) {
            for (int i = 0; i <= (23 - (length + 1)); i++) {
                System.out.print("0");
            }
        }
    }

    static void validatingSign2(char sign) {
        if (sign == '1') {
            System.out.print("-1.");
        } else {
            System.out.print("+1.");
        }

    }

    static void validatingMantissa(String mantissa) {

        char[] characters = mantissa.toCharArray();

        int count = 0;
        for (int i = 22; i >= 0; i--) {
            if (characters[i] == '1') {
                break;
            }
            count = count + 1;
        }

        String fractionPart;
        fractionPart = mantissa.substring(0, (23 - count));
        System.out.print(fractionPart);

    }

    static int binToDecim(int number) {

        int sum = 0;
        int power = 0;

        while (number > 0) {
            int x = number % 10;
            number = number / 10;
            sum = (int) (sum + (x * Math.pow(2, power)));
            power++;
        }
        return sum;

    }

    public static void main(String[] args) {

        System.out.println("****************************************************************************\n"
                + "* Press 1 to enter binary to IEEE 754 Single precision format converter\n"
                + "* Press 2 to enter IEEE 754 Single precision format to binary converter\n"
                + "****************************************************************************\n");

        System.out.println("Chooese your conversion type: ");
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();

        switch (x) {
            case 1:
                System.out.println("Enter the number with the sign: ");
                Scanner scan1 = new Scanner(System.in);
                String number = scan1.nextLine();
                //String number = "+101101.101";
                
                char sign;
                String newNumber;
                String part1;
                String part2;
                double scienteficNum;
                String newScienteficNum;

                sign = number.charAt(0);
                newNumber = number.substring(1, (number.length()));
                int points = newNumber.indexOf(".");
                scienteficNum = Double.parseDouble(newNumber);
                scienteficNum = scienteficNum * (Math.pow(10, points));
                newScienteficNum = String.valueOf(scienteficNum);
                newScienteficNum = newScienteficNum.substring(0, (newScienteficNum.length() - 3));
                part2 = newScienteficNum.substring(2);
                int length = part2.length();
                int E = 127 + (points - 1);

                System.out.println("\nIEEE 754 Single precision format: ");
                validatingSign1(sign);
                System.out.print(" | ");
                decimToBin(E);
                System.out.print(" | ");
                System.out.print(part2);
                validatingMantissaBits(length);
                System.out.println("");
                break;

            case 2:
                System.out.println("Enter the sign: ");
                Scanner scan2 = new Scanner(System.in);
                char sign1 = scan2.next().charAt(0);
                //char sign1 = '1';

                System.out.println("Enter the exponent: ");
                Scanner scan3 = new Scanner(System.in);
                int exponent = scan3.nextInt();
                //int exponent = 10011101;

                System.out.println("Enter the mantissa: ");
                Scanner scan4 = new Scanner(System.in);
                String mantissa = scan4.nextLine();
                //String mantissa = "10111001110000000000000";
                
                int power;
                power = binToDecim(exponent) - 127;

                System.out.println("\nIEEE 754 single precision format to binary form: ");
                validatingSign2(sign1);
                validatingMantissa(mantissa);
                System.out.println(" * " + 2 + "^" + power);
                break;

            default:
                System.out.println("Invalid input!");
        }

    }

}
