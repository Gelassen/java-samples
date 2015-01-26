mainApp.directive("addNewTeam", ['teamSharedObj', function (teamSharedObj) {
    return {
        restrict: 'A',
        link: function( scope, element, attrs ) {
            element.bind('click', function() {
                scope.$apply(function() {
                    console.log(scope.teamName);
                    teamSharedObj.addNewTeam(scope.teamName);
                })
            });
        },
        isValid: function() {
            console.log("Validation hit!");
            return false;
        }
    }
}])