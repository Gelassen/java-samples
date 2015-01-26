mainApp.factory('teamSharedObj',['$rootScope', function($rootScope) {
    return {
        selected: undefined,
        teams: [],
        peopleInTeam: {},
        feedback: {}, /*"Dmitry Lemlekh": [ "feedback" ]*/
        addNewTeam: function(item) {
            console.log("add new team: " + item);
            this.teams.push(item);
            $rootScope.$broadcast('team.new');
        },
        addTeamMembers: function(team, teamMembers) {
            for (var i = 0; i < teamMembers.length; i++) {
                // put in team as key-value pair
                this.peopleInTeam[team] = this.peopleInTeam[team] || [];
                if (this.teamMemberExists(this.peopleInTeam[team], teamMembers[i])) {
                    alert("Exists!");
                    continue;
                } else {
                    this.peopleInTeam[team].push(teamMembers[i]);
                }
            }
            if (teamMembers.length != 0) {
                $rootScope.$broadcast('teamMember.new');
            }
        },
        removeTeamMember: function(team, teamMember) {
            var idx = this.peopleInTeam[team].indexOf(teamMember);
            if (idx > -1) {
                this.peopleInTeam[team].splice(idx, 1);
                $rootScope.$broadcast('teamMember.kickoff', teamMember.name);
            }
        },
        addFeedback: function(employee, feedback) {
            // put feedback per employee as key-value pair
            if (!this.feedback[employee]) {
                this.feedback[employee] = [];
            }
            this.feedback[employee].push(feedback);
        },
        teamMemberExists: function(list, employee) {
            for (var i = 0; i < list.length; i++) {
                if (angular.equals(list[i], employee)) {
                    return true;
                }
            }
            return false;
        }
    }
}]);