import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FileManager {
    private String filename;
    private File file;


    public FileManager(String filename){
        this.filename=filename;
        try{
            file=new File(filename);
        }catch (NullPointerException exception){
            exception.printStackTrace();
        }
    }

    public ArrayList<String> read(){
        try{
            BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "windows-1251"));
            String line=r.readLine();
            ArrayList<String> city=new ArrayList<>();
            while(line !=null){
                String[] reader=line.split(";");
                reader[3]=reader[3].replace("\"","");
                if (!reader[3].equals("name")) {
                    city.add(reader[3]);
                }
                line=r.readLine();
            }
            r.close();
            return city;
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return new ArrayList<String>();
    }
}
