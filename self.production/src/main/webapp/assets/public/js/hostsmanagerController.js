'use strict';

/* Controllers */

var hostsManagerController = angular.module('hostsManagerController', []);

hostsManagerController.controller('HostsManagerCtrl', [ '$scope',
		function($scope) {
			// 拿到hosts参数
			/* $scope.hosts = ($routeParams.hosts == null); */
			// 获取当前的可提供切换的hosts列表
			$scope.loadHosts = function(owner) {
				jQuery.ajax({
					url : "hosts/getOnesHosts.do",
					data : {
						"owner" : owner
					},
					success : function(data) {
						$scope.$apply(function(scope) {
							if (data != null) {
								scope.hostsList = data.hostsList;
							}
						});

					}
				});
			}
			
			/**
			 * 更改hosts
			 */
			$scope.changeHosts = function(target) {
				jQuery.ajax({
					url : "hosts/changeHosts.do",
					data : {
						"owner" : jQuery("#server").val(),
						"hosts" : "5284"
					},
					success : function(data) {
						$scope.$apply(function(scope) {
							if (data != null) {
								location.reload();
//								$scope.loadHosts(jQuery("#server").val());
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
						"owner" : jQuery("#server").val(),
						"hosts" : hosts
					},
					success : function(data) {
						$scope.$apply(function(scope) {
							if (data != null) {
								location.reload();
//								$scope.loadHosts(jQuery("#server").val());
							}
						});

					}
				});				
			}				
			

			/**
			 *  获取某服务器下可用的hosts列表
			 */
			$scope.getOnesHostsList = function(server) {
//				$scope.loadHosts(owner);
				$scope.loadHosts(server);
			}
			
			/**
			 * 获取可用服务器列表
			 */
			$scope.getServers = function() {
				jQuery.ajax({
					url : "servers/getServers.do",
					data : {},
					success : function(data) {
						$scope.$apply(function(scope) {
							if (data != null) {
								//scope.loadHosts(jQuery("#server").val());
								$scope.servers = eval(data);
							}
						});

					}
				});					
			}
			/**
			 * 拷贝hosts
			 */
			$scope.copyHosts = function(target) {
				jQuery.ajax({
					url : "hosts/copyHosts.do",
					data : {
						"owner" : jQuery("#server").val(),
						"from" : "public",
						"hosts" : "152153"
					},
					success : function(data) {
						$scope.$apply(function(scope) {
							if (data != null) {
								//scope.loadHosts(jQuery("#server").val());
								location.reload();
							}
						});

					}
				});					
			}
			
			/**
			 * 增加hosts
			 */
			$scope.createHosts = function(target) {
				jQuery.ajax({
					url : "hosts/createHosts.do",
					data : {
						"owner" : jQuery("#server").val(),
						"hosts" : "5284"
					},
					success : function(data) {
						$scope.$apply(function(scope) {
							if (data != null) {
								location.reload();
								//scope.loadHosts(jQuery("#server").val());
							}
						});

					}
				});					
			}				
			

		} ]);
