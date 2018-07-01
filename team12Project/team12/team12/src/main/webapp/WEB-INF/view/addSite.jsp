<%--
subject    : addSite.jsp
author     : ������
date       : 2018. 6. 15.
description : �ǹ� �߰��ϴ� ������
 
  [�̸�]   [������]     [����]
  ----------------------------------------------------------
    ������	2018-06-15	�ʾ�
    ������	2018-06-16	������ ������
    ������	2018-06-17	���� ����
    ������	2018-06-18	������ ������ �����
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
<h1>ȸ�ǽ� ���</h1>
	<form action="addSite.do" method="post">
	<div>
	<label>�ǹ� �̸�</label>
		<input type="text" id="siteName" name="siteName" placeholder="ȸ�ǽ� �̸�"/>
	</div>
	
	<div>
	<label>�ǹ� ��ȣ</label>
		<input type="text" id="siteNo" name="siteNo" placeholder="ȸ�ǽ� ��ȣ" value="${siteSeq}"/>
	</div>
	<div>
	<label>�ǹ� �ּ�</label>
		<input type="text" name="siteAddr" id="siteAddr" class = "addr" placeholder="ȸ�ǽ� �ּ�"/>
		<input type="button" class="address" value="ã��">
	</div> 
	<div>
	<label>Longitude</label>
		<input type="text" id="long" name="longitude" class="longitude" placeholder="�浵" />
	
	</div>
	<div>
	<label>latitude</label>
		<input type="text" id="lati" name="latitude" class="latitude" placeholder="����" />
	
	</div>
	<input type="submit" value="���"/>
	</form>
<div id="map" style="width:100%;height:350px;"></div>
 --%>


<div class="container">
  <!-- /.col-md-4 -->
    <div width="80%">
        <div class="pricing ultimate">
            <div class="p-header">
                <div class="title">
                    <h4>ȸ�ǽ� ����</h4>
                </div>
                <div class="price">
                    <span class="dollar"></span>
                    <h2>�ǹ� �߰�</h2>
                    <span class="per"></span>
                </div>
            </div>
            <form action="addSite.do" method="post">
            <div class="list-group">
                <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; 
                	<strong class="text-uppercase">�ǹ��̸�</strong>
                	<input type="text" id="siteName" name="siteName" placeholder="�ǹ��̸�"/>
                	    
                </a>
                <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; 
                	<strong class="text-uppercase">�ǹ���ȣ</strong>
                	<input type="text" id="siteNo" name="siteNo" placeholder="�ǹ���ȣ" value="${siteSeq}"/>    
                </a>
                <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; 
                	<strong class="text-uppercase">�ǹ��ּ�</strong>
                	<input type="text" name="siteAddr" id="siteAddr" class = "addr" placeholder="ȸ�ǽ� �ּ�"/>
                	<input type="button" class="address" value="ã��">
                </a>
                <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; 
                	<strong class="text-uppercase">�浵</strong>
                	<input type="text" id="long" name="longitude" class="longitude" placeholder="�浵" />    
                </a>
                <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; 
                	<strong class="text-uppercase">����</strong>
                	<input type="text" id="lati" name="latitude" class="latitude" placeholder="����" />
                </a>
            </div>
            
            <div class="p-footer">
           		<div id="map" style="width:100%;height:350px;">����</div>
                
            </div>
            <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; 
                	<input type="submit" value="���"/>
                </a>
            
        </form>    
        </div>
        <!-- /.pricing -->
    </div>
    <!-- /.col-md-4 -->
</div>










<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=0f587210b9f77ba6bcc46b789d05650e&libraries=services"></script>
<script type="text/javascript">

var mapContainer = document.getElementById('map'), // ������ ǥ���� div 
mapOption = {
    center: new daum.maps.LatLng(33.450701, 126.570667), // ������ �߽���ǥ
    level: 3 // ������ Ȯ�� ����
};  

$(document).ready(function(){
	$('.address').on('click', function() {
		// ������ �����մϴ�    
	var map = new daum.maps.Map(mapContainer, mapOption); 
	// �ּ�-��ǥ ��ȯ ��ü�� �����մϴ�
	var geocoder = new daum.maps.services.Geocoder();
	alert($('#siteAddr').val());
	// �ּҷ� ��ǥ�� �˻��մϴ�
		geocoder.addressSearch($('#siteAddr').val(), function(result, status) {

		    // ���������� �˻��� �Ϸ������ 
		     if (status === daum.maps.services.Status.OK) {
		    	 var lon = result[0].y
		    	 var lati = result[0].x
			
				$('.longitude').val(lon);
		    	$('.latitude').val(lati);
		        var coords = new daum.maps.LatLng(result[0].y, result[0].x);

		        // ��������� ���� ��ġ�� ��Ŀ�� ǥ���մϴ�
		        var marker = new daum.maps.Marker({
		            map: map,
		            position: coords
		        });

		        // ����������� ��ҿ� ���� ������ ǥ���մϴ�
		        var infowindow = new daum.maps.InfoWindow({
		            content: '<div style="width:150px;text-align:center;padding:6px 0;">�츮ȸ��</div>'
		        });
		        infowindow.open(map, marker);

		        // ������ �߽��� ��������� ���� ��ġ�� �̵���ŵ�ϴ�
		        map.setCenter(coords);
		    } 
		});
	})
 })
</script>

</body>
</html>