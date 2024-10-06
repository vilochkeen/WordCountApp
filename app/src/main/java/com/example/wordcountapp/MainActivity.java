package com.example.wordcountapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editTextInput;
    private Spinner spinnerCountType;
    private Button buttonCount;
    private TextView textViewResult;
    private TextCount textCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextInput = findViewById(R.id.editTextInput);
        spinnerCountType = findViewById(R.id.CountType);
        buttonCount = findViewById(R.id.buttonCount);
        textViewResult = findViewById(R.id.textViewResult);

        textCount = new TextCount();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.count_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCountType.setAdapter(adapter);

        buttonCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = editTextInput.getText().toString().trim();

                if (inputText.isEmpty()) {
                    Toast.makeText(MainActivity.this, R.string.empty_input, Toast.LENGTH_SHORT).show();
                } else {
                    String selectedOption = spinnerCountType.getSelectedItem().toString();
                    int result = 0;

                    if (selectedOption.equals(getString(R.string.option_words))) {
                        result = textCount.countWords(inputText);
                    } else if (selectedOption.equals(getString(R.string.option_char))) {
                        result = textCount.countCharacters(inputText);
                    }

                    textViewResult.setText(String.format("Result: %d", result));
                }
            }
        });
    }
}
