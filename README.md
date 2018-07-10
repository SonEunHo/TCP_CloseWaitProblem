http://tech.kakao.com/2016/04/21/closewait-timewait/

server와 client를 연결하면 서버는 바로 로직 상 close되고, client는 무한정 sleep하게 된다.
커널단에서는 close를 어플리케이션에게 요청하고 대기하는 CLOSE_WAIT 상태가 되고 time out 없이 커넥션을 물고 있게 된다.

netstat -p tcp -n |grep CLOSE_WAIT 명령어로 아래와 같이 확인된다.

tcp4       0      0  127.0.0.1.50937        127.0.0.1.8383         CLOSE_WAIT

이번에 알게된 점은 CLOSE_WAIT이 기다리는 close는 명시적으로 어플리케이션이 명시적으로 close를 호출하거나, 어플리케이션이 종료되어야만 받을 수 있다.
따라서 이러한 CLOSE_WAIT 상태에서 무한정 기다리게되면, 자원낭비가 우려되며 종료하는 방법은 Application의 close호출 혹은 강제종료 뿐이다.
