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
public class HombreLobo extends Guerrero {

    @Override
    public Guerrero Atacar(Guerrero Enemigo) {
        Enemigo.setSalud(this.getAtaque()-Enemigo.getDefensa());
        return Enemigo;
    }

}
