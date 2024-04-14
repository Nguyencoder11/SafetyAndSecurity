/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MuVaNhan;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author ADMIN
 */
public class PowerAndMultiple {

    // Ham tinh UCLN cua 2 so
    private static int GCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return GCD(b, a % b);
    }

    // Ham chuyen mu n ve dang nhi phan
    private static void changePowerToBinary(int n, Stack<Integer> binary) {
        while (n > 0) {
            binary.push(n % 2);
            n /= 2;
        }

    }

    private static int powAndMulti(Stack<Integer> binary, int x, int m) {
        int p = 1;

        while (!binary.isEmpty()) {
            p = (p * p) % m;
            if (binary.pop() == 1) {
                p = (p * x) % m;
            }
        }

        return p;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // su dung stack de luu tru cac bit
        Stack<Integer> binary = new Stack<>();
        int x, n, m;
        System.out.print("x = ");
        x = Integer.parseInt(sc.nextLine());
        System.out.print("n = ");
        n = Integer.parseInt(sc.nextLine());
        System.out.print("m = ");
        m = Integer.parseInt(sc.nextLine());

        changePowerToBinary(n, binary);

        System.out.printf("%d^%d mod %d = %d%n", x, n, m, powAndMulti(binary, x, m));
    }
}
