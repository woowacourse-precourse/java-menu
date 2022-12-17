package menu.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CategoryAndFood {
    private HashMap<String, List<String>> dataBase;
    private ArrayList<String> categories;

    public CategoryAndFood() {
        this.dataBase = new HashMap<>();
        this.categories = new ArrayList<>();
        generateCategoryList();
    }

    private void generateCategoryList() {
        List<String> foodList = FileInput.fileRead();
        for (String line :
                foodList) {
            List<String> detachedLine = Arrays.asList(line.replace(" ", "").split(",|:"));
            addingList(detachedLine);
        }
    }


    private void addingList(List<String> line) {
        String category = line.get(0);
        categories.add(category);
        dataBase.put(category, line.subList(1, line.size()));
    }

    public List<String> getCategoryList() {
        return categories;
    }

    public HashMap<String, List<String>> getDataBase() {
        return dataBase;
    }
}
