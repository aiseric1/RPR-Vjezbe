package ba.unsa.etf.rpr;

import java.util.Scanner;
import java.util.Arrays;

public class Suma {
    public static void sumaCifara(int n){
        for(int i = 1; i <= n; i++){
            int broj = i;
            int suma = 0;
            while(broj != 0){
                int cifra = broj % 10;
                suma += cifra;
                broj /= 10;
            }
            if(i % suma == 0){
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner ulaz = new Scanner(System.in);
        int n;
        System.out.println("Unesite broj n: ");
        n = ulaz.nextInt();
        sumaCifara(n);
    }
}