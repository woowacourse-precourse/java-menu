package menu.model;

public class Recommend {

    private final RandomGenerator randomGenerator;


    private Status status;

    public Recommend(){
        randomGenerator = new RandomGenerator();
        status = Status.NOT_OK;
    }

    public Category recommendCategory(Coach coach){
        Category pickedCategory=null;
        while(status==Status.NOT_OK){

            pickedCategory = Category.from(randomGenerator.pickRandomCategory());

            if(coach.isFineCategory(pickedCategory)){
                status = Status.OK;
            }

            if(status==Status.OK){
                break;
            }
        }
        return pickedCategory;
    }

    public String recommendMenu(Category category){

    }



}
