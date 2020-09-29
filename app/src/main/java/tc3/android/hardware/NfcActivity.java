package tc3.android.hardware;

import android.app.PendingIntent;
import android.content.Intent;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.Ndef;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;


import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Locale;

import tc3.android.R;
import tc3.android.common.BaseActivity;

public class NfcActivity extends BaseActivity {

    private NfcAdapter nfcAdapter;
    private PendingIntent pendingIntent;
    private Tag tag;
//    private IntentFilter[] intentFiltersArray;
//    private String[][] techListsArray;

    @Override
    protected int getLayout() {
        return R.layout.blank;
    }

    @Override
    protected void initView() {
        nfcAdapter = NfcAdapter.getDefaultAdapter(this);
        if (nfcAdapter == null) {
            Toast.makeText(this, "NFC模块无法使用!", Toast.LENGTH_LONG).show();
            return;
        }
        pendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);
//        IntentFilter ndef = new IntentFilter(NfcAdapter.ACTION_NDEF_DISCOVERED);
//        try {
//            ndef.addDataType("*/*");
//        } catch (IntentFilter.MalformedMimeTypeException e) {
//            throw new RuntimeException("fail", e);
//        }
//        intentFiltersArray = new IntentFilter[]{ndef,};
//        techListsArray = new String[][]{new String[]{NfcF.class.getName()}};
    }

    @Override
    protected void initEvent() {

    }


    public void onResume() {
        super.onResume();
//        nfcAdapter.enableForegroundDispatch(this, pendingIntent, intentFiltersArray, techListsArray);
        nfcAdapter.enableForegroundDispatch(this, pendingIntent, null, null);
    }

    public void onPause() {
        super.onPause();
        nfcAdapter.disableForegroundDispatch(this);
    }


    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
        readNfc(intent);
    }

    protected  void handleNfcMsg(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    protected void readNfc(Intent intent){
        if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(intent.getAction())) {
            Parcelable[] rawMessages = intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);
            if (rawMessages != null) {
                NdefMessage[] messages = new NdefMessage[rawMessages.length];
                for (int i = 0; i < rawMessages.length; i++) {
                    messages[i] = (NdefMessage) rawMessages[i];
                    NdefRecord[] records = messages[i].getRecords();
                    for (NdefRecord record : records){
                        String msgStr = new String(record.getPayload(), Charset.forName("UTF-8"));
                        handleNfcMsg(msgStr);
                        return;//只读取第一条NdefRecord
                    }
                }
            }
        }
    }

    protected void writeNfcTag(String msg) throws RuntimeException {
        long start = System.currentTimeMillis();
        if (tag == null) {
            Toast.makeText(this, "获取卡失败,无法写入!", Toast.LENGTH_LONG).show();
            return;
        }
        Ndef ndef = Ndef.get(tag);
        NdefRecord record = createNdefRecord(msg);
        NdefMessage message = new NdefMessage(new NdefRecord[]{record});
        try {
            ndef.connect();
            ndef.writeNdefMessage(message);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("写卡异常");
        } finally {
            try {
                if (ndef != null)
                    ndef.close();
                tag = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        Log.d("写入耗时：", String.valueOf(end - start));
    }

    private NdefRecord createNdefRecord(String msg) {
        Locale locale = Locale.CHINA;
        Charset utfEncoding =Charset.forName("UTF-8");
        byte[] langBytes = locale.getLanguage().getBytes(Charset.forName("US-ASCII"));
        byte[] textBytes = msg.getBytes(utfEncoding);
        int utfBit =  0 ;
        char status = (char) (utfBit + langBytes.length);
        byte[] data = new byte[1 + langBytes.length + textBytes.length];
        data[0] = (byte) status;
        System.arraycopy(langBytes, 0, data, 1, langBytes.length);
        System.arraycopy(textBytes, 0, data, 1 + langBytes.length, textBytes.length);
        NdefRecord record = new NdefRecord(NdefRecord.TNF_WELL_KNOWN, NdefRecord.RTD_TEXT, new byte[0], data);
        return record;
    }

//    private NdefRecord createUriRecord(String uriStr) {
//        NdefRecord rtdUriRecord1 = NdefRecord.createUri(uriStr);
////        Uri uri = Uri.parse(uriStr);
////        NdefRecord rtdUriRecord2 = NdefRecord.createUri(uri);
//        return rtdUriRecord1;
//    }

//    private NdefRecord createAARRecord(String appPkg) {
//        NdefRecord record = NdefRecord.createApplicationRecord(appPkg);
//        return record;
//    }

}
