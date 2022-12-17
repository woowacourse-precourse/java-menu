package menu.output;

import menu.message.ErrorMessage;

public class ErrorMessageOutput {
    public static void printErrorMessage(ErrorMessage errorMessage) {
        System.out.println();
        System.out.println(errorMessage.getMessage());
        System.out.println();
    }
}
