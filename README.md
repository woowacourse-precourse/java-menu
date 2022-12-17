# 미션 - 점심 메뉴 추천

## 기능 목록
- [ ] 카테고리를 무작위로 정한다.
  - [ ] 특정 카테고리들을 제외한다.
- [ ] 카테고리의 음식들을 무작위로 정한다.
  - [ ] 특정 음식들을 제외한다.
- [ ] 한 주 메뉴를 추천한다.
  - [ ] 어떤 카테고리를 몇 회 먹는지 알 수 있다.
    - [ ] 어떤 카테고리를 2회까지만 먹을 수 있다.
  - [ ] 한 주 안에 같은 메뉴를 먹으면 안된다.
  - [ ] 코치가 먹지 못하는 음식을 제외하고 추천한다.
- [x] 숫자로 카테고리를 알 수 있다.
- [ ] 코치의 음식을 초기화 할 수 있다.
- [x] 어떤 카테고리의 음식들을 알 수 있다.
  - [x] 문자열으로 준비한다.
- [ ] 음식의 카테고리를 알 수 있다.

## 🔍 진행 방식

- 미션은 **기능 요구 사항, 프로그래밍 요구 사항, 과제 진행 요구 사항** 세 가지로 구성되어 있다.
- 세 개의 요구 사항을 만족하기 위해 노력한다. 특히 기능을 구현하기 전에 기능 목록을 만들고, 기능 단위로 커밋 하는 방식으로 진행한다.
- 기능 요구 사항에 기재되지 않은 내용은 스스로 판단하여 구현한다.

## 📮 미션 제출 방법

- 미션 구현을 완료한 후 GitHub을 통해 제출해야 한다.
  - GitHub을 활용한 제출
    방법은 [프리코스 과제 제출](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse) 문서를 참고해
    제출한다.
