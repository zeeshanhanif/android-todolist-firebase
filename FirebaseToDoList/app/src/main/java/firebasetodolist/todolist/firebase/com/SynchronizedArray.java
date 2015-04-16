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
 * Created by zeeshan on 4/16/2015.
 */
public class SynchronizedArray<T> {

    private ArrayList<T> items;
    private Firebase firebaseRef;
    private static final String TAG = "SynchronizedArray";
    private NotifierListener notifierListener;


    public SynchronizedArray(NotifierListener notifierListener,String arrayKey){
        this.items = new ArrayList<T>();
        firebaseRef = FirebaseHandler.getInstance().getMyFirebaseRef().child(arrayKey);
        this.notifierListener = notifierListener;
        setupEvent();
    }

    public SynchronizedArray(String arrayKey){
        this(null,arrayKey);
    }

    public ArrayList<T> getItems(){
        return items;
    }

    public boolean addItem(T item){
        firebaseRef.push().setValue(item);
        return true;
    }

    public void setupEvent(){
        firebaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                System.out.println("><<><><><<> = "+dataSnapshot.getValue().toString());
                Log.d(TAG, "value Event = " + dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        firebaseRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                System.out.println("><<><><><<> child added == "+dataSnapshot.getValue().toString());
                T item = (T)dataSnapshot.getValue();
                items.add(item);
                if(notifierListener !=null) {
                    notifierListener.notifyChanges();
                }
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

    public void setNotifierListener(NotifierListener notifierListener){
        this.notifierListener = notifierListener;
    }

}
