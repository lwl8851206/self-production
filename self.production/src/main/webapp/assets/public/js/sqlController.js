'use strict';

/* Controllers */

var sqlController = angular.module('sqlController', []);

sqlController.controller('sqlCtrl', [ '$scope',
		function($scope) {
			// 拿到hosts参数
			/* $scope.hosts = ($routeParams.hosts == null); */
			// 获取当前的可提供切换的hosts列表
			$scope.executeSql = function() {
				var checkedBoxes = $("input:checked");
				var sql = $("textarea").val();
				var _arr = [];
				for (var index = 0; index < checkedBoxes.length; index++)
					_arr.push(checkedBoxes[index].value);
				
				jQuery.ajax({
					url : "sql/executeSql.do",
					data : {
						"servers": _arr.join(","),
						"sql": sql
					},
					success : function(data) {
						$scope.$apply(function(scope) {
							if (data != null) {
								jQuery("body").append("<div  id='alert' class='alert alert-success text-center fixed-center'  role='alert'>sql执行任务已加入任务队列中</div>");
								jQuery("#alert").fadeOut(2000, function() {
									$(this).remove();
								});
							}
						});

					}
				});
			}

		} ]);
