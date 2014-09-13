'use strict';

/* Controllers */

var hostsChangeController = angular.module('hostsChangeController', []);

hostsChangeController.controller('HostsChangeCtrl', ['$scope',
  function($scope) {
	//拿到hosts参数
/*	$scope.hosts = ($routeParams.hosts == null);*/
	
	//获取当前的可提供切换的hosts列表
	$scope.getHosts = function() {
	
		jQuery.ajax({
			url : "hostschange/getHosts.do",
			data : {
				"isprivate": "false"
			},
			async : true,
			success : function(data) {
				
				$scope.$apply(function(scope) {
					
					var jsonData = JSON.parse(data);
					if (jsonData != null) {
						scope.hostsInfo = jsonData;
					}					
				});	
				
			}
		});		
	}
	
	$scope.clickIt = function() {
		alert("shit");
	}
	$scope.getHosts();
	
    
  }]);


