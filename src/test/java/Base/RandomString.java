package Base;

import java.util.Random;

public class RandomString {

    public static String randomString(int countOfLetters) {

        String cyrillic = "QWERTYUIOPLKJHGFDSAZXCVBNM";
        char string;
        StringBuilder stringBuilder = new StringBuilder();
        String stringReturn;
        Random random = new Random();
        for (int i = 0; i < countOfLetters; i++) {
            string = cyrillic.charAt(random.nextInt(26));
            stringBuilder.append(string);
        }
        stringReturn = String.valueOf(stringBuilder);

        return stringReturn;
    }

    public static String randomStringCyrillic(int countOfLetters) {

        String cyrillic = "ЙЦУКЕНГШЩЗХЪФЫВАПРОЛДЖЭЯЧСМИТЬБЮ";
        char string;
        StringBuilder stringBuilder = new StringBuilder();
        String stringReturn;
        Random random = new Random();
        for (int i = 0; i < countOfLetters; i++) {
            string = cyrillic.charAt(random.nextInt(21));
            stringBuilder.append(string);
        }
        stringReturn = String.valueOf(stringBuilder);

        return stringReturn;
    }

    public static String randomStringSymbols(int countOfSymbols) {

        String cyrillic = "!@$%^&*(){}|?/.,#:;№";
        char string;
        StringBuilder stringBuilder = new StringBuilder();
        String stringReturn;
        Random random = new Random();
        for (int i = 0; i < countOfSymbols; i++) {
            string = cyrillic.charAt(random.nextInt(20));
            stringBuilder.append(string);
        }
        stringReturn = String.valueOf(stringBuilder);

        return stringReturn;
    }

    public static String randomDigits(int countOfDigits) {

        String cyrillic = "1234567890";
        char string;
        StringBuilder stringBuilder = new StringBuilder();
        String stringReturn;
        Random random = new Random();
        for (int i = 0; i < countOfDigits; i++) {
            string = cyrillic.charAt(random.nextInt(10));
            stringBuilder.append(string);
        }
        stringReturn = String.valueOf(stringBuilder);

        return stringReturn;
    }

}
