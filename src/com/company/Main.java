package com.company;

import java.util.Scanner;

public class Main {

    private final static Parkhaus parkhaus = new Parkhaus();
    private final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("+ = neues Fahrzeug");
            System.out.println("- = vehicle verlässt");
            System.out.println("# = Zeigt alle Kennzeichen von Fahrzeug im Parkhaus.");
            String task = sc.nextLine();


            switch (task) {
                case "+":
                    addFahrzeug();
                    break;
                case "-":
                    leaveVehicle();
                    break;
                case "#":
                    information();
                    break;
                default:
                    System.out.println("Falsche Eingabe. Bitte wiederholen Sie!");
                    break;
            }


        }while(true);


    }

    private static void jedesFahrzeug(Fahrzeug test, String welchesFahrzeug) {


        Kennzeichen testkennzeichen = new Kennzeichen();


        //
        System.out.println("Welches Land: ");
        System.out.println("Deutschland(D) - England(E) - Frankreich(F)");
        String inputLand = sc.nextLine().toLowerCase();
        switch (inputLand){
            case "deutschland":
            case "d":
                testkennzeichen.setLand(Land.DEUTSCHLAND);
                break;
            case "england":
            case "e":
                testkennzeichen.setLand(Land.ENGLAND);
                break;
            case "frankreich":
            case "f":
                testkennzeichen.setLand(Land.FRANKREICH);
                break;
            default:
                System.out.println("Keines von den angegebenen Länders / Abkürzung");
                jedesFahrzeug(test, welchesFahrzeug);
                break;
        }

        //
        boolean boolFarbe;
        do {
            boolFarbe = false;
            System.out.println("Welches Farbe hat ihr Fahrzeug: ");
            System.out.println("Black(BK) - White(W) - Red(R) - Blue(BU) - Green(G)");
            String inputFarbe = sc.nextLine().toLowerCase();
            switch (inputFarbe){
                case "black":
                case "bk":
                    test.setFarbe(Farbe.BLACK);
                    break;
                case "white":
                case "w":
                    test.setFarbe(Farbe.WHITE);
                    break;
                case "red":
                case "r":
                    test.setFarbe(Farbe.RED);
                    break;
                case "blue":
                case "bu":
                    test.setFarbe(Farbe.BLUE);
                    break;
                case "green":
                case "g":
                    test.setFarbe(Farbe.GREEN);
                    break;
                default:
                    System.out.println("Keines von den angegebenen Länders / Abkürzung");
                    boolFarbe = true;
                    break;
            }
        } while (boolFarbe);

        //
        boolean boolKennzeichen = true;
        String zeichen;
        do{
            System.out.println("Kennzeichen darf NUR Buchstaben und Zahlen besitzen!");
            System.out.println("Kein \"-,!.@#\"");
            System.out.print("Enter deine Zeichenfolge: (min. 5 Zeichen, max. 10 Zeichen) \t");
            zeichen = sc.nextLine();


            // Test ob das Kennzeichen ist korrekt
            if (zeichen.length() > 10 || zeichen.length() < 5 || inputLand.equals("") || zeichen.contains("#") || zeichen.contains("!") || zeichen.contains("@") || zeichen.contains(".") || zeichen.contains(",") || zeichen.contains("-")) {
                System.out.println("Kennzeichen nicht vollstädnig.");
                zeichen = "";
            }
            else {
                boolKennzeichen = false;
            }
        } while(boolKennzeichen);



        // zu dem "-" werden jetzt noch die beliebige Zeichenfolge und ein #A (Auto) #M (Motorrad)
        String zeichenfolge = "-";
        zeichenfolge += zeichen;
        // Ist nötig um die Anzahl von Autos / Motorräder zu bekommen!
        String x = welchesFahrzeug.equals("auto") ? "#A" : "#M";
        zeichenfolge += x;

        // Zu dem Land wird jetzt die Zeichenfolge hinzugefügt
        testkennzeichen.setZeichenFolge(zeichenfolge);

        String ka = testkennzeichen.setKennzeichen(parkhaus);

        try {
            if (ka.equals("yes")){
                test.setKennzeichen(testkennzeichen);

                System.out.println(testkennzeichen);
            }
            else {
                jedesFahrzeug(test,welchesFahrzeug);
            }

        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Fehler");
            jedesFahrzeug(test, welchesFahrzeug);
        }





    }

    public static void addFahrzeug() {


        System.out.println("Was für ein Fahrzeug willst du parken?");
        System.out.println("Auto - Motorrad - LKW");
        String stfahrzeug = sc.nextLine().toLowerCase();

        switch (stfahrzeug) {
            case "auto": {
                Auto fahrzeug = new Auto();
                jedesFahrzeug(fahrzeug, stfahrzeug);

                // Damit man nicht eine zu große Zahl eingibt.
                double anzahlTueren;
                boolean boolTueren;
                do {
                    boolTueren = false;

                    System.out.println("Anzahl der Türen [2 - 10]");
                    anzahlTueren = sc.nextDouble();
                    if (anzahlTueren < 2 || anzahlTueren > 10 || anzahlTueren % 1 == 0) {
                        System.out.println("Anzahl nicht in der Spannweite!");
                        boolTueren = true;
                    }
                } while (boolTueren);

                fahrzeug.setAnzahlTueren(anzahlTueren);

                //
                boolean boolVolumen;
                double volumenKofferraum = 0;

                do {


                    try {
                        System.out.println("Volumen des Kofferraum");
                        volumenKofferraum = sc.nextDouble();
                        boolVolumen = false;
                    } catch (Exception ignored){

                    }
                    finally {
                        boolVolumen = true;
                    }


                } while(boolVolumen);



                fahrzeug.setKofferraumVolum(volumenKofferraum);

                try {
                    parkhaus.hineinFahren(fahrzeug);
                } catch (Exception e) {
                    e.printStackTrace();
                }


                break;
            }
            case "motorrad": {
                Motorrad fahrzeug = new Motorrad();
                jedesFahrzeug(fahrzeug, stfahrzeug);

                System.out.println("Beifahrer [j/alles andere = N]");
                boolean beifahrer = sc.nextLine().toLowerCase().equals("j");
                fahrzeug.setBeifahrer(beifahrer);

                parkhaus.hineinFahren(fahrzeug);
                break;
            }
            case "lkw":
                // test = new LKW();
                System.out.println("Sie dürfen bei uns nicht parken, weil sie zu groß sind.");
                break;
            default:
                System.out.println("Sie haben sich vertippt oder falsche eingabe!");
                System.out.println("Bitte wiederholen Sie!");
                break;
        }



    }
    public static void leaveVehicle() {
        // User can delete vehicles / they leave the parking area

        System.out.println("Wählen sie ein Fahrzeug aus: ");
        System.out.println(parkhaus.information());
        String neuesFahrzeug = sc.nextLine();

        Fahrzeug selectedFahrzeug = null;
        for (Fahrzeug fahrzeug : parkhaus.getFahrzeugs()) {
            if (fahrzeug.getKennzeichen().toString().equals(neuesFahrzeug)) {
                selectedFahrzeug = fahrzeug;
                break;
            }
        }

        if (selectedFahrzeug == null) {
            System.out.println("Kennzeichen nicht erkannt oder Fahrzeug nicht im Parkhaus.");
            return;
        }


        try {
            parkhaus.hinausFahren(selectedFahrzeug);
            System.out.println("Faehrt raus!");
        } catch (Exception e){
            e.printStackTrace();
        }

    }
    private static void information () {

        boolean b = true;
        do {
            System.out.println("1. Zeige alle Kennzeichen von Fahrzeugen im Parkhaus.");
            System.out.println("2. Wie viele Autos? Wie viele Motorräder?");
            System.out.println("3. Fahrzeug Informationen");
            System.out.println("o. exit");
            String input = sc.nextLine();

            switch (input){
                case "1":
                    System.out.println(parkhaus.information());
                    break;
                case "2":
                    System.out.printf("Autos: %d \n", parkhaus.getAutos());
                    System.out.printf("Motorräder: %d \n", parkhaus.getMotorraeder());
                    break;
                case "3":
                    fahrzeugInformationen();
                    break;
                case "o":
                    b = false;
                    break;

                default:
                    System.out.println("Falsch");
                    break;
            }



        } while (b);
    }




    public static void fahrzeugInformationen() {

        System.out.println("Wählen sie ein Fahrzeug aus: ");
        System.out.println(parkhaus.information());
        String neuesFahrzeug = sc.nextLine();

        Fahrzeug selectedFahrzeug = null;
        for (Fahrzeug fahrzeug : parkhaus.getFahrzeugs()) {
            if (fahrzeug.getKennzeichen().toString().equals(neuesFahrzeug)) {
                selectedFahrzeug = fahrzeug;
                break;
            }
        }

        if (selectedFahrzeug == null) {
            System.out.println("Kennzeichen nicht erkannt.");
            return;
        }

        if (selectedFahrzeug instanceof Auto) {
            printInformation((Auto) selectedFahrzeug);
        } else if (selectedFahrzeug instanceof Motorrad) {
            printInformation((Motorrad) selectedFahrzeug);
        }





    }
    private static void printInformation(Motorrad selectedFahrzeug) {

        System.out.println("Motorrad");
        System.out.print("Kennzeichen: \t" + selectedFahrzeug.getKennzeichen() + " \n");
        System.out.print("Farbe: \t" + selectedFahrzeug.getFarbe() + " \n");
        System.out.println();
        String beifahrer = selectedFahrzeug.getBeifahrer()? "ja" : "nein";
        System.out.print("Beifahrer: \t" + beifahrer + "\n");
    }
    private static void printInformation(Auto selectedFahrzeug) {
        System.out.println("Motorrad");
        System.out.print("Kennzeichen: \t" + selectedFahrzeug.getKennzeichen() + " \n");
        System.out.print("Farbe: \t" + selectedFahrzeug.getFarbe() + " \n");
        System.out.println();
        System.out.printf("Türen: \t %f\n", selectedFahrzeug.getTueren());
        System.out.printf("Kofferraumvolumen: \t %f\n", selectedFahrzeug.getKofferraumVolum());
    }



    // Kann man die Main methode aufrufen mit man basical abbricht und alle variablens geleert werden ??????

    // jUINTEST
    // was machen sie
    // warum
    // Vor / nachteile

}
