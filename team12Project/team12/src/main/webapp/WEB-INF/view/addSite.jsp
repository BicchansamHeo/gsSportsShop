<%--
subject    : addSite.jsp
author     : 조현우
date       : 2018. 6. 15.
description : 건물 추가하는 페이지
 
  [이름]   [수정일]     [내용]
  ----------------------------------------------------------
    조현우	2018-06-15	초안
    강혜정	2018-06-16	페이지 디자인
    조현우	2018-06-17	지도 수정
    강혜정	2018-06-18	페이지 디자인 재수정
--%>



<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>

</style>

<head>
<meta charset="utf-8"/>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<meta name="viewport" content="initial-scale=1.0">
    <meta charset="utf-8">
    
</head>
<script src="/invent-v1.0/js/jquery-2.1.4.min.js"></script>
<body>
<%-- 
<h1>회의실 등록</h1>
	<form action="addSite.do" method="post">
	<div>
	<label>건물 이름</label>
		<input type="text" id="siteName" name="siteName" placeholder="회의실 이름"/>
	</div>
	
	<div>
	<label>건물 번호</label>
		<input type="text" id="siteNo" name="siteNo" placeholder="회의실 번호" value="${siteSeq}"/>
	</div>
	<div>
	<label>건물 주소</label>
		<input type="text" name="siteAddr" id="siteAddr" class = "addr" placeholder="회의실 주소"/>
		<input type="button" class="address" value="찾기">
	</div> 
	<div>
	<label>Longitude</label>
		<input type="text" id="long" name="longitude" class="longitude" placeholder="경도" />
	
	</div>
	<div>
	<label>latitude</label>
		<input type="text" id="lati" name="latitude" class="latitude" placeholder="위도" />
	
	</div>
	<input type="submit" value="등록"/>
	</form>
<div id="map" style="width:100%;height:350px;"></div>
 --%>


<div class="container">
  <!-- /.col-md-4 -->
    <div width="80%">
        <div class="pricing ultimate">
            <div class="p-header">
                <div class="title">
                    <h4>회의실 관리</h4>
                </div>
                <div class="price">
                    <span class="dollar"></span>
                    <h2>건물 추가</h2>
                    <span class="per"></span>
                </div>
            </div>
            <form action="addSite.do" method="post">
            <div class="list-group">
                <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; 
                	<strong class="text-uppercase">건물이름</strong>
                	<input type="text" id="siteName" name="siteName" placeholder="건물이름"/>
                	    
                </a>
                <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; 
                	<strong class="text-uppercase">건물번호</strong>
                	<input type="text" id="siteNo" name="siteNo" placeholder="건물번호" value="${siteSeq}"/>    
                </a>
                <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; 
                	<strong class="text-uppercase">건물주소</strong>
                	<input type="text" name="siteAddr" id="siteAddr" class = "addr" placeholder="회의실 주소"/>
                	<input type="button" class="address" value="찾기">
                </a>
                <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; 
                	<strong class="text-uppercase">경도</strong>
                	<input type="text" id="long" name="longitude" class="longitude" placeholder="경도" />    
                </a>
                <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; 
                	<strong class="text-uppercase">위도</strong>
                	<input type="text" id="lati" name="latitude" class="latitude" placeholder="위도" />
                </a>
            </div>
            
            <div class="p-footer">
           		<div id="map" style="width:100%;height:350px;">지도</div>
                
            </div>
            <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; 
                	<input type="submit" value="등록"/>
                </a>
            
        </form>    
        </div>
        <!-- /.pricing -->
    </div>
    <!-- /.col-md-4 -->
</div>










<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=0f587210b9f77ba6bcc46b789d05650e&libraries=services"></script>
<script type="text/javascript">

var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
mapOption = {
    center: new daum.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
    level: 3 // 지도의 확대 레벨
};  

$(document).ready(function(){
	$('.address').on('click', function() {
		// 지도를 생성합니다    
	var map = new daum.maps.Map(mapContainer, mapOption); 
	// 주소-좌표 변환 객체를 생성합니다
	var geocoder = new daum.maps.services.Geocoder();
	alert($('#siteAddr').val());
	// 주소로 좌표를 검색합니다
		geocoder.addressSearch($('#siteAddr').val(), function(result, status) {

		    // 정상적으로 검색이 완료됐으면 
		     if (status === daum.maps.services.Status.OK) {
		    	 var lon = result[0].y
		    	 var lati = result[0].x
			
				$('.longitude').val(lon);
		    	$('.latitude').val(lati);
		        var coords = new daum.maps.LatLng(result[0].y, result[0].x);

		        // 결과값으로 받은 위치를 마커로 표시합니다
		        var marker = new daum.maps.Marker({
		            map: map,
		            position: coords
		        });

		        // 인포윈도우로 장소에 대한 설명을 표시합니다
		        var infowindow = new daum.maps.InfoWindow({
		            content: '<div style="width:150px;text-align:center;padding:6px 0;">우리회사</div>'
		        });
		        infowindow.open(map, marker);

		        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
		        map.setCenter(coords);
		    } 
		});
	})
 })
</script>

</body>
</html>