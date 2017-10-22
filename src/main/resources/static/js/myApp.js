var app = angular.module('myBankApp',[]);

app.controller("myBankController",function ($scope,$http) {
    $scope.compte=null
    $scope.CodeCompte=null;
    $scope.pageOperations=[];
    $scope.pageCourante=0;
    $scope.sizePage =3;
    $scope.pages =[];
    $scope.messagError=null;
    $scope.operation={type:"retrait", montant:0,codeCompte2:null};
    $scope.chargerCompte=function () {
        $scope.pageCourante=0;
        $http.get("/comptes/"+$scope.CodeCompte).success(function (data) {
            $scope.compte=data;
            $scope.chargerOperation();
        })
            .error( function (data)  {
                $scope.messagError=data.message;
                $scope.compte=null;
            });

    }


    $scope.goToPage =function (p) {
        $scope.pageCourante= p;
        $scope.chargerOperation();
        
    }

    $scope.chargerOperation =function () {
        $scope.messagError=null;
        $http.get("/operations?codeCompte="+$scope.CodeCompte+"" +
            "&page="+$scope.pageCourante+"&size="+$scope.sizePage
        ).success(function (data) {
            $scope.pageOperations=data;
            $scope.pages =new Array(data.total_page);
        });
    }

    $scope.saveOperation=function () {
        var action ="" ;
        if ($scope.operation.type =="virement")
            action ="code1="+$scope.CodeCompte+"&code2="+$scope.operation.codeCompte2+"&montant="+$scope.operation.montant+"&codeEmp=1";

        else action="code="+$scope.CodeCompte+"&montant="+$scope.operation.montant+"&codeEmp=1";
        $http(
            {
                method :'PUT',
                url    :$scope.operation.type,
                data   : action,
                headers: {'Content-type': 'application/x-www-form-urlencoded'}
            }).success(function (data) {
             $scope.chargerCompte();
        }).error(function (data) {
            $scope.messagError =data.message;
        })
    }
});