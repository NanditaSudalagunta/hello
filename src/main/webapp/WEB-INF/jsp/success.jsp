<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "h
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MyLister</title>

<link rel="stylesheet" media="screen"
	href="<c:url value='/assets/styles/bootstrap.min.css'/>">
<link rel="stylesheet" media="screen"
	href="<c:url value='/assets/styles/bootstrap-theme.min.css'/>">
<link rel="stylesheet" media="screen"
	href="<c:url value='/assets/bower_components/font-awesome/css/font-awesome.min.css'/>">
<style>
.header_page {
	box-sizing: border-box;
	z-index: 99999;
	overflow: hidden;
	color: #ffffff;
	width: 100%;
	background-color: #1c324a;
	height: 80px;
	top: 0;
	position: fixed;
	left: 0;
}

.footer_page {
	box-sizing: border-box;
	z-index: 99999;
	overflow: hidden;
	color: #ffffff;
	width: 100%;
	background-color: #1c324a;
	height: 60px;
	bottom: 0;
	position: fixed;
	left: 0;
}

.footercontainer {
	width: 960px;
	margin: 0 auto;
	float: left;
	padding-left: 90px;
	padding-top: 18px;
	font-size: 11px;
}

.align-right {
	float: right;
}

.thank {
	display: table-cell;
	vertical-align: middle;
}

.outer {
    display: table;
    position: absolute;
    height: 100%;
    width: 100%;
}

.middle {
    display: table-cell;
    vertical-align: middle;
}

.inner {
    margin-left: auto;
    margin-right: auto; 
    width: /*whatever width you want*/;
}
</style>

</head>
<body>
	<div class="header_page">

		<div class="left" style="margin-left: 44px; margin-top: 9px;margin-left:20px;">
			<div class="col-xs-2">
				<div class="col-xs-1">
					<a href="welcome" style="text-decoration: none; color: inherit;"><i
						class="fa fa-home fa-3x" aria-hidden="true"></i></a>
				</div>
				<div class="col-xs-1 col-xs-offset-1" style="margin-top: 6px;">
					<img class="rsysLogo" src="assets/images/lister_logo.png"
						width="160px">
				</div>
			</div>
		</div>
	</div>

	<div class="outer" >
		<div class="middle">
			<div class="inner" align="center">

				<div style="margin-bottom: 15px;">
					<img src="assets/images/thank.PNG">
				</div>
				<span style="font-size: 12px; font-style: italic;">Thank you
					for your feedback.Your message has been delivered.</span>

			</div>
		</div>
	</div>
	<!-- <div class="container" style="margin-top:100px;" align="center">
				 <div class="thank">	
				   <div style="margin-bottom:15px;"><img src="assets/images/thank.png"></div>		  
				    <span style="font-size:12px;font-style:italic;">Thank you for your feedback.Your message has been delivered.</span> 
				 </div>
				 <span class="align-right">
				  <a href="menu" style="text-decoration:none;"><button  class="btn" style="background-color: #009587 !important;color:#fff;margin-left:-15px;">Click here to go back</button></a>
				 </span>
				</div> -->
	<div class="footer_page">

		<div class="footercontainer">
			<p>© Lister Technologies, 2017. All rights reserved.</p>
		</div>

	</div>

</body>
</html>