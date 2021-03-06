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
    <div class="testimonial-area recent-property">
		<div class="container">
			<div class="col-md-12 col-sm-12 text-center page-title">
				<h3>작업 할당</h3> <br/>
				<div class="row">
					<div class="col-sm-8 search-form wow pulse" data-wow-delay="0.8s" style="height: 700; overflow: scroll;">
                    		<div class="table-responsive">  
                    		  <div>
                    		  	<select class="form-control" id="weeks" title="주차 선택" style="width: 40%; border-color: grey; margin-left: auto; margin-right: auto;">
                    		  		<option value="#">주차 선택</option> 
                    		  		<c:forEach var="folder" items="${ folderList }">
	                    		  		<option name ="list" value="${ folder }">${ folder }</option>                    		  		
                    		  		</c:forEach>
                    		  	</select>
                    		  </div>  <br/>   
						  <table class="table" id="data_tbl">
						    <thead>
						      <tr>
						        <th>#</th>
						        <th>파일명</th>
						        <th>1차 작업자</th>
						        <th>2차 작업자</th>
						        <th>3차 작업자</th>
						      </tr>
						    </thead>
						    <tbody id="fileList">
						      <tr>
						      </tr>
						    </tbody>
						  </table>
						</div>
                  	</div>
                  	<div class="col-sm-1" data-wow-delay="0.8s">
                  	</div>
                  	<div class="col-sm-3" data-wow-delay="0.8s">
                    		<div class="search-form wow pulse" data-wow-delay="0.8s">
                    			<h4>작업 단계</h4>
                    			<div class="row" style="font-weight: bold;">
	                    			<input type="radio" name="step" value="1st"> 1st &nbsp;&nbsp;
	                    			<input type="radio" name="step" value="2nd"> 2nd &nbsp;&nbsp;
	                    			<input type="radio" name="step" value="3rd"> 3rd
                    			</div>
	                  	</div> <br/>
	                  	<div class="search-form wow pulse" data-wow-delay="0.8s" style="height: 500; overflow: scroll;">
	                    		<h4>작업자</h4>
	                    		<div style="text-align: left; font-weight: bold;">
		                    		<c:forEach var="member" items="${ members }">
		                    			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		                    			<input type="radio" name="memberName" value="${ member.id }"> ${ member.name } <br> 
		                    		</c:forEach>
	                    		</div>
	                  	</div><br/>
	                  	<button type="button" id="assign" class="btn btn-warning">작업 할당</button> &nbsp;&nbsp;&nbsp;
	                  	<button type="button" id="cancel" class="btn btn-warning">할당 취소</button>
                  	</div>
				</div>
			</div>
		</div>
	</div>
	<br/><br/><br/><br/>

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
        
        <script src="../resources/assets/assist_js/assign.js"></script>
    </body>
</html>