package com.company;



public class Motorrad extends Fahrzeug {

    private boolean beifahrer;

    public void setBeifahrer(boolean beifahrer){
        this.beifahrer = beifahrer;
    }

    public boolean getBeifahrer(){
        return this.beifahrer;
    }

}
