package ba.unsa.etf.rpr;

public class Main {

    public static void main(String[] args) {
        double broj = Double.parseDouble(args[1]);
        double sin_broj = Kalkulator.izracunaj_sinus(broj);
        int faktorijel_broj = Kalkulator.izracunaj_faktorijel((int)broj);
        System.out.println("Sinus broja " + broj + " je " + " je " + sin_broj + ",a faktorijel je " + faktorijel_broj);
    }
}
