package firebase.generic.todolist;

import java.util.Date;

/**
 * Created by zeeshanhanif on 4/11/2015.
 */
public class ToDoItem {

    private String description;
    private Date timestamp;
    private boolean completed;
    private String key;

    public ToDoItem(){}

    public ToDoItem(String description){
        this.description = description;
        this.timestamp = new Date();
    }

    public ToDoItem(String description, boolean completed){
        this.description = description;
        this.completed = completed;
        this.timestamp = new Date();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String toString(){
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
