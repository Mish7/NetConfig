package com.example.upasanam.netconfig;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import java.net.Inet6Address;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class NetworkTest extends AppCompatActivity {
    boolean isIPV6 = false;
    Switch switchB;
    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_test);

        switchB = (Switch) findViewById(R.id.switch1);
        button1 = (Button) findViewById(R.id.butt3);
        switchB.setChecked(false);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                run1();
            }
        });
    }

    void run1(){
        try {
            Enumeration<NetworkInterface> networkInterfaces =
                    NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface ni = networkInterfaces.nextElement();
                for (InterfaceAddress addr : ni.getInterfaceAddresses()) {
                    if (addr.getAddress() instanceof Inet6Address) {
                        isIPV6 = true;
                    }
                }
            }
        } catch (SocketException socketException) {
            socketException.printStackTrace();
        }
        if (isIPV6 == true)
            switchB.setChecked(true);
        else
            Toast.makeText(this, "Not IPv6", Toast.LENGTH_SHORT).show();

    }
}