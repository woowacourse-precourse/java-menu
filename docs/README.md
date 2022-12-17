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
1. 멤버변수 memebers (List<Member>) - 멤버 정보 저장
2. 멤버변수 categories - 요일 별 카테고리 저장
3. chooseCategory() - 요일의 카테고리를 선택해 저장하는 메서드
4. chooseMenus() - 멤버 별로 요일의 추천 음식을 선택해 저장하는 메서드
5. manageMealsDayOfTheWeek() - 3, 4를 이용해 요일의 음식 선택과정을 처리하는 메서드
6. makeRecommends() - 5를 이용해 추천 결과를 완성시키는 메서드 - public
7. validateMenuDuplication() - 해당 메뉴가 중복되었는지 확인하는 메서드
8. validateCategoryDuplication() - 해당 카테고리가 2회 이상 나왔는지 확인하는 메서드
9. validatePickyEating() - 해당 음식이 못먹는 음식인지 확인하는 메서드 (인자로 음식 이름, 멤버 객체를 받아야하나?)

## MenuRandomGenerator 클래스 
 - 랜덤한 숫자를 생성한다. (카테고리, 메뉴 각각에 대해서) 
1. categoryRandomSelector() - 1~5 사이의 카테고리 번호를 생성한다.
2. menuRandomSelector() - 리스트를 셔플해서 반환한다.

## InputView 클래스
 - 입력을 관리
1. readCoachNames() - 코치 이름을 입력받아 검증해 반환
 - 코치의 수가 2~5인지
 - 코치 이름 글자수가 2~4인지

2. readPickyEatings() - 못 먹는 메뉴를 입력받아 검증해 반환
 - 메뉴 수가 0~2인지
 - 정해진 메뉴에 존재하는 이름인지

## OutputView 클래스
 - 출력을 관리

## Controller 클래스
 - view단과 도메인을 활용해서 프로그램을 돌리는 단계


---
코치는 최소 2명, 최대 5명까지 식사를 함께 한다. -> 입력되는 코치 수에 대한 설명? 이거인듯
아니면 같은요일에 같은 메뉴를 먹는 사람이 최소 2명이어야된다는 뜻?? 아닌듯





