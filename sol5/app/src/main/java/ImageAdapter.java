import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.List;

public class ImageAdapter extends BaseAdapter {
    private Context context;
    private List<String> imagePaths;

    public ImageAdapter(Context c, List<String> imagePaths) {
        this.context = c;
        this.imagePaths = imagePaths;
    }

    public int getCount() { return imagePaths.size(); }

    public Object getItem(int position) { return null; }

    public long getItemId(int position) { return 0; }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = (convertView == null) ?
                new ImageView(context) : (ImageView) convertView;

        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(300, 300));

        Bitmap bitmap = BitmapFactory.decodeFile(imagePaths.get(position));
        imageView.setImageBitmap(bitmap);

        return imageView;
    }
}

