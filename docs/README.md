# 요구 사항 분석

## 🚀 기능 요구사항 리스트
### Logic
1. 월요일에 추천할 카테고리 무작위 정함
2. 각 코치가 월요일에 먹을 메뉴를 추천

### Validation
1. 코치의 이름은 최소 2글자, 최대 4글자
2. 코치는 최소 2명, 최대 5명까지 식사를 함께 한다
3. 각 코치는 최소 0개, 최대 2개의 못 먹는 메뉴가 있다.(먹지 못하는 메뉴가 없으면 빈 값을 입력)
4. 한 주에 같은 '카테고리' 는 최대 2회까지만
5. 각 코치에게 한 주에 중복되지 않는 '메뉴' 를 추천

## 구조화(MVC)
InputView : 입력 담당<br>
OutputView : 출력 담당<br>
Controller : 요청 수행<br>
Model(Service) : Recommend, <br>
DTO : <br>
VO : Coach , Menu<br>
Enum : Week , Category <br>


### Domain 구현 목록
1. Recommand
    - [자료구조] 
      - Map<Category,List<String>>
      - Map<Coach,List<Menu>>
    - [기능]
    - [예외 처리]

3. Coach VO
   - 코치 이름
   - 코치가 못먹는 메뉴
4. Menu VO
   - 카테고리
   - 메뉴들 리스트

### InputView
- [기능]
- [예외 처리]

### OutputView
- [기능]
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