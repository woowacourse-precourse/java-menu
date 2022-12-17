package menu.Util;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class FileInput {
    public static List<String> fileRead(){
        Path path = Paths.get("src/main/java/menu/FoodList.txt");
        Charset cs = StandardCharsets.UTF_8;
        List<String> list = new ArrayList<String>();
        try{
            list = Files.readAllLines(path,cs);
        }catch(IOException e){
            e.printStackTrace();
        }
        return list;
    }
}
