# 기능 구현 목록

## 도메인

### Category
- 메뉴의 유형(카테고리)를 담고있는 객체

### Couch
- 코치 이름을 담고있는 객체

### DataRow
- 라인 별 데이터를 담고있는 객체

### DataRows
- 추천 정보 전체를 담고있는 객체 

### Day
- 요일 정보를 담는 Enum 객체 

### Menu
- 카테고리와 메뉴 이름을 가지고 있는 객체

## 뷰
### InputView
- 사용자 입력 기능 담당

### OutputView
- 사용자 출력 기능 담당
## 서비스

### MenuController
- 전체 로직 흐름 제어
- 메뉴 추천 기능 구현

### MenuRepository
- 이름에 맞는 Menu객체 저장

### Validator
- 주어진 입력의 유효성 검증
- 코치는 적어도 2명 이상!
- 음식 이름은 유효한 이름만 가능





