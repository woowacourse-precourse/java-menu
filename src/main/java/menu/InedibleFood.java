package menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InedibleFood {
    List<String> inedibleFoods = new ArrayList<>();
    CategoryLists categoryLists = new CategoryLists();

    public InedibleFood(String input){
        validate(input);
    }

    public void validate(String input){
        String[] inputSplit = input.split(",");
        List<String> eachInedible = Arrays.asList(inputSplit);

        validateLength(eachInedible);
        validateExistence(eachInedible);
        deduplicate(eachInedible);
        addInedible(eachInedible);
    }

    private void validateLength(List<String> input) {
        if(input.size() > 2){
            throw new IllegalArgumentException(ErrorMessage.PREFIX+ErrorMessage.INVALID_INEDIBLE_EACH);
        }
    }


    private void validateExistence(List<String> inedibleFoods) {
        for(String food : inedibleFoods){
            saveExistence(food);
        }
    }

    private void saveExistence(String food){
        if(categoryLists.isExist(food)){
            inedibleFoods.add(food);
        }
    }

    private List<String> deduplicate(List<String> eachInedible) {
        return eachInedible.stream().distinct().collect(Collectors.toList());
    }

    private void addInedible(List<String> eachInedible) {
        for(String food : eachInedible){
            inedibleFoods.add(food);
        }
    }

}
