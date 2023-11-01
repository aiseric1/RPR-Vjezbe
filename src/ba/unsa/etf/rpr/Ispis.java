package ba.unsa.etf.rpr;

import java.util.Scanner;

public class Ispis {

    public static void main(String[] args){

        Scanner ulaz = new Scanner(System.in);

        int a, b;
        System.out.println("Unesite brojeve: ");
        a = ulaz.nextInt();
        b = ulaz.nextInt();
        System.out.println(a + " " + b);

    }
}