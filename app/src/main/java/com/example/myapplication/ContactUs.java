package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ContactUs extends AppCompatActivity {

    private EditText titleEditText, descriptionEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);


        titleEditText = findViewById(R.id.Title);
        descriptionEditText = findViewById(R.id.Description);

        Button whatsAppButton = findViewById(R.id.whatsApp);
        Button browseButton = findViewById(R.id.Browser);
        Button callButton = findViewById(R.id.CallUs);

        Button sendButton = findViewById(R.id.Send);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                                              // Get the values entered in the title and description fields
                String title = titleEditText.getText().toString();
                String description = descriptionEditText.getText().toString();
                if (title.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please write your Subject", Toast.LENGTH_SHORT).show();
                } else if (description.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please write your Message", Toast.LENGTH_SHORT).show();
                } else {
                    Intent emailIntent = new Intent(Intent.ACTION_SEND);
                    emailIntent.setType("plain/text");
                    emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"tariqsbadar@gmail.com", "kkaleemuddin@gmail.com"});
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, title);
                    emailIntent.putExtra(Intent.EXTRA_TEXT, description);
                    startActivity(Intent.createChooser(emailIntent, "Send email..."));
                }
                // Check if there is an email application installed on the device
            }
        });
        browseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com"));
                startActivity(browserIntent);
            }
        });
        whatsAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://api.whatsapp.com/send?phone=+92 3344856560";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        callButton.setOnClickListener(new View.OnClickListener()  {
            @Override
                    public void onClick(View v) {
                String phoneNumber = "tel:" + "+92 3344856560";
                Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                dialIntent.setData(Uri.parse(phoneNumber));
                startActivity(dialIntent);
            }
        });

    }
}
