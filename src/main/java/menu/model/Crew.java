package menu.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Crew {
    ArrayList<ArrayList<String>> crews;
    List<String> names ;

    public Crew(List<String> names){

        crews  = new ArrayList<>(names.size());
        this.names = names;
    }

    public void setCrews(){
        for(int i = 0 ; i <names.size();i++)
        {
            crews.add(new ArrayList<>(List.of(names.get(i))));
        }
    }
    public ArrayList<ArrayList<String>> getCrews(){
        return crews;
    }
    public String getNamesToString(int index){
        return String.valueOf(names.get(index));
    }
    public void setCrewsDislike(int number,List<String> menu){
        IntStream.range(0,menu.size()).forEach(i->{
            crews.get(number).add(menu.get(i));
        });
    }

}