package util;

import core.Cardapio;
import java.io.*;

public class Repositorio {
    public static void salvarCardapio(Cardapio cardapio, String arquivo) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            out.writeObject(cardapio);
        }
    }

    public static Cardapio carregarCardapio(String arquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(arquivo))) {
            return (Cardapio) in.readObject();
        }
    }
}