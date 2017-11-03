<%@ page language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
	<head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>BRAT 작업결과 검수작업 보조 도구</title>

        <link href="resources/assets/css/animate.css" rel="stylesheet" media="screen">
        <link rel="stylesheet" href="resources/assets/css/bootstrap-select.min.css"> 
        <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="resources/assets/css/style.css">
        <link rel="stylesheet" href="resources/assets/css/responsive.css">
        <script src="resources/assets/js/jquery-1.10.2.min.js"></script>
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
 		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
    <div class="page-head"> 
        <div class="container">
            <div class="row">
                <div class="page-head-content">
                    <h1 class="page-title">BRAT 작업결과 검수작업 보조 도구</h1>               
                </div>
            </div>
        </div>
    </div>
    <!-- End page header -->
	
	<!-- Register Modal -->
	<div class="container">
		<div class="modal fade" id="registerModal" role="dialog">
		    <div class="modal-dialog">
    	    <!-- Modal content-->
      		<div class="modal-content">
      			<div class="modal-header">
      			<button type="button" class="close" data-dismiss="modal">&times;</button>
      				<div class="row">
	                <div class="col-lg-12">
    	                <div class="section-title text-center wow fadeInDown" data-wow-duration="2s" data-wow-delay="50ms">
        	                <h2> JOIN </h2>
                	    </div>
                	</div>
      				</div>
      			</div>
      			<div class="modal-body">
      				<div class="row">
		                <div class="col-lg-12">
        		            <form id="registerForm" action="/assist/member/register.action" method="post">
                            <div class="form-group">
                                <label for="id">ID</label>
                                <input type="text" class="form-control" name="id" id="id">
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <input type="password" class="form-control"  name="password" id="password">
                            </div>
                            <div class="form-group">
                                <label for="name">Name</label>
                                <input type="text" class="form-control"  name="name" id="name">
                            </div>
                            <div class="form-group">
                                <label for="mail">E-Mail</label>
                                <input type="email" class="form-control"  name="mail" id="mail">
                            </div>
                            <div class="text-center">
                                <button id="register" type="button" class="btn btn-default"> JOIN </button>
                            </div>
                        </form>
                		</div>
            		</div>
      			</div>
      		</div>
    	    </div>
		</div>
	</div>

    <!-- register-area -->
    <div class="register-area">
        <div class="container">
            <div class="col-md-6 col-md-offset-3">
                <div class="box-for overflow">                         
                    <div class="col-md-12 col-xs-12 login-blocks">
                        <h2>Login : </h2> 
                        <form action="/assist/account/login.action" method="post">
                            <div class="form-group">
                                <label for="id">ID</label>
                                <input type="text" class="form-control"  name="id">
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <input type="password" class="form-control" name="password">
                            </div>
                            <div class="text-center">
                                <button type="submit" class="btn btn-default"> Log in</button>
                                <button type="button" id="join" class="btn btn-default"> Join </button>
                            </div>
                        </form>
                		</div>
             	</div>
			</div>
        </div>
    </div>      
    <script>
        $(document).ready(function() {
        		$('#join').click(function() {
        			$('#registerModal').modal();
        		});
        		$('#register').click(function() {
        			if($('#id').val() == "") {
        				alert("ID를 입력하세요.");
        			} else if ($('#password').val() == "") {
        				alert("비밀번를 입력하세요.");
        			} else if($('#name').val() == "") {
        				alert("이름을 입력하세요.");
        			} else if($('#mail').val() == "") {
        				alert("mail 주소를 입력하세요.");
        			} else {
        				$('#registerForm').submit();
        			}
        		});
        })
     </script>
    </body>
</html>