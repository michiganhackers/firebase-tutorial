package com.samsung.android.firebase_tutorial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class ViewResults extends AppCompatActivity {
    // Firebase database variable
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    // Variables for Android objects in activity_main.xml

    Button go_back;
    ListView resultsView;
    ArrayList<String> results;
    ArrayAdapter<String> adapter;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_results);
        // TODO: Add button to activity_view_results.xml and add ID to go_back variable defined above
        go_back = findViewById(R.id.goBack);
        // TODO: Add ListView to activity_view_results.xml and add ID to results variable defined above
        resultsView = findViewById(R.id.results);
        // TODO: Initialize arrayList
        results = new ArrayList<>();
        // TODO: Initialize adapter with the ArrayList results
        // Use android.R.layout.simple_list_item_1 in your initialization
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, results);


        resultsView.setAdapter(adapter);
        // This code gets data from Firebase
        // https://firebase.google.com/docs/firestore/query-data/get-data
        db.collection("custom")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                // TODO: Add the Name and Number from the document to the ArrayList
                                results.add(document.get("Name").toString() + ":" + document.get("Number").toString());

                                Log.d("success", document.getId() + " => " + document.getData());
                            }
                            // TODO: Tell the adapter the set changed
                            adapter.notifyDataSetChanged();
                        } else {
                            Log.d("failure", "Error getting documents: ", task.getException());
                        }
                    }
                });
        // On click listener to switch to results screen
        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: Use the intent variable defined above to switch back to the MainActivity screen
                // initialize intent properly
                // Switch to MainActivity
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }

        });
    }
}