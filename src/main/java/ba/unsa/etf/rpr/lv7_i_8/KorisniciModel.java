package ba.unsa.etf.rpr.lv7_i_8;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class KorisniciModel {
    private ObservableList<Korisnik> korisnici = FXCollections.observableArrayList();
    private SimpleObjectProperty<Korisnik> trenutniKorisnik = new SimpleObjectProperty<>();

    public ObservableList<Korisnik> getKorisnici() {
        return korisnici;
    }

    public void setKorisnici(ObservableList<Korisnik> korisnici) {
        this.korisnici = korisnici;
    }

    public Korisnik getTrenutniKorisnik() {
        return trenutniKorisnik.get();
    }

    public SimpleObjectProperty<Korisnik> trenutniKorisnikProperty() {
        return trenutniKorisnik;
    }

    public void setTrenutniKorisnik(Korisnik trenutniKorisnik) {
        this.trenutniKorisnik.set(trenutniKorisnik);
    }

    public void ispuni(){
        korisnici.add(new Korisnik("Mahir","Residovic","mresidovic1","mresidovic1@etf.unsa.ba","aaaa"));
        korisnici.add(new Korisnik("Abdullah","Iseric","aiseric1","aiseric1@etf.unsa.ba","bbbbb"));
        korisnici.add(new Korisnik("Ibrahim","Tabakovic","itabakovic1","itabakovic1@etf.unsa.ba","ccccc"));
        trenutniKorisnik.set(null);
    }
}
