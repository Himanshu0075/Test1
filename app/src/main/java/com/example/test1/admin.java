package com.example.test1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class admin extends AppCompatActivity implements View.OnClickListener {

    EditText editTextName;
    EditText editTextBrand;
    EditText editTextDesc;
    EditText editTextPrice;
    EditText editTextQty;
    Button button_save;
    Button textview_view_products;
    Intent intent;
    Context context=admin.this;

    FirebaseFirestore db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        db = FirebaseFirestore.getInstance();

        editTextName = findViewById(R.id.edittext_name);
        editTextBrand = findViewById(R.id.edittext_brand);
        editTextDesc = findViewById(R.id.edittext_desc);
        editTextPrice = findViewById(R.id.edittext_price);
        editTextQty = findViewById(R.id.edittext_qty);
        button_save = findViewById(R.id.button_save);
        textview_view_products=findViewById(R.id.textview_view_products);
        button_save.setOnClickListener(this);
        textview_view_products.setOnClickListener(this);

    }

    public boolean hasValidationErrors(String name, String brand, String desc, String price, String qty) {
        if (name.isEmpty()) {
            editTextName.setError("Name required");
            editTextName.requestFocus();
            return true;
        }

        if (brand.isEmpty()) {
            editTextBrand.setError("Brand required");
            editTextBrand.requestFocus();
            return true;
        }

        if (desc.isEmpty()) {
            editTextDesc.setError("Description required");
            editTextDesc.requestFocus();
            return true;
        }

        if (price.isEmpty()) {
            editTextPrice.setError("Price required");
            editTextPrice.requestFocus();
            return true;
        }

        if (qty.isEmpty()) {
            editTextQty.setError("Quantity required");
            editTextQty.requestFocus();
            return true;
        }
        return false;
    }


    private void saveProduct(){
        String name = editTextName.getText().toString().trim();
        String brand = editTextBrand.getText().toString().trim();
        String desc = editTextDesc.getText().toString().trim();
        String price = editTextPrice.getText().toString().trim();
        String qty = editTextQty.getText().toString().trim();

        if (!hasValidationErrors(name, brand, desc, price, qty)) {

            CollectionReference dbProducts = db.collection("products");

            Product product = new Product(
                    name,
                    brand,
                    desc,
                    Double.parseDouble(price),
                    Integer.parseInt(qty)
            );

            dbProducts.add(product)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast.makeText(admin.this, "Product Added", Toast.LENGTH_LONG).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(admin.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });

        }
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.button_save:
                saveProduct();
                break;
          case R.id.textview_view_products:
                intent=new Intent(context,ProductsActivity.class);context.startActivity(intent);

        }

    }
}
