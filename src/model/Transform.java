package model;

public class Transform {
    public static String decimalToBase(int decimal, int base) {
        String result = "";

        while (decimal > 0) {
            int remainder = decimal % base;
            char digit;

            if (remainder < 10) {
                digit = (char)('0' + remainder);
            } else {
                digit = (char)('A' + (remainder - 10));
            }

            result = digit + result;
            decimal /= base;
        }

        return result;
    }

    public static String convert(String num, int originalBase, int targetBase) {
        int decimalNum = 0;

        // Convertir a decimal si no es decimal original
        if (originalBase != 10) {
            decimalNum = Integer.parseInt(num, originalBase);
        } else {
            decimalNum = Integer.parseInt(num);
        }

        // Convertir a la base objetivo
        if (targetBase == 10) {
            return ("" + decimalNum);
        } else {
            return decimalToBase(decimalNum, targetBase);
        }
    }
}
