## 최종 코딩테스트 점심 메뉴 추천

### 기능 요구 사항

- [X] 코치 이름 입력 InputView#coachNameInput
  - [X] 최소 2글자, 최대 4글자 InputView#validateName
  - [X] 최소 2명 최대 5명
- [X] 코치 먹지 못하는 메뉴 입력 InputView#coachCantEatInput
  - [X] 최소 0개 최대 2개 (,로 구분)
- [X] 카테고리와 메뉴 추가 recommendMenu#AddCategory()
  - [X] 일식,한식,중식,아시안,양식 추가 AddCategory#addJapan,addKorean,addChinese,addAsian,addAmerican
- [ ] 카테고리 추천
  - [X] 카테고리 메뉴 랜덤으로 가져오기 Random#RandomCategory , Random#RandomMenu
  - [ ] 한주에 같은 카테고리 최대 2회
- [ ] 메뉴 추천
  - [ ] 한주에 중복되지 않는 메뉴를 추천해야한다.