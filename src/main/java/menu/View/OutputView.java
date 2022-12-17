package menu.View;

import menu.Constant.Menu;

import java.util.List;

public class OutputView {

    public void printCategory(List<Menu> categories){
        String text = "[ 카테고리";
        for(Menu category: categories){
            text += " | " + category.getCategory();
        }
        text += " ]";
        System.out.println(text);
    }

}
