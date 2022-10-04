/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repaso.model;

import java.io.Serializable;

/**
 *
 * @author mfernandez
 */
public class Piscina implements Serializable  {
    
    private final int MAX_DIST = 2;
    
    private int long_vaso;
    private int long_parcela;
    private int ancho_vaso;
    private int ancho_parcela;
    private int aforo;

    public int getAforo() {
        return aforo;
    }
    
    

    public Piscina(int long_vaso, int long_parcela, int ancho_vaso, int ancho_parcela) {
        this.long_vaso = long_vaso;
        this.long_parcela = long_parcela;
        this.ancho_vaso = ancho_vaso;
        this.ancho_parcela = ancho_parcela;
        this.aforo = this.calcularAforo();
        
    }
    
    private int calcularSuperficie(int longitud, int anchura){
        return longitud * anchura;
    }
    
    private int calcularAforo(){
        int sup_vaso = calcularSuperficie(this.long_vaso, this.ancho_vaso);
        int sup_parcela = calcularSuperficie(this.long_parcela, ancho_parcela);
        
        int aforo_vaso = sup_vaso / MAX_DIST;
        int aforo_parcela = sup_parcela/ MAX_DIST;
        
        int aforo_temp = Math.min(aforo_vaso, aforo_parcela);
        return aforo_temp;
        
    }

    @Override
    public String toString() {
        return "Piscina{" + "MAX_DIST=" + MAX_DIST + ", long_vaso=" + long_vaso + ", long_parcela=" + long_parcela + ", ancho_vaso=" + ancho_vaso + ", ancho_parcela=" + ancho_parcela + ", aforo=" + aforo + '}';
    }
    
          
    
}
