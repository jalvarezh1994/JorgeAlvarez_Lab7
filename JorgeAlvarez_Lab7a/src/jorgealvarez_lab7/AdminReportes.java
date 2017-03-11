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

public class AdminReportes {

    private ArrayList<Reporte> listaReportes = new ArrayList();
    private File archivo = new File("./Reportes");

    public AdminReportes() {
    }

    public AdminReportes(String path) {
        archivo = new File(path);
    }

    public ArrayList<Reporte> getlistaReportes() {
        return listaReportes;
    }

    public void setlistaReportes(ArrayList<Reporte> listaReportes) {
        this.listaReportes = listaReportes;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public void addReporte(Reporte a) {
        listaReportes.add(a);
    }

    @Override
    public String toString() {
        return "listaReportes=" + listaReportes + ", archivo=" + archivo + '}';
    }

    public void cargarArchivoBinario() {//pasar del rom al ram!
        try {
            listaReportes = new ArrayList();

            Reporte temp;
            if (archivo.exists()) {
                FileInputStream entrada = new FileInputStream(archivo);
                ObjectInputStream objeto = new ObjectInputStream(entrada);

                try {
                    while ((temp = (Reporte) objeto.readObject()) != null) {//simpre lanzara un exception
                        listaReportes.add(temp);
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
            for (Object t : listaReportes) {
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