- GitHub에 미션을 제출한 후 [우아한테크코스 지원](https://apply.techcourse.co.kr) 사이트에 접속하여 프리코스 과제를 제출한다.
  - 자세한 방법은 [제출 가이드](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse#제출-가이드)
    참고
  - **Pull Request만 보내고 지원 플랫폼에서 과제를 제출하지 않으면 최종 제출하지 않은 것으로 처리되니 주의한다.**

## 🚨 과제 제출 전 체크 리스트 - 0점 방지

- 기능 구현을 모두 정상적으로 했더라도 **요구 사항에 명시된 출력값 형식을 지키지 않을 경우 0점으로 처리**한다.
- 기능 구현을 완료한 뒤 아래 가이드에 따라 테스트를 실행했을 때 모든 테스트가 성공하는지 확인한다.
- **테스트가 실패할 경우 0점으로 처리**되므로, 반드시 확인 후 제출한다.

### 테스트 실행 가이드

- 터미널에서 `java -version`을 실행하여 Java 버전이 11인지 확인한다. 또는 Eclipse 또는 IntelliJ IDEA와 같은 IDE에서 Java 11로
  실행되는지 확인한다.
- 터미널에서 Mac 또는 Linux 사용자의 경우 `./gradlew clean test` 명령을 실행하고,   
  Windows 사용자의 경우  `gradlew.bat clean test` 명령을 실행할 때 모든 테스트가 아래와 같이 통과하는지 확인한다.

```
BUILD SUCCESSFUL in 0s
```

---

## 🚀 기능 요구 사항

한 주의 점심 메뉴를 추천해 주는 서비스다.

- 코치들은 월, 화, 수, 목, 금요일에 점심 식사를 같이 한다.
- 메뉴를 추천하는 과정은 아래와 같이 이뤄진다.
  1. 월요일에 추천할 카테고리를 무작위로 정한다.
  2. 각 코치가 월요일에 먹을 메뉴를 추천한다.
  3. 화, 수, 목, 금요일에 대해 i, ii 과정을 반복한다.
- 코치의 이름은 최소 2글자, 최대 4글자이다.
- 코치는 최소 2명, 최대 5명까지 식사를 함께 한다.
- 각 코치는 최소 0개, 최대 2개의 못 먹는 메뉴가 있다. (`,` 로 구분해서 입력한다.)
  - 먹지 못하는 메뉴가 없으면 빈 값을 입력한다.
  - 추천을 못하는 경우는 발생하지 않으니 고려하지 않아도 된다.
- 한 주에 같은 카테고리는 최대 2회까지만 고를 수 있다.
- 각 코치에게 한 주에 중복되지 않는 메뉴를 추천해야 한다.
  - 예시)
    - 구구: 비빔밥, 김치찌개, 쌈밥, 규동, 우동 → 한식을 3회 먹으므로 불가능
    - 토미: 비빔밥, 비빔밥, 규동, 우동, 볶음면 → 한 코치가 같은 메뉴를 먹으므로 불가능
    - 제임스: 비빔밥, 김치찌개, 스시, 가츠동, 짜장면 → 매일 다른 메뉴를 먹으므로 가능
    - 포코: 비빔밥, 김치찌개, 스시, 가츠동, 짜장면 → 제임스와 메뉴가 같지만, 포코는 매번 다른 메뉴를 먹으므로 가능
- 메뉴 추천을 완료하면 프로그램이 종료된다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시
  받는다.
  - `Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리한다.

### 입출력 요구 사항

#### 입력

- 메뉴 추천을 받을 코치의 이름을 입력받는다. 올바른 값이 아니면 예외 처리한다.

```
토미,제임스,포코
```

- 각 코치가 못 먹는 메뉴를 입력받는다.

```
우동,스시
```

#### 출력

- 서비스 시작 문구

```
점심 메뉴 추천을 시작합니다.
```

- 서비스 종료 문구

```
메뉴 추천 결과입니다.
[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]
[ 카테고리 | 한식 | 한식 | 일식 | 중식 | 아시안 ]
[ 토미 | 쌈밥 | 김치찌개 | 미소시루 | 짜장면 | 팟타이 ]
[ 제임스 | 된장찌개 | 비빔밥 | 가츠동 | 토마토 달걀볶음 | 파인애플 볶음밥 ]
[ 포코 | 된장찌개 | 불고기 | 하이라이스 | 탕수육 | 나시고렝 ]

추천을 완료했습니다.
```

- 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.

```
[ERROR] 코치는 최소 2명 이상 입력해야 합니다.
```

#### 실행 결과 예시

```
점심 메뉴 추천을 시작합니다.

코치의 이름을 입력해 주세요. (, 로 구분)
토미,제임스,포코

토미(이)가 못 먹는 메뉴를 입력해 주세요.
우동,스시

제임스(이)가 못 먹는 메뉴를 입력해 주세요.
뇨끼,월남쌈

포코(이)가 못 먹는 메뉴를 입력해 주세요.
마파두부,고추잡채

메뉴 추천 결과입니다.
[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]
[ 카테고리 | 한식 | 한식 | 일식 | 중식 | 아시안 ]
[ 토미 | 쌈밥 | 김치찌개 | 미소시루 | 짜장면 | 팟타이 ]
[ 제임스 | 된장찌개 | 비빔밥 | 가츠동 | 토마토 달걀볶음 | 파인애플 볶음밥 ]
[ 포코 | 된장찌개 | 불고기 | 하이라이스 | 탕수육 | 나시고렝 ]

추천을 완료했습니다.
```

---

## 🎯 프로그래밍 요구 사항

- JDK 11 버전에서 실행 가능해야 한다. **JDK 11에서 정상적으로 동작하지 않을 경우 0점 처리한다.**
- 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- `build.gradle` 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
- [Java 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java) 가이드를
  준수하며 프로그래밍한다.
- 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- 프로그램 구현이 완료되면 `ApplicationTest`의 모든 테스트가 성공해야 한다. **테스트가 실패할 경우 0점 처리한다.**
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
  - 함수(또는 메서드)가 한 가지 일만 잘하도록 구현한다.
- else 예약어를 쓰지 않는다.
  - 힌트: if 조건절에서 값을 return 하는 방식으로 구현하면 else를 사용하지 않아도 된다.
  - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.

### 카테고리와 메뉴 요구 사항

- 메뉴 추천 서비스에서 추천할 수 있는 카테고리와 각 카테고리의 메뉴는 아래와 같다.

```
일식: 규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼
한식: 김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음
중식: 깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채
아시안: 팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜
양식: 라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니
```

#### 카테고리

- 추천할
  카테고리는 [`camp.nextstep.edu.missionutils`](https://github.com/woowacourse-projects/mission-utils)에서
  제공하는 `Randoms.pickNumberInRange()`에서 생성해 준 값을 이용하여 정해야 한다.

```java
// 예시 코드. 사용하는 자료 구조에 따라 난수를 적절하게 가공해도 된다.
String category = categories.get(Randoms.pickNumberInRange(1, 5));
```

- 임의로 카테고리의 순서 또는 데이터를 변경하면 안 된다.
  - `Randoms.pickNumberInRange()`의 결과가 **1이면 일식, 2면 한식, 3이면 중식, 4면 아시안, 5면 양식**을 추천해야 한다.
- 추천할 수 없는 카테고리인 경우 다시 `Randoms.pickNumberInRange()`를 통해 임의의 값을 생성해서 추천할 카테고리를 정해야 한다.

#### 메뉴

- 추천할 메뉴는 정해진 카테고리에 있는
  메뉴를 [`camp.nextstep.edu.missionutils`](https://github.com/woowacourse-projects/mission-utils)에서
  제공하는 `Randoms.shuffle()`을 통해 임의의 순서로 섞은 후, 첫 번째 값을 사용해야 한다.
  - 카테고리에 포함되는 메뉴 목록을 `List<String>` 형태로 준비한다.

```java
String menu = Randoms.shuffle(menus).get(0);
```

- 임의로 메뉴의 순서 또는 데이터를 변경하면 안 된다.
  - `Randoms.shuffle()` 메서드의 인자로 전달되는 메뉴 데이터는, 최초에 제공한 목록을 그대로 전달해야 한다.
    - 코치에게 추천할 메뉴를 정할 때 이미 추천한 메뉴, 먹지 못하는 메뉴도 포함된 리스트를 전달해야 한다.
- 추천할 수 없는 메뉴인 경우 다시 섞은 후 첫 번째 값을 사용해야 한다.

---

## ✏️ 과제 진행 요구 사항

- 미션은 [java-menu](https://github.com/woowacourse-precourse/java-menu) 저장소를 Fork & Clone해 시작한다.
- **기능을 구현하기 전 `docs/README.md`에 구현할 기능 목록을 정리**해 추가한다.
- **Git의 커밋 단위는 앞 단계에서 `docs/README.md`에 정리한 기능 목록 단위**로 추가한다.
  - [커밋 메시지 컨벤션](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 가이드를 참고해 커밋 메시지를 작성한다.
- 과제 진행 및 제출 방법은 [프리코스 과제 제출](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse)
  문서를 참고한다.
  - 소감은 간소하게 입력해도 된다. 예를 들어, "."만 입력해도 좋다.
