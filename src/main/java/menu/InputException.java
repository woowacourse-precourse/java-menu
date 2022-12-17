package menu;

public class InputException {
    public static void coachListCheck(String[] coachList) throws IllegalArgumentException {
        if (coachList.length < 2 || coachList.length > 5)
            throw new IllegalArgumentException("최소 2명, 최대 5명의 코치를 \",\"로 구분하여 입력하였는지 확인하세요.");
    }

    public static void coachNameCheck(String[] coachList) throws IllegalArgumentException {
        for (String coach : coachList) {
            if (coach.length() > 4 || coach.length() < 2) {
                throw new IllegalArgumentException("코치 이름이 최소 2글자, 최대 4글자로 입력하였는지 확인하세요.");
            }
        }
    }

    public static void hateMenusNumCheck(String[] hateMenus) throws IllegalArgumentException {
        if (hateMenus.length > 2)
            throw new IllegalArgumentException("최대 2개의 먹지 못하는 메뉴를 \",\"로 구분하여 입력하였는지 확인하세요.");
    }
}
