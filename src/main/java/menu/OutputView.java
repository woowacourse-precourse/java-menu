package menu;

public class OutputView {
    private final String ERROR = "[ERROR] ";

    public void printErrorMessage(String e){
        System.out.println(ERROR + e);
    }
}
