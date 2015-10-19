var clover = {
    getMerchant: function(successCallback, errorCallback) {
        cordova.exec(
            successCallback,
            errorCallback,
            'CloverPlugin',
            'getMerchant',
            []
        );
    }
}
module.exports=CloverPlugin


