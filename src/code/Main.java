package code;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the message for decryption: ");
        String cipherMessage = input.nextLine();

        System.out.println("Enter shift: ");
        int shift = input.nextInt();

        System.out.println("Decrypted message: " + decrypt(cipherMessage, shift));
        input.nextLine();

        System.out.println("Enter the message for encryption: ");
        String message = input.nextLine();

        System.out.println("Enter shift: ");
        int shiftEncryption = input.nextInt();

        System.out.println("Encrypted message: " + encrypt(message, shiftEncryption));
    }

    public static String decrypt(String cipherMessage, int shift) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        cipherMessage = cipherMessage.toUpperCase();
        String originalMessage = "";

        for (int i = 0; i < cipherMessage.length(); i++) {
            if (cipherMessage.charAt(i) == ' ') {
                originalMessage += " ";
            } else {
                int charPosition = alphabet.indexOf(cipherMessage.charAt(i));
                int value = (shift + charPosition) % 26;
                char replaceValue = alphabet.charAt(value);
                originalMessage += replaceValue;
            }
        }
        return originalMessage;
    }

    public static String encrypt(String message, int shift) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        message = message.toUpperCase();
        String cipherMessage = "";

        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == ' ') {
                cipherMessage += " ";
            } else {
                int charPosition = alphabet.indexOf(message.charAt(i));
                int value = (charPosition - shift) % 26;
                if (value < 0) {
                    value = alphabet.length() + value;
                }
                char replaceValue = alphabet.charAt(value);
                cipherMessage += replaceValue;
            }
        }
        return cipherMessage;
    }
}
