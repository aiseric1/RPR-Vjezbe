package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Banka {
    private Long brojRacuna;
    private List<Korisnik>  korisnici;
    private List<Uposlenik> uposlenici;

    private Long generisiBrojRacuna() {
        Random rand = new Random();
        Long brojRacuna = Math.abs(rand.nextLong());
        return brojRacuna;
    }

    Banka(){
        brojRacuna = null;
        korisnici = new ArrayList<Korisnik>();
        uposlenici = new ArrayList<Uposlenik>();
    }
    public Korisnik kreirajNovogKorisnika(String ime, String prezime){
        Korisnik novi = new Korisnik(ime, prezime);
        korisnici.add(novi);
        return novi;
    }
    public Uposlenik kreirajNovogUposlenika(String ime, String prezime){
        Uposlenik novi = new Uposlenik(ime, prezime);
        uposlenici.add(novi);
        return novi;
    }
    public Racun kreirajRacunZaKorisnika(Korisnik x){
        Racun novi = new Racun(generisiBrojRacuna(), x);
        return novi;
    }
}
