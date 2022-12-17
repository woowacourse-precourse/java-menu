## JAVA MENU

###기능 구현 목록
-[X] 코치의 이름을 입력 받는다(,로 구분)
    -[X] 올바른 값이 아니면 예외 처리한다.
    코치의 이름은 최소 2글자, 최대 4글자( 최소 2명~ 5명)
     코치의 이름이 중복되는 경우
-[X] 각 코치가 못먹는 메뉴 입력 
    -[X] 각 코치마다 입력 한다.
    -[X] 최소 0개에서 최대 2개 (, 구분)
    -[X] 없는 경우 빈칸 입력
    
    
-[X] 메뉴 추천 결과를 제공
    -[X] 메뉴 추천은 각 요일마다 한 카테고리 
    -[X] 각 카테고리별로 일주일에 두번만 가능
    -[X] 음식 종류는 같은 음식을 먹어서는 안된다.
  

### 예외 처리 사항
- ERROR_COACH_NAME_SPLITTER, "," 입력 오류
- ERROR_COACH_NUMS, 코치 인원수는 2이상 5이하
- ERROR_COACH_NAME_LENGTH, 코치 이름 길이는 2이상 4이하
- ERROR_COACH_FOODS_SPLITTER ",' 입력 오류
- ERROR_COACH_HATED_FOOD_MANY , 싫어하는 음식으 2개 이하
- ERROR_NONE_MENU , 싫어 하는 음식에 없는 메뉴를 입력
- ERROR_WEEKLY_CATEGORY_SIZE , 일주일 음식 카테고리가 정해진 요일보다 더 들어온 경우
- ERROR_NONE_CATEGORY, 없는 카테고리가 선택된 경우