$(document).ready(()=> {
	const EVENT1 = function(e){
//		console.log(this, $("button").index(this));
		EVENT3($("button").index(this));
	}
	const EVENT2 = (e) => {
//		console.log(e, $("button").index(e.target));
		EVENT3($("button").index(e.target));
	}
	const EVENT3 = (i) => {
		console.log(i);
		switch(i) {
			case 0:
				//console.log("로그인 진행")
				$.post("/login").done(data => alert(data.msg));
				break;
			case 1:
				//console.log("로그아웃 진행")
				$.post("/logout").done(data => alert(data.msg));
				break;
			case 2:
				//console.log("회원정보 진행")
				$.post("/info").done(data => alert(data.name));
				break;
		}
		
	}
	$("button").on("click",EVENT2);
});
