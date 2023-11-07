package ba.unsa.etf.rpr;

import java.util.Scanner;
import java.util.Set;

public class Program {

    public static void main(String[] args) {
        Imenik imenik = new Imenik();
        while(true){
            System.out.println("Unesite komandu: ");
            System.out.println("dodaj, naSlovo, izGrada, izGradaBrojevi, izlaz");
            Scanner ulaz = new Scanner(System.in);
            String a = ulaz.nextLine();
            switch (a){
                case "dodaj" :
                    System.out.println("Unesite tip broja[fiksni, mobilni, medunarodni]");
                    String tipBroja = ulaz.nextLine();
                    if(tipBroja.equals("fiksni")){
                        System.out.println("Unesite ime: ");
                        String ime = ulaz.nextLine();
                        System.out.println("Unesite grad:(Velikim slovima)");
                        String grad = ulaz.nextLine();
                        Grad g;
                        try {
                            g = Grad.valueOf(grad);
                            System.out.println("Unesite broj: ");
                            String broj = ulaz.nextLine();
                            imenik.dodaj(ime, new FiksniBroj(g, broj));
                        }catch(IllegalArgumentException e){
                            System.out.println("Pogresno unijet grad!");
                        }

                    }else if(tipBroja.equals("mobilni")){
                        System.out.println("Unesite ime: ");
                        String ime = ulaz.nextLine();
                        System.out.println("Unesite mobilnu mrezu: ");
                        int mobMreza;
                        try {
                            mobMreza = ulaz.nextInt();
                            if(!(mobMreza >= 60 && mobMreza <= 67))throw new IllegalArgumentException("Neispravna mobilna mreza!");
                            System.out.println("Unesite broj: ");
                            String broj = ulaz.nextLine();
                            imenik.dodaj(ime, new MobilniBroj(mobMreza, broj));
                        }catch(IllegalArgumentException e){
                            System.out.println(e);
                        }
                    }else if(tipBroja.equals("medunarodni")){
                        System.out.println("Unesite ime: ");
                        String ime = ulaz.nextLine();
                        System.out.println("Unesite pozivni broj drzave: ");
                        String pozivniBroj = ulaz.nextLine();
                        System.out.println("Unesite broj: ");
                        String broj = ulaz.nextLine();
                        imenik.dodaj(ime, new MedunarodniBroj(pozivniBroj, broj));
                    }
                    break;
                case "naSlovo" :
                    System.out.println("Unesite slovo: ");
                    char c = ulaz.nextLine().toUpperCase().charAt(0);
                    String s = imenik.naSlovo(c);
                    System.out.println(s);

                    break;
                case "izGrada" :
                    System.out.println("Unesite grad: ");
                    String grad = ulaz.nextLine();
                    Set<String> g = imenik.izGrada(Grad.valueOf(grad));
                    for(String ime : g){
                        System.out.println(ime);
                    }
                    break;
                case "izGradaBrojevi" :
                    System.out.println("Unesite grad: ");
                    grad = ulaz.nextLine();
                    Set<TelefonskiBroj> p = imenik.izGradaBrojevi(Grad.valueOf(grad));
                    for(TelefonskiBroj br : p) System.out.println(br);

                case "izlaz" :
                    System.exit(0);
            }
        }
    }
}
