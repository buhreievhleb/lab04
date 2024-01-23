package glib.bugreyev.kp13.lab4constraint;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public static boolean move = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConstraintLayout constraintLayout = findViewById(R.id.constraint);
                ConstraintSet constraintSet = new ConstraintSet();
                constraintSet.clone(constraintLayout);
                if (move) {
                    constraintSet.connect(R.id.text4, ConstraintSet.BOTTOM, R.id.pink_block, ConstraintSet.BOTTOM);
                } else {
                    constraintSet.connect(R.id.text4, ConstraintSet.BOTTOM, R.id.green_block, ConstraintSet.BOTTOM);
                }
                move = !move;
                constraintSet.applyTo(constraintLayout);
            }
        });
    }
}