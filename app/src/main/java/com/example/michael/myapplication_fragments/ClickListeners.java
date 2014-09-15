package com.example.michael.myapplication_fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ClickListeners {

    public static View.OnClickListener sendButtonListener(final Activity activity, final ChatAdapter adapter){
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText input = ((EditText) activity.findViewById(R.id.main_chat_input));
                if (input.getText().toString().equals("")){
                    Toast.makeText(activity, "You didn't type anything in!", Toast.LENGTH_SHORT).show();
                    return;
                }
                adapter.addChat(new ModelChat(MyActivity.username, input.getText().toString(), MyActivity.userId));
                input.setText("");
            }
        };
    }

    public static void changeUsernameListener(final Activity activity){
        final EditText input = new EditText(activity);
        new AlertDialog.Builder(activity)
                .setTitle("Change Username")
                .setMessage("This is how you will show up to others.")
                .setView(input)
                .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String newName = input.getText().toString();
                        if (newName.equals("")) {
                            Toast.makeText(activity, "Your username can't be blank!", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        MyActivity.username = newName;
                        Toast.makeText(activity, "Your username is now " + newName, Toast.LENGTH_SHORT).show();
                        if (!MyActivity.userColors.containsKey(newName)){
                            MyActivity.addNewUser(newName);
                        }
                        activity.findViewById(R.id.main_chat_button).setBackgroundResource(MyActivity.userColors.get(MyActivity.username));
                        dialogInterface.dismiss();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).show();
    }
}