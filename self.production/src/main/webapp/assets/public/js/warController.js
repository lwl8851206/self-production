'use strict';

/* Controllers */

var warController = angular.module('warController', []);

warController.controller('warCtrl', [ '$scope',
		function($scope) {
			// 拿到hosts参数
			/* $scope.hosts = ($routeParams.hosts == null); */
			// 获取当前的可提供切换的hosts列表
			$scope.updateWar = function() {
				var checkedBoxes = $("input:checked");
				var path = $("input[type='text'").val();
				var mode = $("select").val();
				var _arr = [];
				for (var index = 0; index < checkedBoxes.length; index++)
					_arr.push(checkedBoxes[index].value);
				
				jQuery.ajax({
					url : "war/updateWar.do",
					data : {
						"servers": _arr.join(","),
						"path": path,
						"mode": mode
					},
					success : function(data) {
						$scope.$apply(function(scope) {
							if (data != null) {
								jQuery("body").append("<div  id='alert' class='alert alert-success text-center fixed-center'  role='alert'>包" + path + "更新任务已加入任务队列中"  + "</div>");
								jQuery("#alert").fadeOut(2000, function() {
									$(this).remove();
								});
							}
						});

					}
				});
			}

		} ]);
