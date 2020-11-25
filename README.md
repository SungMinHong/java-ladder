# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

## 사다리 게임 이해하기
* 사다리 게임의 원리는 카드 바꾸기와 동일하다.
    * n명이 서로 카드를 아무리 바꾸더라도 마지막에는 결국 모두 1장의 카드를 가진다.
* 옆 사다리로 이동하는 경우는 카드를 바꾸는 행동과 동일하다.
* 마지막 단계에 도착했을 때 결국 모두 하나의 사다리에 위치하고 있는 것이다.

## 기능 정의
### 사다리 생성
* 사다리 게임 참여자의 이름을 최대 5글자까지 부여할 수 있다. 
    * "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)" 안내 문구를 출력한다.
    * 사용자로 부터 문자열로 이름을 입력 받는다.
    * 사람 이름은 쉼표(,)를 기준으로 구분한다.
* 사다리의 높이를 정할 수 있다.
    * "최대 사다리 높이는 몇 개인가요?" 안내 문구를 출력한다.
    * 사용자로 부터 사다리의 높이를 입력 받는다.
* 사다리를 출력할 수 있다.
    * '|' : 높이 문자(세로)
    * '-' : 폭 문자(가로)
    * 사다리를 출력할 때 사람 이름도 같이 출력한다.
        * 이름은 가장 위에 출력하며 5글자 기준으로 오른쪽 부터 채우며 출력한다.
    * 사다리를 그린다. 
        * 처음에 4개의 공백 이후  '|' 문자를 출력한다.
        * '|' 문자 이후 다음 세로 라인의 사다리가 있는 경우 '-' 문자를 5번 출력한다.
* 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
    * 즉 동일한 높이에서 양쪽으로 폭이 있으면 안된다.
    * ex: '-----|-----'
    
## Top Down 1차 설계
* 사다리 게임
    * 알아야 하는 것
        * 높이개 만큼은 사다리라인 전체
    * 담당 해야할 행동
        * 모든 사다리 초기화
        * 사다리 정보 반환
        * 참여자 반환
* 참여자
    * 알아야 하는 것
        * 자신의 이름
* 사다리 선
    * 알아야 하는 것
        * 사다리의 각 point 리스트
    * 담당 해야할 행동 
        * 모든 point를 초기화
        * 라인의 좌표 값에 선 유무를 판단
* Point(지점)
    * 알아야 하는 것
        * 왼쪽 라인 여부
        * 오른쪽 라인 여부
        * 좌표 값
    * 담당 해야할 행동
        * 다음 Point 생성
* inputView
    * 담당 해야할 행동
        * 사용자 입력 받기
* outputView
    * 담당 해야할 행동
        * 사용자 출력
        * 사다리 출력
* 도메인 이해도가 낮으니 여기까지 TDD로 진행하고 다시 Bottom up으로 리펙토링
