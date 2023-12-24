package ba.unsa.etf.rpr.lv7_i_8;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class MeniController {
        public TextField ime, prezime, mail, korisnicko_ime, lozinka;
        public ListView<Korisnik> choiceKorisnik;
        private KorisniciModel model = new KorisniciModel();

        public MeniController(){
            model.ispuni();
        }

        @FXML
        public void initialize(){
            choiceKorisnik.setItems(model.getKorisnici());
            model.trenutniKorisnikProperty().addListener(
                    (obs, oldKorsik, newKorisnik) -> {
                        if(oldKorsik != null){
                        ime.textProperty().unbindBidirectional(oldKorsik.imeProperty());
                        prezime.textProperty().unbindBidirectional(oldKorsik.prezimeProperty());
                        mail.textProperty().unbindBidirectional(oldKorsik.mailProperty());
                        korisnicko_ime.textProperty().unbindBidirectional(oldKorsik.korisnicko_imeProperty());
                        lozinka.textProperty().unbindBidirectional(oldKorsik.lozinkaProperty());}
                        if(newKorisnik == null){
                            ime.setText("");
                            prezime.setText("");
                            mail.setText("");
                            korisnicko_ime.setText("");
                            lozinka.setText("");
                        }else {
                            ime.textProperty().bindBidirectional(newKorisnik.imeProperty());
                            prezime.textProperty().bindBidirectional(newKorisnik.prezimeProperty());
                            mail.textProperty().bindBidirectional(newKorisnik.mailProperty());
                            korisnicko_ime.textProperty().bindBidirectional(newKorisnik.korisnicko_imeProperty());
                            lozinka.textProperty().bindBidirectional(newKorisnik.lozinkaProperty());
                        }
                    }
            );
        }

    public void dodajKorisnika(ActionEvent actionEvent) {
        Korisnik novi = new Korisnik("", "", "", "", "");
        model.getKorisnici().add(novi);
        model.setTrenutniKorisnik(novi);
        choiceKorisnik.refresh();
    }

    public void promjenaKorisnika(MouseEvent mouseEvent) {
        Korisnik selectedKorisnik = choiceKorisnik.getSelectionModel().getSelectedItem();
        if (selectedKorisnik != null) {
            model.setTrenutniKorisnik(selectedKorisnik);
        }
    }

    public void ugasi(ActionEvent actionEvent) {
            System.exit(0);
    }
}