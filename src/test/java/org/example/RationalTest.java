package org.example;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RationalTest {

    Rational rational;


    @Test
    void givenAConstructor_whenDenominatorIsZero_thenThrowsException(){
        int a = 1;
        int b = 0;



        assertThrows(RuntimeException.class,() -> rational= new Rational(a,b));
    }
    @Nested
    class setter {
        @Test
        void givenAMethodSetNumeratorCalled_whenEverythingIsRight_thenReturnProperResult() {
            int numerator = 2;

            rational = new Rational();
            rational.setNumerator(numerator);

            assertEquals(2, rational.getNumerator());
        }

        @Test
        void givenAMethodSetDenominatorCalled_whenEverythingIsRight_thenReturnProperResult() {
            int denominator = 5;

            rational = new Rational();
            rational.setDenominator(denominator);

            assertEquals(5, rational.getDenominator());
        }

        @Test
        void givenAMethodSetDenominatorCalled_whenDenominatorIsZero_thenThrowsException() {
            int denominator = 0;

            rational = new Rational();

            assertThrows(RuntimeException.class, () -> rational.setDenominator(denominator));
        }
    }

    @Nested
    class setNumeratorAndDenominator {
        @Test
        void givenAMethodSetNumeratorAndDenominatorCalled_whenEverythingIsRight_thenReturnProperResult() {

            int numerator = 3;
            int denominator = 4;

            rational = new Rational();
            rational.setNumeratorAndDenominator(numerator, denominator);

            assertEquals(3, rational.getNumerator());
            assertEquals(4, rational.getDenominator());
        }

        @Test
        void givenAMethodSetNumeratorAndDenominatorCalled_whenNumeratorDivisibleDenominator_thenReturnSimplifiedResult() {
            int numerator = 2;
            int denominator = 4;

            rational = new Rational();
            rational.setNumeratorAndDenominator(numerator, denominator);

            assertEquals(1, rational.getNumerator());
            assertEquals(2, rational.getDenominator());

        }

        @Test
        void givenAMethodSetNumeratorAndDenominatorCalled_whenDenominatorIsZero_thenThrowsException() {
            int numerator = 1;
            int denominator = 0;

            rational = new Rational();

            assertThrows(RuntimeException.class, () -> rational.setNumeratorAndDenominator(numerator, denominator));
        }
    }

    @Nested
    class add {
        @Test
        void givenAMethodAddCalled_whenEverythingIsSimpleAndRight_thenReturnPropreResult() {
            Rational actualR1 = new Rational(1, 2);
            Rational actualR2 = new Rational(2, 3);
            Rational expectedR = new Rational(7, 6);

            Rational addR = actualR1.add(actualR2);

            assertEquals(expectedR.getNumerator(), addR.getNumerator());
            assertEquals(expectedR.getDenominator(), addR.getDenominator());
        }

        @Test
        void givenAMethodAddCalled_whenBothRationalNumeratorDivisibleDenominator_thenReturnPropreResult() {
            Rational actualR1 = new Rational(2, 4);
            Rational actualR2 = new Rational(5, 15);
            Rational expectedR = new Rational(5, 6);

            Rational addR = actualR1.add(actualR2);

            assertEquals(expectedR.getNumerator(), addR.getNumerator());
            assertEquals(expectedR.getDenominator(), addR.getDenominator());
        }

        @Test
        void givenAMethodAddCalled_whenOneOfRationalIsNegative_thenReturnProperResult() {
            Rational actualR1 = new Rational(-2, 4);
            Rational actualR2 = new Rational(5, 15);
            Rational expectedR = new Rational(-1, 6);

            Rational addR = actualR1.add(actualR2);

            assertEquals(expectedR.getNumerator(), addR.getNumerator());
            assertEquals(expectedR.getDenominator(), addR.getDenominator());
        }

        @Test
        void givenAMethodAddCalled_whenOneOfRationalNumeratorIsZero_thenReturnProperResult() {
            Rational actualR1 = new Rational(0, 4);
            Rational actualR2 = new Rational(5, 15);
            Rational expectedR = new Rational(1, 3);

            Rational addR = actualR1.add(actualR2);

            assertEquals(expectedR.getNumerator(), addR.getNumerator());
            assertEquals(expectedR.getDenominator(), addR.getDenominator());
        }

        @Test
        void givenAMethodAddCalled_whenBothRationalNumeratorIsZero_thenReturnZeroOnOne() {
            Rational actualR1 = new Rational(0, 4);
            Rational actualR2 = new Rational(0, 15);
            Rational expectedR = new Rational(0, 1);

            Rational addR = actualR1.add(actualR2);

            assertEquals(expectedR.getNumerator(), addR.getNumerator());
            assertEquals(expectedR.getDenominator(), addR.getDenominator());
        }
    }

    @Nested
    class sub {

        @Test
        void givenAMethodSubCalled_whenEverythingIsRight_thenReturnProperResult() {
            Rational actualR1 = new Rational(3, 4);
            Rational actualR2 = new Rational(2, 3);
            Rational expectedR = new Rational(1, 12);

            Rational subR = actualR1.sub(actualR2);

            assertEquals(expectedR.getNumerator(), subR.getNumerator());
            assertEquals(expectedR.getDenominator(), subR.getDenominator());
        }

        @Test
        void givenAMethodSubCalled_whenSecondRationalBiggerThanFirstRational_thenReturnNegativeResult() {
            Rational actualR1 = new Rational(1, 2);
            Rational actualR2 = new Rational(2, 3);
            Rational expectedR = new Rational(-1, 6);

            Rational subR = actualR1.sub(actualR2);

            assertEquals(expectedR.getNumerator(), subR.getNumerator());
            assertEquals(expectedR.getDenominator(), subR.getDenominator());
        }

        @Test
        void givenAMethodSubCalled_whenSecondRationalIsNegative_thenReturnPositiveResult() {
            Rational actualR1 = new Rational(1, 2);
            Rational actualR2 = new Rational(-2, 3);
            Rational expectedR = new Rational(7, 6);

            Rational subR = actualR1.sub(actualR2);

            assertEquals(expectedR.getNumerator(), subR.getNumerator());
            assertEquals(expectedR.getDenominator(), subR.getDenominator());
        }

        @Test
        void givenAMethodSubCalled_whenBothRationalIsNegativeAndFirstBiggerThanSecond_thenReturnNegativeResult() {
            Rational actualR1 = new Rational(-3, 4);
            Rational actualR2 = new Rational(-2, 3);
            Rational expectedR = new Rational(-1, 12);

            Rational subR = actualR1.sub(actualR2);

            assertEquals(expectedR.getNumerator(), subR.getNumerator());
            assertEquals(expectedR.getDenominator(), subR.getDenominator());
        }

        @Test
        void givenAMethodSubCalled_whenBothRationalIsNegativeAndSecondBiggerThanFirst_thenReturnPositiveResult() {
            Rational actualR1 = new Rational(-2, 3);
            Rational actualR2 = new Rational(-3, 4);
            Rational expectedR = new Rational(1, 12);

            Rational subR = actualR1.sub(actualR2);

            assertEquals(expectedR.getNumerator(), subR.getNumerator());
            assertEquals(expectedR.getDenominator(), subR.getDenominator());
        }

        @Test
        void givenAMethodSubCalled_whenBothRationalNumeratorDivisibleDenominator_thenReturnProperResult() {
            Rational actualR1 = new Rational(8, 12);
            Rational actualR2 = new Rational(3, 15);
            Rational expectedR = new Rational(7, 15);

            Rational subR = actualR1.sub(actualR2);

            assertEquals(expectedR.getNumerator(), subR.getNumerator());
            assertEquals(expectedR.getDenominator(), subR.getDenominator());
        }

        @Test
        void givenAMethodSubCalled_whenOneOfRationalNumeratorIsZero_thenReturnProperResult() {
            Rational actualR1 = new Rational(0, 2);
            Rational actualR2 = new Rational(3, 15);
            Rational expectedR = new Rational(-3, 15);

            Rational subR = actualR1.sub(actualR2);

            assertEquals(expectedR.getNumerator(), subR.getNumerator());
            assertEquals(expectedR.getDenominator(), subR.getDenominator());
        }

        @Test
        void givenAMethodSubCalled_whenBothRationalNumeratorIsZero_thenReturnZeroOnOne() {
            Rational actualR1 = new Rational(0, 2);
            Rational actualR2 = new Rational(0, 100);
            Rational expectedR = new Rational(0, 1);

            Rational subR = actualR1.sub(actualR2);

            assertEquals(expectedR.getNumerator(), subR.getNumerator());
            assertEquals(expectedR.getDenominator(), subR.getDenominator());
        }

    }

    @Nested
    class mul{
        @Test
        void givenAMethodMulCalled_whenEverythingIsRight_thenReturnProperResult() {
            Rational actualR1 = new Rational(4, 5);
            Rational actualR2 = new Rational(2, 3);
            Rational expectedR = new Rational(8, 15);

            Rational mulR = actualR1.mul(actualR2);

            assertEquals(expectedR.getNumerator(), mulR.getNumerator());
            assertEquals(expectedR.getDenominator(), mulR.getDenominator());
        }

        @Test
        void givenAMethodMulCalled_whenBothRationalNumeratorDivisibleDenominator_thenReturnProperResult(){
            Rational actualR1 = new Rational(12, 50);
            Rational actualR2 = new Rational(42, 60);
            Rational expectedR = new Rational(21, 125);

            Rational mulR = actualR1.mul(actualR2);

            assertEquals(expectedR.getNumerator(), mulR.getNumerator());
            assertEquals(expectedR.getDenominator(), mulR.getDenominator());
        }

        @Test
        void givenAMethodMulCalled_whenOneOfRationalNumeratorIsZero_thenReturnZeroOnOne() {
            Rational actualR1 = new Rational(0, 5);
            Rational actualR2 = new Rational(42, 60);
            Rational expectedR = new Rational(0, 1);

            Rational mulR = actualR1.mul(actualR2);

            assertEquals(expectedR.getNumerator(), mulR.getNumerator());
            assertEquals(expectedR.getDenominator(), mulR.getDenominator());
        }

        @Test
        void givenAMethodMulCalled_whenOneOfRationalIsNegative_thenReturnNegativeResult(){
            Rational actualR1 = new Rational(2, 5);
            Rational actualR2 = new Rational(-3, 6);
            Rational expectedR = new Rational(-1, 5);

            Rational mulR = actualR1.mul(actualR2);

            assertEquals(expectedR.getNumerator(), mulR.getNumerator());
            assertEquals(expectedR.getDenominator(), mulR.getDenominator());
        }

        @Test
        void givenAMethodMulCalled_whenBothRationalIsNegative_thenReturnPositiveResult(){
            Rational actualR1 = new Rational(-2, 5);
            Rational actualR2 = new Rational(-3, 6);
            Rational expectedR = new Rational(1, 5);

            Rational mulR = actualR1.mul(actualR2);

            assertEquals(expectedR.getNumerator(), mulR.getNumerator());
            assertEquals(expectedR.getDenominator(), mulR.getDenominator());
        }

    }

    @Nested
    class div {
        @Test
        void givenAMethodDivCalled_whenEverythingIsRight_thenReturnProperResult() {
            Rational actualR1 = new Rational(4, 5);
            Rational actualR2 = new Rational(2, 3);
            Rational expectedR = new Rational(6, 5);

            Rational divR = actualR1.div(actualR2);

            assertEquals(expectedR.getNumerator(), divR.getNumerator());
            assertEquals(expectedR.getDenominator(), divR.getDenominator());
        }

        @Test
        void givenAMethodDivCalled_whenBothRationalNumeratorDivisibleDenominator_thenReturnProperResult() {
            Rational actualR1 = new Rational(27, 90);
            Rational actualR2 = new Rational(17, 34);
            Rational expectedR = new Rational(3, 5);

            Rational divR = actualR1.div(actualR2);

            assertEquals(expectedR.getNumerator(), divR.getNumerator());
            assertEquals(expectedR.getDenominator(), divR.getDenominator());
        }

        @Test
        void givenAMethodDivCalled_whenOneOfTheRationalNumeratorIsZero_thenReturnProperResult(){
            Rational actualR1 = new Rational(0, 9);
            Rational actualR2 = new Rational(8, 50);
            Rational expectedR = new Rational(0, 4);

            Rational divR = actualR1.div(actualR2);

            assertEquals(expectedR.getNumerator(), divR.getNumerator());
            assertEquals(expectedR.getDenominator(), divR.getDenominator());
        }
        @Test
        void givenAMethodDivCalled_whenSecondTheRationalNumeratorIsZero_thenReturnProperResult(){
            Rational actualR1 = new Rational(8, 9);
            Rational actualR2 = new Rational(0, 50);

            assertThrows(RuntimeException.class,() -> actualR1.div(actualR2));
        }
        @Test
        void givenAMethodDivCalled_whenBothRationalNumeratorIsZero_thenThrowsException(){
            Rational actualR1 = new Rational(0, 5);
            Rational actualR2 = new Rational(0, 7);

            assertThrows(RuntimeException.class,() -> actualR1.div(actualR2));
        }

        @Test
        void givenAMethodDivCalled_whenOneOfRationalIsNegative_thenReturnNegativeResult(){
            Rational actualR1 = new Rational(2, 5);
            Rational actualR2 = new Rational(-3, 6);
            Rational expectedR = new Rational(-4, 5);

            Rational divR = actualR1.div(actualR2);

            assertEquals(expectedR.getNumerator(), divR.getNumerator());
            assertEquals(expectedR.getDenominator(), divR.getDenominator());
        }

        @Test
        void givenAMethodDivCalled_whenBothRationalIsNegative_thenReturnPositiveResult(){
            Rational actualR1 = new Rational(-2, 5);
            Rational actualR2 = new Rational(-3, 6);
            Rational expectedR = new Rational(4, 5);

            Rational divR = actualR1.div(actualR2);

            assertEquals(expectedR.getNumerator(), divR.getNumerator());
            assertEquals(expectedR.getDenominator(), divR.getDenominator());
        }

        @Test
        void givenAMethodDivCalled_whenBothNumeratorAndDenominatorIsNegative_thenReturnPositiveResult(){
            Rational actualR1 = new Rational(-2, -5);
            Rational actualR2 = new Rational(-3, -6);
            Rational expectedR = new Rational(4, 5);

            Rational divR = actualR1.div(actualR2);

            assertEquals(expectedR.getNumerator(), divR.getNumerator());
            assertEquals(expectedR.getDenominator(), divR.getDenominator());
        }

    }

    @Test
    void toFloatingPoint() {
        rational = new Rational(849,4);
        double v = Rational.toFloatingPoint(rational);
        double a = 212.25;

        assertEquals(a,v);
    }

    @Test
    void testToString() {
        rational = new Rational(9,5);

        String test = "Deduction =1+ 4/5";

        assertEquals(test,rational.toString());
    }
    @Test
    void testToString2(){
        rational = new Rational(4,9);

        String test = "Deduction =4/9" ;

        assertEquals(test,rational.toString());
    }
}