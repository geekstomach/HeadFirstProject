package ru.geekstomach.headfirst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);
    }

    public void onSendMessageExplicit(View view) {
        EditText messageView = findViewById(R.id.message);
        String messageText = String.valueOf(messageView.getText());
        Intent intent = new Intent(this, ReceiveMessageActivity.class);
        intent.putExtra(ReceiveMessageActivity.EXTRA_MESSAGE, messageText);
        startActivity(intent);
    }

    public void onSendMessageImplicit(View view) {
        EditText messageView = findViewById(R.id.message);
        String messageText = String.valueOf(messageView.getText());
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, messageText);
        startActivity(intent);
    }

    public void onSendMessageChooser(View view) {
        EditText messageView = findViewById(R.id.message);
        String messageText = messageView.getText().toString();
        String chooserTitle = getString(R.string.chooser);
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,messageText);
        Intent chosenIntent = Intent.createChooser(intent,chooserTitle);
        startActivity(chosenIntent);
    }


}

