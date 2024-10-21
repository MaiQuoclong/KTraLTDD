package com.example.ktraltdd;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnSave,btnDelete;
    EditText edtText;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();

        sharedPreferences = getSharedPreferences("data",MODE_PRIVATE);

        edtText.setText(sharedPreferences.getString("text",""));

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Lưu thành công",Toast.LENGTH_SHORT).show();
                String text = edtText.getText().toString().trim();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("text",text);
                editor.commit();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Xóa thành công",Toast.LENGTH_SHORT).show();
                String text = edtText.getText().toString().trim();
                edtText.setText("");
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("text");
                editor.commit();

            }
        });
    }
    private void anhXa(){
        btnSave = (Button) findViewById(R.id.button2);
        btnDelete = (Button) findViewById(R.id.button);
        edtText = (EditText) findViewById(R.id.edtText);
    }

}