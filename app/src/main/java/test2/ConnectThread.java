package test2;


import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.util.Log;

import java.io.IOException;
import java.util.UUID;


public class ConnectThread extends Thread{

    private final BluetoothSocket mmSocket ;
    private final BluetoothDevice mmDevice ;
    BluetoothAdapter mBluetoothAdapter;
    private static final UUID MY_UUID = UUID.fromString("fa87c0d0-afac-11de-8a39-0800200c9a66");
    private static final String NAME = "SARO";

    public ConnectThread(BluetoothDevice device) {
        BluetoothSocket tmp = null;
        mmDevice = device;
        try {
            tmp = device.createRfcommSocketToServiceRecord(MY_UUID);
        }
        catch (IOException e){
            e.getMessage();
        }
        mmSocket = tmp;
    }

    public void run (){
        mBluetoothAdapter.cancelDiscovery();
        try {
            mmSocket.connect();
        }
        catch (IOException connectEx){
            connectEx.getMessage();
            try {
                mmSocket.close();
            }
            catch (IOException closeEx){
                closeEx.getMessage();
            }
            return;
        }

        // A comprendre manageConnectedSocket(mmSocket);
    }


    public  void  cancel(){
        try {
            mmSoket.close();
        }
        catch (IOException e){
            e.getMessage();
        }
    }
}

