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

import static io.augusteiner.calc.EOperacao.*;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class CalcCtrlr {

    private Operador operador1;
    private Operador operador2;

    private EOperacao operacaoAtual;

    private Operador display;

    private final Calculadora calculadora;

    public CalcCtrlr() {

        this.operador1 = new Operador();
        this.operador2 = new Operador();

        this.calculadora = new Calculadora();
    }

    public String getDisplay() {

        return String.valueOf(display.intValue());
    }

    public void acionadoNumero(int numero) throws CalculadoraException {

        if (numero < 0 || numero > 9)
            throw new CalculadoraException("número fora do intervalo [1, 9]");

        getOperadorAtual().putNumero(numero);
        display = getOperadorAtual();
    }

    public void acionadaOperacao(String _operacao) throws CalculadoraException {

        EOperacao operacao = EOperacao.valueOf(_operacao);

        if (operacao.equals(CE)) {

            limpar();

        } else if (operacao.equals(CALCULAR)) {

            operador1 = calcular(operacaoAtual);

        } else if (operacaoAtual != null) {

            if (operador2.isNulo()) {

                operacaoAtual = operacao;

            } else {

                display = calcular(operacaoAtual);

                operador1 = display;
                acionadaOperacao(_operacao);

            }

        } else {

            operacaoAtual = operacao;
        }

    }

    private Operador calcular(EOperacao operacao) throws CalculadoraException {

        int r;

        if (operacao.equals(ADICAO)) {

            r = calculadora.somar(operador1.intValue(), operador2.intValue());

        } else if (operacao.equals(SUBTRACAO)) {

            r = calculadora.subtrair(operador1.intValue(), operador2.intValue());

        } else if (operacao.equals(DIVISAO)) {

            r = calculadora.dividir(operador1.intValue(), operador2.intValue());

        } else if (operacao.equals(MULTIPLICACAO)) {

            r = calculadora.multiplicar(operador1.intValue(), operador2.intValue());

        } else {

            throw new CalculadoraException("operação não suportada");
        }

        display = new Operador(r);

        limpar();

        return display;

    }

    private void limpar() {

        this.operador1.limpar();
        this.operador2.limpar();

        this.operacaoAtual = null;
    }

    public void acionadoSeparadorDecimal() throws CalculadoraException {

        this.getOperadorAtual().putSeparadorDecimal();
    }

    private Operador getOperadorAtual() {

        Operador operador = operador1;

        if (this.operacaoAtual != null)
            operador = this.operador2;

        return operador;

    }

}
