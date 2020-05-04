package com.challenge.interfaces;

import java.math.BigDecimal;

public interface Calculavel {

    public BigDecimal somar(Object objeto) throws IllegalAccessException;
    public BigDecimal subtrair(Object objeto) throws IllegalAccessException;
    public BigDecimal totalizar(Object objeto) throws IllegalAccessException;
}
