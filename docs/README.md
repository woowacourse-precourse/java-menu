## 최종 코딩테스트 점심 메뉴 추천

### 기능 요구 사항

- [X] 코치 이름 입력 Controller#coachName  InputView#coachNameInput
  - [X] 최소 2글자, 최대 4글자 InputView#validateName
  - [X] 최소 2명 최대 5명 InputView#validateNumber
- [X] 코치 먹지 못하는 메뉴 입력 Controller#coachNotEatMenu   InputView#coachCantEatInput
  - [X] 최소 0개 최대 2개 (,로 구분) InputView#validateCantEat
- [X] 카테고리와 메뉴 추가 AddCategory()
  - [X] 일식,한식,중식,아시안,양식 추가 AddCategory#addJapan,addKorean,addChinese,addAsian,addAmerican
- [X] 추천 Controller#recommendMenu
- [X] 카테고리 추천 Recommend#recommendCategory
  - [X] 카테고리 메뉴 랜덤으로 가져오기 Random#RandomCategory , Random#RandomMenu
  - [X] 한주에 같은 카테고리 최대 2회 Recommend#validateCategory
- [x] 메뉴 추천 Recommend#recommendFood
  - [x] 한주에 중복되지 않는 메뉴를 추천해야한다. Recommend#randomMenu

Coach - 코치와 안먹는 음식 저장 class
CoachFood - 코치와 추천받은 음식 저장 class
Menu - 메뉴의 카테고리와 음식리스트 저장 class
