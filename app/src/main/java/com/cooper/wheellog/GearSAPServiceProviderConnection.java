package com.cooper.wheellog;

import timber.log.Timber;

import com.samsung.android.sdk.accessory.SASocket;


public class GearSAPServiceProviderConnection extends SASocket {
    private final int connectionID;
    static int nextID = 1;
    public final static String TAG = "SAPServiceProvider";
    private GearService mParent;

    public void setParent(GearService gearService) {
        mParent = gearService;
        Timber.d("Set Parent");
    }

    public GearSAPServiceProviderConnection() {
        super(GearSAPServiceProviderConnection.class.getName());
        connectionID = ++nextID;
        Timber.d("GearSAPServiceProviderConnection");
    }

    @Override
    protected void onServiceConnectionLost(int reason) {
        if(mParent!=null) {
            mParent.removeConnection(this);
        }
        Timber.d("Set OnServiceConnectionLost");
    }

    @Override
    public void onReceive(int channelID, byte[] data) {
        Timber.d("OnReceive");
    }

    @Override
    public void onError(int channelID, String errorString, int errorCode) {
        Timber.e("ERROR:"+errorString+ " | " + errorCode);
    }
}
