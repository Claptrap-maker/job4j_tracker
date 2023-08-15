package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    public void whenMultipleValidInput() {
        Output out = new StubOutput();
        String[] valid = new String[] {"0", "1", "4", "1", "6"};
        Input in = new StubInput(valid);
        ValidateInput input = new ValidateInput(out, in);
        int[] actual = new int[5];
        actual[0] = input.askInt("Enter menu:");
        actual[1] = input.askInt("Enter menu:");
        actual[2] = input.askInt("Enter menu:");
        actual[3] = input.askInt("Enter menu:");
        actual[4] = input.askInt("Enter menu:");
        int[] expected = {0, 1, 4, 1, 6};
        assertThat(actual).containsExactly(expected);
    }

    @Test
    public void whenNegativeNumberInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"-1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-1);
    }
}