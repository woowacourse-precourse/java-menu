package menu.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PickCategoryTest {


    @Test
    void set_cat_TEST() {
        PickCategory pickCategory = new PickCategory();
        pickCategory.setRecommandCategory();
        System.out.println(pickCategory.getRecommandCategory());
    }

}