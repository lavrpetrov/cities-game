package Manager;

import java.util.ArrayList;
import java.util.Random;


public class CityManager {
    private FileManager fileManager;
    private ArrayList<String> cities=new ArrayList<>();
    private int index;
    private String systemCity;

    public CityManager(FileManager fileManager){
        this.fileManager=fileManager;
        cities=fileManager.read();
    }

    //вывод рандомного города на определенную букву
    public boolean printRandomCityStartWith(String s){
        boolean check=false;
        while (checkSystemCity(s)){
            Random random = new Random();
            index=random.nextInt(cities.size());
            if (cities.get(index).startsWith(String.valueOf(s.toUpperCase().toCharArray()[s.length()-1]))){
                AnswerBuilder.appendln(cities.get(index));
                systemCity=cities.get(index);
                cities.remove(index);
                return true;
            }
        }
        InfoBuilder.appendln("Вы выиграли");
        return false;
    }


    //удаление введенного города из списка,если он есть
    public boolean deleteCity(String s){
        for (String currentCity:cities){
            if (currentCity.equals(s)){
                cities.remove(currentCity);
                return true;
            }
        }
        InfoBuilder.appendln("Данный город уже использовался или его не существует");
        return false;
    }


    //проверка на соблюдение правил игры
    public boolean checkCity(String s){
        try {
            char[] word=systemCity.toUpperCase().toCharArray();
            if (s.startsWith(String.valueOf(word[systemCity.length() - 1]))) {
                return deleteCity(s);
            } else {
                InfoBuilder.appendln("Вы не по правилам ввели город");
                return false;
            }
        }catch(NullPointerException exception){
            return deleteCity(s);
        }
    }


    //проверка по базе городов: найдется ли такой городе в списке,который соответствует правилам
    public boolean checkSystemCity(String s){
        char [] charCity=s.toUpperCase().toCharArray();
        for (String currentCity:cities){
            if (currentCity.startsWith(String.valueOf(charCity[s.length()-1]))){
                return true;
            }
        }
        return false;
    }
}