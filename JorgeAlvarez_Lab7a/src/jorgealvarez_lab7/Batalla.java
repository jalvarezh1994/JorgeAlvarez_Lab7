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
public class Batalla implements Runnable {

    private Guerrero Guerrero1;
    private Guerrero Guerrero2;

    @Override
    public void run() {
        while (Guerrero1.getSalud()>0&&Guerrero2.getSalud()>0) {
            Guerrero2=Guerrero1.Atacar(Guerrero2);
            Guerrero1=Guerrero2.Atacar(Guerrero1);
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
        return Guerrero1.getNickname()+" vs "+Guerrero2.getNickname();
    }

    
}
