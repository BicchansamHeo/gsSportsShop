<%--
subject    : writeNotice.jsp
author     : ������
date       : 2018. 6. 19
description : �����ۼ� ������
 
  [�̸�]   [������]     [����]
  ----------------------------------------------------------
  ������	2018-06-19	�ʾ� �� ������ �ϼ�
--%>



<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title her dddddddde</title>
</head>
<body>
		<div class="row">
	      <div class="col-md-10">
	          <div class="pricing professional" style="padding: 0 30px; margin-left: 20%;">
	              <div class="p-header">
	                  <div class="title">
	                      <h4>�Խ���</h4>
	                  </div>
	                  <div class="price">
	                      <span class="dollar"></span>
	                      <h2>��������</h2>
	                      <span class="per"></span>
	                  </div>
	              </div>
	              <div class="list-group">
	              	<form action="addSite.do" method="post">
			            <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; <strong class="text-uppercase">�� ����</strong>
			                	<input type="text" id="noticeTitle" name="noticeTitle" placeholder=""/>
						</a>
		                <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; <strong class="text-uppercase">����</strong>
							<input type="text" id="noticeContent" name="noticeContent" placeholder="" style="width:400px; height:300px"/>
		                </a>
		              
		            </form>
	              </div>
	             <div class="p-footer">
	            		<input type="submit" class="btn adv-color squre"  value="���"/>
	             </div>
	          </div>
	          <!-- /.pricing -->
	       </div>
		</div>


</body>
</html>