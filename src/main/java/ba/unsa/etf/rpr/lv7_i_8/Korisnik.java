package ba.unsa.etf.rpr.lv7_i_8;

import javafx.beans.property.SimpleStringProperty;

import java.util.SimpleTimeZone;

public class Korisnik {
    SimpleStringProperty ime, prezime, mail, korisnicko_ime, lozinka;

    public Korisnik() {
        ime = new SimpleStringProperty("");
        prezime = new SimpleStringProperty("");
        mail = new SimpleStringProperty("");
        korisnicko_ime = new SimpleStringProperty("");
        lozinka = new SimpleStringProperty("");
    }

    public Korisnik(String ime, String prezime,  String korisnicko_ime, String mail, String lozinka) {
        this.ime = new SimpleStringProperty(ime);
        this.prezime = new SimpleStringProperty(prezime);
        this.korisnicko_ime = new SimpleStringProperty(korisnicko_ime);
        this.mail = new SimpleStringProperty(mail);
        this.lozinka = new SimpleStringProperty(lozinka);
    }

    public String getIme() {
        return ime.get();
    }

    public SimpleStringProperty imeProperty() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime.set(ime);
    }

    public String getPrezime() {
        return prezime.get();
    }

    public SimpleStringProperty prezimeProperty() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime.set(prezime);
    }

    public String getMail() {
        return mail.get();
    }

    public SimpleStringProperty mailProperty() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail.set(mail);
    }

    public String getKorisnicko_ime() {
        return korisnicko_ime.get();
    }

    public SimpleStringProperty korisnicko_imeProperty() {
        return korisnicko_ime;
    }

    public void setKorisnicko_ime(String korisnicko_ime) {
        this.korisnicko_ime.set(korisnicko_ime);
    }

    public String getLozinka() {
        return lozinka.get();
    }

    public SimpleStringProperty lozinkaProperty() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka.set(lozinka);
    }

    @Override
    public String toString() {
        return  ime.get() + " " + prezime.get();
    }
}
