package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LaptopDaoSerializableFileTest {
    private LaptopDaoSerializableFile serializableFileDao;

    @BeforeEach
    void setUp() {
        File serializedFile = new File("laptopi.ser");
        serializableFileDao = new LaptopDaoSerializableFile(serializedFile);
    }

    @Test
    void dodajLaptopUFile() {
        Laptop laptop1 = new Laptop("Dell", "Inspiron", "Intel i5", "Nvidia GTX 1050", 1200.0, 15.6, 8, 512, 0);
        Laptop laptop2 = new Laptop("HP", "Pavilion", "AMD Ryzen 7", "AMD Radeon RX 5600M", 899.99, 14, 16, 256, 512);

        serializableFileDao.dodajLaptopUFile(laptop1);
        serializableFileDao.dodajLaptopUFile(laptop2);

        ArrayList<Laptop> listaIzDatoteke = serializableFileDao.vratiPodatkeIzDatoteke();

        assertEquals(2, listaIzDatoteke.size());
        assertTrue(listaIzDatoteke.contains(laptop1));
        assertTrue(listaIzDatoteke.contains(laptop2));
    }

    @Test
    void getLaptop() throws NeodgovarajuciProcesorException {
        Laptop laptop1 = new Laptop("Dell", "Inspiron", "Intel i5", "Nvidia GTX 1050", 1200.0, 15.6, 8, 512, 0);
        Laptop laptop2 = new Laptop("HP", "Pavilion", "AMD Ryzen 7", "AMD Radeon RX 5600M", 899.99, 14, 16, 256, 512);

        serializableFileDao.dodajLaptopUFile(laptop1);
        serializableFileDao.dodajLaptopUFile(laptop2);

        Laptop trazeniLaptop = serializableFileDao.getLaptop("Intel i5");

        assertEquals(laptop1, trazeniLaptop);
    }

    @Test
    void napuniListu() {
        ArrayList<Laptop> listaLaptopa = new ArrayList<>();
        Laptop laptop1 = new Laptop("Dell", "Inspiron", "Intel i5", "Nvidia GTX 1050", 1200.0, 15.6, 8, 512, 0);
        Laptop laptop2 = new Laptop("HP", "Pavilion", "AMD Ryzen 7", "AMD Radeon RX 5600M", 899.99, 14, 16, 256, 512);

        listaLaptopa.add(laptop1);
        listaLaptopa.add(laptop2);

        serializableFileDao.napuniListu(listaLaptopa);

        assertEquals(listaLaptopa, serializableFileDao.vratiPodatkeIzDatoteke());
    }

    @Test
    void vratiPodatkeIzDatoteke() {
        ArrayList<Laptop> listaLaptopa = new ArrayList<>();
        Laptop laptop1 = new Laptop("Dell", "Inspiron", "Intel i5", "Nvidia GTX 1050", 1200.0, 15.6, 8, 512, 0);
        Laptop laptop2 = new Laptop("HP", "Pavilion", "AMD Ryzen 7", "AMD Radeon RX 5600M", 899.99, 14, 16, 256, 512);

        listaLaptopa.add(laptop1);
        listaLaptopa.add(laptop2);

        serializableFileDao.napuniListu(listaLaptopa);

        assertEquals(listaLaptopa, serializableFileDao.vratiPodatkeIzDatoteke());
    }
}
