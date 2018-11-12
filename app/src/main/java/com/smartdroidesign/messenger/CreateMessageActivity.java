package com.smartdroidesign.messenger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);
    }

    public void sendMessage(View view) {
        EditText messageView = findViewById(R.id.message);
        String messageText = messageView.getText().toString();
        // Explicit intent -> send an intent to a specific activity
//        Intent intent = new Intent(this, ReceiveMessageActivity.class);
//        intent.putExtra("message", messageText);
        // Implicit intent -> send an intent that contains an actions that can be performed by suitable apps
        Intent intent = new Intent(Intent.ACTION_SEND); intent.setType("text/plain");
//        intent.putExtra(ReceiveMessageActivity.EXTRA_MESSAGE, messageText);
        intent.putExtra(Intent.EXTRA_TEXT, messageText);
        String chooserTitle = getString(R.string.chooser);
        Intent chosenIntent = Intent.createChooser(intent, chooserTitle);
        startActivity(chosenIntent);
//        startActivity(intent);
    }
}
