# 구현 방식
1. 코치들의 이름과 못 먹는 메뉴를 입력받기
2. Member 클래스로 생성
3. MenuRecommender 클래스 멤버 변수에 추가

4. 랜덤으로 카테고리 생성
 - 이전 카테고리들 중에 이미 두 번 나왔으면 다시 시도
5. 각 코치 별로 카테고리에 해당하는 랜덤 메뉴 할당
 - 이미 먹은 음식이면 다시 시도
 - 못 먹는 음식이면 다시 시도
6. 4, 5를 요일 별로 반복

---

# 기능 목록
## Member 클래스
 - 각 멤버별로 (추천된 식사, 못 먹는 음식)을 유지한다.

## Category - enum 
- 각 카테고리 별로 메뉴를 저장한다. -> list?? 멤버로 각각에 해당하는 번호를 가져야함 

## MenuRecommender 클래스 
 - 메뉴를 추천해서 결과를 유지한다.
1. 멤버변수 recommends (List<Member>) - 멤버 별로 추천 음식 저장
2. 멤버변수 categories - 요일 별 카테고리 저장
3. 

## MenuRandomGenerator 클래스 
 - 랜덤한 숫자를 생성한다. (카테고리, 메뉴 각각에 대해서) 
1. categoryRandomSelector() - 1~5 사이의 카테고리 번호를 생성한다.
2. menuRandomSelector() - 리스트를 셔플해서 반환한다.
## InputView 클래스
 - 입력을 관리

## OutputView 클래스
 - 출력을 관리





