package Manager;

import Manager.CityManager;

import java.util.Scanner;

public class ConsoleManager {
    private Scanner scanner;
    private String chr;
    private static final String stop="stop";
    private CityManager cityManager;

    public ConsoleManager(Scanner scanner, CityManager cityManager){
        this.scanner=scanner;
        this.cityManager=cityManager;
    }


   /*
    public void processingOfGame(){
        boolean checkGame=false;
        String newCity=null;
        do{
            newCity = scanner.nextLine().trim();
            while (!newCity.equals(stop) && !cityManager.checkCity(newCity)) {
                newCity = scanner.nextLine().trim();
            }
            if(!newCity.equals(stop)) {
                checkGame = cityManager.printRandomCityStartWith(newCity);
            }
        }while(!newCity.equals(stop)&&checkGame);
        System.exit(0);
    }

    */

    public boolean processingOfGame(String newCity){
        boolean check=true;
        if (newCity.equals(stop)){
            InfoBuilder.appendln("Вы проиграли");
            check=false;
        }
        else{
           if(cityManager.checkCity(newCity) ){
               check=cityManager.printRandomCityStartWith(newCity);
            }
        }
        return check;
    }

    //сначала сделать для работы с консолью, потом улучшить с передачей результата
}
