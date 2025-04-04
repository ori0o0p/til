```text
GET : /api/test/1234

GET : /api/test/qwer
```
Path Param으로 API Path 구분하는 방법.?
```java
@GetMapping("/api/test/{value}")
Integer getInt(@PathVariable Integer value) {
		return 500;
}

@GetMapping("/api/test/{value}")
String getString(@PathVariable String value) {
		return "오마이갓~~!!";
}
```
위와 같이 구현하면 스프링 수준에서는 동일한 Path로 인식하게 되어 충돌이 발생한다.

```java
@GetMapping("/api/test/{value:[\\d]+}")
Integer getInt(@PathVariable Integer value) {
		return 500;
}

@GetMapping("/api/test/{value:[\\w]+}")
String getString(@PathVariable String value) {
		return "오마이갓~~!!";
}
```
위와 같이 Path Param을 경로 매핑 수준에서 정규표현식으로 구분을 할 수 있다!

위와 같이 의도한대로 구현을 할 수 있다.
