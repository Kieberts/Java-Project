package com.company;

public abstract class Fahrzeug  {

    private Kennzeichen kennzeichen;
    private Farbe farbe;


    public void setKennzeichen(Kennzeichen kennzeichen){
        this.kennzeichen = kennzeichen;
    }
    public Kennzeichen getKennzeichen(){
        return this.kennzeichen;
    }


    public void setFarbe(Farbe farbe){
        this.farbe = farbe;
    }
    public Farbe getFarbe() {
        return this.farbe;
    }
}

