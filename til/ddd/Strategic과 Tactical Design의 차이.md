# Strategic vs. Tactical Design
Strategic Design은 "무엇을" 해결할지에 중점을 두는 반면,
Tactical Design은 "어떻게" 해결할지에 초점을 맞춘다.

## Strategic Design
도메인 경계 식별과 비즈니스 가치 추출에 초점을 둔 설계이다.
한 시스템내의 비즈니스 가치를 별도의 Bounded Context로 분리하여 Customer-Supplier 관계로 협력하도록 설계하는 것이다.

"기능 단위로 무조건 쪼개는 것"이 아니다.

## Tactical Design
Aggregate, Domain Event과 같은 구현 패턴으로, 도메인 모델의 정교함을 설계한다.

Tactical Design을 과도하게 사용하면 Model Fragmentation과 같은 현상이 발생할 수 있다.
