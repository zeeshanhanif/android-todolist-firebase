package firebase.generic.todolist;

import android.app.Activity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.firebase.client.Query;

import firebase.repo.com.FirebaseListAdapter;
import firebasetodolist.todolist.firebase.com.R;

/**
 * Created by zeeshan on 4/17/2015.
 */
public class ToDoItemListAdapter extends FirebaseListAdapter<ToDoItem> {

    public ToDoItemListAdapter(Query ref, int layout, Activity activity){
        super(ref,ToDoItem.class,layout,activity);
    }

    @Override
    public void populateView(View view, ToDoItem toDoItem){


        TextView descriptionTextView = (TextView)view.findViewById(R.id.todoItemDescriptionTextView);
        TextView dateTextView = (TextView)view.findViewById(R.id.todoItemDateTextView);
        CheckBox doneCheckBox = (CheckBox)view.findViewById(R.id.todoItemCheckBox);

        descriptionTextView.setText(toDoItem.getDescription());
        dateTextView.setText(toDoItem.getTimestamp().toString());
        doneCheckBox.setChecked(toDoItem.isCompleted());
    }
}
