package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Category;
import menu.domain.Coach;
import menu.exception.InputException;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class MenuService {
    private final List<Coach> coaches = new ArrayList<>();
    private final List<Category> categories = new ArrayList<>();

    public List<String> getCategories() {
        return categories.stream()
                .map(Category::getCategoryName)
                .collect(Collectors.toList());
    }

    public List<List<String>> getCoachesMenus() {
        return coaches.stream()
                .map(Coach::getRecommended)
                .collect(Collectors.toList());
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    public List<String> getCoachesName() {
        return coaches.stream()
                .map(Coach::getName)
                .collect(Collectors.toList());
    }

    public void setCoachesName(String input) {
        coaches.clear();
        validateCoachesInput(input);

        StringTokenizer st = new StringTokenizer(input, ",");
        while (st.hasMoreTokens())
            coaches.add(new Coach(st.nextToken()));
    }

    public void setAvoidance(List<String> inputs) {
        for (int i = 0; i < inputs.size(); i++)
            coaches.get(i).addAvoidance(inputs.get(i));
    }

    public void setCategories() {
        while (categories.size() < 5) {
            Category newCategory = Category.values()[Randoms.pickNumberInRange(1, 5) - 1];
            addNewCategory(newCategory);
        }
    }

    public void setMenus() {
        for (int i = 0; i < 5; i++) {
            addMenu(categories.get(i));
        }
    }

    public void validateAvoidanceInput(String input) {
        StringTokenizer st = new StringTokenizer(input, ",");
        List<String> avoidances = new ArrayList<>();
        while (st.hasMoreTokens())
            avoidances.add(st.nextToken());

        if(avoidances.stream().distinct().count()!=avoidances.size())
            throw new IllegalArgumentException(InputException.DUPLICATED_INPUT.getMessage());

        if(2<avoidances.size())
            throw new IllegalArgumentException(InputException.INVALID_COUNT_OF_AVOIDANCE.getMessage());

        avoidances.forEach(Category::isValidMenu);
    }

    private void addMenu(Category category) {
        for (Coach coach : coaches) {
            while (!coach.addRecommended(category.pickMenu())) {
            }
        }
    }

    private void addNewCategory(Category newCategory) {
        if (countDuplicated(newCategory) < 2)
            categories.add(newCategory);
    }

    private int countDuplicated(Category newCategory) {
        int count = 0;
        for (Category category : categories)
            if (category.equals(newCategory))
                count++;

        return count;
    }

    private void validateCoachesInput(String input) {
        List<String> coachesName = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(input, ",");
        while (st.hasMoreTokens())
            coachesName.add(st.nextToken());

        if(coachesName.stream().distinct().count()!=coachesName.size())
            throw new IllegalArgumentException(InputException.DUPLICATED_INPUT.getMessage());

        if (coachesName.size() < 2 || 5 < coachesName.size())
            throw new IllegalArgumentException(InputException.INVALID_COUNT_OF_COACHES.getMessage());
    }
}
