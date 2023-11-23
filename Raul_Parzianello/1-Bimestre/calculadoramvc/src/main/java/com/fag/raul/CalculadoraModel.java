package com.fag.raul;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CalculadoraModel {
    public double somar(double num1, double num2) {
        return num1 + num2;
    }

    public double subtrair(double num1, double num2) {
        return num1 - num2;
    }

    public double multiplicar(double num1, double num2) {
        return num1 * num2;
    }

    public double dividir(double num1, double num2) {
        if (num2 == 0) {
            return Double.NaN; // Retornar NaN para divisão por zero
        }
        return num1 / num2;
    }
}
