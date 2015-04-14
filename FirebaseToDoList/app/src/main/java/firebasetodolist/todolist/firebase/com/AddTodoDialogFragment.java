package firebasetodolist.todolist.firebase.com;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;

/**
 * Created by zeeshan on 4/14/2015.
 */
public class AddTodoDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle saveInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.addTodoText)
                .setPositiveButton(R.string.addTodo, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(), "Todo Add", Toast.LENGTH_SHORT).show();
                    }
                });

        return null;
    }
}
