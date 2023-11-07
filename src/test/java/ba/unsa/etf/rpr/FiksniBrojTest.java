package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FiksniBrojTest {

    @Test
    void testKonstruktora(){
        FiksniBroj br = new FiksniBroj(Grad.SARAJEVO, "367-654");
        assertThrows(BrojException.class, () -> br.setGrad(null), "Pozivni broj za fiksni telefon nije OK");
    }
}