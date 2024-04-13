/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MaHoaCaesar;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class encryptCaesar {

    // Ham ma hoa PlainText thanh CipherText
    private static String encrypt(String text, int key) {
        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isUpperCase(ch)) {
                encryptedText.append((char) ((ch + key - 65) % 26 + 65));
            } else if (Character.isLowerCase(ch)) {
                encryptedText.append((char) ((ch + key - 97) % 26 + 97));
            } else {
                encryptedText.append(ch);
            }
        }

        return encryptedText.toString();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String plainText;
        int key;

        System.out.print("Chuoi can ma hoa (ban ro): ");
        plainText = scan.nextLine();

        System.out.print("Nhap khoa: ");
        key = Integer.parseInt(scan.nextLine());

        String cipherText = encrypt(plainText, key);
        System.out.println("Chuoi duoc ma hoa (ban ma): " + cipherText);
    }
}
