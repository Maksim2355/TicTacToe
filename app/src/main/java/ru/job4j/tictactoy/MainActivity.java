package ru.job4j.tictactoy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.switchmaterial.SwitchMaterial;

import java.util.ArrayList;
import java.util.List;

import ru.job4j.tictactoy.db.StatisticDao;
import ru.job4j.tictactoy.db.StatisticDb;
import ru.job4j.tictactoy.db.WinAndLosses;

public class MainActivity extends AppCompatActivity {
    private final Logic logic = new Logic();
    private final List<Button> buttons = new ArrayList<>();
    private SwitchMaterial switchSide, switchOpponent;

    private TextView numberPlayersTv;
    private TextView numbersPartiesPlayerTv;
    private TextView numbersPartiesSecondPlayerTv;
    private TextView numbersPartiesComputer;
    private TextView numbersWinAndLosePartiesPlayerTv;
    private TextView numbersWinAndLosePartiesSecondPlayerTv;
    private TextView numbersWinAndLosePartiesComputer;
    private TextView averageBathTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout layoutForButtons = findViewById(R.id.LayoutForButtons);
        for (int i = 0; i < layoutForButtons.getChildCount(); i++) {
            LinearLayout layout = findViewById(layoutForButtons.getChildAt(i).getId());
            for (int j = 0; j < layout.getChildCount(); j++) {
                Button button = findViewById(layout.getChildAt(j).getId());
                buttons.add(button);
            }
        }

        switchSide = findViewById(R.id.switchSide);
        switchSide.setOnClickListener(this::clickSwitchSide);
        switchOpponent = findViewById(R.id.switchOpponent);

        Button restart = findViewById(R.id.restart);
        restart.setOnClickListener(this::clickOnRestart);
        restart.setText("Restart");

        updateStatistic();
    }

    @SuppressLint({"StringFormatInvalid", "StringFormatMatches"})
    private void updateStatistic() {
        numberPlayersTv = findViewById(R.id.number_players_tv);
        numbersPartiesPlayerTv = findViewById(R.id.number_parties_players_tv);
        numbersPartiesSecondPlayerTv = findViewById(R.id.number_parties_second_players_tv);
        numbersPartiesComputer = findViewById(R.id.number_parties_computer_tv);
        numbersWinAndLosePartiesPlayerTv = findViewById(R.id.numbers_win_and_losses_player_tv);
        numbersWinAndLosePartiesSecondPlayerTv = findViewById(R.id.numbers_win_and_losses_second_player_tv);
        numbersWinAndLosePartiesComputer = findViewById(R.id.numbers_win_and_losses_tv);
        averageBathTime = findViewById(R.id.numbers_duration_party_tv);

        StatisticDao statisticDao = App.getInstance().getDatabase().getStatisticDao();
        List<StatisticDb> listStatisticDb = statisticDao.getStatistic();
        if (listStatisticDb.size() == 0) {
            statisticDao.addStatistic(
                    new StatisticDb(0,
                            0,
                            0,
                            0,
                            0,
                            0,
                            0,
                            0,
                            0,
                            0,
                            0,
                            0)
            );
        }

        if (listStatisticDb != null && listStatisticDb.size() > 0) {
            StatisticDb statisticDb = listStatisticDb.get(0);
            numberPlayersTv.setText(getString(R.string.count_players, statisticDb.getNumbersPlayers()));
            numbersPartiesPlayerTv.setText(getString(R.string.count_parties_players, statisticDb.getNumbersPartiesPlayer()));
            numbersPartiesSecondPlayerTv.setText(getString(R.string.count_parties_second_players, statisticDb.getNumbersPartiesSecondPlayer()));
            numbersPartiesComputer.setText(getString(R.string.count_parties_computer, statisticDb.getNumbersPartiesComputer()));

            numbersWinAndLosePartiesPlayerTv.setText(getString(R.string.count_win_losses_players, statisticDb.getNumbersWinPartiesPlayer(), statisticDb.getNumbersLosePartiesPlayer()));
            numbersWinAndLosePartiesSecondPlayerTv.setText(getString(R.string.count_win_losses_second_players, statisticDb.getNumbersWinPartiesSecondPlayer(), statisticDb.getNumbersLosePartiesSecondPlayer()));
            numbersWinAndLosePartiesComputer.setText(getString(R.string.count_win_losses_computer, statisticDb.getNumbersWinPartiesComputer(), statisticDb.getNumbersLosePartiesComputer()));

            averageBathTime.setText(getString(R.string.count_players, statisticDb.getAverageBathTime()));
        } else {
            numberPlayersTv.setText(getString(R.string.count_players, 0));
            numbersPartiesPlayerTv.setText(getString(R.string.count_parties_players, 0));
            numbersPartiesSecondPlayerTv.setText(getString(R.string.count_parties_second_players, 0));
            numbersPartiesComputer.setText(getString(R.string.count_parties_computer, 0));
            numbersWinAndLosePartiesPlayerTv.setText(getString(R.string.count_win_losses_players, 0, 0));
            numbersWinAndLosePartiesSecondPlayerTv.setText(getString(R.string.count_win_losses_second_players, 0, 0));
            numbersWinAndLosePartiesComputer.setText(getString(R.string.count_win_losses_computer, 0, 0));
            averageBathTime.setText(getString(R.string.count_players, 0));
        }
    }

    public boolean isWin() {
        Toast toast = Toast.makeText(
                getApplicationContext(),
                "",
                Toast.LENGTH_SHORT
        );
        toast.setGravity(Gravity.CENTER, 0, 0);
        if (this.logic.checkWin("X")) {
            toast.setText("Победили Крестики! Начните новую Игру!");
            toast.show();
            return true;
        } else if (this.logic.checkWin("O")) {
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
        if (clicked.getText() != Logic.firstMark && clicked.getText() != Logic.secondMark && !isWin()) {
            clicked.setText(logic.getValue());
            logic.clickOnButton((String) clicked.getTag());
            if (!switchOpponent.isChecked() && !logic.isFilled() && !logic.checkWin(Logic.firstMark) && logic.getTurn() % 2 == 1) {
                Button button = buttons.get(logic.clickOnButtonWithAI());
                button.setText(logic.getValue());
                logic.setTurn(logic.getTurn() + 1);
            }
            isWin();
        }
    }

    public void clickOnRestart(View view) {
        for (Button v : buttons) {
            v.setText("");
        }
        logic.clearMatrix();
        if (switchSide.isChecked()) {
            logic.changeSide("O");
        } else logic.changeSide("X");
    }

    public void clickSwitchSide(View view) {
        logic.changeSide();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        for (Button v : buttons) {
            outState.putString("buttons" + v.getId(), (String) v.getText());
        }
        for (int i = 0; i < logic.getMatrix().length; i++) {
            for (int j = 0; j < logic.getMatrix().length; j++) {
                outState.putString("matrix" + ((i * logic.SIZE) + j), logic.getMatrix()[i][j]);
            }
        }
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        for (Button v : buttons) {
            v.setText(savedInstanceState.getString("buttons" + v.getId()));
        }
        for (int i = 0; i < logic.getMatrix().length; i++) {
            for (int j = 0; j < logic.getMatrix().length; j++) {
                logic.getMatrix()[i][j] = savedInstanceState.getString("matrix" + ((i * logic.SIZE) + j));
            }
        }
    }
}