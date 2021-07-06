package Manager;

public class InfoBuilder {
    private static StringBuilder stringBuilder=new StringBuilder();
    public static  String get(){
        return stringBuilder.toString();
    }

    public static void clear(){
        stringBuilder.delete(0,stringBuilder.length());
    }

    public static String getAndClear(){
        String string=stringBuilder.toString();
        stringBuilder.delete(0, stringBuilder.length());
        return string;
    }

    public static void appendln(Object obj){
        stringBuilder.append(obj+"\n");
    }
}
