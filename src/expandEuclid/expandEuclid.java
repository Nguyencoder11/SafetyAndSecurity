/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expandEuclid;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
// Su dung Euclid mo rong de tim r1^-1 mod r0
// thoa man s.r0 + t.r1 = gcd(r0, r1) = 1
// Input: r0, r1
// Output: r1^-1 mod r0, neu ton tai
public class expandEuclid {

    private static void extendedEuclidean(int r0, int r1, ArrayList<Integer> steps, ArrayList<Integer> rs, ArrayList<Integer> qs, ArrayList<Integer> sValues, ArrayList<Integer> tValues) {
        int rPrev = r0;
        int rCurr = r1;
        int rNext;

        int sPrev = 1;
        int sCurr = 0;
        int sNext;

        int tPrev = 0;
        int tCurr = 1;
        int tNext;

        int qNext;

        steps.add(0);
        rs.add(rPrev);
        rs.add(rCurr);
        qs.add(0);
        sValues.add(sPrev);
        sValues.add(sCurr);
        tValues.add(tPrev);
        tValues.add(tCurr);

        int step = 1;

        while (rCurr != 0) {
            qNext = rPrev / rCurr;  // q(i+1) = r(i)/r(i+1)

            rNext = rPrev - qNext * rCurr;  // r(i+2) = r(i) - q(i+1)*r(i+1)

            sNext = sPrev - qNext * sCurr;  // s(i) = s(i-2) - q(i-1)*s(i-1)

            tNext = tPrev - qNext * tCurr;  // t(i) = t(i-2) - q(i-1)*t(i-1)

            steps.add(step);
            rs.add(rNext);
            qs.add(qNext);

            sValues.add(sNext);
            tValues.add(tNext);

            // Cập nhật giá trị cho vòng lặp tiếp theo
            rPrev = rCurr;
            rCurr = rNext;

            sPrev = sCurr;
            sCurr = sNext;

            tPrev = tCurr;
            tCurr = tNext;

            step++;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> steps = new ArrayList<>();   // luu tru cac buoc
        ArrayList<Integer> rs = new ArrayList<>();  // luu tru r
        ArrayList<Integer> qs = new ArrayList<>();  // luu tru q
        ArrayList<Integer> sValues = new ArrayList<>();  // luu tru gia tri s
        ArrayList<Integer> tValues = new ArrayList<>();  // luu tru gia tri t

        System.out.print("r0 = ");
        int r0 = scan.nextInt();
        System.out.print("r1 = ");
        int r1 = scan.nextInt();

        extendedEuclidean(r0, r1, steps, rs, qs, sValues, tValues);
        System.out.println("Step[]: " + steps);
        System.out.println("r[]: " + rs);
        System.out.println("q[]: " + qs);
        System.out.println("s[]: " + sValues);
        System.out.println("t[]: " + tValues);

        System.out.println("Buoc\t r(i)\t q(i+1)\t r(i+1)\t r(i+2)\t s(i)\t t(i)");
        for (int i = 0; i < steps.size(); i++) {
            int step = steps.get(i);
            System.out.printf("%d\t %d\t %d\t %d\t %d\t %d\t %d%n", step, rs.get(i), qs.get(i + 1), rs.get(i + 1), rs.get(i + 2), sValues.get(i), tValues.get(i));
        }

    }
}
