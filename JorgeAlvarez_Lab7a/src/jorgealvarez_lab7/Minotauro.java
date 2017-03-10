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
public class Minotauro extends Guerrero {

    @Override
    public Guerrero Atacar(Guerrero Enemigo) {
        Enemigo.setSalud((float) ((this.getAtaque()*2-Enemigo.getDefensa())*1.5));
        this.setAtaque((float) (this.getAtaque()*1.1));
        return Enemigo;
    }

}
