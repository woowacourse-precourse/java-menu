package menu.view;

import menu.dto.output.PrintExceptionDto;

public class OutputView {
    private static final String errorHead = "[ERROR] ";

    private OutputView() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    private static class OutputViewSingletonHelper {
        private static final OutputView OUTPUT_VIEW = new OutputView();
    }

    public static OutputView getInstance() {
        return OutputViewSingletonHelper.OUTPUT_VIEW;
    }

    public void printException(PrintExceptionDto dto) {
        System.out.println(errorHead + dto.getException().getMessage());
    }
}
