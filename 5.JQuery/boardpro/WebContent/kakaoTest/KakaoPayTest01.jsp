<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-3.6.0.min.js"></script>
<script>
$(function(){
	$("#btn1").on("click", function(){
		$.ajax({
			url : "<%=request.getContextPath()%>/Kakao.do",
			method : "post",
			data : {
				"cid" : "TC0ONETIME",
				"partner_order_id" : "sefgie15sefgie15sefgie15", 
				"partner_user_id" : "주문번호",
				"item_name" : "키조개",
				"quantity" : "1",
				"total_amount" : "25000",
				"tax_free_amount" : "20000",
				"approval_url" : "http://localhost/boardpro/kakaoTest/KakaoPayTest01.jsp",
				"cancel_url" : "http://localhost/boardpro/kakaoTest/KakaoPayTest01.jsp",
				"fail_url" : "http://localhost/boardpro/kakaoTest/KakaoPayTest01.jsp",					
			},
			success : function(res){
				alert("결제 성공!");
			},
			error : function(xhr){
				alert("상태 : " + xhr.status);
			},
			dataType : "json"
			
		})
		
	})
	
	
})

</script>


<style>
#btn1{
	text-align: center;
	width : 200px;
	height : 30px;
}
</style>
</head>
<body>

 <script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
    <script>
        // SDK를 초기화 합니다. 사용할 앱의 JavaScript 키를 설정해 주세요.
        Kakao.init('118061b034a20645132f9680a2908f7c');

        // SDK 초기화 여부를 판단합니다.
        console.log(Kakao.isInitialized());
    </script>
	<br><br><br><br><br><br>
	<input type="button" value="결제하기" id="btn1">

</body>
</html>