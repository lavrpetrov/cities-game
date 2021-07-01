import java.util.ArrayList;
import java.util.Random;


public class CityManager {
    private FileManager fileManager;
    private ArrayList<String> city=new ArrayList<>();
    private int index;
    private String systemCity;

    public CityManager(FileManager fileManager){
        this.fileManager=fileManager;
        city=fileManager.read();
    }

    //вывод рандомного города
    public void printRandomCity(){
     //   city=fileManager.read();
        Random random=new Random();
        index= random.nextInt(city.size());
        System.out.println(city.get(index));
        city.remove(index);
    }


    //вывод рандомного города на определенную букву
    public boolean printRandomCityStartWith(String s){
        boolean check=false;
        while (checkSystemCity(s)){
            Random random = new Random();
            index=random.nextInt(city.size());
            if (city.get(index).startsWith(String.valueOf(s.toUpperCase().toCharArray()[s.length()-1]))){
                System.out.println(city.get(index));
                systemCity=city.get(index);
                city.remove(index);
                return true;
            }
        }
        System.out.println("Вы выиграли");
        return false;
    }

    /*
    public boolean checkCity(String s){
        char[] word=s.toCharArray();
        int check1=0;
    }

     */

    //удаление введенного города из списка,если он есть
    public boolean deleteCity(String s){
         for (String currentCity:city){ //city почему-то пустой
             if (currentCity.equals(s)){
                 city.remove(currentCity);
                 return true;
             }
         }
         System.out.println("Данный город уже использовался или его не существует");
         return false;
    }


    //проверка на соблюдение правил игры
    public boolean checkCity(String s){
        try {
        char[] word=systemCity.toUpperCase().toCharArray();
       // System.out.println(systemCity);
            if (s.startsWith(String.valueOf(word[systemCity.length() - 1]))) {
                return deleteCity(s);
            } else {
                System.out.println("Вы не по правилам ввели город");
                return false;
            }
        }catch(NullPointerException exception){
            return deleteCity(s);
        }
    }


    //проверка по базе городов: найдется ли такой городе в списке,который соответствует правилам
    public boolean checkSystemCity(String s){
        char [] charCity=s.toUpperCase().toCharArray();
        for (String currentCity:city){
            if (currentCity.startsWith(String.valueOf(charCity[s.length()-1]))){
                return true;
            }
        }
        return false;
    }
}
