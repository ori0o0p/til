## Heap

JVM이 관리하는 메모리 영역 중 **가장 큰 공간**으로 `new` 키워드로 생성된 Instance, Array가 저장되는 공간이다.

**내부 구조**는 크게 **Young Generation, Old Generation**으로 나뉜다.

- **Young Generation**(이하 **YG**)

  **새롭게 생성된 객체들이 주로 할당**되는 영역으로 젊은 객체가 저장된다. 이 영역에서의 GC를 **Minor GC**라고 부른다.

  YG는 크게 **Eden, Survivor 0 / Survivor 1(From Space / To Space)** 영역으로 나뉜다.

    - **Eden**은 **객체가 최초로 할당되는 공간**으로 꽉 차면 Minor GC가 발생한다.
    - **Survivor**는 Eden 영역에서 **Minor GC 후 살아남은 객체들이 이동하는 공간**이다.
        - 두 개의 Survivor 영역 중 하나는 반드시 비어있어야하고,
          객체는 Survivor 영역(From/To)을 오가며 Age를 증가시킨다.

- **Old Generation**(이하 **OG**)

  **YG에서 특정 Age 이상 살아남은 객체들이 이동**하는 영역으로 늙은 객체가 저장된다.

  또는 **YG에서 할당하기에는 너무 큰 객체가 바로 할당**될 수도 있다.

  이 영역에서의 GC를 Major GC라고 부른다.

    - Major GC는 Heap Area 전체 또는 OG + Method Area에 발생한다.