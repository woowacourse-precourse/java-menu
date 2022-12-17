
    public void printResult(Coachs coachs) {
        System.out.println(RESULT_MESSAGE);
        printWeekDays();
        printCategories();
        for (Coach coach : coachs.getCoachs()) {
            printRecommend(coach);
        }
        this.printBlank();
    }

    private void printWeekDays() {
        System.out.println(makeResultView("구분", WEEKDAYS));
    }

    private void printCategories() {
        System.out.println(makeResultView("카테고리", Category.getNames()));
    }

    private void printRecommend(Coach coach) {
        System.out.println(makeResultView(coach.getName(), coach.getRecommends()));
    }

    private String makeResultView(String head, List<String> list) {
        String elements = String.format("[ %s | ", head);
        elements += String.join(" | ", list);
        elements += " ]";
        return elements;
    }
}
