package menu.view;

public class OutputView {
    private static final String ERROR_PRINT_FORMAT = "[ERROR] %s";

    public static void printErrorMsg(String error_msg){
        System.out.println(String.format(ERROR_PRINT_FORMAT,error_msg));
    }
}
