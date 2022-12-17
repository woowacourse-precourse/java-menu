package menu.service;

import menu.MainController;
import menu.dto.SuggestMenuResultDto;

public class SuggestMenuService {

    private static final SuggestMenuService instance = new SuggestMenuService();

    private SuggestMenuService() {

    }

    public static SuggestMenuService getInstance() {
        return instance;
    }

    public SuggestMenuResultDto suggest() {


    }
}
