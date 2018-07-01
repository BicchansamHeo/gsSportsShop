<%--
subject    : addConference.jsp
author     : ������
date       : 2018. 6. 15.
description : ȸ�ǽ��� �߰��ϴ� ������
 
  [�̸�]   [������]     [����]
  ----------------------------------------------------------
    ������	2018-06-15	�ʾ� ���ε�
    ������	2018-06-16	������ ������ �ϼ�
    ������	2018-06-17	�������� �� �籸��
    ������	2018-06-18	������ ������ �����
    ������	2018-06-19	���� �߰� ���� ����
    ������	2018-06-20	������ ���������� ����, ��� ����ȵǴ� �������� ����
    
--%>



<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="viewport" content="initial-scale=1.0">

</head>
<script src="/invent-v1.0/js/jquery-2.1.4.min.js"></script>
<body>
<%--
<h1>ȸ�ǽ� ���</h1>
	<form action="addConf.do" method="post" enctype="multipart/form-data">
		<div>
			<label>ȸ�ǽ� �̸�</label> <input type="text" name="confName"
				placeholder="ȸ�ǽ� �̸�" />
		</div>
		<div>
			<label>ȸ�ǽ� �ּ�</label> <select class="confAddr" name="confAddr">
					<option value="ȸ�ǽ� ����">ȸ�ǽ� ����</option> 
				<c:forEach var="list" items="${selectList}" varStatus="status">
					<option value="${list.siteName}">${list.siteName}</option>
				</c:forEach>
			</select>
		</div>
		<div>
			<label>ȸ�ǽ� ����</label> <input type="text" name="roomComm"
				placeholder="ȸ�ǽ� ����" />
		</div>
		<div>
			<label>ȸ�ǽ� ����</label> <select name="roomKind">
				<option value="conference">ȸ�ǽ�</option>
				<option value="education">������</option>
			</select>
		</div>
		<div>
			<label>�� ũ��</label> <input type="text" name="roomSize" />
		</div>
		<div>
			<label>��Ʈ��ũ ��뿩��</label> <select name="network">
				<option value="Y">Y</option>
				<option value="N">N</option>
			</select> <label>�ִ� �����ο�</label> <input type="text" name="maxPeople" />
		</div>

		<div>
			<label>ȸ�ǽ� ���� ����</label> <input type="text" name="roomState" />
		</div>
		<div>
			<label>�뿩��</label> <input type="text" name="roomPrice"
				placeholder="30�д� �⺻ ����" />
		</div>
		<div>
			<label>���λ�������</label> <input multiple="multiple" type="file"
				name="mainFile" /> <label>ȸ�ǽ� �̸�</label><input type="text" name="src" />
		</div>
		<div>
			<label>��������</label> <input multiple="multiple" type="file"
				name="file" /> <label>ȸ�ǽ� �̸�</label><input type="text" name="src" />
		</div>
		<div>
			<label>longitude</label> <input type="text" id="long"
				name="longitude" />
		</div>
		<div>
			<label>latitude</label> <input type="text" id="lati" name="latitude" />
		</div>
		<div>
		<label>�����縮��Ʈ</label> <select id="temp" class="fix" name="fix">
		
				<c:forEach var="list" items="${fixList}" varStatus="status">
					<option value="${list.fixName}">${list.fixName}</option>
				</c:forEach>
			</select>
		<table id="table">
		
		
		</table>
		<input type="button" id="addTR" value="�߰�">
		<div>
		<input type="hidden" id="siteNo" name="siteNo">
		</div>
		<div>
		<input type="hidden" id="siteAddr" name="siteAddr">
		</div>
		<input type="hidden" id="cnt" name="cnt">
		</div>
		<div>
		<input type="hidden" id="roomSeq" name="roomSeq" value="${roomSeq}">
		</div>
		
		<div>
		<c:forEach var="list" items="${roomCount}" varStatus="status">
		<label>ī��Ʈ</label><input type="text" name="roomCnt" value="${list.count}">
		</c:forEach>
		</div>
		<input type="submit" value="���" />
	</form>

 --%>


   <div class="container">
       <div class="pricing professional">
           <div class="p-header">
               <div class="title">
                   <h4>ȸ�ǽ� ����</h4>
               </div>
               <div class="price">
                   <span class="dollar"></span>
                   <h2>ȸ�ǽ� �߰�</h2>
                   <span class="per"></span>
               </div>
           </div>
           <form action="addConf.do" method="post" enctype="multipart/form-data">
           <div class="list-group">
             <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; 
             	<strong class="text-uppercase">üũǥ�ô� �ʼ� �Է� �����Դϴ�.</strong>
             </a>                
             <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; 
             	<strong class="text-uppercase">ȸ�ǽ� �̸���������</strong>
             	<input type="text" name="confName" placeholder="ȸ�ǽ� �̸�" />
             </a>                 
             <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; 
             	<strong class="text-uppercase">�ǹ����á���������</strong>
               	<select class="confAddr" name="confAddr">
				<option value="ȸ�ǽ� ����">�ǹ� ����</option> 
				<c:forEach var="list" items="${selectList}" varStatus="status">
				<option value="${list.siteName}">${list.siteName}</option>
				</c:forEach>
			</select>	    
             </a>
             <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; 
             	<strong class="text-uppercase">ȸ�ǽ� ����������</strong>
             	<input type="text" name="roomComm" placeholder="ȸ�ǽǼ���" />    
             </a>
             <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; 
             	<strong class="text-uppercase">ȸ�ǽ�������������</strong>
             	<select name="roomKind">
					<option value="conference">ȸ�ǽ�</option>
					<option value="education">������</option>
				</select>
             </a>
             <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; 
             	<strong class="text-uppercase">�� ũ�⡡����������</strong>
             	<input type="text" name="roomSize" />m�� 
             </a>
             <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; 
             	<strong class="text-uppercase">�ִ� �����ο�������</strong>
             	<input type="text" name="maxPeople" />��    
             </a>
             <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; 
	            <strong class="text-uppercase">��Ʈ��ũ ��뿩�Ρ�</strong>
	           	<select name="network">
					<option value="Y">Y</option>
					<option value="N">N</option>
				</select> 
             </a>
             <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; 
             	<strong class="text-uppercase">ȸ�ǽ� ���� ���¡���</strong>
             	 <input type="text" name="roomState" />    
             </a>
             <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; 
             	<strong class="text-uppercase">�뿩�ᡡ����������</strong>
             	 <input type="text" name="roomPrice" placeholder="30�д� �⺻ ����" />
             </a>
             <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; 
             	<strong class="text-uppercase">�����縮��Ʈ������</strong>
					 <select id="temp" class="fix" name="fix">
						<c:forEach var="list" items="${fixList}" varStatus="status">
							<option value="${list.fixName}">${list.fixName}</option>
						</c:forEach>
				</select>
				<input type="button" id="addTR" value="�߰�">
             </a>
			<table id="table">
			
			
			</table>             	 
						<div>
						<input type="hidden" id="siteNo" name="siteNo">
						</div>
						<div>
						<input type="hidden" id="siteAddr" name="siteAddr">
						</div>
						<div>
						<input type="hidden" id="cnt" name="cnt">
						</div>
						<div>
						<input type="hidden" id="roomSeq" name="roomSeq" value="${roomSeq}">
						</div>
						
					<div>
						<c:forEach var="list" items="${roomCount}" varStatus="status">
						<label>ī��Ʈ</label><input type="text" name="roomCnt" value="${list.count}">
						</c:forEach>
					</div>
                           
            <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; 
             	<strong class="text-uppercase">ȸ�ǽ� ��ǥ��������
             	      <input type="text" name="src" placeholder="(ȸ�ǽ��̸� �Է�)"   />    
             	</strong>
             	<input multiple="multiple" type="file" name="mainFile" />   
             </a>
             <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; 
             	<strong class="text-uppercase">��Ÿ��������������
             	      <input type="text" name="src" placeholder="(ȸ�ǽ��̸� �Է�)"   />    
             	</strong>
             	<input multiple="multiple" type="file" name="file" /> 
             </a>

    

              
              
           </div>
           <div class="p-footer">
          		 <input type="submit" value="���"  class="btn adv-color squre" />
           </div>
           <!-- /list group -->
          	<input type="hidden" id="long" name="longitude" />    
           	<input type="hidden" id="lati" name="latitude" />   


           
       </form>              
       </div>
       <!-- /.pricing professional -->
