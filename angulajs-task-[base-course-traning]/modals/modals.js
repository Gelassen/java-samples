mainApp.factory('modalsService', ['$modal',
    function($modal) {
        return {
            show: function(text) {
                var modalInstance = $modal.open({
                    templateUrl: "modals/modal-template.html",
                    controller: "modalCtrl",
                    resolve: {
                        text: function() {
                            return text;
                        }
                    }
                });
            }
        }
    }
])

mainApp.controller('modalCtrl', ['$scope', '$modalInstance', 'text', function($scope, $modalInstance, text) {
    $scope.msg = text;
    $scope.confirm = function() {
        $modalInstance.close()
    }
}
])