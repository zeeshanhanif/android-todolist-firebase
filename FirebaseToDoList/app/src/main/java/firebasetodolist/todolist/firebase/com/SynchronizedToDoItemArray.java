package firebasetodolist.todolist.firebase.com;

import android.util.Log;

import com.firebase.client.ChildEventListener;
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
        //addTodo(new ToDoItem("New Check if todo item in argument"));
        //fillDummyData();
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
        mToDoItems.add(new ToDoItem("Hello 6"));
        mToDoItems.add(new ToDoItem("Hello 7"));
        mToDoItems.add(new ToDoItem("Hello 8"));
        mToDoItems.add(new ToDoItem("Hello 9"));
    }

    public boolean addTodo(ToDoItem toDoItem){
        //todoFirebaseRef.set
        //todoFirebaseRef.setValue(new ToDoItem("Hello with todo object"));
        //todoFirebaseRef.setValue("simple todo sdfsd");
        //todoFirebaseRef.push().setValue(new ToDoItem("Hello asdf with todo object"));
        todoFirebaseRef.push().setValue(toDoItem);
        return true;
    }

    public void setupReadingEvent(){
        todoFirebaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                System.out.println("><<><><><<> = "+dataSnapshot.getValue().toString());
                Log.d(TAG, "value Event = "+dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        todoFirebaseRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                System.out.println("><<><><><<> child added == "+dataSnapshot.getValue().toString());
                ToDoItem item = dataSnapshot.getValue(ToDoItem.class);
                mToDoItems.add(item);
                Log.d(TAG, "child added ==  "+dataSnapshot.getValue().toString());

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }

}
