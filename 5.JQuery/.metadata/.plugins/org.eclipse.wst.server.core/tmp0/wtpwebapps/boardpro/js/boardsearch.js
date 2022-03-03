/**
 * 
 */

currentPage = 1;

replyUpdate = function(){
	$.ajax({
		url : "/boardpro/ReplyUpdate.do",
		data : {
			"renum" : actionIdx,
			"cont" : modifycont
		},
		method : "post",
		success : function(res){
			if(res.sw == "수정이 완료되었습니다."){
				// DB수정이 성공후에 웹상에서 화면을 바꿔준다.
				alert(res.sw);
				cp3.html(modifycont2);				
			}
		},
		error : function(xhr){
			alert("상태 : " + xhr.status)
		},
		dataType : "json"
	})
}

replyDelete = function(but){
	$.ajax({
		url : "/boardpro/ReplyDelete.do",
		data : {"renum" : actionIdx},
		method : "get",
		success : function(res){
			// 화면에 댓글 지우기
			if(res.sw == "삭제성공"){
				$(but).parents(".rep").remove();				
			}
		},
		error : function(xhr){
			alert("상태 : " + xhr.status)
		},
		dataType : "json"
	})
}

replyList = function(rebut){	//rebut : 등록버튼 이거나 제목(사용자가 누른 '그녀석')
	
	$.ajax({
		url : "/boardpro/ReplyList.do",
		type : "post",
		data : {"bonum" : actionIdx},
		//reply.bonum
		success : function(res){
			
			rcode = "";
			$.each(res, function(i, v){
				
				// foward해서 replylist.jsp 에서 json데이터를 구성할때는 
				// 아래 cont가 필요 없다.
				cont = v.cont;
				cont = cont.replaceAll("\r","").replaceAll("\n", "<br>");
				
				rcode += '<div class="rep">'
				rcode += '<p class="p1">'
				rcode += '<span class="wr">'
						+ v.name
						+ '</span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'
				rcode += '<span class="da">'
						+ v.redate
						+ '</span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'
				rcode += '</p>'
				rcode += '<p class="p2">'
				rcode += '<input type="button" class="action" name="r_modify" idx="'
						+ v.renum + '" value="댓글수정">'
				rcode += '<input type="button" class="action" name="r_delete" idx="'
						+ v.renum + '" value="댓글삭제">'
				rcode += '</p>'
				rcode += '<hr>'
				rcode += '<p class="p3">'
				rcode += '내용보기 내용출력<br>'
				rcode += cont
				rcode += '</p>'
				rcode += '</div>'
																
			})
				$(rebut).parents(".card").find(".rep").remove();
				$(rebut).parents(".card").find(".card-body").append(rcode);
		},
		error : function(xhr){
			alert("상태 : " + xhr.status);
		},
		dataType : "json"
	})
}


replyInsert = function(rebut){
	$.ajax({
		url : "/boardpro/ReplyInsert.do",
		type : "post",
		data : reply,	//bonum, cont, name
		success : function(res){
			alert(res.sw);
			// 댓글 리스트 가져오기
			replyList(rebut);
			// 저장한 댓글 화면에 출력
		},
		error : function(xhr){
			alert("상태 : " + xhr.status)
		},
		dataType : "json"
		
	})
}


listServer = function(cpage){
	
	type = $("#stype option:selected").val().trim();
	word = $("#sword").val().trim();
	
	$.ajax({
		url : "/boardpro/ListSearch.do",
		data : {"page" : cpage,
				"type" : type,
				"word" : word
				},
		method : "get",
		success : function(res){

			code = "<div id='accordion'>";
			
			$.each(res.datas, function(i, v){
				
			
				code += '<div class="card">'
		    	code += '<div class="card-header">'
		    	code += '<a name="list" idx="' + v.num + '" class="card-link action" data-toggle="collapse" href="#collapse' + v.num + '">'
		    	code += v.subject
		    	code += '</a>'
		    	code += '</div>'
		    	code += '<div id="collapse' + v.num + '" class="collapse" data-parent="#accordion">'
		    	code += '<div class="card-body cbody">'
				code += '<p class="p1">'
				code += '작성자 : <span class="wr">' + v.writer + '</span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'
				code += '이메일 : <span class="em">' + v.mail + '</span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp'
				code += '조회수 : <span class="hit">' + v.hit + '</span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'
				code += '날짜 : <span class="da">' + v.wdate + '</span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'
				code += '</p>'
				code += '<p class="p2">'
				code += '<input type="button" class="action" name="modify" idx="' + v.num + '" value="수정">'
				code += '<input type="button" class="action" name="delete" idx="' + v.num + '" value="삭제">'
				code += '</p>'
				code += '<hr>'
				code += '<p class="p3">'
				code += '내용보기 내용출력<br>'
				code += v.content
				code += '</p>'
				code += '<p class="p4">'
				code += '<textarea cols="60"></textarea>'
				code += '<input type="button" class="action reply" name="reply" idx="' + v.num + '" value="등록">'
				code += '</p>'
		    	code += '</div>'
		    	code += '</div>'
		    	code += '</div>'
			
			})
		    
		    code += "</div>";
		    $(".box").html(code);
		    
		    // 이전버튼 만들기
		    pager = "";
		    if(res.startPage > 1){
		    	pager += '<ul class="pagination">';
		    	pager += '<li class="previous page-item"><a class="page-link" href="#">Previous</a></li>';
		    	pager += '</ul>';
		    }
		    
		    // 페이지번호
		    pager += '<ul class="pagination pager">';
		    
		    for(i=res.startPage; i <= res.endPage; i++){
		    	if(currentPage == i){
		    		pager += '<li class="active page-item"><a class="page-link pnum" href="#">' + i + '</a></li>';
		    	}else{
		    		pager += '<li class="page-item"><a class="page-link pnum" href="#"> ' + i + ' </a></li>';
		    	}
		    }
		    pager += '</ul>';
		    
		    // 다음버튼
		    if(res.endPage < res.totalPage){
		    	pager += '<ul class="pagination">';
		    	pager += '<li class="next page-item"><a class="page-link" href="#">Next</a></li>';
		    	pager += '</ul>';
		    }
		    $("#btngroup1").empty();
		    $("#btngroup1").append(pager);
		    
			
		},
		error : function(xhr){
			alert("상태 : "  + xhr.status);
		},
		dataType : "json"
	})
}