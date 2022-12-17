# 점심 메뉴 추천

## 애플리케이션 시나리오
1. 점심 메뉴를 추천 받을 코치들의 이름을 ,로 구분지어서 최소 2명, 최대 5명까지 입력 받는다.
2. 입력 받은 코치들이 못 먹는 메뉴를 각각 ,로 구분지어서 최소 0개, 최대 2개까지 입력 받는다.
3. 코치별로 메뉴를 추천해준다.
<br> - 한 주에 같은 카테고리의 음식은 2개까지만 가능하다.
<br> - 한 주에 중복되는 음식을 추천하면 안된다.
4. 메뉴 추천 결과를 출력해준다.

## 기능 목록

## 시작 안내
- [x] 점심 메뉴 추천 안내 문구를 출력한다.

### 기본 정보 등록
- [x] 주어진 음식들을 카테고리별로 등록한다.
  - [x] 음식 카테고리 등록
  - [x] 카테고리별 음식 등록
- [x] 코치의 이름을 ,로 구분지어서 입력 받는다.
  - [x] 입력 받은 코치 이름을 List 형태로 변환시켜준다. 
  - [x] 코치의 수가 2명 미만, 5명 초과할 경우 IllegalArgumentException 발생
  - [x] 각 코치의 이름이 2글자 미만, 4글자 초과할 경우 IllegalArgumentException 발생
  - [x] 중복되는 코치의 이름이 있다면 IllegalArgumentException 발생
- [x] 코치가 먹지 못하는 음식을 ,로 구분지어서 입력 받는다.
  - [x] 등록된 메뉴에 없는 음식을 입력 받으면 IllegalArgumentException 발생
  - [x] 입력 받은 먹지 못하는 음식들을 List 형태로 변환시켜준다.
  - [x] 먹지 못하는 메뉴가 2개를 초과할 경우 IllegalArgumentException 발생
- [x] 코치가 먹지 못하는 음식을 등록해준다.

### 메뉴 추천
- [x] 각 코치들에게 월요일부터 금요일까지의 음식 카테고리를 Randoms.pickNumberInRange()을 사용하여 추천해준다.
  - [ ] 한 주에 같은 음식 카테고리가 3개 이상 있는지 확인하고, 있다면 CannotRecommendCategoryException 발생
  - [ ] CannotRecommendCategoryException 에러 발생 시 해당 코치에게 다시 음식 카테고리를 추천해준다.
- [ ] 음식 카테고리 안에서 음식을 Randoms.shuffle()을 사용하여 섞고, 가장 앞에 있는 음식을 추천해준다.
  - [ ] 한 주에 같은 음식이 2개 이상 있는지 확인하고, 있다면 CannotRecommendMenuException 발생
  - [ ] CannotRecommendMenuException 에러 발생 시 해당 코치에게 다시 음식을 추천해준다. 
- [ ] 메뉴 추천 결과를 출력해준다.
