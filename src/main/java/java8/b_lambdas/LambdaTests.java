package java8.b_lambdas;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@FunctionalInterface // a Functional interface can only have one abstract method
interface BooleanComputer {
    boolean compute(int n);
}

@FunctionalInterface
interface Computer {
    int compute (int n);
}

public class LambdaTests {


    @Test
    public void shouldCheckThatNumberIsEvenUsingAnonymousClass() {
        BooleanComputer computer = new BooleanComputer() {
            @Override
            public boolean compute(int n) {
                return n % 2 == 0;
            }
        };
        assertThat(computer.compute(2)).isTrue();
    }

    @Test
    public void shouldCheckThatNumberIsEvenUsingLambda() {
        BooleanComputer isEven = n -> (n % 2) == 0;
        assertThat(isEven.compute(2)).isTrue();
    }


    @Test
    public void shouldBeGreaterThan100() {
        BooleanComputer computer = n -> {
                int a = n*n;
                System.out.println(a);
                return (a>100);
        };
        assertThat(computer.compute(11)).isTrue();
    }

    @Test
    public void shouldDoSquareMultiplicationNoType() {
        Computer squareComputer = n -> n*n; // n's type is inferred. It is not specified anywhere.
                                            // alternative: (int n) -> n*n;
                                            // parenthesis are not mandatory if there is only one parameter. Could also write (n) -> n*n;
        assertThat(squareComputer.compute(5)).isEqualTo(25);
    }





}
