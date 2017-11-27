<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script type="text/javascript">
	$(document).ready(function(){
		$("#logout").click(function() {
			location.href="/assist/account/logout.action";
		});
	})
</script>

<nav class="navbar navbar-default ">
	<div class="container">
    <!-- Brand and toggle get grouped for better mobile display -->
    		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navigation">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/assist/home.action"><img style="width: 150; height: 50;" src="/assist/resources/assets/img/log.jpg" alt=""></a>
		</div>
		
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse yamm" id="navigation">
			<div class="button navbar-right">
				<button id="logout" class="navbar-btn nav-button wow bounceInRight login" data-wow-delay="0.45s">Logout</button>
			</div>
			<c:choose>
				<c:when test="${ loginuser.userType == 2}" > 
		    			<ul class="main-nav nav navbar-nav">
						<li class="wow fadeInDown" data-wow-delay="0.5s"><a href="/assist/home.action">BRAT 검사 보조 도구</a></li>
		           	</ul>
					<ul class="main-nav nav navbar-nav navbar-right">
						<li class="wow fadeInDown" data-wow-delay="0.5s"><a href="/assist/home.action">HOME</a></li>
						<li class="dropdown ymm-sw " data-wow-delay="0.1s">
							<a href="#" class="dropdown-toggle active" data-toggle="dropdown" data-hover="dropdown" data-delay="200">오류 검출<b class="caret"></b></a>
							<ul class="dropdown-menu navbar-nav">
								<li>
									<a href="/assist/mentionType/mentionTypeCheck.action">MentionType 검사</a>
								</li>
								<li>
									<a href="/assist/constructure/constructureCheck.action">Event 구조 검사</a>
								</li>
								<li>
									<a href="/assist/fixDragging/goFixDraggingError.action">Dragging 오류 수정</a>
								</li>
							</ul>
						</li>
						<li class="wow fadeInDown" data-wow-delay="0.5s"><a href="/assist/concordance/goConcordance.action">검색</a></li>
						<li class="dropdown ymm-sw " data-wow-delay="0.1s">
							<a href="#" class="dropdown-toggle active" data-toggle="dropdown" data-hover="dropdown" data-delay="200"> 관리 <b class="caret"></b></a>
							<ul class="dropdown-menu navbar-nav">
								<li>
									<a href="/assist/management/goUserManagement.action"> 사용자 관리 </a>
								</li>
								<li>
									<a href="/assist/management/goAssignWork.action"> 작업 관리 </a>
								</li>
							</ul>
						</li>
		           	</ul>
				</c:when>
				<c:when test="${ loginuser.userType == 1}">
					<ul class="main-nav nav navbar-nav">
						<li class="wow fadeInDown" data-wow-delay="0.5s"><a href="/assist/home.action">BRAT 검사 보조 도구</a></li>
		           	</ul>
					<ul class="main-nav nav navbar-nav navbar-right">
						<li class="wow fadeInDown" data-wow-delay="0.5s"><a href="/assist/home.action">HOME</a></li>
						<li class="wow fadeInDown" data-wow-delay="0.5s"><a href="/assist/concordance/goConcordance.action">검색</a></li>
						<li class="wow fadeInDown" data-wow-delay="0.5s"><a href="/assist/management/goAssignWork.action"> 작업 관리 </a></li>
					</ul>
				</c:when>
		    		<c:otherwise>
		    			<ul class="main-nav nav navbar-nav">
						<li class="wow fadeInDown" data-wow-delay="0.5s"><a href="/assist/home.action">BRAT 검사 보조 도구</a></li>
		           	</ul>
		    			<ul class="main-nav nav navbar-nav navbar-right">
						<li class="wow fadeInDown" data-wow-delay="0.5s"><a href="/assist/home.action">HOME</a></li>
						<li class="wow fadeInDown" data-wow-delay="0.5s"><a href="/assist/concordance/concordance.action">검색</a></li>
		           	</ul>
		    		</c:otherwise>
			</c:choose>
		</div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>