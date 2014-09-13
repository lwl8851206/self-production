'use strict';

/* App Module */

var hostsChangeApp = angular.module('hostsChangeApp', [
  'ngRoute',
  'hostsChangeController'
]);

hostsChangeApp.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/hostschange', {
        templateUrl: 'spring/templates/hostschangetp.jsp',
        controller: 'HostsChangeCtrl'
      }).
      when('/hostschange/:hosts', {
          templateUrl: 'spring/templates/hostschangetp.jsp',
          controller: 'HostsChangeCtrl'
      }).
      otherwise({
        redirectTo: '/hostschange'
      });
  }]);
