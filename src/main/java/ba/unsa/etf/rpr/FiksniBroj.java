package ba.unsa.etf.rpr;
import java.util.Objects;

public class FiksniBroj extends TelefonskiBroj {
    private Grad grad;
    private String broj;
    public FiksniBroj(Grad g, String b) throws BrojException {
        if(g == null) throw new BrojException("Pozivni broj za fiksni telefon nije OK");
        grad = g;
        broj = b;
    }
    @Override
    public String ispisi(){
        if(grad != null && broj != null)
            return grad.getFiksni_broj() + "/" + broj;
        return null;
    }

    @Override
    public int hashCode(){return Objects.hash(grad, broj);}

    public void setGrad(Grad grad) {
        if(grad == null) throw new BrojException("Pozivni broj za fiksni telefon nije OK");
        this.grad = grad;
    }
    public String getGrad() {
        return broj;
    }
}
