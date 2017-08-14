package fu.alfie.com.tabexdemo;

import android.widget.ImageView;

/**
 * Created by Jiunhau.Fu on 2017/8/8.
 */

public class Item {
    int image;
    String title,subtitle;

    public Item(int image, String title, String subtitle) {
        this.image = image;
        this.title = title;
        this.subtitle = subtitle;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
}
