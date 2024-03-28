package org.example;

import java.util.Scanner;

public class Rational {

    private int numerator;
    private int denominator;

    public Rational() {
        this.numerator = 0;
        this.denominator = 1;
    }

    public Rational(int numerator, int denominator) {
        if (denominator == 0) {
            throw new RuntimeException("denominator can't be zero");
        }else {
            checkDeduction(numerator,denominator);
        }
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        if (denominator == 0) {
            System.out.println();
            throw new RuntimeException("denominator can't be zero");
        }else this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setNumeratorAndDenominator(int numerator,int denominator){
        this.numerator = numerator;
        if (denominator == 0) {
            throw new RuntimeException("denominator can't be zero");
        }else this.denominator = denominator;

        checkDeduction(this.numerator,this.denominator);
    }

    private void checkDeduction(int numerator, int denominator){
        int greatestCommonDivisor = 1;
        int max = Math.max(numerator, denominator);
        if (denominator < 0){
            numerator = -numerator;
            denominator = -denominator;
        }
        if (denominator !=0){
            for (int i = 1; i <= max; i++) {
            if (numerator % i == 0 && denominator % i == 0)
                greatestCommonDivisor = i;
            }
            this.numerator = (numerator / greatestCommonDivisor);
            this.denominator = (denominator / greatestCommonDivisor);
        }
    }

    private void checkAnotherDeduction(Rational rational){
        int greatestCommonDivisor = 1;
        int max = Math.max(rational.getNumerator(),rational.getDenominator());
        if (rational.getDenominator() < 0){
            rational.setNumerator(-rational.getNumerator());
            rational.setDenominator(-rational.getDenominator());
        }
        if (rational.getDenominator() != 0){
            for (int i = 1; i <= max; i++) {
                if (rational.getNumerator() % i == 0 && rational.getDenominator() % i == 0)
                    greatestCommonDivisor = i;
            }
            rational.setNumerator((rational.getNumerator()/greatestCommonDivisor));
            rational.setDenominator((rational.getDenominator()/greatestCommonDivisor));
        }

    }

    public Rational add(Rational num){
        Rational addRational = new Rational();
        addRational.setNumerator(
                (this.numerator * num.getDenominator() + num.getNumerator() * this.denominator)
        );
        addRational.setDenominator(
                (this.denominator * num.denominator)
        );
        checkAnotherDeduction(addRational);
        return addRational;
    }

    public Rational sub(Rational num){
        Rational subRational = new Rational();
        subRational.setNumerator(
                (this.numerator*num.denominator - num.numerator*this.denominator)
        );
        if (this.denominator == num.denominator){
            subRational.setDenominator(num.denominator);
        }else {
            subRational.setDenominator(
                (this.denominator*num.denominator));
        }
        if (subRational.getNumerator() != 0) {
            checkAnotherDeduction(subRational);
        }
        return subRational;
    }

    public Rational mul(Rational num){
        Rational mulRational = new Rational();
        mulRational.setNumerator(
                (this.numerator * num.numerator)
        );
        mulRational.setDenominator(
                (this.denominator * num.denominator)
        );
        checkAnotherDeduction(mulRational);

        return mulRational;
    }


    public Rational div(Rational num){
        Rational divRational = new Rational();
        divRational.setNumerator(this.numerator*num.denominator);
        divRational.setDenominator(this.denominator*num.numerator);
        checkAnotherDeduction(divRational);
        return divRational;
    }

    public static double toFloatingPoint(Rational num){
        double floatingPoint;
        floatingPoint = ((double) num.getNumerator() / num.getDenominator());
        return floatingPoint;
    }

    @Override
    public String toString() {


        if (this.numerator>this.denominator){
            int completePart = (this.numerator/this.denominator);
            return "Deduction ="+ completePart +"+"+" "+(this.numerator-(this.denominator*completePart)) +"/"+this.denominator;
        }else{
        return "Deduction ="+ this.numerator+"/"+this.denominator;
        }
    }
}
