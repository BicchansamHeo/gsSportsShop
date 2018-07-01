<%--
subject    : Top.jsp
author     : 허빛찬샘
date       : 2018. 6. 07.
description : tiles를 이용한 top 페이지
 
  [이름]   [수정일]     [내용]
  ----------------------------------------------------------
  허빛찬샘	2018-06-07	초안 작성
    강혜정	2018-06-11	아이콘 수정
  허빛찬샘	2018-06-12	header 수정
  허빛찬샘	2018-06-14	내용 수정
    강혜정	2018-06-19	상위 메뉴 추가(회의실관리)
  허빛찬샘	2018-06-20	통계 메뉴 권한 수정
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<link rel="stylesheet" 
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

<!-- Bootstrap JS & Others JavaScript Plugins -->
<!-- Placed At The End Of The Document So Page Loads Faster -->
<script src="/invent-v1.0/js/jquery-2.1.4.min.js"></script>
<script src="/invent-v1.0/js/jquery-migrate-1.2.1.min.js"></script>
<script src="/invent-v1.0/js/bootstrap.min.js"></script>
<!-- SLIDER REVOLUTION 4.x SCRIPTS  -->
<script src="/invent-v1.0/plugins/rs-plugin/js/jquery.themepunch.tools.min.js"></script>
<script src="/invent-v1.0/plugins/rs-plugin/js/jquery.themepunch.revolution.min.js"></script>
<script src="/invent-v1.0/plugins/prettyPhoto/js/jquery.prettyPhoto.js"></script>
<script src="/invent-v1.0/js/jquery.carouFredSel-6.2.1-packed.js"></script>
<script src="/invent-v1.0/js/jflickrfeed.min.js"></script>
<script src="/invent-v1.0/js/easing.js"></script>
<script src="/invent-v1.0/js/jquery.ui.totop.min.js"></script>
<script src="/invent-v1.0/js/isotope.pkgd.min.js"></script>
<script src="/invent-v1.0/js/jquery.fitvids.js"></script>
<!-- Custom Script For This Template -->
<script src="/invent-v1.0/js/script.js"></script>

<script> 
$(document).ready(function() { 
	$('[data-toggle="popover"]').popover({container: "body"}); 
	$(".fa-send").on("click", function(){
		location.href = "/contact.do";
	})
}); 
	
</script>

<header id="masthead" class="site-header" role="banner">
	<nav class="navbar navbar-default navbar-static-top" role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="main.do"> <img style width="500px"
					height="50px" src="/invent-v1.0/img/logo_gsitm.png">
				</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<span class="nav-msg visible-lg-block"><i class="fa fa-send"></i> </span>
				<ul id="menu" class="nav navbar-nav navbar-right">
					<li id="main"><a href="main.do">Home</a></li>


					<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_EM','ROLE_AM','ROLE_SM','ROLE_DM','ROLE_TM')">
						<li id="paging"><a href="/paging.do?index=1&roomkind=conference">회의실조회</a></li>
					</sec:authorize>

					<li id="board"><a href="/board.do">커뮤니티</a></li>

					<sec:authorize access="hasAnyRole('ROLE_TM','ROLE_AM','ROLE_EM','ROLE_DM')">
						<li id="pay"><a href="pay.do">결재</a></li>
					</sec:authorize>

                    <sec:authorize access="hasAnyRole('ROLE_SM')">
						<li id="authManage"><a href="/authManage.do">사용자 관리</a></li>
                    </sec:authorize>

					<sec:authorize access="hasAnyRole('ROLE_AM')">
						<li id="searchConf"><a href="/searchConf.do">회의실관리</a></li>
					</sec:authorize>

					<sec:authorize access="hasAnyRole('ROLE_TM','ROLE_AM','ROLE_EM','ROLE_SM')">
						<li id="stat"><a href="stat.do">통계</a></li>
					</sec:authorize>
					<sec:authorize access="!hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_EM','ROLE_AM','ROLE_SM','ROLE_DM','ROLE_TM')">
						<li id="login" style="display: inline;">
							<a href="/login.do" style="padding-top: 27px;">
								<div style="display: inline;">로그인</div>
								<img width="30px" height="30px" src="https://use.fontawesome.com/releases/v5.0.13/svgs/solid/user-circle.svg"></img>
							</a>
						</li>
					</sec:authorize>
					<sec:authorize access="isAuthenticated()">
						<li id="mypage" style="display: inline;" class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" style="padding-top: 27px;">
								<!--<img width="30px" height="30px" src="https://use.fontawesome.com/releases/v5.0.13/svgs/solid/user-circle.svg"></img>-->
								<i class="fa fa-user"></i>
								<i class="fa fa-angle-double-down"></i>
							</a>
							<ul class="dropdown-menu">
                                <li><a href="/mypage.do?empNo=<sec:authentication property='principal.username' />">마이페이지</a>
                                </li>
								<li><a href="/j_spring_security_logout">로그아웃</a></li>
							</ul>
						</li>
					</sec:authorize>
				</ul>
				<!-- /.nav -->
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>
	<!-- /.navbar -->
</header>
<!-- /#masthead -->
<header id="header-search-box" class="search-box-wrapper">
	<div class="container">
		<div class="search-box">
			<button type="button" class="close">
				<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
			</button>
			<form role="form">
				<div class="input-group">
					<span class="input-group-btn">
						<button class="btn btn-default btn-lg" type="button">
							<i class="fa fa-search"></i>
						</button>
					</span> <input type="text" class="form-control input-lg"
						placeholder="Search">
				</div>
			</form>
		</div>
	</div>
</header>

<!-- /#header-search-box -->


