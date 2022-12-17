package menu;

public class Validate {
    OutputView outputView = new OutputView();

    public boolean isValidCoachName(String input){
        try {
            String[] coachName = input.split(",");
            checkCoachNum(coachName);
            checkCoachNameSize(coachName);
        }
        catch (IllegalArgumentException e){
            outputView.printErrorMessage(e.getMessage());
            return (false);
        }
        return true;
    }

    public boolean isValidDislikeFood(String input){
        try {
            String[] dislikeFood = input.split(",");
            checkDislikeFoodSize(dislikeFood);
            for (String food : dislikeFood){
                checkFoodInCategory(food);
            }
        }
        catch (IllegalArgumentException e){
            outputView.printErrorMessage(e.getMessage());
            return (false);
        }
        return true;
    }

    private void checkDislikeFoodSize(String[] input){
        if (input.length > 2){
            throw new IllegalArgumentException("못 먹는 메뉴는 최대 2개까지 입력할 수 있습니다.");
        }
    }

    private void checkFoodInCategory(String food){
        if (!checkFoodInEachCategory(food)){
            throw new IllegalArgumentException("입력할 수 없는 메뉴입니다");
        }

    }
    private boolean checkFoodInEachCategory(String food){
        return (Category.JAPANESE.checkFoodInside(food) ||
                Category.KOREAN.checkFoodInside(food) ||
                Category.CHINESE.checkFoodInside(food) ||
                Category.ASIAN.checkFoodInside(food) ||
                Category.WESTERN.checkFoodInside(food));
    }

    private void checkCoachNum(String[] input) {
        if (input.length < 2 || input.length > 5) {
            throw new IllegalArgumentException("코치는 최소 2명, 최대 5명까지 함께 밥을 먹을 수 있습니다.");
        }
    }

    private void checkCoachNameSize(String[] input){
        for (String name : input){
            if (name.length() < 2 || name.length() > 4){
                throw new IllegalArgumentException("코치 이름은 최소 2글자 최대 4글자 입니다.");
            }
        }
    }


}
