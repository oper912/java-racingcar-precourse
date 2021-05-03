# 자동차 경주 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 프로그래밍 요구사항
### 메소드 분리
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    - https://naver.github.io/hackday-conventions-java/
- indent(인덴트,들여쓰기) depth를 2가 넘지 않도록 구현한다. 1까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트:indent(인덴트,들여쓰기) depth를 줄이는 좋은 방법은 함수(또는메소드)를 분리하면 된다.
- 자바8에 추가된 stream api를 사용하지 않고 구현해야 한다. 단, 람다는 사용 가능하다.
- else 예약어를 쓰지 않는다.
    - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
    - else를 쓰지말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
- 함수(또는메소드)의 길이가 10라인을 넘어가지 않도록 구현한다.
    - 함수(또는메소드)가 한 가지 일만 잘 하도록 구현한다.
    
### 2주차 추가
- 일급콜렉션을 활용해 구현한다.
    - 참고문서 : https://developerfarm.wordpress.com/2012/02/01/object_calisthenics_/
- 모든 원시값과 문자열을 포장한다.
    - 참고문서 : https://developerfarm.wordpress.com/2012/01/27/object_calisthenics_4/

### 단위 테스트
- 로직에 단위 테스트를 구현한다. 단, UI(System.out,System.in,Scanner)로직은 제외
    - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
- JUnit5와 AssertJ 사용법에 익숙하지 않은 개발자는 첨부한 "학습테스트를 통해 JUnit학습하기.pdf" 문서를 참고해
  사용법을 익힌 후 JUnit5 기반 단위 테스트를 구현한다.

## 과제 진행 요구사항
- 미션은 https://github.com/next-step/java-racingcar-precourse 저장소를 fork/clone해 시작한다.
- 기능을 구현하기 전에 java-racingcar-precourse/README.md 파일에 구현할 기능 목록을 정리해 추가한다.
- git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.
    - [AngularJS Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 참고해 commit log를 남긴다.
- 과제 진행 및 제출 방법은 [프리코스 과제 제출](https://github.com/next-step/nextstep-docs/tree/master/precourse) 문서를 참고한다.

## 기능 요구사항
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이의 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3이하의 값이면 멈춘다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

## 기능 목록
- 자동차 이름 입력
    - 쉼표(,) 기준으로 구분
    - 5자 초과 예외 처리
- 시도 횟수 입력
    - 최소값 1, 음수 또는 0 일경우 예외 처리
- 자동차 전진
    - 0 ~ 9 사이 난수 생성
    - 4 이상일 경우 전진 판단
- 실행 결과 출력
    - 회수마다 자동차별 전진 상태 출력
- 우승자 출력
    - 가장 많이 이동한 자동차 이름 출력
    - 다중 우승 가능

## 구조 비교
### 구현 전 예상 구조 
- controller
    - RacingcarController
- domain
    - Car
    - Cars
    - MoveCount
    - Name
    - Position
- strategy
    - MovableStrategy
    - RandomMovableStrategy
- utils
    - StringUtils
- view
    - InputView
    - ResultView

### 구현 후 구조 
- controller
    - RacingCarController
- domain
    - Car
    - Cars
    - Name
    - Position
    - RaceCount
    - RacingGame
    - Winners
- exception
    - CarNameValidationException
    - InvalidRaceCountException
- strategy
    - MoveableStrategy
    - RandomMoveableStrategy
- utils
    - StringUtils
- view
    - InputView
    - ResultView

## 역할
- Car
    - 경주를 하는 자동차
    - 전진 여부 판단
- Name
    - 자동차의 이름
    - 이름이 유효한 이름인지 검사
- Position
    - 자동차의 위치
    - 전진시 위치값 증가
- Cars
    - 자동차의 일급 컬렉션
    - 전체 자동차의 이동 관리
- RaceCount
    - 경주할 횟수
    - 경주시마다 count 차감
    - 경주 가능 여부 판단 
- RacingGame
    - 레이싱 게임 전체 관리 
- Winners
    - 우승 자동차 일급 컬렉션
    - 우승자 배정