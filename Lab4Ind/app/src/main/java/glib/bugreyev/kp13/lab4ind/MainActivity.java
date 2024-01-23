package glib.bugreyev.kp13.lab4ind;

import static com.google.android.material.internal.ContextUtils.getActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button rememberBtn = findViewById(R.id.remember);
        Button clearBtn = findViewById(R.id.clear);
        Button exitBtn = findViewById(R.id.exit);
        ImageView imageView = findViewById(R.id.image);

        EditText surnameEdit = findViewById(R.id.surname_edit);
        EditText nameEdit = findViewById(R.id.name_edit);
        EditText dateEdit = findViewById(R.id.date_edit);
        TextView resTextView = findViewById(R.id.res_text);
        Drawable emptyImage = getResources().getDrawable(R.drawable.empty);
        Drawable studentImage = getResources().getDrawable(R.drawable.student);

        rememberBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageDrawable(studentImage);

                String resStr = "Ваше ім'я ";
                resStr += surnameEdit.getText() + " ";
                resStr += nameEdit.getText() + "\n";
                resStr += dateEdit.getText();

                resTextView.setText(resStr);

                writeToFile(resStr);

            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                surnameEdit.setText("");
                nameEdit.setText("");
                dateEdit.setText("");
                imageView.setImageDrawable(emptyImage);
            }
        });

        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
    }

    private void writeToFile(String message) {

        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput("remembered.txt",
                    Context.MODE_PRIVATE));
            outputStreamWriter.append(message);
            outputStreamWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}