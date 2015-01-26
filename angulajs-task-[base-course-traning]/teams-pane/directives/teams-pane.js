mainApp.directive("teamspane", [
    function(){
    return {
        restrict: 'A',
        templateUrl: "teams-pane/teams.html",
        controller: 'teamListCtrl'
    }
}])

mainApp.controller('teamListCtrl', ['$rootScope', '$scope', 'teamSharedObj',
    function($rootScope, $scope, teamSharedObj) {
    // Handles manipulations with team
    $scope.$on('team.new', function(event) {
        console.log(event.name + " " + teamSharedObj.teams);
        $scope.items = teamSharedObj.teams;
    });
    $scope.$on('teamMember.new', function(event) {
        console.log(event.name + " " + teamSharedObj.peopleInTeam);
        $scope.devs = teamSharedObj.peopleInTeam;
    });
    $scope.selectTeam = function(teamTitle) {
        console.log("select team: " + teamTitle);
        if (typeof teamSharedObj.selected !== 'undefined'
                && teamSharedObj.selected !== teamTitle) {
            $rootScope.$broadcast("team.selected", teamTitle);
        }
        teamSharedObj.selected = teamTitle;

    }
    $scope.oneAtATime = true;
    $scope.items = teamSharedObj.teams;
    $scope.devs = teamSharedObj.peopleInTeam;

    // Handles delete case when user operates with right team section
    $scope.$on('teamMember.kickoff', function(event) {
        console.log(event.name + " " + teamSharedObj.peopleInTeam);
        $scope.devs = teamSharedObj.peopleInTeam;
    });
    $scope.kickedOff = function(team, employee) {
        teamSharedObj.removeTeamMember(team, employee);
    }

}]);

