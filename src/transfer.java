import java.io.BufferedReader;
import java.io.InputStreamReader;

public class transfer {

    //Simple converter for alphabets without Letters
    public static long convertible(long ch, long osn) {
        long k = 0;
        int razr = (Long.toString(ch)).length();
        for (int i = 0; i < razr; i++) {
            k = (k + ((ch % 10) * (int) (java.lang.Math.pow(osn, i))));
            ch = ch / 10;
        }
        return k;
    }

    //Complex converter with alphabet initialization
    public static String DecToArbSys(long decimalNumber, int radix) throws Exception {
        final int BitsInLong = 64;
        final String Digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //exception
        if (radix < 2 || radix > Digits.length()) {
            throw new Exception("The radix must be >= 2 and <= " + Digits.length());
        }
        //simplifier
        if (decimalNumber == 0) {
            return "0";
        }
        //0-63
        int index = BitsInLong - 1;
        long currentNumber = Math.abs(decimalNumber);
        char[] charArray = new char[BitsInLong];

        while (currentNumber != 0) {
            int remainder = (int) (currentNumber % radix);
            charArray[index--] = Digits.charAt(remainder);
            currentNumber = currentNumber / radix;
        }

        String result = new String(charArray, index + 1, BitsInLong - index - 1);
        //Privative numbers
        if (decimalNumber < 0) {
            result = "-" + result;
        }
        return result;
    }

    public static void main(String Args[]) throws Exception {
        int origin;
        int destiny;
        long k = 0;
        /*
        Buffer declaration + initialization
        */
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        origin = Integer.parseInt(reader.readLine());
        destiny = Integer.parseInt(reader.readLine());
        String numb = reader.readLine();

        if (origin > 10) {
            char[] ceil = numb.toCharArray();
            for (int i1 = numb.length() - 1, i4 = 0; i1 >= 0; i1--, i4++) {

                if (ceil[i1] > 47 && ceil[i1] < 58) {
                    k += (ceil[i1] - 48) * (long) Math.pow(origin, i4);

                } else if (ceil[i1] > 64 && ceil[i1] < 91) {
                    k += (ceil[i1] - 65 + 10) * (long) (Math.pow(origin, i4));

                } else if (ceil[i1] > 96 && ceil[i1] < 123) {
                    k += (ceil[i1] - 97 + 10) * (long) (Math.pow(origin, i4));
                }
            }
            String result = DecToArbSys(k, destiny);
            System.out.println(result);
        } else {
            long ceil = Long.parseUnsignedLong(numb);
            long k1 = convertible(ceil, origin);
            String result = DecToArbSys(k1, destiny);
            System.out.println(result);
        }
    }


}
