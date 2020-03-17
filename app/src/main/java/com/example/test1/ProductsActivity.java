package com.example.test1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

    public class ProductsActivity<db> extends AppCompatActivity implements View.OnClickListener {

        private ListView listView;
        private ProductsAdapter adapter;
        private List<Product> productList;
        private Button btn;


        public FirebaseFirestore db;

        public ProductsActivity(OnSuccessListener<QuerySnapshot> error) {
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_products);
            ListView itemsListView = (ListView) findViewById(R.id.listview);
            final ProductsAdapter adapter = new ProductsAdapter(this, generateProductsList());
            itemsListView.setAdapter(adapter);
            listView.setAdapter(adapter);
            btn.setOnClickListener(this);
        }
        private ArrayList<Product> generateProductsList(){
            Product item1=new Product("Pepsi","$2","Home screen");
            Product item2=new Product("Pepsi","$2","Home screen");
            Product item3=new Product("Pepsi","$2","Home screen");
            ArrayList<Product> list= new ArrayList<>();
            list.add(item1);
            list.add(item2);
            list.add(item3);

            return list;

        }

        public void user()
        {



                db = FirebaseFirestore.getInstance();
                db.collection("products").getId();

        new ProductsActivity(new OnSuccessListener<QuerySnapshot>() {
                            @Override
                            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {


                                if (!queryDocumentSnapshots.isEmpty()) {

                                    List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();

                                    for (DocumentSnapshot d : list) {

                                        Product p = d.toObject(Product.class);
                                        productList.add(p);

                                    }

                                    adapter.notifyDataSetChanged();

                                } else {
                                    Toast.makeText(ProductsActivity.this, "Error", Toast.LENGTH_LONG).show();
                                }


                            }
                        });

            }

        @Override
        public void onClick(View v) {

        }
    }

