package menu.views;

public class ProgramOutput {

    public void suggestProgramStart(){
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public void printRequestCoachNames(){
        System.out.println("\n코치의 이름을 입력해 주세요. (, 로 구분)");
    }

    public void printRequestNotHaveMenu(String coachName){
        System.out.printf("\n%s(이)가 못 먹는 메뉴를 입력해 주세요.\n",coachName);
    }

    public static void printStatement(String errorMessage){
        System.out.println(errorMessage);
    }
}
