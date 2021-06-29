import java.util.ArrayList;
import java.util.Random;


public class CityManager {
    private FileManager fileManager;
    private ArrayList<String> city=new ArrayList<>();
    private int index;

    public CityManager(FileManager fileManager){
        this.fileManager=fileManager;
    }

    public void printRandomCity(){
        city=fileManager.read();
        Random random=new Random();
        index= random.nextInt(city.size());
        System.out.println(city.get(index));
        city.remove(index);
    }

    public void printRandomCityStartWith(String s){
        int check=0;
        while (check ==0){
            Random random = new Random();
            index=random.nextInt(city.size());
            if (city.get(index).startsWith(s)){
                System.out.println(city.get(index));
                check=1;
            }
        }
    }

}
