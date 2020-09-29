package tc3.android.common;

public class Item {
    private String title;
    private Class activityClass;
    public Item(String title, Class activityClass) {
        this.title = title;
        this.activityClass = activityClass;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setActivityClass(Class activityClass) {
        this.activityClass = activityClass;
    }

    public String getTitle() {
        return title;
    }

    public Class getActivityClass() {
        return activityClass;
    }
}