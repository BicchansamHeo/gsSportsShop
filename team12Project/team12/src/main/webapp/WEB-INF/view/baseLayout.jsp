<%--
subject    : 
author     : 허빛찬샘
date       : 2018. 6. 06.
description : login 페이지
 
  [이름]   [수정일]     [내용]
  ----------------------------------------------------------
  허빛찬샘	2018-06-06	초안 작성
  허빛찬샘	2018-06-10	로그인 CSS, JS 추가
  강혜정	2018-06-15	로고 수정
--%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="/invent-v1.0/ico/GS_logo.png">
<title>GS ITM 회의실 예약 시스템</title>
<!-- Bootstrap Core CSS -->
<link href="/invent-v1.0/css/bootstrap.min.css" rel="stylesheet">
<link href="/invent-v1.0/plugins/prettyPhoto/css/prettyPhoto.css" rel="stylesheet">
<link href="/invent-v1.0/css/animate.min.css" rel="stylesheet">
<link href="/invent-v1.0/css/ui.totop.css" rel="stylesheet">
<!-- SLIDER REVOLUTION 4.x CSS SETTINGS -->
<link href="/invent-v1.0/css/extralayers.css" rel="stylesheet">
<link href="/invent-v1.0/plugins/rs-plugin/css/settings.css" rel="stylesheet">
<!-- Font Awesome  -->
<link href="/invent-v1.0/css/font-awesome.min.css" rel="stylesheet">
<!-- Custom Stylesheet For This Template -->
<link href="/invent-v1.0/css/stylesheet.css" rel="stylesheet">
<link href="/invent-v1.0/css/skins.css" rel="stylesheet">
 <!-- dataTables CSS -->
<link href="/invent-v1.0/css/semantic.min.css" rel="stylesheet">
<link href="/invent-v1.0/css/dataTables.semanticui.min.css" rel="stylesheet">
<!-- Google Fonts -->
<link href="http://fonts.googleapis.com/css?family=Raleway:400,900,800,700,600,500,300,200,100" rel="stylesheet" type="text/css">
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
            <script src="js/html5shiv.min.js"></script>
            <script src="js/respond.min.js"></script>
        <![endif]-->
<!-- login CSS -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>

<link href="/invent-v1.0/css/login.css" rel="stylesheet">
<style type="text/css">

</style>
</head>
<body>
	<tiles:insertAttribute name="header"/>
	<div id="main" class="wrapper">
        <!-- 바디 부분 -->
		<tiles:insertAttribute name="body" />
	<!-- /.site-comtent -->
	</div>
	<!-- footer -->
	<tiles:insertAttribute name="footer" />
        <!-- /#page -->
        <!--
        <div class="skin-chooser-wrap visible-lg-block">
            <span class="skin-chooser-toggle"><i class="fa fa-cog"></i></span>
            <section class="section">
                <h4>Style Switcher</h4>
            </section>
            <section class="section">
                <h6>Layout Options</h6>
                <p>Which layout option you want to use?</p>
                <p><a id="boxed" class="btn adv-default squre btn-xs" href="#" role="button">Boxed</a><em>&nbsp; or &nbsp;</em><a id="wide" class="btn adv-primary squre btn-xs" href="#" role="button">Wide</a></p>
            </section>
            <section class="section">
                <h6>Color Schemes</h6>
                <p>Which theme color you want to use? Here are some predefined colors.</p>
                <ul class="list-inline">
                    <li id="color-skin-1" class="color-skin active"></li>
                    <li id="color-skin-2" class="color-skin"></li>
                    <li id="color-skin-3" class="color-skin"></li>
                    <li id="color-skin-4" class="color-skin"></li>
                    <li id="color-skin-5" class="color-skin"></li>
                </ul>
            </section>
            <section class="section">
                <h6>Patterns</h6>
                <p>You can choose between four patterns.</p>
                <ul class="list-inline">
                    <li id="color-pattern-1" class="color-pattern active"></li>
                    <li id="color-pattern-2" class="color-pattern"></li>
                    <li id="color-pattern-3" class="color-pattern"></li>
                    <li id="color-pattern-4" class="color-pattern"></li>
                    <li id="color-pattern-5" class="color-pattern"></li>
                </ul>
            </section>
        </div>
         -->
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
        <!-- dataTables SCRIPTS -->
        <script src="/invent-v1.0/js/jquery.dataTables.min.js"></script>
        <script src="/invent-v1.0/js/dataTables.semanticui.min.js"></script>
        <script src="/invent-v1.0/js/semantic.min.js"></script>
   
        <!-- login SCRIPT -->
        <script src="/invent-v1.0/js/login.js"></script>

