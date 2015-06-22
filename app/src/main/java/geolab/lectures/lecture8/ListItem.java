package geolab.lectures.lecture8;

/**
 * Created by Jay on 6/22/2015.
 */
public class ListItem {
    private String id, title, item;

    public ListItem(String id, String title, String item) {
        this.id = id;
        this.title = title;
        this.item = item;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "ListItem{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", item='" + item + '\'' +
                '}';
    }
}
