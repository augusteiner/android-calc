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

/**
 * @author augusteiner
 */
class Operador implements Cloneable {

    private StringBuilder buffer;

    private boolean isNulo;
    private boolean hasSeparador;

    public Operador(int value) {

        limpar();
        putNumero(value);
    }

    public Operador() {

        this.limpar();
    }

    public boolean isNulo() {

        return isNulo;
    }

    public void putNumero(int numero) {

        buffer.append(numero);
        isNulo = false;
    }

    public void putSeparadorDecimal() throws CalculadoraException {

        if (this.hasSeparador)
            throw new CalculadoraException("operador já possui separador decimal");

        buffer.append('.');

        hasSeparador = true;
        isNulo = false;

    }

    public int intValue() {

        return (int) doubleValue();
    }

    public double doubleValue() {

        String number = buffer.toString();

        if (number.endsWith("."))
            number = number.substring(0, number.length() - 1);

        return Double.parseDouble(number);
    }

    public void limpar() {

        buffer = new StringBuilder("");
        hasSeparador = false;
        isNulo = true;
    }

    @Override
    public String toString() {

        return buffer.toString();
    }

    @Override
    public Operador clone() {

        return new Operador();
    }

}
