package com.company;

public class Auto extends Fahrzeug{


    private double  anzahlTueren = 0;
    private double kofferraumVolum = 0;

    public void setAnzahlTueren(double anzahl){
        this.anzahlTueren = anzahl;
    }
    public double getTueren(){
        return this.anzahlTueren;
    }


    public void setKofferraumVolum(double volumeSize){
        this.kofferraumVolum = volumeSize;
    }
    public double getKofferraumVolum(){
        return this.kofferraumVolum;
    }

}
