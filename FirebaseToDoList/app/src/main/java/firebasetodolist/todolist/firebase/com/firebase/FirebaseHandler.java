package firebasetodolist.todolist.firebase.com.firebase;

import android.app.Activity;

import com.firebase.client.Firebase;

/**
 * Created by zeeshanhanif on 4/12/2015.
 */
public class FirebaseHandler {

    private static FirebaseHandler ourInstance;
    private Firebase myFirebaseRef;

    public static FirebaseHandler getInstance() {
        if(ourInstance == null){
            ourInstance = new FirebaseHandler();
        }
        return ourInstance;
    }

    private FirebaseHandler() {
        myFirebaseRef = new Firebase("https://todolist-dev.firebaseio.com/");
    }

    public Firebase getMyFirebaseRef(){
        return myFirebaseRef;
    }
}
