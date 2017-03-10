/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jorgealvarez_lab7;

import java.io.Serializable;

/**
 *
 * @author ofici
 */
public abstract class Guerrero implements Serializable {

    private String Nombre, Nickname;
    private float Ataque, Defensa, Salud, Puntos=0;

    public Guerrero() {
    }

    public Guerrero(String Nombre, String Nickname, float Ataque, float Defensa, float Salud, float Puntos) {
        this.Nombre = Nombre;
        this.Nickname = Nickname;
        setAtaque(Ataque);
        setDefensa(Defensa);
        setSalud(Salud);
        this.Puntos = Puntos;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getNickname() {
        return Nickname;
    }

    public void setNickname(String Nickname) {
        this.Nickname = Nickname;
    }

    public float getAtaque() {
        return Ataque;
    }

    public void setAtaque(float Ataque) {
        if (Ataque > 200 && Ataque < 300) {
            this.Salud = Salud;
        }
    }

    public float getDefensa() {
        return Defensa;
    }

    public void setDefensa(float Defensa) {
        if (Defensa > 25 && Defensa < 75) {
            this.Defensa = Defensa;
        }
    }

    public float getSalud() {
        return Salud;
    }

    public void setSalud(float Salud) {
        if (Salud > 800) {
            this.Salud = Salud;
        }
    }

    public float getPuntos() {
        return Puntos;
    }

    public void setPuntos(float Puntos) {
        this.Puntos = Puntos;
    }

    @Override
    public String toString() {
        return Nombre + ": " + Nickname;
    }

    public abstract Guerrero Atacar(Guerrero Enemigo);

}
