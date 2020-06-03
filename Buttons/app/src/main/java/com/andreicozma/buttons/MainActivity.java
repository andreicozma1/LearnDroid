package com.andreicozma.buttons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView selectedBtnText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectedBtnText = findViewById(R.id.selectedButtonText);
    }

    public void selectBtn(View view) {
        Button btn = (Button) view;
        selectedBtnText.setText("You clicked on: " + btn.getText());
    }

    public void resetSelection(View view) {
        selectedBtnText.setText(R.string.nothing_selected);
    }
}
