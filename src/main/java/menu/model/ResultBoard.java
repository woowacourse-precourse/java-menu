package menu.model;

import java.util.ArrayList;
import java.util.List;

public class ResultBoard {
    private List<String> recommandCategory;

    ArrayList<ArrayList<String>> crewmenu;
    private Crew crew;
    public ResultBoard(Crew crew){
        this.crew = crew;
        crewmenu  = new ArrayList<>(crew.getsize());
    }

    public void setRecommandCategory(List<String> recommandCategory){
        this.recommandCategory = recommandCategory;
        List<String> names = crew.getnames();
        for(int i = 0 ; i <crew.getsize();i++)
        {
            crewmenu.add(new ArrayList<>(List.of(names.get(i))));
        }
    }
    public List<String> getRecommandCategory()
    {
        return recommandCategory;
    }
    public void setCrewmenu(int person,String menu)
    {
        crewmenu.get(person).add(menu);
    }
    public ArrayList<ArrayList<String>> getCrewmenu() {
        return  crewmenu ;
    }

}
