var app = angular.module('myApp', []);

app.controller('TabsCtrl', ['$scope','$http','$window',function ($scope,$http,$window) {
	
    $scope.complaint = {title:"", comment:""};
    /*$scope.items=[];
   // $scope.items = ["Apple", "Banana", "Orange"];
    $scope.init = function (name) {

      $scope.tempVar = name;
       $scope.temp = name.replace('[','').replace(']','');
       //console.log($scope.temp );
       $scope.items = $scope.temp.split(',');         
            //console.log($scope.adminTimeArray);
            //$scope.items.push();
        
    	
    	
    	//console.log(typeof(name));
    }*/
   // $scope.loading=false;
    $scope.toggle = function (complaintForm) {
    	//console.log($scope.complaint.title+" "+$scope.complaint.comment);
    	 
    	$scope.loading=true;
    	 $http({
             method: 'POST',
             url: '/realimage/link',
             data:  {distributor: $scope.complaint.title, region:$scope.complaint.comment},
             headers: {
                 'Content-Type': 'application/text',
                 'Accept':'application/text',
               }
                
                 
         })  
         .success(function(data, status,response){
         	
        	 if(angular.equals(data,"invalid"))
          		alert("invalid region");
        	 else
        	    $scope.output=data;
        	 
        	complaintForm.$setPristine();
        	$scope.complaint.title="";
        	$scope.complaint.comment="";
        	
         	//alert("Your response submitted successfully");
        	//$window.location.href = 'success';
         	$scope.loading=false;
         	//console.log(data);
         	
         	
         })
         .error(function(data, status){
             // login failure
        	// alert("error");
    	});
		 
    
	};
    	
    	
	
	   	
}]);

app.controller('adminCtrl', ['$scope','$http','$window',function ($scope,$http,$window) {
	
    $scope.complaint = {title:"", comment:"",exclude:"",parent:""};
    /*$scope.items=[];
   // $scope.items = ["Apple", "Banana", "Orange"];
    $scope.init = function (name) {

      $scope.tempVar = name;
       $scope.temp = name.replace('[','').replace(']','');
       //console.log($scope.temp );
       $scope.items = $scope.temp.split(',');         
            //console.log($scope.adminTimeArray);
            //$scope.items.push();
        
    	
    	
    	//console.log(typeof(name));
    }*/
   // $scope.loading=false;
    $scope.toggle = function (complaintForm) {
    	//console.log($scope.complaint.title+" "+$scope.complaint.comment);
    	 
    	$scope.loading=true;
    	 $http({
             method: 'POST',
             url: '/sample/add',
             data:  {distributor: $scope.complaint.title, include:$scope.complaint.comment,exclude:$scope.complaint.exclude,parent:$scope.complaint.parent},
             headers: {
                 'Content-Type': 'application/text',
                 'Accept':'application/text',
               }
                
                 
         })  
         .success(function(data, status,response){
         	
        	complaintForm.$setPristine();
        	$scope.complaint.title="";
        	$scope.complaint.comment="";
        	$scope.complaint.exclude="";
        	$scope.complaint.parent="";
        	
         	//alert("Your response submitted successfully");
        	//$window.location.href = 'success';
         	$scope.loading=false;
         	//console.log(data);
         	$scope.output=data;
         	
         })
         .error(function(data, status){
             // login failure
        	// alert("error");
    	});
		 
    
	};
    	
    	
	
	   	
}]);





