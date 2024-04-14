/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MaHoaVigenere;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class encryptVigenere {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ban ro: ");
        String plainText = sc.nextLine();
        System.out.print("Khoa vigenere: ");
        String key = sc.nextLine();

        String encryptedTexT = encrypt(plainText, key);
        System.out.println("Ban ma: " + encryptedTexT);
    }

    private static String encrypt(String plainText, String key) {
        StringBuilder result = new StringBuilder();
        int keyIndex = 0;
        for (int i = 0; i < plainText.length(); i++) {
            char ch = plainText.charAt(i);
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                char encryptedChar = (char) ((ch + key.charAt(keyIndex) - 2 * base) % 26 + base);
                result.append(encryptedChar);
                keyIndex = (keyIndex + 1) % key.length();
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }
}