</div>













	<script>
	var cnt=0;
	var i = 0;
	var j = 0;
		$(function() {
			$("#addTR").click(function() {
				i++;
				j++;
				cnt++;
				var select = $('#temp').val(); // ����Ʈ�� ��
				var fixName;
				$.ajax({
					url : "/getFixList.do?fixName=" + select,
					type : "GET",
					dataType : 'json',
					success : function(data) {
						for(var k = 0; k < data.data.length; k++) {
							if(data.data[k].fixName == select) {
								price = data.data[k].price;
							}
						}
						var row = "<tr>";
						row += "<td><label>������ �̸�</label><input type='text' name='FN" + i + "' value='" + select + "' placeholder='�������̸�'/></td>";
						row += "<td><label>����</label><input type='text' name='QU" + i + "' value='' placeholder='����ʱⰪ'/></td>"; 
						row += "<td><label>���� : </label><span>" + price + "</span><td>";
						row += "<td><input type='button' id='delete' value='����'><td>";
						row += "</tr>";
						$("#table").append(row);
						$("#cnt").val(cnt);
					}
				});
				
			});
			
			$("#table").on("click", "#delete", function() {
				i--;
				cnt--;
				$(this).closest("tr").remove();
			});
		});

		$('.confAddr').on('change', function() {
			var select = $(this).val(); // ����Ʈ�� ��

			$.ajax({
				url : "/getSiteLD.do?siteName=" + select,
				type : "GET",
				dataType : 'json',
				success : function(data) {
					$('#siteAddr').val(data.data[0].siteAddr);
					$('#siteNo').val(data.data[0].siteNo);
					$('#long').val(data.data[0].longitude);
					$('#lati').val(data.data[0].latitude);
				}
			});

		})
	</script>
</body>
</html>