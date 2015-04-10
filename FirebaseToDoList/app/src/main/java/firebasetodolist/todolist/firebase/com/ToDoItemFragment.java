package firebasetodolist.todolist.firebase.com;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A fragment representing a list of Items.
 * <p/>
 * <p/>

 */
public class ToDoItemFragment extends ListFragment {


    public ToDoItemFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SynchronizedToDoItemArray toDoItemArray = new SynchronizedToDoItemArray();

        // TODO: Change Adapter to display your content
        setListAdapter(new ArrayAdapter<ToDoItem>(getActivity(),
                android.R.layout.simple_list_item_1, android.R.id.text1, toDoItemArray.getToDoItems()));
    }

}
