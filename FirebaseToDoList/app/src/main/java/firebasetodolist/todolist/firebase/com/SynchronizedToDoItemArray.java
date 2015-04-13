package firebasetodolist.todolist.firebase.com;

import android.util.Log;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

import firebasetodolist.todolist.firebase.com.firebase.FirebaseHandler;

/**
 * Created by zeeshanhanif on 4/11/2015.
 */
public class SynchronizedToDoItemArray {

    private ArrayList<ToDoItem> mToDoItems;
    private Firebase todoFirebaseRef;
    private static final String TAG = "SynchronizedToDoItemArray";


    public SynchronizedToDoItemArray(){
        this.mToDoItems = new ArrayList<ToDoItem>();
        todoFirebaseRef = FirebaseHandler.getInstance().getMyFirebaseRef().child("todos");
        setupReadingEvent();
        addTodo();
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

    public void addTodo(){
        //todoFirebaseRef.set
        //todoFirebaseRef.setValue(new ToDoItem("Hello with todo object"));
        //todoFirebaseRef.setValue("simple todo sdfsd");
        todoFirebaseRef.push().setValue(new ToDoItem("Hello with todo object"));
    }

    public void setupReadingEvent(){
        todoFirebaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                System.out.println("><<><><><<> = "+dataSnapshot.getValue().toString());
                Log.d(TAG, dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

}
