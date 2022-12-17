package menu.model;

public class Recommend {

    private final RandomGenerator randomGenerator;


    private Status status;

    public Recommend(){
        randomGenerator = new RandomGenerator();
        status = Status.NOT_OK;
    }



}
