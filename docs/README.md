## 기능 요구 사항

- 입력
  - 코치 이름
    - 코치 수 2명 미만이거나 5명 초과면 error 
    - 이름 길이 2글자 미만이거나 4글자 초과면 error
  - 못 먹는 메뉴
    - 못먹는 메뉴가 2개 초과면 error
    - 못먹는 메뉴가 추천 메뉴 리스트에 없으면 error

- 출력 
  - [ 토미 | 쌈밥 | 김치찌개 | 미소시루 | 짜장면 | 팟타이 ] 형식
  - 에러 발생시 에러 문구



### 객체
- Input
- Validate
- Output
- Category : string name , List<String> 메뉴
- PickRandomNum