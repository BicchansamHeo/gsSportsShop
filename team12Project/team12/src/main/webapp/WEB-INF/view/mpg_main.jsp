<%--
subject    : mpg_main.jsp
author     : 허빛찬샘
date       : 2018. 6. 11.
description : 마이페이지 메인
 
  [이름]   [수정일]     [내용]
  ----------------------------------------------------------
  허빛찬샘	2018-06-11	초안 작성
  허빛찬샘	2018-06-12	디테일(iframe) 작성
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE>
<html>
<head>
<style type="text/css">
/* iframe CSS */
iframe {
	display: block;       /* iframes are inline by default */
	border: none;         /* Reset default border */
	height: 100vh;        /* Viewport-relative units */
    width: 100%;
}
</style>
</head>
	<!-- iframe -->
 	<div class="container">
		<input id="memBtn" type="button" class="btn btn-info" value="개인" />
		<input id="memTeam" type="button" class="btn btn-default" value="팀" /><br/>
		<iframe id="jsp_iframe" src="/mypage_mmb.do?empNo=<sec:authentication property='principal.username' />"
				style="margin:0; padding:0; overflow:hidden; z-index:999999;">
		</iframe>
	</div>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="/dist/js/jquery-iframe-auto-height.min.js"></script>
	<script type="text/javascript" src="/dist/js/jquery.browser.js"></script>
	<script type="text/javascript">
	    function autoSize(str){
	        var obj = document.getElementById(str);
	        try{ // 에러가 나더라도 무시하게 처리
	            if(obj)obj.height = obj.contentWindow.document.body.scrollHeight;
	        }catch(e){}
	    }
	    setInterval("autoSize('jsp_iframe')", 50) // 계속 실행
		$(document).ready(function(){
			/* iframe 세팅 */
			/*$('iframe').iframeAutoHeight({
				minHeight: 240, // Sets the iframe height to this value if the calculated value is less
				heightOffset: 50 // Optionally add some buffer to the bottom
			}); */

			/* iframe 세팅 */
			$("#memBtn").on("click",function(){
				$(this).attr("class","btn btn-info");
				$("#memTeam").attr("class","btn btn-default");
				$("#jsp_iframe").attr("src", "/mypage_mmb.do?empNo=<sec:authentication property='principal.username' />");
            });
			$("#memTeam").on("click",function(){
				$(this).attr("class","btn btn-info");
				$("#memBtn").attr("class","btn btn-default");
				$("#jsp_iframe").attr("src", "/mypage_team.do?empNo=<sec:authentication property='principal.username' />");
			})
		})
	</script>
</html>