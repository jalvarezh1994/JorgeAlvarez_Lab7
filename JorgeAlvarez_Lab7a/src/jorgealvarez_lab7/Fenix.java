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
public class Fenix extends Guerrero{

    @Override
    public Guerrero Atacar(Guerrero Enemigo) {
        Enemigo.setSalud((float) (this.getAtaque()*.75-Enemigo.getDefensa()));
        return Enemigo;
    }

    
}
