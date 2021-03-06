<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
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

</head>
 <div id="main" class="wrapper">
           <div class="container">
				 <div class="pricing professional">
		            <div class="p-header">
		                <div class="title">
		                    <h4 style="font-weight: 100; font-size: 20px;">예약</h4>
		                </div>
		                <div class="price">
		                    <span class="dollar"></span>
		                    <h2 style="font-weight: 530; font-size: 45px;">건물조회</h2>
		                    <span class="per"></span>
		                 </div>
		            </div>
				 </div>      
           
           
           
                <section class="portfolio-filter section type2">
	                <div class="row">
	                	<div class="col-sm-6">
	                        <ul class="nav nav-pills">
	                            <li ><a id="conference" href="#" data-filter=".artwork">회의실</a></li>
	                            <li><a id="education"href="#" data-filter=".artwork">교육실</a></li>
	                            <li class="active"><a id="site" href="#" data-filter=".artwork">건물</a></li>
	                        </ul>
                     	</div>
	                	<div class="col-sm-6" style="text-align: right;">
                		<sec:authorize access="hasAnyRole('ROLE_SM')">
	                		<input id="" type="button" class="btn btn-info btn-sm" value="추가" onclick="location.href='/addSite.do'"/>
							<input id="" type="button" class="btn btn-default btn-sm" value="수정" onclick="location.href='/modifySite.do'"/>
						</sec:authorize>
             		</div>
                     </div>
                 </section>
                    <div id="primary" class="site-comtent">
                        <div class="row">
                            <div class="posts-wrap">
                               <c:forEach var="list" items="${SiteList}" varStatus="status">
                                <div class="col-md-4 article-wrap">
                                <article class="post type2">
                                    <div class="entry-thumb">
                                        <img src="" width = "360px" class="img-responsive" alt="">
                                        <div class="image-overlay"></div>
                                        <a href="" data-rel="prettyPhoto" class="ima-zoom"><i class="fa fa-plus"></i></a>
                                    </div>
                                    <!-- /.entry-thumb -->
                                    <div class="entry-wrap">

                                        <header class="entry-header">
                                            <h1 class="entry-title"><a href="#" rel="bookmark">${list.siteName}</a></h1>
                                        </header>
                                        <!-- /.entry-header -->
                                        <div class="entry-content">
                                            <p>${list.siteAddr}</p>
                                        </div>
                                        <!-- /.entry-content -->
                                        <!-- /.entry-meta -->
                                    </div>
                                    <!-- /.entry-wrap -->
                                </article>
                                <!-- /.post -->
                            </div>
                           </c:forEach>
                            </div>
                        </div>
                        <div style="text-align:center">
                        <ul id="pageMenu" class="pagination">
     
                        </ul>
                        </div>
                         
                    </div>
                    <!-- /.site-comtent -->
                </div>
                <input type="hidden" id="hd" value="${index}">
            </div>
             <script>
		
            	 var totalPg = ${totalPg};
           	     for(var i = 1; i <= totalPg; i++){
           	    	 $('#pageMenu').append("<li id='" + i + "' name='page'><a href='pagingBuild.do?index=" + i + "'>" + i + "</a></li>");
           	     } 

            $("#conference").on("click", function(){
        		location.href = "/paging.do?index=1&roomkind=conference";
        	})
        	$("#education").on("click", function(){
        		location.href = "/pagingEdu.do?index=1&roomkind=education";
        	})
        	$("#site").on("click", function(){
        		location.href = "/pagingBuild.do?index=1";
        	})
            $('.pagination').find('li').each(function(i, e){
                console.log($(this).attr('id'));
                if($(this).attr('id') == $('#hd').val()){
                	$(this).addClass("active");
                } else {
                	$(this).removeClass("active");
                }
            });
            
            </script>