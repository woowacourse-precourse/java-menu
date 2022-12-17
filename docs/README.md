# 요구 사항 분석

## 🚀 기능 요구사항 리스트
### Logic
1. [x]추천할 카테고리 무작위 정함
2. [x]각 코치가 먹을 메뉴를 추천

### Validation
1. [x]코치의 이름은 최소 2글자, 최대 4글자
2. [x]코치는 최소 2명, 최대 5명까지 식사를 함께 한다
3. [x]각 코치는 최소 0개, 최대 2개의 못 먹는 메뉴가 있다.(먹지 못하는 메뉴가 없으면 빈 값을 입력)
4. [x]한 주에 같은 '카테고리' 는 최대 2회까지만
5. [x]각 코치에게 한 주에 중복되지 않는 '메뉴' 를 추천

## 구조화(MVC)
InputView : 입력 담당<br>
OutputView : 출력 담당<br>
Controller : 요청 수행<br>
Model(Service) : Recommend, Menu <br>
DTO : CoachWeekMenu <br>
VO : Coach<br>
Enum : Week , FoodCategory <br>


### Domain 구현 목록
1. Recommend
    - [자료구조] 
      - Map<FoodCategory,Integer> : 이번주에 카테고리 선택 수
      - List<FoodCategory> : 카테고리 누적 리스트(월~금)
    - [기능]
      - 추천할 카테고리 무작위 정함
      - 각 코치가 먹을 메뉴를 추천
    - [예외 처리]

2. Menu
   - [자료구조]
     - FoodCategory : 미리 해당 카테고리를 정해 놓는다. 해당 카테고리에서만 음식 찾음
     - List<String> : 카테고리에 해당하는 음식들
   - [기능]
     - 코치의 정보를 넣으면 카테고리 안에서 메뉴를 선택
   - [예외 처리]

3. Coach VO
   - 코치 이름
   - 코치가 못먹는 메뉴

4. CoachWeekMenu DTO
   - 코치 이름
   - 코치가 이번주 먹은 메뉴 리스트

### InputView
- [기능] 
   - 추천 시작 메시지
   - 코치 이름 입력 기능
   - 코치 별 못먹는 메뉴 입력 기능
- [예외 처리]

### OutputView
- [기능]
  - 메뉴 추천 결과 출력 기능
- [예외 처리]

### Controller
- [기능]
- [예외 처리]



### 
```
[field]<br>

[constructor]<br>

[method]<br>

```

### 
```
[field]<br>

[constructor]<br>

[method]<br>

```