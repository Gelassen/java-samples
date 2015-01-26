mainApp.factory('searchService', function($resource, $q) {
    var cached;
    var deferred;

    return {
        fetch: function() {
            // try to return cached
            if (cached) {
                console.log("Return cached!");
                return $q.when(cached);
            }

            // return the same instance if we are waiting the result
            if (deferred) {
                console.log("Return promise!");
                return deferred.promise;
            }

            deferred = $q.defer();
            $resource(
                'common/mock.js',
                {},
                { get:{ method: 'GET', isArray: true} }
            ).get(
                function(response) {
                    cached = response;
                    deferred.resolve(response);
                }
            );
            return deferred.promise;
        }
    }
});