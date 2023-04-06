
## 외부 라이브러리 및 오픈소스
- Lombok
  - 어노테이션 기반의 코드 자동 생성을 통한 생산성 향상

- QueryDSL
  - 문자가 아닌 코드로 쿼리를 작성함으로써, 컴파일 시점에 문법 오류를 쉽게 확인

- AssertJ
  - 메소드 체이닝을 통한 좀 더 깔끔하고 읽기 쉬운 테스트 코드를 작성


## REST API 명세서

### * VOC API
  - GET - /voc  (VOC 목록 조회)
  - POST - /voc  (VOC 등록)
  - PATCH - /voc  (이의제기 여부 등록)


### * Compensation API
- GET - /comp  (보상 정보 조회)
- POST - /comp  (보상 정보 등록)


### * Penalty API
- POST - /pen  (패널티 등록)
- PATCH - /pen  (패널티 확인 여부 등록)

     