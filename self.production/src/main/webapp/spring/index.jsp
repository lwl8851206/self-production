<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp"></jsp:include>
<body ng-controller="HostsChangeCtrl">
	<nav class="navbar navbar-inverse" role="navigation">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-9">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">TEST</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-9">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">切换hosts</a></li>
					<li><a href="#">同步数据库</a></li>
					<li><a href="#">更换war包</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
	
	<c:forEach var="server" items="${servers}">
		<c:out value="${server}" />
	</c:forEach>

	<section ng-view>
		<div class="row">
			<div class="col-md-4"></div>
			<div class="list-group">
				<a href="#" class="list-group-item disabled">共有{{hostsInfo.count}}套hosts</a>
				<a href="#" class="list-group-item"
					ng-repeat="hosts in hostsInfo.hostsList">{{hosts}}</a>
			</div>
		</div>
<!-- 	<script src="assets/lib/angular/angular-route.min.js"></script>
	<script src="assets/public/js/hostschangeapp.js"></script> -->
	<script src="assets/lib/angular/angular.min.js"></script>
	<script src="assets/public/js/hostschangeController.js"></script>
</body>
</html>