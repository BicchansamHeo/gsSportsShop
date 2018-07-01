<%--
subject    : contact.jsp
author     : 허빛찬샘
date       : 2018. 6. 11.
description : contact 페이지
 
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
.fa {
    border-width: 2px !important;
    box-shadow: none !important;
    height: 43px !important;
}
.fat {
    border-width: 2px !important;
    box-shadow: none !important;
}
</style>
</head>
    <div id="primary" class="site-comtent">
        <div class="container">
            <section class="section">
             <!-- <iframe height="350" src="https://maps.google.com/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=dhaka&amp;aq=&amp;sll=37.0625,-95.677068&amp;sspn=38.963048,86.572266&amp;ie=UTF8&amp;hq=&amp;hnear=Dhaka,+Dhaka+Division,+Bangladesh&amp;t=m&amp;z=10&amp;ll=23.709921,90.407143&amp;output=embed"></iframe> -->
           	<div id="map" style="width: 90%; height: 450px; margin-top:20px">&nbsp;</div>
         	</section>
         <!-- /#google-map -->
         <div class="row">
             <div class="col-md-4">
                 <section class="section type2">
                     <div class="subpage-title">
                         <h5><i class="fa fa-compass"></i> Visit Us</h5>
                     </div>
                     <address>
                         <strong>GS ITM</strong><br>
                         서울시 종로구 계동길 31<br>
                         보헌빌딩 1F & 2F (우)03059<br>
                     </address>
                 </section>
                 <section class="section type2">
                     <div class="subpage-title">
                         <h5><i class="fa fa-phone"></i> Contact</h5>
                     </div>
                     <address>
                         Tel: 02-2189-6700<br>
                         Fax: 02-764-4164 (2F) / 747-2720 (1F)<br>
                         <a href="mailto:#">heobi@gsitm.com</a>
                     </address>
                 </section>
             </div>
             <div class="col-md-8">
                 <section class="section type2">
                     <form id="frm" class="contact-form" action="/sendEmail.do" method="POST">
                         <div class="row" style="padding-right: 3px; padding-left: 3px;">
                             <div class="col-md-4">
                                 <input class="form-control fa" placeholder="성함" type="text" name="userName" id="userName">
                             </div>
                             <div class="col-md-4">
                                 <input class="form-control fa" placeholder="Email" type="text" name="email" id="email">
                             </div>
                             <div class="col-md-4">
                                 <input class="form-control fa" placeholder="제목" type="text" name="title" id="title">
                             </div>
                         </div>
                         <!-- row-fluid -->
                         <textarea class="form-control fat" placeholder="내용" rows="5" name="content"></textarea>
                         <button class="btn adv-color" type="button" id="subBtn">이메일 전송</button>
                     </form>
                     <!-- /.contact-form -->
                 </section>
             </div>
         </div>
         <!-- /.row -->
     </div>
 </div>
 <!-- /.site-comtent -->
 
<script src="/invent-v1.0/js/jquery-2.1.4.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- 카카오 API -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=291795bfc47de493eac5797cdeeb8623"></script>
        <script type="text/javascript">
        	var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
	        var options = { //지도를 생성할 때 필요한 기본 옵션
	        	center: new daum.maps.LatLng(37.5786446, 126.98644059999992), //지도의 중심좌표.
	        	level: 3 //지도의 레벨(확대, 축소 정도)
	        };
	        var map = new daum.maps.Map(container, options); //지도 생성 및 객체 리턴
	        var positions = [
                {
                    content: '<div>GS AIR</div>', 
                    latlng: new daum.maps.LatLng(37.5786446, 126.98644059999992)
                }
			]
	        for (var i = 0; i < positions.length; i ++) {
	            // 마커를 생성합니다
	            var marker = new daum.maps.Marker({
	                map: map, // 마커를 표시할 지도
	                position: positions[i].latlng // 마커의 위치
	            });
	
	            // 마커에 표시할 인포윈도우를 생성합니다 
	            var infowindow = new daum.maps.InfoWindow({
	                content: positions[i].content // 인포윈도우에 표시할 내용
           		});
	        }

        </script>
<!-- sweetalert SCRIPT -->
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#subBtn").on("click", function(){
			if($("#userName").val()==null ||  $("#userName").val()==''){
				swal("이름입력", "성함을 입력해주세요.", "warning");
			}else if($("#email").val()==null ||  $("#email").val()==''){
				swal("메일입력", "메일을 입력해주세요.", "warning");
			}else if($("#title").val()==null ||  $("#title").val()==''){
				swal("제목입력", "제목을 입력해주세요.", "warning");
			}else{
				frm.submit();
			}
		})
	})
</script>
</html>