package menu.study;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class StudyTest {


    @Test
    void array_TEST() {
        int size =  3;
        ArrayList<String>[] arr  = new ArrayList[size];
        for(int i = 0 ; i < size; i++){
            arr[i] = new ArrayList<>();
        }
        arr[0].add(("new"));

        String input = "ad ,b,c" ;
        String[] answer = input.split(",");

        System.out.println(answer[0]);
        ArrayList<String> an = new ArrayList<>(List.of(answer));
        System.out.println(an.size());

        String text = "[cc한국]";
        text = text.replaceAll("\\]", "");
        text = text.replaceAll("\\[", "");

        System.out.println(text);

    }


}