<%--
subject    : Footer.jsp
author     : 강혜정
date       : 2018. 6. 10.
description : tiles를 이용한 Footer 페이지
 
  [이름]   [수정일]     [내용]
  ----------------------------------------------------------
  강혜정	2018-06-10 	초안작성
  강혜정	2018-06-13 	위치 고정
  강혜정	2018-06-14 	디자인 수정
 
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- /#main -->
<style>

#colophon {
    position: absolute;
    bottom: auto;
    width: 100%;
    height: 70px;
 }
 #site-info{   
 
    height: 70px;
    padding-bottom: 0px;

     padding-top: 20px;
    height: 80px;
}

/*
#supplementary{
    padding-top: 10px;
    padding-bottom: 10px;
    top: 550px;
} */

</style>
<footer id="colophon" class="site-footer" role="contentinfo">
     <div id="site-info">
         <div class="container">
             <div class="row">
                 <div class="col-xs-12 col-sm-6">
                     <div class="footer-info-wrapper">
          			   <span style="color:black; font-size: ">COPYRIGHT ⓒ 2018 GS ITM CO, LTD ALL RIGHT RESERVED.</span>
                     </div>
                 </div>
                 <!-- /.footer-info-wrapper -->
                 <div class="col-xs-12 col-sm-6">
                     <div class="footer-links-wrapper">
                         <ul class="list-inline">
                 			<li><a href="https://portal.gsitm.com/?q=book">Privacy Policy</a></li>
                             <li><a href="/developer.do">TEAM12</a></li>
                         </ul>
                     </div>
                 </div>
                 <!-- /.footer-links-wrapper -->
             </div>
             <!-- /.row -->
         </div>
         <!-- /.container -->
     </div>
     <!-- /.site-footer -->
 </footer>