mainApp.controller("DevsListCtrl",
    ['$rootScope', '$scope', '$log', 'searchService', 'ngTableParams', 'teamSharedObj', 'modalsService',
        function ($rootScope, $scope, $log, searchService, ngTableParams, teamSharedObj, modalsService) {

//           var myPage = parseInt($stateParams.pageNumber);

            $scope.data = [];
            searchService.fetch().then(
                function(response) {
                    $scope.data = response;
                    $scope.tableParams = new ngTableParams(
                        {
                            page: 0,
                            count: 10
                        },
                        {
                            total: $scope.data.length,
                            getData: function($defer, params) {
                                $defer.resolve($scope.data.slice((params.page() - 1) * params.count(), params.page() * params.count()));
                            }
                        });
                }
            )
            $scope.addTeamMember = function(newTeamMember) {
                teamSharedObj.addTeamMember(newTeamMember);
            }
            // control visibility state
            $scope.state = 'off';
            $scope.selected = "undefined";
            $scope.isOpen = function(employee) {
                return $scope.state === "on" && $scope.selected === employee;
            }
            // handle click on item
            $scope.onItemClick = function(employee, event) {
                event.stopPropagation();
                event.preventDefault();
                $scope.state = ($scope.state === 'on' ? 'off' : 'on');
                $scope.selected = employee;
            }
            // open appropriate feedback container
            $scope.getFeedback = function(employee) {
                return teamSharedObj.feedback[employee] || [];
            }
            $scope.submitNewFeedback = function(employee, feedback) {
                teamSharedObj.addFeedback(employee, feedback);
            }
            // add new employee to the team
            $scope.addNewTeamMember = function(employee, $event) {
                $event.stopPropagation();
                $event.preventDefault();
                if (typeof teamSharedObj.selected == 'undefined') {
                    modalsService.show("No team. Please select team.")
//                    alert("No team. Please select team.");
                    return;
                }
                var result = [];
                result.push(employee);
                teamSharedObj.addTeamMembers(teamSharedObj.selected, result);
            }
        }]);


