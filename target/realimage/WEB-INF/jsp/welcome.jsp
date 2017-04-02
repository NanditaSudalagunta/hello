<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RealImage</title>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.5/angular.min.js"></script>
<link rel="stylesheet" media="screen"
	href="<c:url value='/assets/styles/bootstrap.min.css'/>">
<link rel="stylesheet" media="screen"
	href="<c:url value='/assets/styles/bootstrap-theme.min.css'/>">
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">
<script type="text/javascript">	
 
</script>
<style>
body {
	font-family: 'Open Sans', sans-serif;
}
ul.actions {
    cursor: default;
    list-style: outside none none;
    padding-left: 0;
}

.button {
    border-color: white !important;
    color: #ffffff !important;
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

.outer.middle.inner.hover-item:hover {
	background-color: #fff;
}

</style>
</head>
<body style="background-color: #1c324a">
				
	<div class="outer">
  <div class="middle">
    <div class="inner" align="center">
     <div style="margin-bottom:60px; font-size: 60px; font-weight: 600; color: #fff">
     Real Image Challenge!
     <!-- <img src="assets/images/message.png"> -->
     </div>
      <a href="home" class="hover-item" style="font-weight: 600; text-transform: uppercase; background-color: #47bac1; width:  260px; padding: 12px 20px; border-radius: 50px; color: #fff;text-decoration:none;">
      	<!-- <img src="assets/images/button.png"> -->Check distributor region!
      </a>
      
      <!-- <a href="addDistributor" class="hover-item" style="font-weight: 600; text-transform: uppercase; background-color: #47bac1; width:  260px; padding: 12px 20px; border-radius: 50px; color: #fff;text-decoration:none;margin-left:35px;">
      	<img src="assets/images/button.png">Add distributor!
      </a> -->

    </div>
  </div>
</div>			
				
 
</body>
</html>