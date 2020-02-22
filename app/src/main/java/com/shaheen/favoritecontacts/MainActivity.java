package com.shaheen.favoritecontacts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn1Call, btn2Call, btn3Call;
    Button btn1Text, btn2Text, btn3Text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupCallButtonClickEvents();
        setupTextButtonClickEvents();

    }

    private void setupCallButtonClickEvents() {
        btn1Call = (Button) findViewById(R.id.con1Call);
        btn1Call.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", getResources().getString(R.string.contact1phone), null));
                startIntent(intent);
            }
        });

        btn2Call = (Button) findViewById(R.id.con2Call);
        btn2Call.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", getResources().getString(R.string.contact2phone), null));
                startIntent(intent);
            }
        });

        btn3Call = (Button) findViewById(R.id.con3Call);
        btn3Call.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", getResources().getString(R.string.contact3phone), null));
                startIntent(intent);
            }
        });
    }

    private void setupTextButtonClickEvents() {
        btn1Text = (Button) findViewById(R.id.con1Text);
        btn1Text.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Spinner tbody = findViewById(R.id.spinner1);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", getResources().getString(R.string.contact1phone), null));
                intent.putExtra("sms_body", tbody.getSelectedItem().toString());
                startIntent(intent);
            }
        });

        btn2Text = (Button) findViewById(R.id.con2Text);
        btn2Text.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Spinner tbody = findViewById(R.id.spinner2);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", getResources().getString(R.string.contact2phone), null));
                intent.putExtra("sms_body", tbody.getSelectedItem().toString());
                startIntent(intent);
            }
        });

        btn3Text = (Button) findViewById(R.id.con3Text);
        btn3Text.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Spinner tbody = findViewById(R.id.spinner3);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", getResources().getString(R.string.contact3phone), null));
                intent.putExtra("sms_body", tbody.getSelectedItem().toString());
                startIntent(intent);
            }
        });
    }

    public void startIntent(Intent i) {
        PackageManager pm = getPackageManager();
        List activities = pm.queryIntentActivities(i, PackageManager.MATCH_DEFAULT_ONLY);
        if (activities.size() > 0) {
            startActivity(i);
        }
    }
}
