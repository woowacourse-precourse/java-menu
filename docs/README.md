# 생각

한 주에 같은 카테고리는 최대 2번까지..

한 주에 중복되지 않는 메뉴만 가능

메뉴 추천을 입력받는다.. 일단 String.split 으로 쪼개면 될 것 같다.
그 후에 리스트화 시키고, 리스트의 크기(코치 몇명인지)가 2 ~ 5인지 확인하기.
코치 이름은 2~4글자니까 String 의 길이로 예외 처리.

Coach 클래스로 코치를 관리하자.
못먹는 메뉴 List<String> cantEat 에다가 메뉴를 저장해두기.

Category 클래스로 카테고리를 관리하자.
List<String> menu에다가 다 넣어놓기.

# 기능 구현 목록

## InputView (view)

- [x] 코치의 이름을 입력받기
  - [x] (예외) 코치는 2~5명, 코치의 이름은 2~4글자
- [x] 각 코치마다 못 먹는 메뉴 입력받기
  - [x] (예외) 못 먹는 메뉴는 0~2개
  - [x] (예외) 못 먹는 메뉴가 존재하지 않는 메뉴라면 예외

## OutputView (view)

- [x] 점심 메뉴 추천 시작 출력하기
- [x] 메뉴 추천 결과 출력하기
- [x] 추천 완료 출력하기

## Coach (domain)

- [x] 코치의 이름을 String 형의 필드로 가진다.
- [x] 코치가 못 먹는 메뉴를 List<String> 형의 필드로 가진다.
- [x] 코치가 먹을 메뉴를 List<String> 형의 필드로 가진다.
- [x] 정해진 카테고리에 대해서 코치에게 메뉴를 추천한다.
  - [x] 코치가 못 먹는 메뉴는 추천하면 안된다.
  - [x] 중복되는 메뉴를 추천하면 안된다.

## Coaches (domain)

- [x] 코치들을 List<Coach> 형의 필드로 가진다.

## Category (domain)

- [x] 카테고리 이름을 String 형의 필드로 가진다.
- [x] 메뉴들을 List<String> 형의 필드로 가진다.
- [x] 존재하는 메뉴인지 확인한다.

## Categories (domain)

- [x] 카테고리 종류들을 List<Categpory> 형의 필드로 가진다.
- [x] 랜덤으로 추천할 카테고리 5개를 반환한다.
  - [x] Randoms API 를 사용해야 한다.
  - [x] 같은 카테고리는 최대 2번까지만 고를 수 있다.
- [x] 모든 카테고리들의 메뉴 중에서 해당 메뉴가 존재하는지 확인한다.

## MenuController (controller)

- [x] 카테고리에 대한 정보들을 초기 설정한다.
- [x] 메뉴 추천 프로그램을 시작한다.

## StringParser (util)

- [x] 입력으로 들어오는 String 을 적절히 split 하여 리스트로 반환한다.

## InputViewConstants (constant)

- [x] InputView 에서 사용되는 상수를 관리한다.

## OutputViewConstants (constant)

- [x] OutputView 에서 사용되는 상수를 관리한다.

## ExceptionConstants (constant)

- [x] 예외 처리 시에 사용되는 상수를 관리한다.

## CategoryConstants (constant)

- [x] 카테고리와 메뉴에 대한 상수를 관리한다.