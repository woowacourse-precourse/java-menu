package menu.view;

public class OutputView {

    public void printStartGuide(){
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public void printNameInputGuide(){
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
    }

    public void printError(String errorMessage){
        System.out.println("[ERROR]" +  errorMessage);
    }
}
