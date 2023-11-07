package ba.unsa.etf.rpr;

import java.util.Objects;

public class MobilniBroj extends TelefonskiBroj {
    private int mobilnaMreza;
    private String broj;
    MobilniBroj(int mobilnaMreza, String broj){
        this.broj = broj;
        this.mobilnaMreza = mobilnaMreza;
    }

    @Override
    public String ispisi(){
        if(broj != null)
            return "0" + mobilnaMreza + "/" + broj;
        return null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mobilnaMreza, broj);
    }

}