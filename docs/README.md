# 기능 구현 목록

---

## 흐름

- 코치의 이름을 입력 받는다.
  - n명의 코치에 대해 못 먹는 메뉴를 전부 입력 받는다.
- 메뉴를 추천해준다. (매주 랜덤한 카테고리와, 메뉴 채우기)

## 설계

- Domain
  - Crew
    - name, List<String> // 이름과 먹을 요리 관리
  - CrewList
    - List<Crew> crews
  - BannedFood
    - List<String> 못먹는 메뉴 관리
  - Category
    - List<String> 카테고리 관리

## 패키지별 기능 구현

- Domain
  - 위에 정리
- Domain - Menu
  - 주어진 메뉴 Enum 관리
- Controller
  - 실행 관리
- View
  - OutputView
    - 출력 관리
  - InputView
    - 입력관리
- Exception
  - InputException
    - 입력 예외처리
