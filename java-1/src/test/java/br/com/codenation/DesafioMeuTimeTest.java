package br.com.codenation;

import br.com.codenation.DesafioMeuTimeApplication;

import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.*;

public class DesafioMeuTimeTest {

    DesafioMeuTimeApplication DMTA;

    @Before
    public void definition() {
        DMTA = new DesafioMeuTimeApplication();
    }

    @Test
    public void gerarUmTime() {
        DMTA.incluirTime(1L, "Barcelona", LocalDate.now(), "vermelho", "azul");
        DMTA.incluirTime(1L, "Barcelona", LocalDate.now(), "vermelho", "azul");
    }

    @Test(expected = TimeNaoEncontradoException.class)
    public void gerarJogadores() {
        DMTA.incluirTime(1L, "Barcelona", LocalDate.now(), "vermelho", "azul");
        DMTA.incluirJogador(1L, 2L, "Ronaldo", LocalDate.now(), 5, new BigDecimal("100.0"));
    }

    @Test(expected = IdentificadorUtilizadoException.class)
    public void deveRetornarExcecao() {
        DMTA.incluirTime(1L, "Barcelona", LocalDate.now(), "vermelho", "azul");
        DMTA.incluirJogador(1L, 1L, "Ronaldo", LocalDate.now(), 5, new BigDecimal("100.0"));
        DMTA.incluirJogador(1L, 1L, "Ronaldo", LocalDate.now(), 5, new BigDecimal("100.0"));
    }

    @Test
    public void deveRetornarJogadorMaisVelho() {
        DMTA.buscarTopJogadores(2);
    }
}
