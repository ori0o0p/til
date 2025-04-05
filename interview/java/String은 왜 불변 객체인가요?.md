<h1>
String은 보안, 스레드 안정성, 성능 때문에 불변 객체로 설계되었습니다. <br/>
제임스 고슬링의 인터뷰에서 보안 검사가 끝난 문자열을 조작하지 못하게 불변으로 설계했다는 내용을 본 적이 있습니다.<br/>
또한, 해시 코드를 사용하는 HashMap의 경우에 문자열이 수정되면 해시도 수정 되어야하는 문제도 막을 수 있습니다.<br/>
그리고, String이 불변 객체라면 String Pool을 사용할 수 있습니다. String이 불변이므로, 여러 변수가 같은 문자열을 참조해도 값이 변하지 않아 풀링을 할 수 있습니다.<br/>
만약 가변이라면, 두 객체가 서로 같은 문자열을 참조할때 한 객체의 변경이 다른 객체에 영향을 줄 수 있어 풀링이 불가능합니다.
</h1>

- 동기화 없이 Thread-safe
- 보안
- 성능 + 효율성(String Pool 설계 가능)

---
- [James Gosling의 Artima 인터뷰 (2001)](https://www.artima.com/intv/gosling313.html)
- [Java Language Specification (JLS)](https://docs.oracle.com/javase/specs/)