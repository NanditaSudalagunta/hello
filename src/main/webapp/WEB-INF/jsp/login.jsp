<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd" >
<!-- saved from url=(0321)https://d3c33hcgiwev3.cloudfront.net/_c97e6d7d64d1543c1f4fdac32f72c68f_contactus.html?Expires=1475020800&Signature=eKR7wKGTY0bzT4LiC6EKqB-6cl5sOuAcf3lbvWTmk5NQ8G9zXDW5~lwLK1dXSt6ZGiIrQAfTw6HcFSHk63zxCYaJALCKHIDZ8DAlp0vv5KAOqXFW-b83gT2VbsvFSNdLfITs6FhkmtcFY-eRzJPnVVDcBx6hU2SivJL8G35w8wI_&Key-Pair-Id=APKAJLTNE6QMUY6HBC5A# -->
<html lang="en" ng-app="myApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head 
         content must come *after* these tags -->
<title>MyLister</title>
<script type="text/javascript"
	src="<c:url value='/assets/scripts/jquery-1.10.2.min.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/assets/bower_components/angular/angular.min.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/assets/scripts/app.js'/>"></script>

<link rel="stylesheet" media="screen"
	href="<c:url value='/assets/styles/bootstrap.min.css'/>">
<link rel="stylesheet" media="screen"
	href="<c:url value='/assets/styles/bootstrap-theme.min.css'/>">
<link rel="stylesheet" media="screen"
	href="<c:url value='/assets/bower_components/font-awesome/css/font-awesome.min.css'/>">
<!-- endbuild -->
</head>

<body data-pinterest-extension-installed="cr1.40">

	<div class="container" ng-controller="ContactController" style="margin-left:444px;margin-top:300px;">
       <span class="text-danger" ng-model="feedback.error">{{ feedback.error }}</span>
		<div class="row row-content">
			<div class="col-xs-12">
				<!-- <h3>Login</h3> -->
			</div>
			<div class="col-xs-12 col-sm-9">
				<form class="form-horizontal" name="feedbackForm"
					ng-submit="sendFeedback()" novalidate>
					<div class="form-group"
						ng-class="{ 'has-error' : feedbackForm.firstname.$error.required && !feedbackForm.firstname.$pristine }">
<!-- 						<label for="firstname" class="col-sm-2 control-label">User Name</label>
 -->						
                           <div class="col-sm-2">Username</div>
                           <div class="col-sm-8">
							<input type="text" class="form-control" id="firstname"
								name="firstname" placeholder="Username"
								ng-model="feedback.firstName" required> <span
								ng-show="feedbackForm.firstname.$error.required && !feedbackForm.firstname.$pristine"
								class="help-block">Username required.</span>
						</div>
					</div>
					<div class="form-group"
						ng-class="{ 'has-error' : feedbackForm.lastname.$error.required && !feedbackForm.lastname.$pristine }">
<!-- 						<label for="lastname" class="col-sm-2 control-label">Password</label>
 -->						<div class="col-sm-2">Password</div>
                         <div class="col-sm-8">
							<input type="password" class="form-control" id="lastname"
								name="lastname" placeholder="Password"
								ng-model="feedback.lastName" required> <span
								ng-show="feedbackForm.lastname.$error.required && !feedbackForm.lastname.$pristine"
								class="help-block">Password required.</span>
						   </div>
					</div>
					<div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" ng-disabled="feedbackForm.$invalid" style="margin-left:-148px;" class="btn btn-primary">Login</button>
                        </div>
                    </div>				
					
				</form>
			</div>
			<!-- <div class="col-xs-12 col-sm-3">
				<h3>Your Current Feedback:</h3>
				<p>{{feedback.firstName}} {{feedback.lastName | uppercase }}</p>
			</div> -->
		</div>

	</div>


</body>
</html>