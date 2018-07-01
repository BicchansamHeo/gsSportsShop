<%--
subject    : 
author     : 허빛찬샘
date       : 2018. 6. 11.
description : exceptLayout 페이지. 타일즈를 적용 하지 않을 기본 틀 페이지
 
  [이름]   [수정일]     [내용]
  ----------------------------------------------------------
  허빛찬샘	2018-06-11	초안 작성
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
<head>
<title>GS ITM</title>
</head>
<body>
   <tiles:insertAttribute name="body" />                                                  
</body>
</html>