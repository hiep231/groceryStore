package groceryStore.service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
interface CommonInterface {
    String getTime();
    String inputPayment();
    boolean checkPayment(String payment);
    char generateRandomDigit();
    char generateRandomUppercaseLetter();
    Double checkDouble();
    Integer checkInteger();
}
public class Common implements CommonInterface {
    public static Scanner scanner = new Scanner(System.in);
    public String generateRandom(String prefix) {
        char digit1 = generateRandomDigit();
        char UpperLetter = generateRandomUppercaseLetter();
        char digit2 = generateRandomDigit();
        return prefix + digit1 + UpperLetter + digit2;
    }
    public String getTime() {
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("dd-MM-yyy // HH:mm:ss");
        return time.format(timeFormat);
    }
    public String inputPayment() {
        String payment;
        System.out.println("Enter customer choice payment: ");
        payment = scanner.next();
        return payment;
    }
    public boolean checkPayment(String payment) {
        return payment.equals("cod") || payment.equals("momo") || payment.equals("zalopay");
    }
    public char generateRandomDigit() {
        Random random = new Random();
        int digit = random.nextInt(10);
        return (char) (digit + '0');
    }
    public char generateRandomUppercaseLetter() {
        Random random = new Random();
        int letter = random.nextInt(26);
        return (char) (letter + 'A');
    }
    public Double checkDouble(){
        while (true) {
            try {
                Double aDouble = scanner.nextDouble();
                return aDouble;
            } catch (InputMismatchException e) {
                scanner.next();
            }
        }
    }
    public Integer checkInteger(){
        while (true) {
            try {
                Integer aInteger = scanner.nextInt();
                return aInteger;
            } catch (InputMismatchException e) {
                scanner.next();
            }
        }
    }
}
