<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
  <script src="http://localhost/boardpro/js/jquery-3.6.0.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
  
  
  <script src="../js/boardsearch.js"></script>

<style>
body{
	background : pink;
	padding : 20px;
}
.box{
	padding : 10px;
}
.card-header{
	background : lightblue;
	margin : 2px;
}
.card-header:hover{
	background : maroon;
}
.pagination{
	float : left;
}
#btngroup1{
	margin-left : 45%;
}
input[name=reply]{
	height: 55px;
	vertical-align: top;

}
nav{
	background : lightblue;
}
#stype{
	width : 100px; 
}
.rep{
	border : 1px solid gray;
	background : #ffd699;
	margin : 1px;
	padding : 3px;
}
.p1{
   width : 60%;
   float : left;   
   border : none;
}

.p2{
   width : 38%;
   float : left; 
   text-align: right;
   border : none;  
}

hr{
   clear : both;   
}

#modifyform{
	display : none;
}


</style>
<script>

reply = {};


$(function(){
	// js/boardserach.js에 구현
	listServer(1);
	
	
	// 이벤트
	// 수정, 삭제, 등록, 댓글 등록, 댓글 수정, 댓글 삭제, 제목(list)버튼에 대한 이벤트
	
	$(".box").on("click", ".action", function(){
		actionName = $(this).attr("name");
		actionIdx = $(this).attr("idx");
		
		if(actionName == "modify"){
			alert(actionIdx + "번 글을 수정합니다.");
		}else if(actionName == "delete"){
			alert(actionIdx + "번 글을 삭제합니다.");			
		}else if(actionName == "reply"){			
			// 입력한 내용 가져오기
			cont = $(this).prev().val();
			// 저장할 요소를 만들기 - renum, bonum, name, cont, redate
			reply.bonum = actionIdx;
			
			name1 = String.fromCharCode(Math.random() * 26 + 65);
			name2 = String.fromCharCode(Math.random() * 26 + 97);
			name3 = parseInt(Math.random() * 100 + 1);
			
			reply.name = name1 + name2 + name3;
			reply.cont = cont;
			
			
			
			$(this).prev().val(""); // 댓글  지우기 
			// boardsearch.js의 replyInsert()실행
			replyInsert(this); // 댓글 저장
			
			// 댓글 리스트( 비동기 방식에서는 응답이 섞일 수도 있다. 따라서 확실히 응답을 받고나서 댓글조회를 요청한다. 
			//		boardsearch.js의 success에서 기술 )
				
		}else if(actionName == "r_modify"){
			alert(actionIdx + "번 댓글을 수정합니다.");
			
			// 댓글 수정폼 modifyform의 display 스타일속성값을 가져온다.
			// none이 아니면 - 보여지고 있는 상태 : 다른 곳에 수정폼이 열려있다면, 보여지고 있는 수정폼을 닫는다.
			if($("#modifyform").css("display") != "none"){
				replyReset();
			}
			
			// 수정할 내용을 가져오기
			modifycont = $(this).parents(".rep").find(".p3").html();
			// br태그를 \n으로 바꿔준다.
			modifycont = modifycont.replace(/<br>/g, "\n");
			
			// 수정할 내용(원래글)을 수정폼에 modifyform에 출력하기
			$("#modifyform #text").val(modifycont);
			
			// 수정폼을 보이게 하기
			$(this).parents(".rep").find(".p3").empty().append($("#modifyform"));
			$("#modifyform").css("display", "block");
			// $("#modifyform").show(); : J쿼리 메서드 사용
			
		}else if(actionName == "r_delete"){
			alert(actionIdx + "번 댓글을 삭제합니다.");	
			
			// DB삭제
			replyDelete(this);
			
		}else if(actionName == "list"){			
			replyList(this);
			
		}
	})
	
	// 댓글 수정창 닫기
	replyReset = function(){
		cp3 = $("#modifyform").parent();
		cp3value = $("#modifyform #text").val();
		
		$("body").append($("#modifyform"));
		$("#modifyform").hide();
		
		cp3value = modifycont.replace(/\n/g,"<br>");
		cp3.html(cp3value);
	}
	
	
	// page번호 : pnum 이벤트
	$("#btngroup1").on("click", ".pnum", function(){
		numtext = $(this).text().trim();
		currentPage = numtext;
		listServer(currentPage);
	})
	// 다음
	$("#btngroup1").on("click", ".next", function(){
		nextnum = parseInt($(".pager a").last().text().trim()) +1;
		currentPage = nextnum;
		listServer(currentPage);
	})
	
	// 이전
	$("#btngroup1").on("click", ".previous", function(){
		nextnum = parseInt($(".pager a").first().text().trim()) -1;
		currentPage = nextnum;
		listServer(currentPage);
	})
	
	// 검색버튼
	$("#search").on("click", function(){
		listServer(1);
	})
	
	// 댓글 수정창에서 수정버튼 클릭
	$("#btnreset").on("click", function(){
		replyReset();
	})
	
	// 댓글 수정창에서 확인버튼 클릭
	$("#btnok").on("click", function(){
		alert(actionIdx);
		// 수정한 내용을 가져오기
		modifycont = $("#modifyform #text").val();
		
		cp3 = $("#modifyform").parent();
		
		// 수정폼을 body로 이동 - 감추기
		$("body").append($("#modifyform"));
		$("#modifyform").hide();
		
		// 수정내용의 \n을 <br>태그로 변경
		 modifycont2 = modifycont.replace(/\n/g,"<br>");
				
		// 수정항목을 DB로 보내기 - js
		replyUpdate(); // renum이랑 cont필요
		
		// p3에 수정내용 출력 (화면에서만 수정됨)
		// cp3.html(modifycont);
	})
	
	
	
})
</script>
</head>
<body>
	<br><br>
	
	<div id="modifyform">
		<textarea rows="5" cols="50" id="text"></textarea>
		<input type="button" value="확인" id="btnok">
		<input type="button" value="취소" id="btnreset">
	</div>
	
	
	<nav class="navbar navbar-expand-sm ">
	<select id="stype" class="form-control">
		<option value="">전체</option>
		<option value="subject">제목</option>
		<option value="content">내용</option>
		<option value="writer">작성자</option>
	</select>
    <form class="form-inline">
    	<input id="sword" class="form-control mr-sm-2" type="text" placeholder="Search">
    	<button id="search" class="btn btn-success" type="button">Search</button>
    </form>
</nav>
		
	<div class="box"></div>
	<br><br>
	<div id="btngroup1"></div>
	

<!-- The Modal -->
<div class="modal" id="modifyModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Modal Heading</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        <form action="">
        	<label>제목</label><input type="text" name="subject"><br>
        	<label>이름</label><input type="text" name="writer"><br>
        	<label>메일</label><input type="text" name="mail"><br>
        	<label>비밀번호</label><input type="password" name="password"><br>
        	<label>내용</label><textarea cols="30" rows="50"></textarea>
        </form>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>	
	

</body>
</html>