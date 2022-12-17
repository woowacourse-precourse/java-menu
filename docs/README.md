## 기능 목록

### 카테고리 및 메뉴 초기화 `INITIALIZE_MENUS`

- [x] 카테고리 등록 `Category` `CategoryRepository`
- [x] 메뉴 등록 `Menu` `MenuRepository`
- [x] 카테고리 안에 메뉴 등록

### 메뉴 추천 초기 설정  `RECEIVE_COACH_DATA`

- [x] 시작 멘트 출력
- [x] 코치 이름 입력 (,로 구분)
    - [x] 예외) 코치의 수가 1명 이하이거나, 6명 이상인 경우 예외 처리
    - [x] 예외) 이름이 1글자 이하이거나, 5글자 이상인 경우 예외 처리
- [x] 각 코치가 못 먹는 메뉴 입력 (먹지 못하는 메뉴가 없으면 빈 값을 입력)
    - [x] 예외) 입력한 메뉴가 `MenuRepository`에 존재하지 않으면 예외 처리
    - [x] 예외) 못 먹는 메뉴가 3개 이상인 경우 예외 처리
    - [ ] 공백 입력 시 못 먹는 메뉴가 없는 것임

### 메뉴 추천 `RECOMMEND_RANDOM_MENU`

- [x] 추천할 카테고리 선택: `Randoms.pickNumberInRange()`
    - `String category = categories.get(Randoms.pickNumberInRange(1, 5));`
    - [x] 한 주에 같은 카테고리는 최대 2회까지 고를 수 있음.
    - [x] 추천할 수 없는 카테고리인 경우 다시 임의의 값을 생성해서 추천할 카테고리를 정함

- [x] 정해진 카테고리에 있는 메뉴를 임의의 순서로 섞은 후, 첫 번째 값을 사용: `Randoms.shuffle()`
    - `String menu = Randoms.shuffle(menus).get(0);`
    - [x] 각 코치에게 한 주에 중복되지 않는 메뉴를 추천해야 함.
    - [x] 추천할 수 없는 메뉴인 경우 다시 섞은 후 첫 번째 값을 사용

- [x] 출력 양식에 맞게 추천 메뉴 출력

### 리팩터링

- [ ] 접근제어자 수정
- [ ] OutputView 유연성 개선
- [ ] Controller 분리
- [ ] 하드코딩 제거