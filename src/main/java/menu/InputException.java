package menu;

public class InputException {
    public static boolean exceptionCoach(String[] coachNameList){
        try{
            exceptionCoachSize(coachNameList);
            exceptionCoachName(coachNameList);
            return false;
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return true;
        }
    }
    public static void exceptionCoachSize(String[] coachNameList) {
        if (coachNameList.length < 2 || coachNameList.length > 5) {
            throw new IllegalArgumentException("[ERROR] 코치는 최소 2명, 최대 5명으로 입력해야 합니다.");
        }
    }
    public static void exceptionCoachName(String[] coachNameList){
        for(int i=0;i<coachNameList.length;i++){
            if(coachNameList[i].length() < 2 || coachNameList[i].length() > 4){
                throw new IllegalArgumentException("[ERROR] 코치의 이름은 최소 2글자, 최대 4글자로 입력해야 합니다.");
            }
        }
    }

    public static boolean exceptionMenu(String[] menuList){
        try{
            exceptionMenuSize(menuList);
            return false;
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return true;
        }
    }

    public static void exceptionMenuSize(String[] menuList){
        if(menuList.length < 0 || menuList.length > 2){
            throw new IllegalArgumentException("[ERROR] 못 먹는 메뉴는 최소 0개, 최대 2개로 입력해야 합니다.");
        }
    }
}
