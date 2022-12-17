package view;

public class OutputView {
    public void printStartMessage() {
        System.out.println(ViewConstants.PROGRAM_START);
        System.out.println();
    }

    public void printRecommendation(String render) {
        System.out.println(ViewConstants.RECOMMEND_RESULT);
        System.out.println(render);
    }

    public void printEndMessage() {
        System.out.println(ViewConstants.END);
    }

    public void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
