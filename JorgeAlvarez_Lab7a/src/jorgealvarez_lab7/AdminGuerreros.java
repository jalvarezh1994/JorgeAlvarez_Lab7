package jorgealvarez_lab7;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AdminGuerreros {

    private ArrayList<Guerrero> listaGuerreros = new ArrayList();
    private File archivo = null;

    public AdminGuerreros() {
    }

    public AdminGuerreros(String path) {
        archivo = new File(path);
    }

    public ArrayList<Guerrero> getlistaGuerreros() {
        return listaGuerreros;
    }

    public void setlistaGuerreros(ArrayList<Guerrero> listaGuerreros) {
        this.listaGuerreros = listaGuerreros;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public void addGuerrero(Guerrero a) {
        listaGuerreros.add(a);
    }

    @Override
    public String toString() {
        return "listaGuerreros=" + listaGuerreros + ", archivo=" + archivo + '}';
    }

    public void cargarArchivoBinario() {//pasar del rom al ram!
        try {
            listaGuerreros = new ArrayList();

            Guerrero temp;
            if (archivo.exists()) {
                FileInputStream entrada = new FileInputStream(archivo);
                ObjectInputStream objeto = new ObjectInputStream(entrada);

                try {
                    while ((temp = (Guerrero) objeto.readObject()) != null) {//simpre lanzara un exception
                        listaGuerreros.add(temp);
                    }
                } catch (EOFException e) {
                    //encontro el final el archivo
                }
                objeto.close();
                entrada.close();

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //Google traduce//algotitmo para reconocer patrones

    }

    public void escribirArchivo() {
        FileOutputStream fw = null;
        ObjectOutputStream bw = null;

        try {

            fw = new FileOutputStream(archivo);
            bw = new ObjectOutputStream(fw);
            for (Object t : listaGuerreros) {
                bw.writeObject(t);
            }
            bw.flush();

        } catch (Exception ex) {
        } finally {

            try {
                bw.close();
                fw.close();
            } catch (Exception ex) {
            }
        }

    }

}
