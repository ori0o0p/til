## Try-Catch 구문을 추가했을 때 성능에 미치는 영향
성능을 확인하기 위해 바이트 코드를 확인한다.

try-catch 없이:
```java
public class SeungwonService {

    public String execute(String name) {
        return innerHandle(name);
    }

    private String innerHandle(String name) {
        return null;
    }

}
```

```java
public java.lang.String execute(java.lang.String);
    Code:
       0: aload_0
       1: aload_1
       2: invokevirtual #7                  // Method innerHandle:(Ljava/lang/String;)Ljava/lang/String;
       5: areturn
```

try-catch 추가:
```java
public class SeungwonService {

    public String execute(String name) {
        try {
            return innerHandle(name);
        } catch (Exception e) {
            return "e";
        }
    }

    private String innerHandle(String name) {
        return null;
    }

}
```

```java
public java.lang.String execute(java.lang.String);
    Code:
       0: aload_0
       1: aload_1
       2: invokevirtual #7                  // Method innerHandle:(Ljava/lang/String;)Ljava/lang/String;
       5: areturn
       6: astore_2
       7: ldc           #15                 // String e
       9: areturn
    Exception table:
       from    to  target type
           0     5     6   Class java/lang/Exception

```

이렇게 바이트 코드를 확인했을 때 많은 과정이 추가되었다. 그런데 많은 과정이 추가됐다고 해서 성능에 영향을 미치게 될까?
정답은 미칠 수도 있고 아닐 수도 있다.

왜냐하면 바이트 코드에서 Exception이 발생하지 않을 시에 0 ~ 5 단계만 실행한다고 적혀있다. 
해당 과정은 try-catch를 추가하지 않은 과정과 동일하기 떄문에 성능에 영향을 미치지 않는다.

하지만, Exception이 발생했을 때는 어떻까?
당연히 성능 차이가 존재한다. 실행 깊이가 더 깊어지고, 객체 생성 비용이 발생하게된다.

---

바이트 코드를 확인하기 위한 명령어:
```shell
javac SeungwonService.java

javac -c SeungwonService.class
```