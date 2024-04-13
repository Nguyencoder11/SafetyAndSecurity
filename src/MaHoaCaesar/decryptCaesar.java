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
public class decryptCaesar {
    // Ham ma hoa CipherText thanh PlainText
    private static String decrypt(String text, int key) {
        StringBuilder decryptedText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isUpperCase(ch)) {
                decryptedText.append((char) ((ch - key - 65) % 26 + 65));
            } else if (Character.isLowerCase(ch)) {
                decryptedText.append((char) ((ch - key - 97) % 26 + 97));
            } else {
                decryptedText.append(ch);
            }
        }

        return decryptedText.toString();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String cipherText;
        int key;

        System.out.print("Chuoi can giai ma (ban ma): ");
        cipherText = scan.nextLine();

        System.out.print("Nhap khoa: ");
        key = Integer.parseInt(scan.nextLine());

        String plainText = decrypt(cipherText, key);
        System.out.println("Chuoi duoc giai ma (ban ro): " + plainText);
    }
}
