package com.samsung.android.firebase_tutorial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    // Firebase database variable
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    // Variables for Android objects in activity_main.xml
    EditText name;
    EditText number;
    Button send;
    Button results;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // TODO: Add input text objects to activity_main.xml and add their IDs here to variables defined above

        // TODO: Add 2 buttons to activity_main.xml and add their IDs here to variables defined above
        // One button will send data to Firebase and the other will switch to the results screen


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, Object> numbers = new HashMap<>();
                // TODO: Add "Name", <Name entered> to the HashMap created above
                // TODO: Add "Number", <Number entered> to the HashMap created above

                // This block of code sends the numbers to Firebase
                // https://firebase.google.com/docs/firestore/manage-data/add-data
                Task<DocumentReference> documentReferenceTask = db.collection("custom")
                        .add(numbers)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Log.d("Success", "DocumentSnapshot written with ID: " + documentReference.getId());
                                Toast result = Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG);
                                result.show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w("Failure", "Error adding document", e);
                                Toast result = Toast.makeText(getApplicationContext(), "Error connecting to firebase", Toast.LENGTH_LONG);
                                result.show();
                            }
                        });

            }
        });

        // On click listener to switch to results screen
        results.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: Use the intent variable defined above to switch to the ViewResults screen
                // initialize intent properly
                // Switch to new screen
            }

        });
    }
}