package firebasetodolist.todolist.firebase.com;

/**
 * Created by zeeshanhanif on 4/15/2015.
 */
public interface FragmentCommunicationInterface {

    boolean addToDo(ToDoItem toDoItem);
    //SynchronizedArray getToDoItemArray();
    SynchronizedToDoItemArray getToDoItemArray();
    //void updateToDoFragmentUI();
}
