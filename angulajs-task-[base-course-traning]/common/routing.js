mainApp.config(['$stateProvider',
    function($stateProvider) {
        $stateProvider.
            state('home', {
                abstract: true,
                url: '/',
                templateUrl: 'main.html'
            }).
            state('home.search', {
                url: 'search',
                templateUrl: 'search-pane/left-tab.html',
                controller: 'TypeaheadCtrl'
            }).
            state('home.people', {
                url: 'people',
                templateUrl: 'table-pane/right-tab.html',
                controller: 'DevsListCtrl'
            })
    }]);

