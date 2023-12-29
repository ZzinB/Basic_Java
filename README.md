# 1. Car Sharing Manager

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


-----
# 2. TodoListApp
