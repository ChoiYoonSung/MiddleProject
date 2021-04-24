/**
 * main.js 
 */

// 로그아웃 처리
function logout(url){ 
	alert("로그아웃 합니다.");
	movePageByGet(url);
}

function movePageByGet(url){
	  // 페이지이동 1
	  location.href = url;
}