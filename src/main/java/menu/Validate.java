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
