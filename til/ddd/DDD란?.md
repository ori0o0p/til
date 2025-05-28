# Domain Driven Design
DDD는 **도메인 주도 설계**로 비즈니스 본질을 소프트웨어의 코드에 담아내도록 설계하는 방법론이다.

내가 생각하는 DDD의 주된 목표는 아래와 같다. 
- 소프트웨어 개발의 복잡도를 낮추는 것.
  - 복잡한 비즈니스 로직을 단순화하는 것.
  - 협업을 더욱 강하게 하는 것.
- 비즈니스 가치를 이해하며 구현하는 것.
  - 단순 코딩이 아닌, 비즈니스 도메인을 이해하는 것.

DDD의 핵심은 [Strategic Design, Tactical Design](Strategic%EA%B3%BC%20Tactical%20Design%EC%9D%98%20%EC%B0%A8%EC%9D%B4.md)이 아니다. 그저 표면적인 개념의 접근일뿐 <br/> 
핵심은 Model이다. Model은 끊임없이 변하는 비즈니스의 복잡성을 모델링하여 추상화한 결과이다.

DDD에서는 Model을 만들기 위한 모델링의 방법을 [Strategic Design, Tactical Design](Strategic%EA%B3%BC%20Tactical%20Design%EC%9D%98%20%EC%B0%A8%EC%9D%B4.md)으로 나누는데,
DDD에서 Model이 핵심인 이유이다. Entity, Value Object, Aggregate이런 개념은 전부 모델링을 위한 개념이다.

DDD를 적용했을 때의 이점은 아래와 같다.
- 확장 가능성. MSA로 애플리케이션을 분리할 때 Context Map, Bounded Context가 MSA의 나침반이 될 수 있다.
- 비즈니스 이해. SRS만 보고 단순 코딩을 하는 것이 아닌, 비즈니스를 이해하고 개발을 하여 가치를 빠르게 실현할 수 있다.
- 문서화. Bounded Context, Ubiquitous Language 등은 팀 전체가 공유하며 살아있는 문서로 관리해야한다. 

DDD를 적용할 때는 모든 이론을 전부 적용하는 것이 아닌, 명확한 이유를 갖고 부분적으로 적용해야한다.
DDD는 모든 상황에서의 해결책이 아니고 항상 오버 엔지니어링을 피해야한다. <br/>
DDD 이외의 비즈니스 가치를 더 나은 방식으로 구체화하는 방식이 있다면, 그 방식을 추구하는 것도 좋다.

특정 기술을 추구하는 것이 아닌 문제의 본질에 대한 해결을 추구해야한다.