<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<script src="/invent-v1.0/js/jquery-2.1.4.min.js"></script>
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
<style>
.container {
    
    margin-right: 0 !important;
    margin-left: 0 !important;
}
</style>
</head>
 <div id="main" class="wrapper">
                <div class="container">
                    <div id="primary" class="site-comtent">
                        <div class="row">
                            <div class="posts-wrap">
                               <c:forEach var="list" items="${eduList}" varStatus="status">
                                <div class="col-md-4 article-wrap">
                                <article class="post type2">
                                    <div class="entry-thumb">
                                        <img src="${list.mainImgPath}" width = "360px" class="img-responsive" alt="">
                                        <div class="image-overlay"></div>
                                        <a href="${list.mainImgPath}" data-rel="prettyPhoto" class="ima-zoom"><i class="fa fa-plus"></i></a>
                                    </div>
                                    <!-- /.entry-thumb -->
                                    <div class="entry-wrap">

                                        <header class="entry-header">
                                            <h1 class="entry-title"><a href="#" rel="bookmark">${list.confName}</a></h1>
                                        </header>
                                        <!-- /.entry-header -->
                                        <div class="entry-content">
                                            <p>${list.roomComm}</p>
                                        </div>
                                        <!-- /.entry-content -->
                                        <div class="entry-meta">
                                            <span class="post-date"><i class="fa fa-clock-o"></i> <a href="#" title="6:17 pm">21 August, 2014</a></span>
                                            <span class="comments-link"><i class="fa fa-comments"></i> <a href="#">7 Replies</a></span>
                                        </div>
                                        <!-- /.entry-meta -->
                                    </div>
                                    <!-- /.entry-wrap -->
                                </article>
                                <!-- /.post -->
                            </div>
                           </c:forEach>
                            </div>
                        </div>
                        <ul class="pagination">
                            <li><a href="#">« Previous</a></li>
                            <li id="1" name="page" class="active"><a id="temp" href="pagingEdu.do?index=1&roomkind=education">1</a></li>
                            <li id="2" name="page" class="active"><a href="pagingEdu.do?index=2&roomkind=education">2</a></li>
                            <li id="3" name="page" class="active"><a href="pagingEdu.do?index=3&roomkind=education">3</a></li>
                            <li id="4" name="page"><a href="pagingEdu.do?index=4&roomkind=education">4</a></li>
                            <li id="5" name="page"><a href="pagingEdu.do?index=5&roomkind=education">5</a></li>
                            <li name="page"><a href="pagingEdu.do?index=1&roomkind=education">Next »</a></li>
                        </ul>
                    </div>
                    <!-- /.site-comtent -->
                </div>
                <input type="hidden" id="hd" value="${index}">
            </div>
            <script>
            $('.pagination').find('li').each(function(i, e){
                console.log($(this).attr('id'));
                if($(this).attr('id') == $('#hd').val()){
                	$(this).addClass("active");
                } else {
                	$(this).removeClass("active");
                }
            });
            
            </script>
           