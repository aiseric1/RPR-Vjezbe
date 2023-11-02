package ba.unsa.etf.rpr;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	System.out.println("Unesite brojeve: ");
	Scanner ulaz = new Scanner(System.in);
	List<Double> lista = new ArrayList<Double>();
	while(true){
		String temp = ulaz.nextLine();
		if(temp.equals("stop")) break;
		try {
			Double broj = Double.parseDouble(temp);
			lista.add(broj);
		}catch(NumberFormatException e){
			System.out.println("Neispravan unos. Molimo unesite broj ili stop.");
		}
    }
	Double min = lista.get(0);
	Double max = lista.get(0);
	Double srednja_vrijednost = 0.0;
	Double sum = 0.0;
	Double standardna_devijacija = 0.0;
	Double c = 0.0;

	for(Double x : lista){
		if(x < min) min = x;
		if(x > max) max = x;
		sum = sum + x;
	}
	srednja_vrijednost = sum / lista.size();

	for(Double x : lista){
		c += Math.pow(x - srednja_vrijednost, 2);
	}
	standardna_devijacija = Math.sqrt(c / lista.size());
	System.out.println("Min element: " + min);
	System.out.println("Max element: " + max);
	System.out.println("Srednja vrijednost: " + srednja_vrijednost);
	System.out.println("Standardna devijacija: " + standardna_devijacija);
    }
}
