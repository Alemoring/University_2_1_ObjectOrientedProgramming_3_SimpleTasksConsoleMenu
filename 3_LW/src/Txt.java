import java.io.*;

public class Txt {
    private static File filename;

    public static void writeValueInFile(){

    }
    public static String readFile() throws FileNotFoundException {
        String str = "";
        StringBuilder result = new StringBuilder("");
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            while((str = br.readLine()) != null){
                result.append(str);
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Такого файла не существует");
        }
        catch (IOException e){
            System.out.println("Что-то пошло не так");
        }
        return result.toString();
    }
    public static void setFilename(String name){
        filename = new File(name);
    }
}
