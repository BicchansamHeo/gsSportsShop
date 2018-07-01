<%--
subject    : searchMain.jsp
author     : 조현우
date       : 2018. 6. 11.
description : 마이페이지
 
  [이름]   [수정일]     [내용]
  ----------------------------------------------------------
  조현우		2018-06-11	초안 작성
  조현우		2018-06-12	디테일 작성
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
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
<style type="text/css">

/* iframe CSS */
iframe {
	display: block;       /* iframes are inline by default */
	border: none;         /* Reset default border */
	height: 100vh;        /* Viewport-relative units */
    width: 75vw;
}
</style>
</head>
<input type="hidden" id="code" value="${code}"/>
	<!-- iframe -->
 	<div class="container">
 		<input id="confBtn" type="button" class="btn btn-info" value="회의실" />
		<input id="eduBtn" type="button" class="btn btn-info" value="교육실" />
		<input id="buildBtn" type="button" class="btn btn-default" value="건물" /><br/>
		<iframe id="jsp_iframe" src="/searchConf.do" style="margin:0; padding:0; overflow:hidden; z-index:999999;">
		</iframe>
	</div>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#eduBtn").on("click",function(){
                $(this).removeClass();
                $(this).addClass("btn btn-info");
                $("#confBtn").attr("class", "btn btn-default");
                $("#buildBtn").attr("class", "btn btn-default");
				$("#jsp_iframe").attr("src", "/searchEdu.do");
            });
			$("#buildBtn").on("click",function(){
                $(this).removeClass();
                $(this).addClass("btn btn-info");
				$("#buildBtn").attr("class","btn btn-default");
				$("#jsp_iframe").attr("src", "/searchBuild.do");
            });
			$("#confBtn").on("click",function(){
                $(this).removeClass();
                $(this).addClass("btn btn-info");
                $("#eduBtn").attr("class", "btn btn-default");
                $("#buildBtn").attr("class", "btn btn-default");
            });

            if ($("#code").val() != 0) {
                //회의실
                if ($("#code").val() == 1) {
                    $("#confBtn").removeClass();
                    $("#confBtn").addClass("btn btn-info");
                    $("#eduBtn").attr("class", "btn btn-default");
                    $("#buildBtn").attr("class", "btn btn-default");
                    $("#jsp_iframe").attr("src", "/searchConf.do");
                } else if ($("#code").val() == 2) {
                    //교육실
                    $("#eduBtn").removeClass();
                    $("#eduBtn").addClass("btn btn-info");
                    $("#confBtn").attr("class", "btn btn-default");
                    $("#buildBtn").attr("class", "btn btn-default");
                    $("#jsp_iframe").attr("src", "/searchEdu.do");
                }
            }
		})
	
	</script>
	<script type="text/javascript">
        function change_parent_url(url)
        {
	    document.location=url;
        }		
    </script>
</html>