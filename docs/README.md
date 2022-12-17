# 기능 구현 목록

---

## 패키지별 기능 구현

- Domain
  - Crew
    - name, List<String> // 이름과 먹을 요리 관리
  - CrewList
    - List<Crew> crews
  - BannedFood
    - List<String> 못먹는 메뉴 관리
  - Category
    - List<String> 카테고리 관리
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

- util
- CategoryGenerator
  - 카테고리를 하나씩 생성해주는 유틸
- FoodsFiller
  - 음식을 카테고리에 맞게 채워주는 유틸
