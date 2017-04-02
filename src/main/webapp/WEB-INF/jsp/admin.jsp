<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd" >
<html lang="en" ng-app="myApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Real Image</title>
<script type="text/javascript"
	src="<c:url value='/assets/scripts/jquery-1.10.2.min.js'/>"></script>
<%-- <script type="text/javascript"
	src="<c:url value='/assets/bower_components/angular/angular.min.js'/>"></script> --%>
<script type="text/javascript"
	src="<c:url value='/assets/scripts/angular.min.js'/>"></script>
<%-- <script type="text/javascript"
	src="<c:url value='/assets/bower_components/angular/angular-drag-and-drop-lists.min.js'/>"></script> --%>
<!-- <script src="http://cdnjs.cloudflare.com/ajax/libs/angular-ui-bootstrap/0.9.0/ui-bootstrap-tpls.min.js"></script>
 --><script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-material-design/0.2.1/js/material.min.js"></script>
	
<script type="text/javascript"
	src="<c:url value='/assets/scripts/app.js'/>"></script>

<link rel="stylesheet" media="screen"
	href="<c:url value='/assets/styles/bootstrap.min.css'/>">
<link rel="stylesheet" media="screen"
	href="<c:url value='/assets/styles/bootstrap-theme.min.css'/>">
<link rel="stylesheet" media="screen"
	href="<c:url value='/assets/bower_components/font-awesome/css/font-awesome.min.css'/>">
<link rel="stylesheet" media="screen"
	href="<c:url value='/assets/styles/mystyles.css'/>">
<link rel="stylesheet" media="screen"
	href="<c:url value='/assets/styles/simple.css'/>">
	
	<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-material-design/0.2.1/css/material.min.css" />

<style>
.tabs_check {
	list-style: none;
	padding: 0;
	margin: 0;
}

.list_check {
	float: left;
	border-bottom-width: 0;
	margin: 3px 3px 0px 3px;
	padding: 5px 5px 0px 5px;
	background-color: #fff;
	color: #696969;
	padding: 12px 56px;
	margin-bottom: -1px;
	
}

#mainView {
	clear: both;
	padding: 0 1em;
	border: 1px solid #eee;
	margin: 3px;
}

.active {
	background-color: #47bac1;
	color: #fff;
	border: 1px solid #47bac1 ;
	border-bottom: none;
	border-radius:4px;

}

#pointer_check td{
   cursor: pointer; 
   cursor: hand;
}

.export_button{
  color:#fff;
  background-color:#45A4C0;
  border-color:#000;
  border-radius: 4px;
  padding: 2px 14px;
}


.form-control-wrapper{
   border-color:#757575 !important;
}

body {
    background-color: #fff;
}

.material-input::after{
   color: #009587 !important;

}

.header_page{

  box-sizing: border-box;
    z-index: 99999;
    overflow: hidden;
    color: #ffffff;
    width: 100%;
    background-color:#1c324a;
    height:80px;
    top:0;
    position:fixed;
     left:0;
}


.footer_page{

  box-sizing: border-box;
    z-index: 99999;
    overflow: hidden;
    color: #ffffff;
    width: 100%;
    background-color: #1c324a;
    height:60px;
    bottom:0;
    position:fixed;
     left:0;
}

.loading {
	background-color: #EFEFEF;
	position: fixed;
	width: 100%;
	height: 100%;
	z-index: 1000;
	top: 0px;
	left: 0px;
	opacity: .6;
	filter: alpha(opacity = 50);
}

.footercontainer{
width: 960px;
    margin: 0 auto;
    float: left;
    padding-left:90px;
    padding-top:18px;
    font-size:11px;
}

.container{
	margin-top : 50px;
}



</style>

</head>
<body>
				<!-- <a ng-href="login" style="margin-left:1068px;text-decoration:none;" class="export_button">Logout</a -->
				 <div class="header_page">

		<div class="left" style="margin-left: 44px; margin-top: 9px;margin-left:20px;">
			<div class="col-xs-2">
				<div class="col-xs-1">
					<a href="welcome" style="text-decoration: none; color: inherit;"><i
						class="fa fa-home fa-3x" aria-hidden="true"></i></a>
				</div>
				<div class="col-xs-1 col-xs-offset-1" >
					<img class="rsysLogo" src="assets/images/real_image_logo.gif"
						width="135px">
				</div>
			</div>
		</div>
	</div>

		
	<div class="container">
		<div class="row">
		</div>
		<div ng-controller="adminCtrl">
         <div class="row" id="viewOne" style="margin-top:50px;margin-left:50px;">
			<div class="col-xs-12 col-sm-9">
				<form class="form-horizontal" name="complaintForm"
					ng-submit="toggle(complaintForm)" enctype="multipart/form-data" novalidate>
					<div class="form-group" 
						ng-class="{ 'has-error' : complaintForm.title.$error.required && !complaintForm.title.$pristine }" style="margin-bottom:30px;">						
                           <label>Distributor</label>
                           <div class="form-control-wrapper">
							<input type="text" class="form-control" id="title"
								name="title" placeholder="Enter distributor's name or number"
								ng-model="complaint.title" required> 
                              <small
								ng-show="complaintForm.title.$error.required && !complaintForm.title.$pristine"
								class="help-block">Distributor required.</small>
						</div>
					</div>
					<div class="form-group"
						ng-class="{ 'has-error' : complaintForm.comment.$error.required && !complaintForm.comment.$pristine }">
						<label>Include</label>
                         <div class="form-control-wrapper">                       
							<input type="text" class="form-control" id="comment"
								name="comment" placeholder="Include"
								ng-model="complaint.comment"  required>  
								
								
							<%-- <select class="form-control" id="comment"
								name="comment" placeholder="Select the region"
								ng-model="complaint.comment" required>
                            <c:forEach items="${dropdownList}" var="item">
                            <option value="${item}">${item}</option>
                            </c:forEach>
                            </select>	 --%>
                            	
                             <small
								ng-show="complaintForm.comment.$error.required && !complaintForm.comment.$pristine"
								class="help-block">Include required.</small>
						   </div>
					</div>
					
					<div class="form-group"
						ng-class="{ 'has-error' : complaintForm.exclude.$error.required && !complaintForm.exclude.$pristine }">
						<label>Exclude</label>
                         <div class="form-control-wrapper">                       
							<input type="text" class="form-control" id="exclude"
								name="exclude" placeholder="Enter the region"
								ng-model="complaint.exclude"  required>  
								
				
                            	
                             <small
								ng-show="complaintForm.exclude.$error.required && !complaintForm.exclude.$pristine"
								class="help-block">Exclude required.</small>
						   </div>
					</div>
					
					<div class="form-group">
						<label>Parent(Optional)</label>
                         <div class="form-control-wrapper">                       
							<input type="text" class="form-control" id="parent"
								name="parent" placeholder="Enter the parent ditributor's name"
								ng-model="complaint.parent">  
					
						   </div>
					</div>
					
					
                    
			       <div class="loading" ng-show="loading"><div style="margin-left:500px;margin-top:250px;"><img src="assets/images/31.gif"><b>&nbsp;&nbsp;Adding</b>
                                               </div></div> 
                        
                   <button type="submit" ng-disabled="complaintForm.$invalid"  class="btn" style="background-color: #47bac1 !important;color:#fff;margin-left:-15px;">Add</button>
                       		
					
				</form>
				
			</div>
		</div>		

		</div>
	</div>
	<div class="footer_page">
				
						<div class="footercontainer">
                       <p>© Real Image, 2017. All rights reserved.</p>
                     </div>
					
				</div> 

</body>

</html>