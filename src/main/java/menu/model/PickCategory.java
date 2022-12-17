package menu.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class PickCategory {

    private List<String> recommandCategory;

    private GenerateRandomNumber generateRandomNumber;

    public PickCategory() {
        this.recommandCategory = new ArrayList<>();
        generateRandomNumber = new GenerateRandomNumber();
    }

    public void setRecommandCategory() {
        generateRandomNumber.setRandomNumbers();
        for (String numbers : generateRandomNumber.getRandomNumbers()) {
            String category = getOneCategory(numbers);
            recommandCategory.add(category);
        }
    }

    public String getOneCategory(String numbers) {
        int number = Integer.valueOf(numbers);

        if (number == Category.JAP.getValue()) {
            return Category.JAP.getMean();
        }
        if (number == Category.KOR.getValue()) {
            return Category.KOR.getMean();
        }
        if (number == Category.CHI.getValue()) {
            return Category.CHI.getMean();
        }
        if (number == Category.ASI.getValue()) {
            return Category.ASI.getMean();
        }
        if (number == Category.FRE.getValue()) {
            return Category.FRE.getMean();
        }
        return null;
    }
    public List<String> getRecommandCategory()
    {
        return recommandCategory;
    }
}
