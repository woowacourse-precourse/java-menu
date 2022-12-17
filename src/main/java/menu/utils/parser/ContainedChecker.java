package menu.utils.parser;

import java.util.List;

public class ContainedChecker {
    public static boolean isValidateManu(String input, List<String> manuList) {

        for (String manu : manuList) {
            if (manu.contains(input)) {
                return true;
            }
        }
        return false;
    }
}
