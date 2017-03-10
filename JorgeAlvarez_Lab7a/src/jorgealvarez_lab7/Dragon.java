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
public class Dragon extends Guerrero {

    @Override
    public Guerrero Atacar(Guerrero Enemigo) {
        Enemigo.setDefensa((float) (Enemigo.getDefensa()-.15*Enemigo.getDefensa()));
        Enemigo.setSalud((float) (Enemigo.getSalud()-this.getAtaque()*.35-Enemigo.getDefensa()));
        return Enemigo;
    }

}
