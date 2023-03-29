# Car Sharing Manager

김동준, 이신비  

- version : 1.0.0  
- Development Environment : 

--- 
### 프로젝트 설명 
need description  

### 사용법  
Room List Page(HomePage)에서, 방을 만들고, 그 방에 들어갈 수 있다.  

### 개선할 점
한 user가 하나의 방에만 배정됨.(따로 처리를 해주지 않음)  
추후, version upgrade가 되면서, user에 대한 정보를 배열로 가지거나 알고리즘을 변경할 필요가 있음.  

### DB Schema 
수정중  

### 로직
In Detail Page, GET METHOD로 받은, uid, room_num으로  
roomVO, userVO 객체를 생성. (**getUser**, **getRoom**)  
그리고 count와 master을 비교하여 덧셈 뺄셈을 해줌.  

---  

#### History

```
2021-12-7  
레파지토리 생성, 프로젝트 시작  
```
```
2021-12-10  
로그인 기능 구현, 로그인 페이지 완료.  
```
```
2021-12-11  
회원정보수정 페이지 구현 완료.  
방만들기 페이지 구현 완료.  
방만들기 기능 구현 완료(room_master 지정 가능).  
방리스트 페이지 제작중...  
회원가입 페이지 구현 완료.  
로그아웃 기능 추가.  
dj branch 하나 더 팜.  
```
```
2021-12-12  
count_update 로직 완료.  
인원 최대 4명 제한 기능 구현 완료.  
detail page 제작중...(아직 view 연결안함 + list 부르는 부분 구현 안함)  
방 만들기 로직 변경.(한 사람이 한 방에만 속할 수 있게끔)  
```
```  
2021-12-13  
detail page 제작 완료.  
방장 추방 권한 설정.  
추방 로직 구현 완료.   
black_list 값 증가 로직 구현 완료.  
payment 로직 추가 완료.  
모든 페이지 구현 완료.  
css 스타일 적용(협업) + merge to master branch   
- login page 적용 완료  
- register page 적용 완료  
- room_list page 적용 완료  
```  