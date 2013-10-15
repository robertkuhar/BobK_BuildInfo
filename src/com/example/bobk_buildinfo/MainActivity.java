package com.example.bobk_buildinfo;

import java.util.*;

import android.app.*;
import android.content.*;
import android.os.*;
import android.telephony.*;
import android.view.*;
import android.widget.*;

public class MainActivity extends Activity {

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        TableLayout tableLayout = new TableLayout( getApplicationContext() );

        Map<String, String> buildInfos = makeBuildInfos();
        for ( String key : buildInfos.keySet() ) {
            String value = buildInfos.get( key );
            TableRow tableRow = new TableRow( getApplicationContext() );
            TextView keyView = new TextView( getApplicationContext() );
            keyView.setText( key );
            tableRow.addView( keyView );
            TextView valueView = new TextView( getApplicationContext() );
            valueView.setText( value );
            tableRow.addView( valueView );
            tableLayout.addView( tableRow );
        }
        setContentView( tableLayout );
        // setContentView( R.layout.activity_main );
    }

    @Override
    public boolean onCreateOptionsMenu( Menu menu ) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate( R.menu.main, menu );
        return true;
    }

    private Map<String, String> makeBuildInfos() {
        Map<String, String> buildInfos = new LinkedHashMap<String, String>();
        TelephonyManager teleMgr = (TelephonyManager) getSystemService( Context.TELEPHONY_SERVICE );
        buildInfos.put( "IMEI", teleMgr.getDeviceId() );

        buildInfos.put( "Build.BOARD", Build.BOARD );
        buildInfos.put( "Build.BOOTLOADER", Build.BOOTLOADER );
        buildInfos.put( "Build.BRAND", Build.BRAND );
        buildInfos.put( "Build.CPU_ABI", Build.CPU_ABI );
        buildInfos.put( "Build.CPU_ABI2", Build.CPU_ABI2 );
        buildInfos.put( "Build.DEVICE", Build.DEVICE );
        buildInfos.put( "Build.DISPLAY", Build.DISPLAY );
        buildInfos.put( "Build.FINGERPRINT", Build.FINGERPRINT );
        buildInfos.put( "Build.HARDWARE", Build.HARDWARE );
        buildInfos.put( "Build.HOST", Build.HOST );
        buildInfos.put( "Build.ID", Build.ID );
        buildInfos.put( "Build.MANUFACTURER", Build.MANUFACTURER );
        buildInfos.put( "Build.MODEL", Build.MODEL );
        buildInfos.put( "Build.PRODUCT", Build.PRODUCT );
        buildInfos.put( "Build.SERIAL", Build.SERIAL );
        buildInfos.put( "Build.TAGS", Build.TAGS );
        buildInfos.put( "Build.TYPE", Build.TYPE );
        buildInfos.put( "Build.VERSION.CODENAME", Build.VERSION.CODENAME );
        buildInfos.put( "Build.VERSION.INCREMENTAL", Build.VERSION.INCREMENTAL );
        buildInfos.put( "Build.VERSION.RELEASE", Build.VERSION.RELEASE );
        buildInfos.put( "Build.VERSION.SDK_INT", "" + Build.VERSION.SDK_INT );
        return buildInfos;
    }

}
