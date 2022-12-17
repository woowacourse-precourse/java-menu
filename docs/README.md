## 🚀 기능 구현에 필요한 사항
**`충분한 test를 통해, 구현이 완료된 사항만 체크한다.`**

### 1. 사용자의 입력
**`camp.nextstep.edu.missionutils`의 `Console.readLine()` 사용**
- [X] 사용자 입력 유효성 검사
  * 코치는 2명 이상, 5명 이하
    * 코치 이름은 2글자 이상, 4글자 이하
  * 못먹는 메뉴는 0개 이상, 2개 이하
    
### 2. 메뉴 추천
**`camp.nextstep.edu.missionutils`의 `Randoms.pickNumberInRange()` 사용**
- [X] 카테고리 선택
  * 한 주에 동일한 카테고리는 2회까지만 가능
- [X] 메뉴 선택
  * 중복되지 않는 메뉴를 선택
  * 못먹는 메뉴 제외
  
### 3. 결과 출력
- [X] 메뉴 추천 결과 출력
  * 요일별 구분
