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
    public String inputCharacter(){
        chr=null;
        System.out.println("Введите город:");
        chr=scanner.nextLine().trim().toUpperCase();
        return chr;
    }

     */

    public void processingOfGame(){
        boolean checkGame=false;
        String newCity=null;
        System.out.println("Введите город:");
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
        //до тех пор, пока пользователь не ввел слово stop или система не нашла город
    }

}
