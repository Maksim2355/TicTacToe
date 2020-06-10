package ru.job4j.tictactoy;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void filledLogic() {
        Logic logic = new Logic(new String[][]{
                {"X", "X", "O"},
                {"O", "O", "X"},
                {"O", "O", "X"},
        });
        assertThat(logic.isFilled(), is(true));
    }

    @Test
    public void notFilledLogic() {
        Logic logic = new Logic(new String[][]{
                {"X", "X", null},
                {"O", "O", "X"},
                {"O", "O", "X"},
        });
        assertThat(logic.isFilled(), is(false));
    }

    @Test
    public void OisWinDiagonal() {
        Logic logic = new Logic(new String[][]{
                {"O", "X", null},
                {"X", "O", "X"},
                {"O", "O", "O"},
        });
        assertThat(logic.checkWin("O"), is(true));
    }

    @Test
    public void OisWinColumn() {
        Logic logic = new Logic(new String[][]{
                {"X", "O", null},
                {"X", "O", null},
                {null, "O", "X"},
        });
        assertThat(logic.checkWin("O"), is(true));
    }

    @Test
    public void XisWinRow() {
        Logic logic = new Logic(new String[][]{
                {"X", "X", "X"},
                {"O", "O", null},
                {"X", "O", "X"},
        });
        assertThat(logic.checkWin("X"), is(true));
    }

    @Test
    public void XisWinColumn() {
        Logic logic = new Logic(new String[][]{
                {"X", "X", null},
                {"O", "X", null},
                {"X", "X", "O"},
        });
        assertThat(logic.checkWin("X"), is(true));
    }

    @Test
    public void clickOnButtonDoNothing() {
        Logic logic = new Logic(new String[][]{
                {"X", "X", null},
                {"O", "X", null},
                {"X", "X", "O"},
        });
        logic.clickOnButton("00");
        String[][] expect = new String[][]{
                {"X", "X", null},
                {"O", "X", null},
                {"X", "X", "O"},
        };
        Assert.assertArrayEquals(logic.getMatrix(), expect);
    }

    @Test
    public void clickOnButtonPlaceX() {
        Logic logic = new Logic();
        logic.clickOnButton("11");
        String[][] expect = new String[][]{
                {null, null, null},
                {null, "X", null},
                {null, null, null},
        };
        Assert.assertArrayEquals(logic.getMatrix(), expect);
    }

    @Test
    public void clickOnButtonAIForDoNotLose() {
        Logic logic = new Logic(new String[][]{
                {null, null, null},
                {"O", "X", null},
                {null, "X", null},
        });
        logic.setTurn(3);
        logic.clickOnButtonWithAI();
        String[][] expect = new String[][]{
                {null, "O", null},
                {"O", "X", null},
                {null, "X", null},
        };
        Assert.assertArrayEquals(logic.getMatrix(), expect);
    }

    @Test
    public void clickOnButtonAIForWin() {
        Logic logic = new Logic(new String[][]{
                {"O", "X", null},
                {"O", null, "X"},
                {null, "X", null},
        });
        logic.setTurn(5);
        logic.clickOnButtonWithAI();
        String[][] expect = new String[][]{
                {"O", "X", null},
                {"O", null, "X"},
                {"O", "X", null},
        };
        Assert.assertArrayEquals(logic.getMatrix(), expect);
    }

    @Test
    public void clearMatrix() {
        Logic logic = new Logic(new String[][]{
                {"O", "X", null},
                {"O", null, "X"},
                {null, "X", null},
        });
        logic.setTurn(5);
        logic.clearMatrix();
        String[][] expect = new String[][]{
                {null, null, null},
                {null, null, null},
                {null, null, null},
        };
        Assert.assertArrayEquals(logic.getMatrix(), expect);
        assertThat(logic.getTurn(), is(0));
    }

    @Test
    public void changeSide() {
        Logic logic = new Logic();
        logic.changeSide();
        assertThat(logic.getValue(), is("O"));
        logic.changeSide();
    }

}