package firebasetodolist.todolist.firebase.com;

import java.util.Date;

/**
 * Created by zeeshanhanif on 4/11/2015.
 */
public class ToDoItem {

    private String description;
    private Date timestamp;

    public ToDoItem(){}

    public ToDoItem(String description){
        this.description = description;
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

}
