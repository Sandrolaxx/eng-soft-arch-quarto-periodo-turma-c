package com.fag.raul;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CalculadoraService {

    @Inject
    CalculadoraModel calculadoraModel;

    public double realizarCalculo(double num1, double num2, String operacao) {
        double resultado;

        switch (operacao) {
            case "somar":
                resultado = calculadoraModel.somar(num1, num2);
                break;
            case "subtrair":
                resultado = calculadoraModel.subtrair(num1, num2);
                break;
            case "multiplicar":
                resultado = calculadoraModel.multiplicar(num1, num2);
                break;
            case "dividir":
                resultado = calculadoraModel.dividir(num1, num2);
                break;
            default:
                throw new IllegalArgumentException("Operação inválida: " + operacao);
        }

        return resultado;
    }
}
