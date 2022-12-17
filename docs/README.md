# 기능 목록
## domain
- [x] Category
    - [x] 필드, 생성자, getter 생성
    - [x] 음식 추가 기능
    - [x] 해당 음식을 가지고 있는지 확인 기능
- [ ] Coach
    - [x] 필드, 생성자, getter 생성
    - [x] 못 먹는 음식 추가 기능
    - [ ] 이름 글자 validate
    - [x] 먹을 수 있는 음식인지 체크 기능
    - [x] 요일 별 추천음식 필드 추가
    - [x] 음식이 추천 리스트에 있는지 확인 기능
    - [x] 추천받은 음식 조회 기능

## repository
- [x] foodRepository
    - [x] 필드, 생성자 
    - [x] 등록된 음식인지 조회
- [x] categoryRepository
    - [x] 필드, 생성자
    - [x] 등록된 카테고리인지 조회
    - [x] 카테고리 이름들 조회
    - [x] 특정 카테고리 조회 기능
- [x] coachRepository
    - [x] 필드, 생성자
    - [x] 저장 가능한 코치의 숫자인지 확인 기능
    - [x] 등록된 코치인지 조회
    - [x] 코치 이름 리스트 출력

## service
- [x] CategoryService
    - [x] 랜덤 카테고리 뽑는 기능
    - [x] 특정 카테고리에서 음식을 뽑는 기능
- [x] RecommendationService
    - [x] 생성자에서 요일별 카테고리 정하는 기능
    - [x] 코치에 맞는 추천리스트 생성
    - [x] 요일별 카테고리 리스트로 조회 기능

## view
- [x] 문구 생성
- [x] InputView
    - [x] 문자열 리스트를 읽는 기능
- [x] OutputView
    - [x] 문구 출력 기능
    - [x] 메뉴 추천 결과 출력 기능

## MainController
- [x] 시작 기능
    - [x] 시작 문구 출력
- [x] 코치 등록 기능
- [x] 못 먹는 메뉴 등록 기능
- [x] 메뉴 추천 기능
- [x] 추천 결과 출력 기능
- [x] 종료 기능




