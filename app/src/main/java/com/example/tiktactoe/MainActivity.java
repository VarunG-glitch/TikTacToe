package com.example.tiktactoe;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static int counter = 0;
    // 0 -> X
    // 1 -> O
    static int[] checkBox = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    static int[][] winningMoves = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8},
            {2, 4, 6}
    };
    static boolean flag = false;

    public void functionInput(View view) {
        if (flag) {
            TextView obj = findViewById(R.id.statusbar);
            obj.setText("Tap to play first turn is X\'s turn");
            resetGame(view);
            return;
        }

        ImageView img = (ImageView) view;
        int number = Integer.parseInt(img.getTag().toString());
        if (checkBox[number - 1] == 2) {
            checkBox[number - 1] = counter;
            if (counter == 0) {
                ((ImageView) view).setImageResource(R.drawable.x);
                counter = 1;
            } else {
                img.setImageResource(R.drawable.o);
                counter = 0;
            }
            for (int[] temp : winningMoves) {
                if (checkBox[temp[0]] == checkBox[number - 1] && checkBox[temp[1]] == checkBox[number - 1] && checkBox[temp[2]] == checkBox[number - 1]) {
                    String value = "";
                    if (checkBox[temp[0]] == 1) {
                        value = "O";
                    } else {
                        value = "X";
                    }
                    value = "Winning player is: " + value;
                    TextView obj = findViewById(R.id.statusbar);
                    obj.setText(value);
                    for (int i = 0; i < checkBox.length; i++)
                        checkBox[i] = 2;
                    Toast.makeText(this, "Tap to reset the game", Toast.LENGTH_SHORT).show();
                    flag = true;
                    counter = 0;
                    break;
                }
            }
            if (!flag) {
                TextView obj = findViewById(R.id.statusbar);
                String status = "";
                if (counter == 0)
                    status = "X";
                else
                    status = "0";
                status = "Now its: " + status + "\'s turn";
                obj.setText(status);

            }
        }
        else{
            Toast.makeText(this, "Invalid Move", Toast.LENGTH_SHORT).show();
        }
        checkGame(view);
    }
    public void checkGame(View view){
        int temp =  0;
        for (int i : checkBox){
            if (i == 2) {
                temp = i;
                break;
            }
        }
        if (temp != 2){
            TextView obj = findViewById(R.id.statusbar);
            obj.setText("Match Draw! tap again to play");
            counter = 0;
            for (int i = 0 ; i < checkBox.length ; i++){
                checkBox[i] = 2;
            }
            resetGame(view);
        }
        else{
            return;
        }
    }
    public void resetGame(View view){
        flag = false;
        ImageView obj = (ImageView)findViewById(R.id.img1);
        obj.setImageResource(0);
        obj = (ImageView)findViewById(R.id.img2);
        obj.setImageResource(0);
        obj = (ImageView)findViewById(R.id.img3);
        obj.setImageResource(0);
        obj = (ImageView)findViewById(R.id.img4);
        obj.setImageResource(0);
        obj = (ImageView)findViewById(R.id.img5);
        obj.setImageResource(0);
        obj = (ImageView)findViewById(R.id.img6);
        obj.setImageResource(0);
        obj = (ImageView)findViewById(R.id.img7);
        obj.setImageResource(0);
        obj = (ImageView)findViewById(R.id.img8);
        obj.setImageResource(0);
        obj = (ImageView)findViewById(R.id.img9);
        obj.setImageResource(0);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}