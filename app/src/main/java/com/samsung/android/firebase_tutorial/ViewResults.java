package com.samsung.android.firebase_tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.firestore.FirebaseFirestore;

public class ViewResults extends AppCompatActivity {
    // Firebase database variable
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    // Variables for Android objects in activity_main.xml

    Button go_back;
    ListView results;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_results);
        // TODO: Add button to activity_view_results.xml and add ID to go_back variable defined above

        // TODO: Add ListView to activity_view_results.xml and add ID to results variable defined above

    

        // On click listener to switch to results screen
        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: Use the intent variable defined above to switch back to the MainActivity screen
                // initialize intent properly
                // Switch to MainActivity
            }

        });
    }
}