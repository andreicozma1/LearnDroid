package com.example.android.dialogs_basic;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {


    Button alert_ex_1;
    Button alert_ex_2;
    Button alert_ex_3;
    Button alert_ex_4;
    Button alert_ex_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        alert_ex_1 = findViewById(R.id.example_1);
        alert_ex_2 = findViewById(R.id.example_2);
        alert_ex_3 = findViewById(R.id.example_3);
        alert_ex_4 = findViewById(R.id.example_4);
        alert_ex_5 = findViewById(R.id.example_5);

        alert_ex_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Simple Alert with Text
                AlertDialog.Builder alert_dialog_1 = new AlertDialog.Builder(MainActivity.this);
                alert_dialog_1.setMessage("Example of a simple alert dialog");
                alert_dialog_1.create().show();
            }
        });

        alert_ex_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Simple Alert with Title
                AlertDialog.Builder alert_dialog_2 = new AlertDialog.Builder(MainActivity.this);
                alert_dialog_2.setTitle("My Alert Title");
                alert_dialog_2.setMessage("Example of a simple alert dialog");
                alert_dialog_2.create().show();
            }
        });

        alert_ex_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Simple Alert with ICON
                AlertDialog.Builder alert_dialog_3 = new AlertDialog.Builder(MainActivity.this);
                alert_dialog_3.setIcon(R.mipmap.ic_launcher_round);
                alert_dialog_3.setTitle("My Alert Title");
                alert_dialog_3.setMessage("Example of a simple alert dialog");

                alert_dialog_3.create().show();
            }
        });

        alert_ex_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Simple Alert with Listeners
                // Observe the difference between clicking the back button, clicking outside of the alert, and clicking on the negative button
                AlertDialog.Builder alert_dialog_4 = new AlertDialog.Builder(MainActivity.this);
                alert_dialog_4.setIcon(R.mipmap.ic_launcher_round);
                alert_dialog_4.setTitle("My Alert Title");
                alert_dialog_4.setMessage("Example of a simple alert dialog");
                alert_dialog_4.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        Snackbar.make(findViewById(android.R.id.content), "DIALOG CANCELED", Snackbar.LENGTH_SHORT).show();
                    }
                });
                alert_dialog_4.setPositiveButton("POSITIVE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.v("AC_ACTION", "CLICKED POSITIVE");
                        // Doesn't seem to get called because the Toast gets overriden by Dialog Dismissed
                        Toast.makeText(MainActivity.this, "CLICKED POSITIVE", Toast.LENGTH_SHORT).show();
                    }
                });
                alert_dialog_4.setNegativeButton("NEGATIVE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.v("AC_ACTION", "CLICKED NEGATIVE");
                        // Doesn't seem to get called because the Toast gets overriden by Dialog Dismissed
                        Toast.makeText(MainActivity.this, "CLICKED NEGATIVE", Toast.LENGTH_SHORT).show();
                    }
                });
                alert_dialog_4.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        Toast.makeText(MainActivity.this, "DIALOG DISMISSED", Toast.LENGTH_SHORT).show();
                    }
                });

                alert_dialog_4.create().show();
            }
        });


        alert_ex_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Simple Alert NOT Cancellable WITH BUTTONS.
                AlertDialog.Builder alert_dialog_5 = new AlertDialog.Builder(MainActivity.this);
                alert_dialog_5.setIcon(R.mipmap.ic_launcher_round);
                alert_dialog_5.setTitle("My Alert Title");
                alert_dialog_5.setMessage("Example of a simple alert dialog");
                alert_dialog_5.setCancelable(false);
                alert_dialog_5.setPositiveButton("POSITIVE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "POSITIVE BUTTON CLICKED", Toast.LENGTH_SHORT).show();
                    }
                });
                alert_dialog_5.setNegativeButton("NEGATIVE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "NEGATIVE BUTTON CLICKED", Toast.LENGTH_SHORT).show();
                    }
                });
                alert_dialog_5.setNeutralButton("NEUTRAL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "NEUTRAL BUTTON CLICKED", Toast.LENGTH_SHORT).show();
                    }
                });
                alert_dialog_5.create().show();
            }
        });





    }
}
