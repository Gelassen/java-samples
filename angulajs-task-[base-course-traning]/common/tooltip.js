mainApp.controller('TooltipCtrl', ['$scope', '$q', '$sce', '$tooltip',
    function($scope, $q, $sce, $tooltip) {
        $scope.tooltip = {title: 'Hello Tooltip<br />This is a multiline message!', checked: false};
    }
])