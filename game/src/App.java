import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        FileManager fileManager=new FileManager("city.csv");
        CityManager cityManager=new CityManager(fileManager);
        ConsoleManager consoleManager=new ConsoleManager(scanner,cityManager);
        fileManager.read();
        consoleManager.processingOfGame();
     //   cityManager.printRandomCityStartWith(clientManager.inputCharacter());
    }
}
