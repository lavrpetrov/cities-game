import Interface.GameWindow;
import Manager.CityManager;
import Manager.ConsoleManager;
import Manager.FileManager;

import javax.swing.*;
import java.util.Scanner;

public class App {
    public static JFrame jFrame;
    public static GameWindow gameWindow;

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        FileManager fileManager=new FileManager("city.csv");
        CityManager cityManager=new CityManager(fileManager);
        ConsoleManager consoleManager=new ConsoleManager(scanner,cityManager);
        GameWindow gameWindow=new GameWindow(consoleManager);
        fileManager.read();
    }
}