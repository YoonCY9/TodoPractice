할일타이틀


할일타이틀안의할일을

예시)

오늘할일

-양치질
-세수하기

내일할일
-저녁먹기

넣는거 까진 구현

ToDo 목록조회하면
모든 할일의 목록이 조회됨(양치질,세수하기,저녁먹기)

오늘할일을 조회하면 (양치질,세수하기)만 나오게 구현해야함)

오늘할일의 id값과 일치하는 할일만 조회되도록 구현

1. Post http://localhost:8080/lists
2. {"title" : "오늘할일"}
3. {"title" : "내일할일"}
4. Post http://localhost:8080/titles
5. {  "listId" : 1,
   "title" : "점심먹기"}
6. {  "listId" : 1,
   "title" : "저녁먹기"}

리스트 목록 조회 시 할 일 개수 함께 전달하기
GET ("lists/{id}")
   
