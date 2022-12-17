package menu;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;

public class Menu {
    private final List<String> japanese;
    private final List<String> korean;
    private final List<String> chinese;
    private final List<String> asian;
    private final List<String> western;

    public Menu(){
        japanese = Arrays.asList("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼");
        korean = Arrays.asList("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음");
        chinese = Arrays.asList("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채");
        asian = Arrays.asList("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜");
        western = Arrays.asList("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니");
    }

    public boolean isExist(String foodName){
        if(japanese.contains(foodName) || korean.contains(foodName) || chinese.contains(foodName)
            || asian.contains(foodName) || western.contains(foodName))
            return true;
        return false;
    }

    public String getRandomJapanese(){
        return Randoms.shuffle(japanese).get(0);
    }

    public String getRandomKorean(){
        return Randoms.shuffle(korean).get(0);
    }

    public String getRandomChinese(){
        return Randoms.shuffle(chinese).get(0);
    }

    public String getRandomAsian(){
        return Randoms.shuffle(asian).get(0);
    }

    public String getRandomWestern(){
        return Randoms.shuffle(western).get(0);
    }

}
