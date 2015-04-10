package firebasetodolist.todolist.firebase.com;

import java.util.ArrayList;

/**
 * Created by zeeshanhanif on 4/11/2015.
 */
public class SynchronizedToDoItemArray {

    private ArrayList<ToDoItem> mToDoItems;

    public SynchronizedToDoItemArray(){
        this.mToDoItems = new ArrayList<ToDoItem>();
        fillDummyData();
    }

    public ArrayList<ToDoItem> getToDoItems(){
        return mToDoItems;
    }

    public void fillDummyData(){
        mToDoItems.add(new ToDoItem("Hello 1"));
        mToDoItems.add(new ToDoItem("Hello 2"));
        mToDoItems.add(new ToDoItem("Hello 3"));
        mToDoItems.add(new ToDoItem("Hello 4"));
        mToDoItems.add(new ToDoItem("Hello 5"));
    }

}
