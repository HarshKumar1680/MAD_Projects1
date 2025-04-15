import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sol5.R;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GalleryActivity extends AppCompatActivity {
    GridView gridView;
    File folder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_gallery);
        System.out.println("Hello from GalleryActivity");


        gridView = findViewById(R.id.gridView);
        folder = getExternalFilesDir(null); // Choose a folder
        File[] images = folder.listFiles();

        List<String> imagePaths = new ArrayList<>();
        for (File file : images) {
            if (file.getName().endsWith(".jpg")) {
                imagePaths.add(file.getAbsolutePath());
            }
        }

        gridView.setAdapter(new ImageAdapter(this, imagePaths));

        gridView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(this, ImageDetailActivity.class);
            intent.putExtra("imagePath", imagePaths.get(position));
            startActivity(intent);
        });
    }
}

