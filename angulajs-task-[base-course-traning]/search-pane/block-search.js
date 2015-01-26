mainApp.controller('TypeaheadCtrl',
    ['$rootScope', '$scope', '$http', 'searchService', 'teamSharedObj',
        function($rootScope, $scope, $http, searchService, teamSharedObj) {
            // access to web resource
            $scope.selected = undefined;
            $scope.getLocation = function(val) {
                console.log("search for: " + val);
                return searchService.fetch()
                    .then(
                        function(response){
                            var formatted = [];
                            response.map(
                                function(item) {
                                    if (item.name.toLowerCase().indexOf(val) != -1
                                            || item.grade.toLowerCase().indexOf(val) != -1
                                                || item.job.toLowerCase().indexOf(val) != -1) {
                                        formatted.push(item);
                                    }
                                });
                            return formatted;
                        }
                    );
            };
            // tags
            $scope.tags=[];
            $scope.tagsAsObjects = [];
            $scope.$on('teamMember.kickoff', function(event, data) {
                console.log(event.name + " " + teamSharedObj.peopleInTeam);
                for (var i = 0; i < $scope.tags.length; i++) {
                    var tag = $scope.tags[i].name;
                    if (tag === data) {
                        $scope.tags.splice(i, 1);
                        break;
                    }
                }
            });
            $scope.onSelect = function ($item, $model, $label) {
                $scope.tags.push($item);
                $scope.tagsAsObjects.push($item);
                $rootScope.$broadcast('tags.new', $item);

            };

            $scope.deleteTag=function(tag){
                $scope.tags.splice( $scope.tags.indexOf(tag), 1);
            }
            $scope.$on("team.selected", function(event, team) {
                $scope.tags.length = 0;
                $scope.tagsAsObjects.length = 0;
                var temp = teamSharedObj.peopleInTeam[team];
                if (typeof temp === "undefined") {
                    $scope.tags = [];
                    $scope.tagsAsObjects = [];
                } else {
                    $scope.tags = teamSharedObj.peopleInTeam[team];
                    $scope.tagsAsObjects = teamSharedObj.peopleInTeam[team];
                }

            });

            // refresh button
            $scope.turnedOff = true;
            $scope.refresh = function() {
                console.log('refresh for ' + teamSharedObj.selected + ": " + $scope.tags);
                var tagsAsArrays = [];
                for (var i = 0; i < $scope.tags.length; i++) {
                    tagsAsArrays.push($scope.tagsAsObjects[i]);
                    console.log($scope.tagsAsObjects[i]);
                }
                if (typeof teamSharedObj.selected === "undefined") {
                    alert('Please select the team');
                } else {
                    teamSharedObj.addTeamMembers(teamSharedObj.selected, tagsAsArrays);
                }
            }
        }]);


