/*
 * MIT License
 *
 * Copyright (c) 2017 José Nascimento <joseaugustodearaujonascimento@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package io.augusteiner.calc;

import org.junit.*;
import org.junit.rules.*;

import static io.augusteiner.calc.EOperacao.*;

import static org.junit.Assert.*;

/**
 * @author augusteiner
 */
public class CalculadoraCtrlrTest {

    private CalculadoraCtrlr ctrlr;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() {

        ctrlr = new CalculadoraCtrlr();
    }

    @Test
    public void testAcionarNumeroAtualizaDisplay() throws CalculadoraException {

        ctrlr.acionadoNumero(1);

        assertEquals(ctrlr.getDisplay(), "1");

    }

    //@Test
    //public void testAcionarPrimeiroOperacaoMultiplicacaoJogaExcecao() throws CalculadoraException {
    //
    //    thrown.expect(CalculadoraException.class);
    //
    //    ctrlr.acionadaOperacao(MULTIPLICACAO);
    //
    //}

    @Test
    public void testSubtracaoComResultadoNegativo() throws CalculadoraException {

        ctrlr.acionadoNumero(1);
        ctrlr.acionadaOperacao(SUBTRACAO);
        ctrlr.acionadoNumero(3);
        ctrlr.acionadaOperacao(CALCULAR);

        assertEquals("-2", ctrlr.getDisplay());

    }

    @Test
    public void testSomaInteira() throws CalculadoraException {

        ctrlr.acionadoNumero(1);
        ctrlr.acionadaOperacao(ADICAO);
        ctrlr.acionadoNumero(2);
        ctrlr.acionadaOperacao(CALCULAR);

        assertEquals("3", ctrlr.getDisplay());

    }

    @Test
    public void testSubtracaoInteira() throws CalculadoraException {

        ctrlr.acionadoNumero(4);
        ctrlr.acionadaOperacao(SUBTRACAO);
        ctrlr.acionadoNumero(1);
        ctrlr.acionadaOperacao(CALCULAR);

        assertEquals("3", ctrlr.getDisplay());

    }

    @Test
    public void testMultiplicacaoInteira() throws CalculadoraException {

        ctrlr.acionadoNumero(3);
        ctrlr.acionadaOperacao(MULTIPLICACAO);
        ctrlr.acionadoNumero(2);
        ctrlr.acionadaOperacao(CALCULAR);

        assertEquals("6", ctrlr.getDisplay());

    }

    @Test
    public void testDivisaoInteira() throws CalculadoraException {

        ctrlr.acionadoNumero(6);
        ctrlr.acionadaOperacao(DIVISAO);
        ctrlr.acionadoNumero(2);
        ctrlr.acionadaOperacao(CALCULAR);

        assertEquals("3", ctrlr.getDisplay());

    }

}
