package menu.model;

import java.util.ArrayList;
import java.util.List;

public class Crew {
    ArrayList<String>[] crews;
    List<String> names ;

    public Crew(List<String> names){
        crews  = new ArrayList[names.size()];
        this.names = names;
    }

    public void setCrews(){
        for(int i = 0 ; i < names.size(); i++){
            crews[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < names.size(); i++){
            crews[i].add(names.get(i));
        }
    }
    public ArrayList<String>[] getCrews(){
        return crews;
    }
    public String getNamesToString(){
        return String.valueOf(names);
    }



}
