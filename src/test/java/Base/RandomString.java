package Base;

import io.qameta.allure.Step;

import java.util.Random;

public class RandomString {

    @Step("Generate random string of latin symbols")
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

    @Step("Generate random string of cyrillic symbols")
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

    @Step("Generate random string of special symbols")
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

    @Step("Generate random string of digits")
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
