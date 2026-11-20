package com.exus.executor;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(50, 50, 50, 50);

        EditText scriptInput = new EditText(this);
        scriptInput.setHint("Cole seu script Lua aqui...");
        scriptInput.setMinLines(10);
        scriptInput.setGravity(android.view.Gravity.TOP);
        
        Button executeBtn = new Button(this);
        executeBtn.setText("EXECUTAR");
        executeBtn.setOnClickListener(v -> {
            String script = scriptInput.getText().toString();
            Toast.makeText(this, "Script pronto: " + script.length() + " chars", Toast.LENGTH_SHORT).show();
        });

        layout.addView(scriptInput);
        layout.addView(executeBtn);
        setContentView(layout);
    }
}
