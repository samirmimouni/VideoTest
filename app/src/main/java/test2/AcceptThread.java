package test2;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;

import java.io.IOException;
import java.util.UUID;

public class AcceptThread extends Thread{
    BluetoothAdapter mBluetoothAdapter;
    private static final UUID MY_UUID = UUID.fromString("fa87c0d0-afac-11de-8a39-0800200c9a66");
    private static final String NAME = "SARO";

    private final BluetoothServerSocket mmServerSoket;
    public AcceptThread() {
        BluetoothServerSocket tmp = null;

        try {
            tmp = mBluetoothAdapter.listenUsingRfcommWithServiceRecord(NAME,MY_UUID);
        }
        catch (IOException e){
            e.getMessage();
        }

        mmServerSoket = tmp;

    }

    public void run (){

        BluetoothSocket socket = null;
        while (true){
            try {
                socket = mmServerSoket.accept();

            }
            catch (IOException e){
                break;
            }

            if (socket!=null){
                //do some thing
                //doSomeThingConnection(socket);
                try {
                    mmServerSoket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            }
        }

    }

    public  void  cancel(){
        try {
            mmServerSoket.close();
        }
        catch (IOException e){
            e.getMessage();
        }
    }
}