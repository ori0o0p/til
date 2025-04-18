## Spring Event

주로 클래스간의 느슨한 결합을 원할 때, 단일 책임 원칙을 강하게 적용하기 위해 사용된다.

### 예시

```
1. 유저가 회원가입을 진행한다.
2. 회원가입이 완료되면 유저에게 메일을 전송한다.
```

회원가입 서비스의 프로세스이다. 
‘유저가 회원가입을 하는 것.’ 
‘유저에게 메일을 보내는 것’ 이 두 동작은 책임의 주체도 다르고 만약 같은 클래스에서 모두 처리하면 단일 책임 원칙을 위반하게 된다.

그럼 당연히 별도의 클래스 ‘메일 전송 클래스’를 생성해서 처리를 한다.

하지만, ‘회원가입 클래스’에서 ‘메일 전송 클래스’를 강하게 의존하게 된다.

이게 무엇이 문제일까?

- 메일 전송 기능에서 회원가입 기능에 예외 전파 가능성이 존재한다.
- 메일 전송 기능이 이상하면 회원가입에 영향을 미친다.

이럴 경우에 이벤트라는 개념을 사용하는데,

```
1. 회원가입 완료시 회원가입 클래스에서 이벤트 발행
2. 메일 전송 클래스에서 이벤트 캐치 후 메일 전송
```

이런 프로세스로 동작하게 된다.

직접적으로 클래스를 의존해 메일을 전송했다면, 이젠 간접적으로 메일을 전송하는 것이다.

흔히 사람들이 말하는 느슨한 결합도를 얻게 되었다. 하지만, 이게 좋은걸까? 나는 잘 모르겠다.

이벤트 발행 패턴을 사용하게 되면 가독성도 안 좋아지고, 시스템 복잡도만 늘리는 게 아닐까?라는 고민이 있다.

## 어노테이션

@TransactionalEventListener

@EventListener