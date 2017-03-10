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

public class AdminArchivos {

    private ArrayList<Alumno> listaAlumnos = new ArrayList();
    private File archivo = null;

    public AdminArchivos() {
    }

    public AdminArchivos(String path) {
        archivo = new File(path);
    }

    public ArrayList<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }

    public void setListaAlumnos(ArrayList<Alumno> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public void addAlumno(Alumno a) {
        listaAlumnos.add(a);
    }

    @Override
    public String toString() {
        return "listaAlumnos=" + listaAlumnos + ", archivo=" + archivo + '}';
    }

    public void cargarArchivoBinario() {//pasar del rom al ram!
        try {
            listaAlumnos = new ArrayList();

            Alumno temp;
            if (archivo.exists()) {
                FileInputStream entrada = new FileInputStream(archivo);
                ObjectInputStream objeto = new ObjectInputStream(entrada);

                try {
                    while ((temp = (Alumno) objeto.readObject()) != null) {//simpre lanzara un exception
                        listaAlumnos.add(temp);
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
            for (Alumno t : listaAlumnos) {
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
