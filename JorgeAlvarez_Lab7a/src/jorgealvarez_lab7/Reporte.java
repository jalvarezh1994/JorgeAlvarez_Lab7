/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jorgealvarez_lab7;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author ofici
 */
public class Reporte implements Serializable {

    private Guerrero g1, g2;
    private String reporte;
    Date fecha = new Date();

    public Reporte() {
    }

    public Reporte(Guerrero g1, Guerrero g2, String reporte) {
        this.g1 = g1;
        this.g2 = g2;
        this.reporte = reporte;
    }

    public Guerrero getG1() {
        return g1;
    }

    public void setG1(Guerrero g1) {
        this.g1 = g1;
    }

    public Guerrero getG2() {
        return g2;
    }

    public void setG2(Guerrero g2) {
        this.g2 = g2;
    }

    public String getReporte() {
        return reporte;
    }

    public void setReporte(String reporte) {
        this.reporte = reporte;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
