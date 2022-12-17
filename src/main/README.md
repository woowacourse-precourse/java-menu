## 기능 목록
### domain
 - [x] 코치 이름을 입력받아 코치 객체 생성해 레파지토리에 저장하기. - CoachGenerator
 - [x] 못먹는 음식을 받아 못먹는 음식 객체에 넣기 - ForbiddenMenu
 - [x] 요일별로 카테고리 정해서 저장하기 - CategoryDecider
   - [x] 동일 카테고리는 2회 이상 불가
 - [x] 카테고리에 맞는 메뉴 전달해주기 - MenuGiver
 - [x] 못먹는 음식 객체는 카테고리를 받아 메뉴 리스트 전달 - ForbiddenMenu
 - [x] 메뉴리스트를 코치 객체가 받아 이미 선택한 메뉴 제외하기 - Coach
 - [x] 최종 메뉴 리스트로 랜덤 선택해 코치 객체에 저장 - Coach
 - [x] 메뉴 추천 결과 메세지 전달 - Coach
### view
 - [x] 시작 메세지 ("점심 메뉴 추천을 시작합니다.") - InputView
 - [x] 코치 이름 입력 ("코치의 이름을 입력해 주세요. (, 로 구분)") - InputView
 - [x] 각 코치별 못 먹는 메뉴 입력 ("(이)가 못 먹는 메뉴를 입력해 주세요.") - InputView
 - [x] 최종 메뉴 추천 결과 출력 - OutputView
### controller
 - [x] 코치 이름 입력값으로 코치 객체 생성해 레파지토리 저장하기 - MenuController
 - [x] 코치마다 못먹는 음식 받아 ForbiddenMenu 객체에 저장하기 - MenuController
 - [x] 메뉴 리스트를 전달해 각 코치가 메뉴 선택하도록 컨트롤하기 - CoachController
 - [x] 매 요일마다 카테고리를 선정하고, 각 코치 메뉴 선택하기  - MenuController
 - [x] 최종 결과물 출력하기  - MenuController