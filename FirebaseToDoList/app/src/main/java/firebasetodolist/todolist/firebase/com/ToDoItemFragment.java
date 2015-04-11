package firebasetodolist.todolist.firebase.com;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A fragment representing a list of Items.
 * <p/>
 * <p/>

 */
public class ToDoItemFragment extends ListFragment {


    public static final String TAG = "ToDoItemFragment";

    public ToDoItemFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SynchronizedToDoItemArray toDoItemArray = new SynchronizedToDoItemArray();

        // TODO: Change Adapter to display your content
        //setListAdapter(new ArrayAdapter<ToDoItem>(getActivity(),
        //        android.R.layout.simple_list_item_1, android.R.id.text1, toDoItemArray.getToDoItems()));

        ToDoAdapter adapter = new ToDoAdapter(toDoItemArray.getToDoItems());
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        //ToDoItem todo = (ToDoItem)getListAdapter().getItem(position);
        ToDoItem todo = ((ToDoAdapter)getListAdapter()).getItem(position);
        Log.d(TAG, todo.getDescription());
    }

    private class ToDoAdapter extends ArrayAdapter<ToDoItem> {
        public ToDoAdapter(ArrayList<ToDoItem> toDoItems){
            super(getActivity(),0,toDoItems);
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            if(convertView == null){
                convertView = getActivity().getLayoutInflater()
                        .inflate(R.layout.fragment_to_do_list,null);
            }

            ToDoItem toDoItem = getItem(position);


            TextView descriptionTextView = (TextView)convertView.findViewById(R.id.todoItemDescriptionTextView);
            TextView dateTextView = (TextView)convertView.findViewById(R.id.todoItemDateTextView);
            CheckBox doneCheckBox = (CheckBox)convertView.findViewById(R.id.todoItemCheckBox);

            descriptionTextView.setText(toDoItem.getDescription());
            dateTextView.setText(toDoItem.getTimestamp().toString());
            doneCheckBox.setChecked(toDoItem.isCompleted());

            return convertView;
        }
    }
}
