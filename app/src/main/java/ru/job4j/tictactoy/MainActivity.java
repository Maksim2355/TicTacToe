package ru.job4j.tictactoy;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {
    private Logic logic = Logic.getLogic();
    private List<Button> buttons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout layoutForButtons = findViewById(R.id.LayoutForButtons);
        for (int i=0; i < layoutForButtons.getChildCount(); i++){
            LinearLayout layout = findViewById(layoutForButtons.getChildAt(i).getId());
            for (int j=0; j < layout.getChildCount(); j++){
                Button button = findViewById(layout.getChildAt(j).getId());
                button.setOnClickListener(this::clickOnButton);
                buttons.add(button);
            }
        }

        Button restart = findViewById(R.id.restart);
        restart.setOnClickListener(this::clickOnRestart);
        restart.setText("Restart");
    }

    public boolean isWin() {
        Toast toast = Toast.makeText(
                getApplicationContext(), "",
                Toast.LENGTH_SHORT
        );
        toast.setGravity(Gravity.CENTER, 0, 0);
        if (this.logic.isWin("X")) {
            toast.setText("Победили Крестики! Начните новую Игру!");
            toast.show();
            return true;
        } else if (this.logic.isWin("O")) {
            toast.setText("Победили Нолики! Начните новую Игру!");
            toast.show();
            return true;
        } else if (this.logic.isFilled()) {
            toast.setText("Ничья! Начните новую Игру!");
            toast.show();
            return true;
        }
        return false;
    }

    public void clickOnButton(View view) {
        Button clicked = findViewById(view.getId());
        if (clicked.getText() != Logic.X && clicked.getText() != Logic.O && !isWin()) {
            clicked.setText(logic.getValue());
        String tag = (String) view.getTag();
        logic.getMatrix()
                [Character.digit(tag.charAt(0), 10)]
                [Character.digit(tag.charAt(1), 10)] = logic.getValue();
        logic.setTurn(logic.getTurn() + 1);
        Switch sw = findViewById (R.id.switch2);
        if (!sw.isChecked()) {
            List<Button> temp = buttons.stream().filter(v -> v.getText() != Logic.X && v.getText() != Logic.O).collect(Collectors.toList());
            if (temp.size() != 0) {
                Button randomButton = temp.get(new Random().nextInt(temp.size()));
                randomButton.setText(logic.getValue());
                String tagAI = (String) randomButton.getTag();
                logic.getMatrix()
                        [Character.digit(tagAI.charAt(0), 10)]
                        [Character.digit(tagAI.charAt(1), 10)] = logic.getValue();
                logic.setTurn(logic.getTurn() + 1);
            }
        }
        isWin();
        }
    }

    private void clearButtons() {
        for (Button v : buttons) {
            v.setText("");
        }
    }

    public void clickOnRestart(View view) {
        clearButtons();
        logic.clearMatrix();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        for (Button v : buttons) {
            outState.putString(String.valueOf(v.getId()), (String) v.getText());
        }
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        for (Button v : buttons) {
            v.setText(savedInstanceState.getString(String.valueOf(v.getId())));
        }
    }
}
