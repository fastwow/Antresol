package antresol.it.antresol.images.model;

/**
 * Created by artem on 2/12/15.
 */
public class Image {

    private int imageId;
    private String url;
    private int height;
    private int width;

    public Image(int imageId, int width, int height, String url) {

        this.imageId = imageId;
        this.width = width;
        this.height = height;
        this.url = url;
    }

    public int getImageId() {

        return imageId;
    }

    public void setImageId(int imageId) {

        this.imageId = imageId;
    }

    public String getUrl() {

        return url;
    }

    public void setUrl(String url) {

        this.url = url;
    }

    public int getHeight() {

        return height;
    }

    public void setHeight(int height) {

        this.height = height;
    }

    public int getWidth() {

        return width;
    }

    public void setWidth(int width) {

        this.width = width;
    }
}
