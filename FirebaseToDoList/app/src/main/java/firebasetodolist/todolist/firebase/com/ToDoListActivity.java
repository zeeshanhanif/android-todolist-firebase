package firebasetodolist.todolist.firebase.com;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class ToDoListActivity extends ActionBarActivity implements FragmentCommunicationInterface {

    Button addTodoBtn;
    SynchronizedToDoItemArray mSynchronizedToDoItemArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);
        mSynchronizedToDoItemArray = new SynchronizedToDoItemArray();
        loadViewElements();
        addEventListeners();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new ToDoItemFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_to_do_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void loadViewElements(){
        addTodoBtn = (Button)findViewById(R.id.addToDoBtn);
    }

    private void addEventListeners(){
        addTodoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createDialog(getLayoutInflater(),ToDoListActivity.this);
            }
        });
    }

    private void createDialog(LayoutInflater inflater,final Activity activity){
        // 1. Instantiate an AlertDialog.Builder with its constructor

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        // 2. Chain together various setter methods to set the dialog characteristics
        builder.setTitle("Add Your Next ToDo");
        final View dialogView = inflater.inflate(R.layout.dialog_add_todo, null, false);
        builder.setView(dialogView);
        builder.setPositiveButton(R.string.addTodo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditText todoEditText = (EditText)dialogView.findViewById(R.id.todoEditText);
                mSynchronizedToDoItemArray.addTodo(new ToDoItem(todoEditText.getText().toString()));
                Toast.makeText(activity, "Todo Add", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton(R.string.cancleTodoAdd, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(activity, "Cancel", Toast.LENGTH_SHORT).show();
            }
        });

        // 3. Get the AlertDialog from create()
        AlertDialog dialog = builder.create();
        dialog.show();
    }


    // Fragment Communication Interface
    public boolean addToDo(ToDoItem toDoItem){
        return mSynchronizedToDoItemArray.addTodo(toDoItem);
    }

    public SynchronizedToDoItemArray getToDoItemArray(){
        return mSynchronizedToDoItemArray;
    }

}
