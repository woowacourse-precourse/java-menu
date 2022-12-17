# 📝 기능 요구 사항

- [x] 기능
    - [x] 월요일 ~ 금요일까지 음식을 카테고리 별로 추천
        - [x] 한 주에 같은 카테고리는 최대 2회까지만 고를 수 있다. RecommendService#findRecommendMenus()
        - [x] 각 코치에게 한 주에 중복되지 않는 메뉴를 추천해야 한다. RecommendService#findRecommendMenus()
        - [x] 랜덤으로 카레고리를 뽑아준다 RecommendSystem#pickRandomCategory()
        - [x] 랜덤으로 음식을 뽑아준다 RecommendSystem#pickRandomMenu()
        - [x] 메뉴 저장 기능 MenuRepository

- [ ] 입력
    - [x] 코치 이름 InputView#inputCoachName()
    - [x] 못먹는 음식(없으면 빈 값) InputView#inputCannotEatMenu()

- [x] 출력
    - [x] 메뉴 추천 결과 OutputView#printResult()
    - [x] 추천 완료 메시지 OutputView#printResult()
    - [x] 시작 메시지 OutputView#printStartMessage()

- [ ] 예외
    - [x] 코치의 이름은 최소 2글자, 최대 4글자이다. Coaches#validateCoachName()
    - [x] 코치는 최소 2명, 최대 5명까지 식사를 함께 한다. Coaches#validateCoachName()
      - [x]각 코치는 최소 0개, 최대 2개의 못 먹는 메뉴가 있다. (, 로 구분해서 입력한다.)
      먹지 못하는 메뉴가 없으면 빈 값을 입력한다. Menus#validateMenuSize
    - [x] 3번이상 같은 카테고리를 못먹게 한다. Coach#validateIfTooManyCategory()