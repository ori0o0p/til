## 스프링에서의 HTTP 응답 압축

```yaml
# Application.yml
server:
  compression:
    enabled: true
    mime-types: text/html, text/xml, application/json
    min-response-size: 1024
```

위의 설정을 활성화하면 Spring에서 HTTP 응답을 압축을 할 수 있다.

HTTP 응답 압축은 보통 해외에 API를 전송해야하는 상황 이거나, API 레이턴시를 줄여야할 때 사용할 수 있다.

현재 위의 코드에서 Text, JSON 파일만 압축하도록 설정한 이유는 미디어 파일은 기본적으로 압축되기 때문에 압축을 진행할 필요가 없다.

또한, 응답의 크기가 크지 않을 때에는 압축되지 않도록 Min value를 지정해줄 수 있다. 
현재 코드에서는 `min-response-size: 1024`로 지정해주고 있다.