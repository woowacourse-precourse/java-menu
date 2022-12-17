package menu.model;

import java.util.List;

public class ResultBoard {
    private List<String> recommandCategory;
    private Crew crew;
    public ResultBoard(Crew crew){
        this.crew = crew;
    }

    public void setRecommandCategory(List<String> recommandCategory){
        this.recommandCategory = recommandCategory;
    }
    public List<String> getRecommandCategory()
    {
        return recommandCategory;
    }
}
