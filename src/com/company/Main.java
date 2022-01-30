package com.company;

import java.util.Scanner;
import static java.lang.Math.*;

interface Printable {
    String Display();
}

abstract class Shape implements Printable {
    protected int size;

    public abstract double GetPerimeter();
    public abstract double GetSquare();
    public String Display() { return this.getClass().getSimpleName(); }
    public int GetSize() { return size; }
}

class Round extends Shape {

    Round(int size) { this.size = size; }
    public double GetPerimeter() {
        return 2 * 3.14 * size;
    }

    public double GetSquare() {
        return 3.14 * size * size;
    }
}

class Square extends Shape {

    Square(int size) { this.size = size; }
    public double GetPerimeter() {
        return 4 * size;
    }

    public double GetSquare() {
        return size * size;
    }
}

class Triangle extends Shape {

    Triangle(int size) { this.size = size; }
    public double GetPerimeter() {
        return 3 * size;
    }

    public double GetSquare() {
        return (sqrt(3) * size * size) / 4;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        int n = cin.nextInt();
        Shape[] a = new Shape[n];

        for(int i = 0; i < n; i++) {
            int t = (int) (Math.random() * 3);
            if(t == 0) a[i] = new Round((int) (Math.random() * 10) + 1);
            if(t == 1) a[i] = new Square((int) (Math.random() * 10) + 1);
            if(t == 2) a[i] = new Triangle((int) (Math.random() * 10) + 1);
        }

        for(int i = 0; i < n; i++) {
            System.out.println("Shape " + (i+1) + " :");
            System.out.println(a[i].Display() + "  x = " + a[i].GetSize());
            System.out.println("Square = " + a[i].GetSquare());
            System.out.println("Perimeter = " + a[i].GetPerimeter() + "\n");
        }
    }
}
