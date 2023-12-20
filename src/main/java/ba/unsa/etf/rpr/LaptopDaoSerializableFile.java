package ba.unsa.etf.rpr;

import java.io.*;
import java.util.ArrayList;

public class LaptopDaoSerializableFile implements LaptopDao, Serializable {
    File file;
    ArrayList<Laptop> laptopi;
    public LaptopDaoSerializableFile(File file){
        this.file = file;
        laptopi = new ArrayList<>();
    }
    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        laptopi.add(laptop);
    }

    @Override
    public void dodajLaptopUFile(Laptop laptop) {
        try{
            ObjectOutputStream izlaz = new ObjectOutputStream(new FileOutputStream(file, true));
            izlaz.writeObject(laptop);
            izlaz.close();
        }catch(Exception e){
            System.out.println("Greska: " + e);
        }
    }

    @Override
    public Laptop getLaptop(String procesor) {
            for (Laptop l : laptopi) {
                if (l.getProcesor().equals(procesor)) return l;
            }

      throw new NeodgovarajuciProcesorException("Nije pronađen laptop sa procesorom: " + procesor);
    }

    @Override
    public void napuniListu(ArrayList<Laptop> laptopi) {
        this.laptopi = laptopi;
    }

    @Override
    public ArrayList<Laptop> vratiPodatkeIzDatoteke() {
        ArrayList<Laptop> rez = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    Laptop laptop = (Laptop) ois.readObject();
                    if (laptop == null) {
                        // Kraj datoteke, izlazak iz petlje
                        break;
                    }
                    rez.add(laptop);
                } catch (ClassNotFoundException | IOException e) {
                    // Pogreška prilikom čitanja objekta, izlazak iz petlje
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rez;
    }
}
