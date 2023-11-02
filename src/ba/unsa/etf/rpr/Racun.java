package ba.unsa.etf.rpr;

public class Racun {
    private Long brojRacuna;
    private Osoba korisnikRacuna;
    private boolean odobrenjePrekoracenja;
    private double stanjeRacuna;
    public Racun(Long br, Osoba o){
        brojRacuna = br;
        korisnikRacuna = o;
        stanjeRacuna = 0;
        odobrenjePrekoracenja = false;
    }
    public void odobriPrekoracenje(double x){
        if(x >= 0) odobrenjePrekoracenja = true;
    }
    public boolean izvrsiUplatu(double p){
        if(p >= 0){
            stanjeRacuna += p;
            return true;
        }
        return false;
    }
    public boolean izvrsiIsplatu(double x){
        if(x >= 0 && (stanjeRacuna - x >= 0 || odobrenjePrekoracenja)){
            stanjeRacuna -= x;
            return true;
        }
        return false;
    }
    public boolean provjeriOdobrenjePrekoracenja(double x){
        return odobrenjePrekoracenja;
    }
}
