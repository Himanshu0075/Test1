package com.example.test1;

import android.os.Bundle;
import android.widget.ListView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class ProductsActivity extends AppCompatActivity {
    private ListView listView;
    private ProductsAdapter adapter;
    private List<Product> productList;



    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        listView = findViewById(R.id.listview);
        productList = new ArrayList<>();
        adapter = new ProductsAdapter(this, (ArrayList<Product>) productList);

        listView.setAdapter(adapter);


        db = FirebaseFirestore.getInstance();


        db.collection("products").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {



                        if(!queryDocumentSnapshots.isEmpty()){

                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();

                            for(DocumentSnapshot d : list){

                                Product p = d.toObject(Product.class);
                                productList.add(p);

                            }

                            adapter.notifyDataSetChanged();

                        }


                    }
                });

    }
}