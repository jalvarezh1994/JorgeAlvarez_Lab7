/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jorgealvarez_lab7;

/**
 *
 * @author ofici
 */
public class Batalla extends Thread{

    private Guerrero Guerrero1;
    private Guerrero Guerrero2;
    private String Bitacora;
    private AdminReportes adm=new AdminReportes();
    
    @Override
    public void run() {
        while (Guerrero1.getSalud()>0&&Guerrero2.getSalud()>0) {
            Guerrero2=Guerrero1.Atacar(Guerrero2);
            Guerrero1=Guerrero2.Atacar(Guerrero1);
            System.out.println(this);
            Bitacora+=this+"\n";
        }
        if (Guerrero1.getSalud()>0) {
            System.out.println("El ganador es: "+Guerrero1);
            Bitacora+="El ganador es: "+Guerrero1;
            adm.cargarArchivoBinario();
            adm.getlistaReportes().add(new Reporte(Guerrero1, Guerrero2, Bitacora));
            adm.escribirArchivo();
        }else{
            System.out.println("El ganador es: "+Guerrero2);
            Bitacora+="El ganador es: "+Guerrero2;
            adm.cargarArchivoBinario();
            adm.getlistaReportes().add(new Reporte(Guerrero1, Guerrero2, Bitacora));
            adm.escribirArchivo();
        }
    }

    public Batalla() {
    }

    public Batalla(Guerrero Guerrero1, Guerrero Guerrero2) {
        this.Guerrero1 = Guerrero1;
        this.Guerrero2 = Guerrero2;
    }

    @Override
    public String toString() {
        return Guerrero1.getNickname()+":"+Guerrero1.getSalud()+" vs "+Guerrero2.getNickname()+":"+Guerrero2.getSalud();
    }

    
}
