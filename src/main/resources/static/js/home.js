$(document).ready(()=> {
	const EVENT1 = function() {
//		alert($(this).children('td').eq(0).text() + "번호에 접근 불가!!");
	//	비동기 요청 ("/check") : param - noticeNo "$(this).children('td').eq(0).text()"  
		var noticeNo = $(this).children('td').eq(0).text();
		$.ajax("/check", {
			'method': "GET",
			'data': {'noticeNo': noticeNo}
		}).done(data => alert(data));
	}
	$("tbody tr").on("click", EVENT1);
	
	const EVENT2 = e => {
	$.post("/info").done(data => alert(data.message));
/*	EVENT3($("button").index(e.target));
	const EVENT3 = i => {
		switch(i) {
			case 0:
				//alert("로그인");
				location.href = "/login";
				break;
			case 1:
				//alert("로그아웃");
				location.href = "/logout";
				break;
			case 2:
				//alert("회원정보");
				location.href = "/info";
				break;
		}
	}*/
	}
	$("button").on("click", EVENT2);
	
});