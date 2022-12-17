package menu.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVUtils {
    private static final String CSV_SPLIT_COMMA = ",";
    private static final String CSV_FILE_EXTENSION = ".csv";
    private static final String CSV_RESOURCE_DIRECTORY = "/Users/wseok/2022_woowa_final_test/java-menu/src/main/java/menu/resource/";

    public static List<String> getCsvLine(String fileName){
        List<String> line = new ArrayList<>();

        try{
            BufferedReader br = getBufferedReader(CSV_RESOURCE_DIRECTORY+fileName+CSV_FILE_EXTENSION);
            line.addAll(Arrays.asList(getOneLine(br).split(CSV_SPLIT_COMMA)));
        } catch (IOException e){
            e.printStackTrace();
        }
        return line;
    }

    private static BufferedReader getBufferedReader(String file) throws FileNotFoundException{
        File csv = new File(file);
        return new BufferedReader(new FileReader(csv));
    }

    private static String getOneLine(BufferedReader br) throws IOException{
        return br.readLine();
    }
}
