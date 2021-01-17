package com.company;

import java.util.Objects;

public class Kennzeichen {
    
    private Land land;
    private String zeichenFolge;
    private String kennzeichen;
    
    public void setZeichenFolge(String zeichenFolge){
        this.zeichenFolge = zeichenFolge;
    }

    public void setLand(Land land) {
        this.land = land;
    }

    public String getKennzeichen(){
        return this.kennzeichen;
    }

    public String setKennzeichen(Parkhaus parkhaus){
        if (this.land != null && this.zeichenFolge != null){
            this.kennzeichen = this.land + "" + this.zeichenFolge;
            if (parkhaus.schonDrin(this.kennzeichen)){
                System.out.println("Kennzeichen schon im Parkhaus! Geht nicht");
                return "no";
            }
            else {
                System.out.println("Worked");

            }

        }

        return "yes";
    }

    @Override
    public String toString() {
        return getKennzeichen();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kennzeichen that = (Kennzeichen) o;
        return Objects.equals(kennzeichen, that.kennzeichen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kennzeichen);
    }
}
