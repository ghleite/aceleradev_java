package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

import java.lang.reflect.Field;
import java.math.BigDecimal;

public class CalculadorDeClasses implements Calculavel {

    @Override
    public BigDecimal somar(Object objeto) throws IllegalAccessException {
        
        BigDecimal soma = BigDecimal.ZERO;
        Field[] campos = objeto.getClass().getDeclaredFields();
        int iterator = 0;

        for (Field campo : campos) {
            campo.setAccessible(true);
            if(campo.getType().equals(BigDecimal.class) && campo.isAnnotationPresent(Somar.class)) {
                soma = soma.add((BigDecimal) campo.get(objeto));
                iterator++;
            }
        }

        if(iterator == 0) return BigDecimal.ZERO;
        else return soma;
    }

    @Override
    public BigDecimal subtrair(Object objeto) throws IllegalAccessException {

        BigDecimal subtracao = BigDecimal.ZERO;
        Field[] campos = objeto.getClass().getDeclaredFields();
        int iterator = 0;

        for (Field campo : campos) {
            campo.setAccessible(true);
            if(campo.getType().equals(BigDecimal.class) && campo.isAnnotationPresent(Subtrair.class)) {
                subtracao = subtracao.add((BigDecimal) campo.get(objeto));
                iterator++;
            }
        }

        if(iterator == 0) return BigDecimal.ZERO;
        else return subtracao;
    }

    @Override
    public BigDecimal totalizar(Object objeto) throws IllegalAccessException {
        return somar(objeto).subtract(subtrair(objeto));
    }
}
