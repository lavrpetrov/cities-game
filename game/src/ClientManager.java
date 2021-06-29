import java.util.Scanner;

public class ClientManager {
    private Scanner scanner;
    private String chr;

    public ClientManager(Scanner scanner){
        this.scanner=scanner;
    }

    public String inputCharacter(){
        chr=null;
        System.out.println("Введите букву:");
        chr=scanner.nextLine().trim().toUpperCase();
        return chr;
    }
}