</body>
<script>
    window.onload = function () {

        $('#menu > li').each(function () {

            var _tempUrl = $(location).attr('href');
            if (_tempUrl.indexOf("main") != -1) {
                $('#main').addClass('active');
                $('#paging').removeClass('active');
                $('#board').removeClass('active');
                $('#pay').removeClass('active');
                $('#authManage').removeClass('active');
                $('#searchConf').removeClass('active');
                $('#stat').removeClass('active');
                $('#login').removeClass('active');
                $('#mypage').removeClass('active');
            } else if (_tempUrl.indexOf("paging") != -1) {
                $('#paging').addClass('active');
                $('#main').removeClass('active');
                $('#board').removeClass('active');
                $('#pay').removeClass('active');
                $('#authManage').removeClass('active');
                $('#searchConf').removeClass('active');
                $('#stat').removeClass('active');
                $('#login').removeClass('active');
                $('#mypage').removeClass('active');
            } else if (_tempUrl.indexOf("board") != -1) {
                $('#board').addClass('active');
                $('#main').removeClass('active');
                $('#paging').removeClass('active');
                $('#pay').removeClass('active');
                $('#authManage').removeClass('active');
                $('#searchConf').removeClass('active');
                $('#stat').removeClass('active');
                $('#login').removeClass('active');
                $('#mypage').removeClass('active');
            } else if (_tempUrl.indexOf("pay") != -1) {
                $('#pay').addClass('active');
                $('#main').removeClass('active');
                $('#paging').removeClass('active');
                $('#board').removeClass('active');
                $('#authManage').removeClass('active');
                $('#searchConf').removeClass('active');
                $('#stat').removeClass('active');
                $('#login').removeClass('active');
                $('#mypage').removeClass('active');
            } else if (_tempUrl.indexOf("authManage") != -1) {
                $('#authManage').addClass('active');
                $('#main').removeClass('active');
                $('#paging').removeClass('active');
                $('#board').removeClass('active');
                $('#pay').removeClass('active');
                $('#searchConf').removeClass('active');
                $('#stat').removeClass('active');
                $('#login').removeClass('active');
                $('#mypage').removeClass('active');
            } else if (_tempUrl.indexOf("searchConf") != -1) {
                $('#searchConf').addClass('active');
                $('#main').removeClass('active');
                $('#paging').removeClass('active');
                $('#board').removeClass('active');
                $('#pay').removeClass('active');
                $('#authManage').removeClass('active');
                $('#stat').removeClass('active');
                $('#login').removeClass('active');
                $('#mypage').removeClass('active');
            } else if (_tempUrl.indexOf("stat") != -1) {
                $('#stat').addClass('active');
                $('#main').removeClass('active');
                $('#paging').removeClass('active');
                $('#board').removeClass('active');
                $('#pay').removeClass('active');
                $('#authManage').removeClass('active');
                $('#searchConf').removeClass('active');
                $('#login').removeClass('active');
                $('#mypage').removeClass('active');
            } else if (_tempUrl.indexOf("login") != -1) {
                $('#login').addClass('active');
                $('#main').removeClass('active');
                $('#paging').removeClass('active');
                $('#board').removeClass('active');
                $('#pay').removeClass('active');
                $('#authManage').removeClass('active');
                $('#searchConf').removeClass('active');
                $('#stat').removeClass('active');
                $('#mypage').removeClass('active');
            } else if (_tempUrl.indexOf("mypage") != -1) {
                $('#mypage').addClass('active');
                $('#main').removeClass('active');
                $('#paging').removeClass('active');
                $('#board').removeClass('active');
                $('#pay').removeClass('active');
                $('#authManage').removeClass('active');
                $('#searchConf').removeClass('active');
                $('#stat').removeClass('active');
                $('#login').removeClass('active');

            }
        });
    }


</script>
</html>

