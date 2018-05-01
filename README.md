# FirebasePushWebserver
Android에서 Firebase의 push를 서버로 받기

### 1. Prerequisites

- Eclipse IDE for Java EE Developers

### 2. Installation Process

- Eclipse IDE for Java EE Developers 다운
- Firebase에 프로젝트를 만들고 생성된 서버 키를 Java에 참조
  - Pushserver.java
    ```Java
      con.setRequestProperty("Authorization", "Firebase 서버 키");
    ```
- Server 주소 입력
  - Pushserver.java
  - 서버주소는 가림
    ```Java
      String url = ""; 
    ```
- Push 보낼 내용 입력
  - Pushserver.java
    ```Java
      String parameters =  "{\"data\" : {\"title\" : \"여기다 제목 넣기 \", \"body\" : \"여기다 내용 넣기\"}, \"to\":\"/topics/noticeMsg\"}";
    ```
    
### 3. Getting Started
 
 - 서버주소와 보낼 내용 그리고 Firebase 서버키를 입력 후 실행을 누르면 연결된 앱에 Push가 보내지게 된다.
 
### 4. Copyright / End User License
 
- 배희주 010-4736-9516

### 5. Change Log
 
- 2018-05-02 기록을위해 커밋
