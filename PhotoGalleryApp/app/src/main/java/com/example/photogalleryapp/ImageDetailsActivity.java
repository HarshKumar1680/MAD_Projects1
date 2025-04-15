package com.example.photogalleryapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ImageDetailsActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView txtName, txtPath, txtSize, txtDate;
    private Button btnDelete;
    private String imagePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_details);

        imageView = findViewById(R.id.imageView);
        txtName = findViewById(R.id.txtName);
        txtPath = findViewById(R.id.txtPath);
        txtSize = findViewById(R.id.txtSize);
        txtDate = findViewById(R.id.txtDate);
        btnDelete = findViewById(R.id.btnDelete);

        imagePath = getIntent().getStringExtra("imagePath");
        File file = new File(imagePath);

        Glide.with(this).load(file).into(imageView);
        txtName.setText("Name: " + file.getName());
        txtPath.setText("Path: " + file.getAbsolutePath());
        txtSize.setText("Size: " + file.length() / 1024 + " KB");
        txtDate.setText("Date Taken: " + new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date(file.lastModified())));

        btnDelete.setOnClickListener(v -> showDeleteDialog(file));
    }

    private void showDeleteDialog(File file) {
        new AlertDialog.Builder(this)
                .setTitle("Confirm Delete")
                .setMessage("Are you sure you want to delete this image?")
                .setPositiveButton("Yes", (dialog, which) -> {
                    if (file.delete()) {
                        Toast.makeText(this, "Image deleted", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(this, "Failed to delete", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }
}
