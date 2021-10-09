package com.example.bosspal.NewWallet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.bosspal.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class QrCodeActivity extends AppCompatActivity {

    String textForCode = "textForCodeGet";
    ImageView ivOutPut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code);
        ivOutPut = (ImageView)findViewById(R.id.iv_output);

        MultiFormatWriter writer = new MultiFormatWriter();
        try {
            // initialise bit matrix
            BitMatrix matrix = writer.encode(textForCode, BarcodeFormat.QR_CODE
            ,350,350);

            //initialise barcode encoder

            DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Test");
            reference.setValue("Hello BossPal");
            Toast.makeText(this,"Data send to firebase",Toast.LENGTH_SHORT).show();

            BarcodeEncoder encoder = new BarcodeEncoder();
            Bitmap bitmap = encoder.createBitmap(matrix);
            //set bitmap on image view
            ivOutPut.setImageBitmap(bitmap);
            // initialise input manager
            InputMethodManager methodManager = (InputMethodManager)getSystemService(
                    Context.INPUT_METHOD_SERVICE
            );
            //hide soft keyboard
            methodManager.hideSoftInputFromWindow(ivOutPut.getApplicationWindowToken(),0);

        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}