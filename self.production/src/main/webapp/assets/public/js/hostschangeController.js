'use strict';

/* Controllers */

var hostsChangeController = angular.module('hostsChangeController', []);

hostsChangeController.controller('HostsChangeCtrl', [ '$scope',
		function($scope) {
			// 拿到hosts参数
			/* $scope.hosts = ($routeParams.hosts == null); */
			// 获取当前的可提供切换的hosts列表
			$scope.loadHosts = function(owner) {
				jQuery.ajax({
					url : "hosts/getHosts.do",
					data : {
						"owner" : owner
					},
					success : function(data) {
						$scope.$apply(function(scope) {
							if (data != null) {
								scope.hostsInfo = data;
							}
						});

					}
				});
			}
			
			/**
			 * 更改hosts
			 */
			$scope.changeHosts = function(hosts) {
				jQuery.ajax({
					url : "hosts/changeHosts.do",
					data : {
						"owner" : owner
					},
					success : function(data) {
						$scope.$apply(function(scope) {
							if (data != null) {
								scope.changeResult = data;
							}
						});

					}
				});				
			}
			
			/**
			 * 删除hosts
			 */
			$scope.deleteHosts = function(hosts) {
				jQuery.ajax({
					url : "hosts/deleteHosts.do",
					data : {
						"owner" : owner
					},
					success : function(data) {
						$scope.$apply(function(scope) {
							if (data != null) {
								scope.changeResult = data;
							}
						});

					}
				});				
			}				
			

			// 获取某服务器下可用的hosts列表
			$scope.getOnesHostsList = function(target) {
//				$scope.loadHosts(owner);
				$scope.loadHosts(target.innerHTML);
			}

		} ]);
