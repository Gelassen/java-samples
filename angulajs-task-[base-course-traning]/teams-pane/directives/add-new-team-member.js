mainApp.directive("addNewTeamMember", ['teamSharedObj', function (teamSharedObj) {
    return {
        restrict: 'A',
        link: function( scope, element, attrs ) {
            element.bind('click', function(e) {
                e.preventDefault();
                console.log(scope.teamMemberName)
                scope.$apply(function() {
                    if (typeof teamSharedObj.selected == 'undefined') {
                        alert("No team. Please select team.");
                        return;
                    }

                    var result = [];
                    var asObject = JSON.parse(attrs.value);
                    result.push(asObject);
                    teamSharedObj.addTeamMembers(teamSharedObj.selected, result);
                });
            });
        }
    }
}])