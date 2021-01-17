package com.company;

import java.util.ArrayList;

public class Parkhaus {


    private final ArrayList<Fahrzeug> fahrzeugs = new ArrayList<>();

    public void hineinFahren(Fahrzeug fahrzeug) {
        fahrzeugs.add(fahrzeug);
    }

    public void hinausFahren(Fahrzeug fahrzeug){
        fahrzeugs.remove(fahrzeug);
    }

    // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public boolean schonDrin(String kennzeichen){
        int x = 0;
        for(Fahrzeug fahrzeug : fahrzeugs) {
            if (fahrzeug.getKennzeichen().toString().equals(kennzeichen)){
                x = 1;
                System.out.println("say it");
            }
        }

        return x == 1;

    }



    public String information() {

        StringBuilder sb = new StringBuilder();
        for(Fahrzeug fahrzeug : fahrzeugs) {
            sb.append(fahrzeug.getKennzeichen()).append("; ");
        }
        return sb.toString();
    }

    public int getAutos() {
        int ans = 0;
        for (Fahrzeug fahrzeug : fahrzeugs) {
            if (fahrzeug instanceof Auto){
                ans += 1;
            }
        }
        return ans;
    }

    public int getMotorraeder() {
        int ans = 0;
        for (Fahrzeug fahrzeug : fahrzeugs) {
            if (fahrzeug instanceof Motorrad){
                ans += 1;
            }
        }
        return ans;
    }

    public ArrayList<Fahrzeug> getFahrzeugs() {
        return fahrzeugs;
    }
}
