package ba.unsa.etf.rpr;

public class Kalkulator {
    public static double izracunaj_sinus(double x){
        return Math.sin(x);
    }
    public static int izracunaj_faktorijel(int x){
        if(x == 0) return 1;
        int rezultat = 1;
        for(int i = 2; i <= x; i++){
            rezultat *= i;
        }
        return rezultat;
    }
}
