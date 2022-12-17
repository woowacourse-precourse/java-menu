package menu.model;

public enum Category {

//일식: 규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼
//한식: 김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음
//중식: 깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채
//아시안: 팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜
//양식: 라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니



    JAP(1,"일식"),
    KOR(2,"한식"),
    CHI(3,"중식"),
    ASI(4,"아시안"),
    FRE(5,"양식");

    private final int value;
    private final String mean;

    Category(int value, String mean) {
        this.value = value;
        this.mean = mean;
    }
    public String getValueToString() {
        return String.valueOf(value);
    }
    public int getValue() {
        return value;
    }
    public String getMean(){
        return mean;
    }
}
