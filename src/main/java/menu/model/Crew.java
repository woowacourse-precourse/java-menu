package menu.model;

import java.util.ArrayList;
import java.util.List;

public class Crew {
    ArrayList<ArrayList<String>> crews;
    List<String> names ;

    public Crew(List<String> names){

        crews  = new ArrayList<>(names.size());
        this.names = names;
    }

    public void setCrews(){
        System.out.println(names.get(0));
        for(int i = 0 ; i <names.size();i++)
        {
            crews.add(new ArrayList<>(List.of(names.get(i))));
        }
        System.out.println(crews);
    }
    public ArrayList<ArrayList<String>> getCrews(){
        return crews;
    }
    public String getNamesToString(){
        return String.valueOf(names);
    }



}