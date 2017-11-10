<%@ page language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <script src="resources/assets/js/jquery-1.10.2.min.js"></script>

	<link rel="stylesheet" href="resources/assets/css/normalize.css">
    <link rel="stylesheet" href="resources/assets/css/font-awesome.min.css">
    <link rel="stylesheet" href="resources/assets/css/fontello.css">
    <link href="resources/assets/fonts/icon-7-stroke/css/pe-icon-7-stroke.css" rel="stylesheet">
    <link href="resources/assets/css/animate.css" rel="stylesheet" media="screen">
    <link rel="stylesheet" href="resources/assets/css/bootstrap-select.min.css"> 
    <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/assets/css/style.css">
    <link rel="stylesheet" href="resources/assets/css/responsive.css">
</head>
<body>
	<div id="preloader">
        <div id="status">&nbsp;</div>
    </div>
    
    <!--  header  -->
    <c:import url="/WEB-INF/views/include/header.jsp" />
    
        <!-- Count area -->
        <div class="count-area" style="height: 90%">
            <div class="container">
                <div class="row">
                    <div class="col-md-10 col-md-offset-1 col-sm-12 text-center page-title">
                        <!-- /.feature title -->
                        <h2>작업 현황</h2> 
                    </div>
                </div>
                <div class="row">
                		<ul class="nav nav-tabs" style="font-size: 23;">
                    		<li class="active"><a data-toggle="tab" href="#Total">Total</a></li>
                    		<li><a id="newsCounting" data-toggle="tab" href="#News">News</a></li>
                    		<li><a id="promedCounting" data-toggle="tab" href="#Promed">Promed</a></li>
                    </ul>
                    <div class="tab-content">
                    		<div id="Total" class="tab-pane fade in active">
			                	<div class="col-md-12 col-xs-12 percent-blocks m-main" data-waypoint-scroll="true">
			                    <div class="row">
			                        <div class="col-sm-3 col-xs-6">
			                            <div class="count-item">
			                                <div class="count-item-circle">
			                                    <span class="pe-7s-news-paper"></span>
			                                </div>
			                                <div class="chart" data-percent="5000">
			                                    <h2 class="percent" id="docNo"><fmt:formatNumber value="${ totalDocNum }" pattern="#,###"></fmt:formatNumber></h2>
			                                    <h5>총 작업 문서</h5>
			                                </div>
			                            </div>
			                        </div>
			                        <div class="col-sm-3 col-xs-6">
			                            <div class="count-item">
			                                <div class="count-item-circle">
			                                    <span class="pe-7s-junk"></span>
			                                </div>
			                                <div class="chart" data-percent="5000">
			                                    <h2 class="percent"  id="noDocNo"><fmt:formatNumber value="${ totalNoDocNum }" pattern="#,###"></fmt:formatNumber> ( <fmt:formatNumber value="${ totalEventDocNo }" pattern="#,###"></fmt:formatNumber> )</h2>
			                                    <h5>작업 제외 문서 (작업 대상)</h5>
			                                </div>
			                            </div> 
			                        </div>
			                        
			                        <div class="col-sm-3 col-xs-6">
			                            <div class="count-item">
			                                <div class="count-item-circle">
			                                    <span class="pe-7s-light"></span>
			                                </div>
			                                <div class="chart" data-percent="12000">
			                                    <h2 class="percent" id="eventNo"><fmt:formatNumber value="${ totalEventNum }" pattern="#,###"></fmt:formatNumber> ( <fmt:formatNumber value="${ totalDistinctEventNum }" pattern="#,###"></fmt:formatNumber> ) </h2>
			                                    <h5>Event (중복 제외)</h5>
			                                </div>
			                            </div> 
			                        </div> 
			                        <div class="col-sm-3 col-xs-6">
			                            <div class="count-item">
			                                <div class="count-item-circle">
			                                    <span class="pe-7s-link"></span>
			                                </div>
			                                <div class="chart" data-percent="120">
			                                    <h2 class="percent" id="entityNo"><fmt:formatNumber value="${ totalEntityNum }" pattern="#,###"></fmt:formatNumber></h2>
			                                    <h5>Entity</h5>
			                                </div>
			                            </div> 
			                        </div> 
			                    </div>
			                </div>
                    		</div>
                    		<div id="News" class="tab-pane fade">
                    			<div class="col-md-12 col-xs-12 percent-blocks m-main" data-waypoint-scroll="true">
			                    <div class="row">
			                        <div class="col-sm-3 col-xs-6">
			                            <div class="count-item">
			                                <div class="count-item-circle">
			                                    <span class="pe-7s-news-paper"></span>
			                                </div>
			                                <div class="chart" data-percent="5000">
			                                    <h2 class="percent" id="newsDocNum"><fmt:formatNumber value="${ newsDocNum }" pattern="#,###"></fmt:formatNumber></h2>
			                                    <h5>총 작업 문서</h5>
			                                </div>
			                            </div>
			                        </div>
			                        <div class="col-sm-3 col-xs-6">
			                            <div class="count-item">
			                                <div class="count-item-circle">
			                                    <span class="pe-7s-junk"></span>
			                                </div>
			                                <div class="chart" data-percent="5000">
			                                    <h2 class="percent"  id="noDocNo"><fmt:formatNumber value="${ newsNoDocNum }" pattern="#,###"></fmt:formatNumber> ( <fmt:formatNumber value="${ newsEventDocNo }" pattern="#,###"></fmt:formatNumber> )</h2>
			                                    <h5>작업 제외 문서 (작업 대상)</h5>
			                                </div>
			                            </div> 
			                        </div>
			                        
			                        <div class="col-sm-3 col-xs-6">
			                            <div class="count-item">
			                                <div class="count-item-circle">
			                                    <span class="pe-7s-light"></span>
			                                </div>
			                                <div class="chart" data-percent="12000">
			                                    <h2 class="percent" id="eventNo"><fmt:formatNumber value="${ newsEventNum }" pattern="#,###"></fmt:formatNumber> ( <fmt:formatNumber value="${ newsDistinctEventNum }" pattern="#,###"></fmt:formatNumber> ) </h2>
			                                    <h5>Event (중복 제외)</h5>
			                                </div>
			                            </div> 
			                        </div> 
			                        <div class="col-sm-3 col-xs-6">
			                            <div class="count-item">
			                                <div class="count-item-circle">
			                                    <span class="pe-7s-link"></span>
			                                </div>
			                                <div class="chart" data-percent="120">
			                                    <h2 class="percent" id="entityNo"><fmt:formatNumber value="${ newsEntityNum }" pattern="#,###"></fmt:formatNumber></h2>
			                                    <h5>Entity</h5>
			                                </div>
			                            </div> 
			                        </div> 
			                    </div>
			                </div>
                    		</div>
                   		<div id="Promed" class="tab-pane fade">
                   			<div class="col-md-12 col-xs-12 percent-blocks m-main" data-waypoint-scroll="true">
			                    <div class="row">
			                        <div class="col-sm-3 col-xs-6">
			                            <div class="count-item">
			                                <div class="count-item-circle">
			                                    <span class="pe-7s-news-paper"></span>
			                                </div>
			                                <div class="chart" data-percent="5000">
			                                    <h2 class="percent" id="docNo"><fmt:formatNumber value="${ promedDocNum }" pattern="#,###"></fmt:formatNumber></h2>
			                                    <h5>총 작업 문서</h5>
			                                </div>
			                            </div>
			                        </div>
			                        <div class="col-sm-3 col-xs-6">
			                            <div class="count-item">
			                                <div class="count-item-circle">
			                                    <span class="pe-7s-junk"></span>
			                                </div>
			                                <div class="chart" data-percent="5000">
			                                    <h2 class="percent"  id="noDocNo"><fmt:formatNumber value="${ promedNoDocNum }" pattern="#,###"></fmt:formatNumber> ( <fmt:formatNumber value="${ promedEventDocNo }" pattern="#,###"></fmt:formatNumber> )</h2>
			                                    <h5>작업 제외 문서 (작업 대상)</h5>
			                                </div>
			                            </div> 
			                        </div>
			                        
			                        <div class="col-sm-3 col-xs-6">
			                            <div class="count-item">
			                                <div class="count-item-circle">
			                                    <span class="pe-7s-light"></span>
			                                </div>
			                                <div class="chart" data-percent="12000">
			                                    <h2 class="percent" id="eventNo"><fmt:formatNumber value="${ promedEventNum }" pattern="#,###"></fmt:formatNumber> ( <fmt:formatNumber value="${ promedDistinctEventNum }" pattern="#,###"></fmt:formatNumber> ) </h2>
			                                    <h5>Event (중복 제외)</h5>
			                                </div>
			                            </div> 
			                        </div> 
			                        <div class="col-sm-3 col-xs-6">
			                            <div class="count-item">
			                                <div class="count-item-circle">
			                                    <span class="pe-7s-link"></span>
			                                </div>
			                                <div class="chart" data-percent="120">
			                                    <h2 class="percent" id="entityNo"><fmt:formatNumber value="${ promedEntityNum }" pattern="#,###"></fmt:formatNumber></h2>
			                                    <h5>Entity</h5>
			                                </div>
			                            </div> 
			                        </div> 
			                    </div>
			                </div>
                    		</div>
                    </div>
                </div>
            </div>
        </div>
        
        <script src="resources/assets/js/modernizr-2.6.2.min.js"></script>
        <script src="resources/assets/js/jquery-1.10.2.min.js"></script> 
        <script src="resources/bootstrap/js/bootstrap.min.js"></script>
        <script src="resources/assets/js/bootstrap-select.min.js"></script>
        <script src="resources/assets/js/bootstrap-hover-dropdown.js"></script>
        <script src="resources/assets/js/easypiechart.min.js"></script>
        <script src="resources/assets/js/jquery.easypiechart.min.js"></script>
        <script src="resources/assets/js/owl.carousel.min.js"></script>
        <script src="resources/assets/js/wow.js"></script>
        <script src="resources/assets/js/icheck.min.js"></script>
        <script src="resources/assets/js/main.js"></script>
    </body>
</html>