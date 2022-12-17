package menu.domain;

import java.util.*;

public class Food {
    Map<Category, List<String>> foods = new HashMap<>();

    public List<String> japan = new ArrayList<>(Arrays.asList("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"));
    public List<String> korea = new ArrayList<>(Arrays.asList("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"));
    public List<String> china = new ArrayList<>(Arrays.asList("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"));
    public List<String> asian = new ArrayList<>(Arrays.asList("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"));
    public List<String> western = new ArrayList<>(Arrays.asList("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));

    public Map<Category,List<String>> initFoods(){
        foods.put(Category.JAPAN, Arrays.asList("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"));
        foods.put(Category.KOREA, Arrays.asList("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"));
        foods.put(Category.CHINA, Arrays.asList("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"));
        foods.put(Category.ASIAN, Arrays.asList("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"));
        foods.put(Category.WESTERN, Arrays.asList("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));
        return foods;
    }

    public Map<Category,List<String>> changeFood(Category category, String foodName){
        for(String name: foods.get(category)){
            if(name.equals(foodName)){
                foods.get(category).remove(foodName);
            }
        }
        return foods;
    }
    public boolean findFoodByName(List<String> eachFoods, String findFood){
        for(String food: eachFoods){
            if(food.equals(findFood)){
                return true;
            }
        }
        return false;
    }
    public void findFoodByCategory(String notFood){
        boolean checkFood = false;
        Set<Category> categories = foods.keySet();
        for(Category category: categories){
            checkFood = findFoodByName(foods.get(category),notFood);
            if(checkFood){
                System.out.println("delete");
                //deleteFood(category,foods.get(category), notFood);
            }
        }
        System.out.println(foods.toString());

    }
    public void splitNotFood(List<String> notFoods){
        for(String notFood: notFoods){
            findFoodByCategory(notFood);
        }
    }

    public void deleteFood(Category category, List<String> existingFoods, String foodName){
        List<String> newFoods = new ArrayList<>();
        newFoods = foods.get(category);
        newFoods.remove(foodName);
        System.out.println(newFoods);
    }
//        for(String name: foods.get(category)){
//            if(name.equals(foodName)){
//                foods.get(category).remove(foodName);
//            }


}
