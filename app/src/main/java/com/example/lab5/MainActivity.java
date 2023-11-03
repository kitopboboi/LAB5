package com.example.lab5;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.Button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Please select function");
                dialog.setMessage("Press a button");

                dialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i){
                        Toast.makeText(MainActivity.this, "Close Dialog", Toast.LENGTH_SHORT).show();
                    }
                });

                dialog.setNegativeButton("Customize Toast", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i){
                        showToast();
                    }
                });

                dialog.setPositiveButton("Show List", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        showListDialog();
                    }
                });
                dialog.show();
;
            }

        });


        }
        private void showToast(){
            Toast toast = new Toast(MainActivity.this);
            toast.setGravity(Gravity.TOP, 0, 50);
            toast.setDuration(Toast.LENGTH_SHORT);
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.custom_toast,(ViewGroup)findViewById(R.id.custom_toast_root));
            toast.setView(layout);
            toast.show();

        }

        private void showListDialog(){
            final String[] list = {"message1", "message2", "message3", "message4", "message5"};
            AlertDialog.Builder dialog_list = new AlertDialog.Builder(MainActivity.this);

            dialog_list.setTitle("Show it by List");
            dialog_list.setItems(list, new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(MainActivity.this, "You chose"+list[i],Toast.LENGTH_SHORT).show();
                }
            });
            dialog_list.show();
    }
}