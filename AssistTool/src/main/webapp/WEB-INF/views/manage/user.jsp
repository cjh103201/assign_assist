<%@page import="java.util.ArrayList"%>
<%@ page language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<title>Brat Assist Home</title>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    
    <meta name="description" content="GARO is a real-estate template">
    <meta name="author" content="Kimarotec">
    <meta name="keyword" content="html5, css, bootstrap, property, real-estate theme , bootstrap template">
    <meta name="viewport" content="width=device-width, initial-scale=1">

	<!-- jQuery Version 2.1.3 -->
    <script src="../resources/assets/js/jquery-1.10.2.min.js"></script>

    <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    <link rel="icon" href="favicon.ico" type="image/x-icon">

	<link rel="stylesheet" href="../resources/assets/css/normalize.css">
    <link rel="stylesheet" href="../resources/assets/css/font-awesome.min.css">
    <link rel="stylesheet" href="../resources/assets/css/fontello.css">
    <link href="../resources/assets/fonts/icon-7-stroke/css/pe-icon-7-stroke.css" rel="stylesheet">
    <link href="../resources/assets/fonts/icon-7-stroke/css/helper.css" rel="stylesheet">
    <link href="../resources/assets/css/animate.css" rel="stylesheet" media="screen">
    <link rel="stylesheet" href="../resources/assets/css/bootstrap-select.min.css"> 
    <link rel="stylesheet" href="../resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../resources/assets/css/icheck.min_all.css">
    <link rel="stylesheet" href="../resources/assets/css/price-range.css">
    <link rel="stylesheet" href="../resources/assets/css/owl.carousel.css">  
    <link rel="stylesheet" href="../resources/assets/css/owl.theme.css">
    <link rel="stylesheet4" href="../resources/assets/css/owl.transitions.css">
    <link rel="stylesheet" href="../resources/assets/css/style.css">
    <link rel="stylesheet" href="../resources/assets/css/responsive.css">
    
    
</head>
<body>
	<div id="preloader">
        <div id="status">&nbsp;</div>
    </div>
    
    <!--  header  -->
    <c:import url="/WEB-INF/views/include/header.jsp" />
    
    <!-- Body content -->
    <!-- folder 경로 설정 -->
	<div class="testimonial-area recent-property">
		<div class="container">
			<div class="row">
				<div class="col-md-10 col-md-offset-1 col-sm-12 text-center page-title">
                     <!-- text/event-type, 연결속성, entity/entity-type/mentionType/Relation-type(all/coref), type1,2(pgen,dis/pgen,dis) 에 대한 검색 -->        
					<h3> 사용자 관리 </h3> </br>
					<table class="table" >
					    <thead>
					      	<tr class="warning">
					    	    		<th> 아이디 </th>
					       		<th> 이름 </th>
					        		<th> 이메일 </th>
					        		<th> 사용자 유형 </th>
					        		<th colspan="2" class="text-center"> 사용자 유형 변경 </th>
					        		<th> 사용자 삭제 </th>
					      	</tr>
					    </thead>
					    <tbody id="contents" >
					    		<c:forEach var="member" items="${ Members }">
					    			<tr id="low${ member.id }">
						    			<td>${ member.id }</td>
						    			<td>${ member.name }</td>
						    			<td>${ member.mail }</td>
						    			<c:choose>
						    				<c:when test="${ member.userType == '0' }">
						    					<td id="user${ member.id }" class="0"> 기본 사용자 </td>
						    				</c:when>
						    				<c:when test="${ member.userType == '1' }">
						    					<td id="user${ member.id }" class="1"> 작업자 </td>
						    				</c:when>
						    				<c:otherwise>
						    					<td id="user${ member.id }" class="2"> 관리자 </td>
						    				</c:otherwise>
						    			</c:choose>
						    			<td>
					    				<select id="userType${ member.id }" class="form-control" title="사용자 유형" style="width:auto;">
	                                 	<option value="0">기본 사용자</option>
	                                 	<option value="1">작업자</option>
	                                 	<option value="2">관리자</option>
	                                 </select>
						    			</td>
						    			<td><button type="button" onclick="changeUserType(this.id)" id="${ member.id }" class="btn btn-warning"> 변경 </button></td>
						    			<td><button type="button" onclick="deleteMember(this.id)" id="${ member.id }" class="btn btn-warning">&nbsp; 삭제 &nbsp;</button></td>
						    		</tr>
					    		</c:forEach>
					    </tbody>
					</table>
	            </div>
	        	</div>
		</div>
	</div>

        <script src="../resources/bootstrap/js/bootstrap.min.js"></script>
        <script src="../resources/assets/js/bootstrap-select.min.js"></script>
        <script src="../resources/assets/js/bootstrap-hover-dropdown.js"></script>

        <script src="../resources/assets/js/easypiechart.min.js"></script>
        <script src="../resources/assets/js/jquery.easypiechart.min.js"></script>

        <script src="../resources/assets/js/owl.carousel.min.js"></script>
        <script src="../resources/assets/js/wow.js"></script>

        <script src="../resources/assets/js/icheck.min.js"></script>
        <script src="../resources/assets/js/price-range.js"></script>

        <script src="../resources/assets/js/main.js"></script>
        
        <script src="../resources/assets/assist_js/userManage.js"></script>
    </body>
</html>