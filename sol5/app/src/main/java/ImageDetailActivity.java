import android.annotation.SuppressLint;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sol5.R;


import java.io.File;
import java.util.Date;

public class ImageDetailActivity extends AppCompatActivity {
    ImageView imageView;
    TextView imageInfo;
    Button btnDelete;
    String path;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_detail);

        imageView = findViewById(R.id.imageView);
        imageInfo = findViewById(R.id.imageInfo);
        btnDelete = findViewById(R.id.btnDelete);

        path = getIntent().getStringExtra("imagePath");
        File imageFile = new File(path);
        imageView.setImageBitmap(BitmapFactory.decodeFile(path));

        String details = "Name: " + imageFile.getName()
                + "\nPath: " + imageFile.getAbsolutePath()
                + "\nSize: " + (imageFile.length() / 1024) + " KB"
                + "\nDate: " + new Date(imageFile.lastModified());

        imageInfo.setText(details);

        btnDelete.setOnClickListener(v -> {
            new AlertDialog.Builder(this)
                    .setTitle("Delete Image")
                    .setMessage("Are you sure you want to delete this image?")
                    .setPositiveButton("Yes", (dialog, which) -> {
                        imageFile.delete();
                        Toast.makeText(this, "Image Deleted", Toast.LENGTH_SHORT).show();
                        finish();
                    })
                    .setNegativeButton("No", null)
                    .show();
        });
    }
}

