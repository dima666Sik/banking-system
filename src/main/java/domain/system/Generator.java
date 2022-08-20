package domain.system;

import domain.models.Card;

import java.util.Calendar;

public class Generator {

    public static String generateNumberCard() {
        String bankIdentifier = String.valueOf(generateRandomize(10_000, 99_999));
        String cardID = String.valueOf(generateRandomize(1_00_000_000, 9_99_999_999));
        String checkDigit = String.valueOf(generateRandomize(0, 9));
        return Card.FIRST_NUMBER_PAYMENT_SYSTEM_MASTER_CARD + bankIdentifier + cardID + checkDigit;
    }

    public static String generateCardEndDataMonth() {
        int currentMonth = Calendar.getInstance().get(Calendar.MONTH) + 1;
        return currentMonth > 9 ? String.valueOf(currentMonth) : "0" + currentMonth;
    }

    public static String generateCardEndDataYear() {
        return String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
    }

    /**
     * Please change methods, we must get not only num from 100 to 999, for example 002 or 082 -> done
     */
    public static String generateCVC2() {
        int gNum = generateRandomize(1, 999);
        String sGNum = String.valueOf(gNum);
        return gNum > 10 ? gNum > 100 ? sGNum : "0" + sGNum : "00" + sGNum;
    }

    private static int generateRandomize(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }

    public static String generateData(int deadline) {
        Calendar calendar = Calendar.getInstance();
        int data = calendar.get(Calendar.DATE);
        calendar.add(Calendar.MONTH, deadline);
        int month = calendar.get(Calendar.MONTH) + 1;
        int year = calendar.get(Calendar.YEAR);
        return data + ":" + month + ":" + year;
    }
}
