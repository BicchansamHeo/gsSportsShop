<%--
subject    : mpg_team.jsp
author     : 허빛찬샘
date       : 2018. 6. 11.
description : 마이페이지 팀 전용
 
  [이름]   [수정일]     [내용]
  ----------------------------------------------------------
  허빛찬샘	2018-06-11	초안 작성
  허빛찬샘	2018-06-12	디테일 작성
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<!-- Bootstrap Core CSS -->
<link href="/invent-v1.0/css/bootstrap.min.css" rel="stylesheet">
<link href="/invent-v1.0/plugins/prettyPhoto/css/prettyPhoto.css"
	rel="stylesheet">
<link href="/invent-v1.0/css/animate.min.css" rel="stylesheet">
<link href="/invent-v1.0/css/ui.totop.css" rel="stylesheet">
<!-- SLIDER REVOLUTION 4.x CSS SETTINGS -->
<link href="/invent-v1.0/css/extralayers.css" rel="stylesheet">
<link href="/invent-v1.0/plugins/rs-plugin/css/settings.css"
	rel="stylesheet">
<!-- Font Awesome  -->
<link href="/invent-v1.0/css/font-awesome.min.css" rel="stylesheet">
<!-- Custom Stylesheet For This Template -->
<link href="/invent-v1.0/css/stylesheet.css" rel="stylesheet">
<link href="/invent-v1.0/css/skins.css" rel="stylesheet">
</head>
<body style="width=800; height=1000; overflow:auto; overflow-x;">
<div class="container">
		<input id="memBtn" type="button" class="btn btn-default" value="개인" />
		<input id="memTeam" type="button" class="btn btn-info" value="팀" /><br/><br/>
<input id="empNo" type="hidden" value="<sec:authentication property="principal.username" />">
<section>
	<div class="subpage-title">
	    <h4 id="headDeptNm"></h4>
	</div>
	<blockquote>
		<table id="teamBudget" class="table table-bordered" style="text-align: center;">
		</table>
		<table id="tb" class="table table-bordered" style="text-align: center;">
		</table>
	</blockquote>
</section>
</div>
	<script src="/invent-v1.0/js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#memBtn").on("click", function(){
	    		location.href = "/mypage.do";
	    	})
	    	$("#memTeam").on("click", function(){
    			location.href = "/mypageTeam.do";
   			})
			var url = "/teamAjax.do?empNo="+$('#empNo').val();
			$.ajax({
				type : "GET",
				url : url,
				dataType : "json",
				success	: function(data) {
					if(data!=''){
						$("#teamBudget").html('<tr><td>팀 예산</td><td>'+numberWithCommas(data.userVO.deptBudget)+'원</td></tr>');
						$("#headDeptNm").html(data.userVO.deptName);
						var str='<tr><td width="20%">이름</td><td width="35%">핸드폰 번호</td><td width="35%">생년월일</td></tr>';
						for(var i = 0; i<data.userList.length; i++){
							str+='<tr>';
							str+='<td>';
							str+=data.userList[i].empName;
							str+='</td>';
							str+='<td>';
							str+=data.userList[i].phone;
							str+='</td>';
							str+='<td>';
							str+=data.userList[i].birthday;
							str+='</td>';
							str+='</tr>';
						}
						if(data.userList.length!=null){
							$("#tb").html(str);
						}
			 		}
			    }
			})//ajax
		})	
		//숫자 콤마
	    function numberWithCommas(x) {
	        return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	    }
	</script>
</body>
</html>