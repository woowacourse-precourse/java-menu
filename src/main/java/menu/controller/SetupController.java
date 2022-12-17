package menu.controller;

import menu.domain.MenuCategory;
import menu.domain.MenuCategoryRepository;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SetupController extends AbstractController{

    public static final String MENU_FILE_FILE_PATH = "src/main/resources/menuFile.txt";
    public static final String UNREADABLE_FILE_EXCEPTION = "파일을 읽을 수 없습니다.";
    public static final String BLOCK = ", ";


    @Override
    void doProcess() {
        try {
            Scanner scanner = new Scanner(new File(MENU_FILE_FILE_PATH));
            while (scanner.hasNext()) {
                saveMenuCategory(scanner);
            }
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(UNREADABLE_FILE_EXCEPTION);
        }
    }

    private void saveMenuCategory(Scanner scanner) {
        String[] matchInfoSentence = getMatchInfoSentence(scanner);
        MenuCategoryRepository.saveByName(matchInfoSentence[0]);
    }

    private static String[] getMatchInfoSentence(Scanner scanner) {
        String matchInfo = scanner.nextLine();
        return matchInfo.split(BLOCK);
    }
}
