package com.cloversdk;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import android.accounts.OperationCanceledException;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.clover.sdk.util.CloverAccount;
import com.clover.sdk.util.CloverAuth;
import com.clover.sdk.v1.ResultStatus;
import com.clover.sdk.v1.ServiceConnector;
import com.clover.sdk.v1.merchant.Merchant;
import com.clover.sdk.v3.employees.Employee;
import com.clover.sdk.v1.merchant.MerchantAddress;
import com.clover.sdk.v1.merchant.MerchantConnector;
import com.clover.sdk.v3.employees.EmployeeConnector;
import com.clover.sdk.v1.merchant.MerchantIntent;
import com.clover.sdk.v3.employees.EmployeeIntent;
import java.text.DateFormat;
import java.util.Date;

public class CloverPlugin extends CordovaPlugin implements MerchantConnector.OnMerchantChangedListener, ServiceConnector.OnServiceConnectedListener{
    public static final String ACTION_GET_MERCHANT = "getMerchant";
    private static final String TAG = "CloverPlugin";
    
    @Override
    public void onMerchantChanged(Merchant merchant) {
        updateMerchant("merchant changed", null, merchant);
    }
    
    @Override
    public void onServiceConnected(ServiceConnector connector) {
        Log.i(TAG, "service connected: " + connector);
    }
    
    @Override
    public void onServiceDisconnected(ServiceConnector connector) {
        Log.i(TAG, "service disconnected: " + connector);
    }
    
 
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        try {
            if (ACTION_GET_MERCHANT.equals(action)) {
                startAccountChooser();
                connect();
                getMerchant();
                getEmployee();
                getToken();
		JSONObject obj = new JSONObject();
        try {
            obj.put("MerchantID", merchantID);
            obj.put("MerchantName", merchantName);
            obj.put("DeviceID", deviceID);
            obj.put("PhoneNumber", phoneNumber);
            obj.put("Address1", address1);
            obj.put("Address2", address2);
            obj.put("City", city);
            obj.put("State", state);
            obj.put("Zip", zip);
            obj.put("Country", country);
            obj.put("EmployeeEmail", employeeEmail);
            obj.put("EmployeeName", employeeName);
            obj.put("MerchantToken", merchantToken);
        } catch (JSONException e) {
            Log.e(TAG, e.getMessage(), e);
        }
        
	PluginResult result = new PluginResult(PluginResult.Status.OK, obj);
        result.setKeepCallback(true);
        callbackContext.sendPluginResult(result);

        return true;
        }
            callbackContext.error("Invalid action");
            return false;
        } catch(Exception e) {
            System.err.println("Exception: " + e.getMessage());
            callbackContext.error("Exception: " + e.getMessage());
            return false;
        }
    }
    
    private static final int REQUEST_ACCOUNT = 0;
    private MerchantConnector merchantConnector;
    private Account account;
    private Employee employee;
    private EmployeeConnector employeeConnector;
    private String merchantID;
    private String merchantName;
    private String deviceID;
    private String phoneNumber;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String employeeEmail;
    private String employeeName;
    private String merchantToken;
    
    private void startAccountChooser() {
        AccountManager accountManager = AccountManager.get(this.cordova.getActivity().getApplicationContext());
        Account[] accounts = accountManager.getAccountsByType(CloverAccount.CLOVER_ACCOUNT_TYPE);
        for (Account acc : accounts){
            account = acc;
            break;
        }
        
    }
    
    
    private void connect() {
        disconnect();
        if (account != null) {
            merchantConnector = new MerchantConnector(cordova.getActivity(), account, this);
            merchantConnector.setOnMerchantChangedListener(this);
            merchantConnector.connect();
            //added
            employeeConnector = new EmployeeConnector(cordova.getActivity(), account, this);
            //employeeConnector.setOnEmployeeChangedListener(this);
            employeeConnector.connect();
            // u added
        }
    }
    
    private void disconnect() {
        if (merchantConnector != null) {
            merchantConnector.disconnect();
            merchantConnector = null;
        }
    }
    // added
    private void getEmployee() {
        Employee employee = null;
        try {
            employee = employeeConnector.getEmployee();
        }
        catch (Exception e){
            
        }
        employeeEmail = employee.getEmail();
        employeeName = employee.getName();
    }
    // added
    private void getToken() {
		CloverAuth.AuthResult result = null;
		try {
		    result = CloverAuth.authenticate(cordova.getActivity(), account);
		} catch (OperationCanceledException e) {
          Log.e(TAG, "Authentication cancelled", e);
        } catch (Exception e) {
          Log.e(TAG, "Error retrieving authentication", e);
        }
        merchantToken = result.authToken; 
    }
    //up added
    private void getMerchant() {
        Merchant merchant = null;
        try {
            merchant = merchantConnector.getMerchant();
        }
        catch (Exception e){
            
        }
        merchantID = merchant.getId();
        merchantName = merchant.getName();
        deviceID = merchant.getDeviceId();
        phoneNumber = merchant.getPhoneNumber();
        address1 = merchant.getAddress().getAddress1();
        address2 = merchant.getAddress().getAddress2();
        city = merchant.getAddress().getCity();
        state = merchant.getAddress().getState();
        zip = merchant.getAddress().getZip();
        country = merchant.getAddress().getCountry();
    }
    
    private void updateMerchant(String status, ResultStatus resultStatus, Merchant result) {
        merchantID = result.getId();
        merchantName = result.getName();
        deviceID = result.getDeviceId();
    }
}
