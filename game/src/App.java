import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        FileManager fileManager=new FileManager("city.csv");
        CityManager cityManager=new CityManager(fileManager);
        ClientManager clientManager=new ClientManager(scanner);
        fileManager.read();
        cityManager.printRandomCity();
        cityManager.printRandomCity();
        cityManager.printRandomCityStartWith(clientManager.inputCharacter());
    }
}
