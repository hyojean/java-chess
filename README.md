# [요구사항 정리]
<br>

## 기능 요구사항

### 1단계 - 체스판 초기화   
- 콘솔 UI에서 체스 게임을 할 수 있는 기능을 구현한다.
- 1단계는 체스 게임을 할 수 있는 체스판을 초기화한다.
- 체스판에서 말의 위치 값은 가로 위치는 왼쪽부터 a ~ h이고,
  세로는 아래부터 위로 1 ~ 8로 구현한다.
- 체스판에서 각 진영은 검은색 (대문자)과 흰색(소문자) 편으로 구분한다.
<br>

### 2단계 - 말 이동
- 콘솔 UI에서 체스 게임을 할 수 있는 기능을 구현한다.
- 체스 말의 이동 규칙을 찾아보고 체스 말이 이동할 수 있도록 구현한다.
- move source 위치 target 위치를 실행해 이동한다.
- 체스판의 위치 값은 가로 위치는 왼쪽부터 a ~ h이고, 세로는 아래부터 위로 1 ~ 8로 구현한다.
<br>

### 3단계 - 승패 및 점수
- 체스 게임은 상대편 King이 잡히는 경우 게임에서 진다.
- King이 잡혔을 때 게임을 종료해야 한다.
- 체스 게임은 현재 남아 있는 말에 대한 점수를 구할 수 있어야 한다.
- "status" 명령을 입력하면 각 진영의 점수를 출력하고 어느 진영이 이겼는지 결과를 볼 수 있어야 한다.

&nbsp; **점수 계산 규칙**
- 체스 프로그램에서 현재까지 남아 있는 말에 따라 점수를 계산할 수 있어야 한다.
- 각 말의 점수는 queen은 9점, rook은 5점, bishop은 3점, knight는 2.5점이다.
- pawn의 기본 점수는 1점이다.
- 하지만 같은 세로줄에 같은 색의 폰이 있는 경우 1점이 아닌 0.5점을 준다.
- king은 잡히는 경우 경기가 끝나기 때문에 점수가 없다.
- 한 번에 한 쪽의 점수만을 계산해야 한다.
<br>

### 4단계 - DB 적용
&nbsp; **필수 사항**
- 애플리케이션을 재시작하더라도 이전에 하던 체스 게임을 다시 시작할 수 있어야 한다.
- DB를 적용할 때 도메인 객체의 변경을 최소화해야 한다.

&nbsp; **선택 사항**
- 체스 게임방을 만들고 체스 게임방에 입장할 수 있는 기능을 추가한다.
- 사용자별로 체스 게임 기록을 관리할 수 있다.
<br>

## 프로그래밍 요구사항
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    - 기본적으로 Java Style Guide를 원칙으로 한다.
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다.
- 3항 연산자를 쓰지 않는다.
- else 예약어를 쓰지 않는다.
- 모든 기능을 TDD 로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
    - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
    - UI 로직을 InputView, ResultView 와 같은 클래스를 추가해 분리한다.
- 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다.
    - 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- 배열 대신 컬렉션을 사용한다.
- 모든 원시값과 문자열을 포장한다.
- 줄여쓰지 않는다(축약 금지).
- 일급 컬렉션을 쓴다.
- 모든 엔티티를 작게 유지한다.
- 3개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.

- 도메인의 의존성을 최소한으로 구현한다.
- 한 줄에 점을 하나만 찍는다.
- 게터/세터/프로퍼티를 쓰지 않는다.
- 모든 객체지향 생활 체조 원칙을 잘 지키며 구현한다.
- 프로그래밍 체크리스트의 원칙을 지키면서 프로그래밍 한다.
