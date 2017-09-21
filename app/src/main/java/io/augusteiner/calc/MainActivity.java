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

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.augusteiner.calc.R;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class MainActivity extends AppCompatActivity {

    private CalculadoraCtrlr ctrlr;
    private EditText editResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ctrlr = new CalculadoraCtrlr();

        editResultado = (EditText) findViewById(R.id.edit_resultado);

    }

    public void btnNumero_onClick(View view) {

        String pNumero = ((Button) view).getText().toString();
        int numero = Integer.parseInt(pNumero);

        try {

            ctrlr.acionadoNumero(numero);

        } catch (CalculadoraException e) {

            e.printStackTrace();

        }

        // Toast.makeText(this, String.format("Número pressionado: %d", numero), Toast.LENGTH_SHORT).show();

        editResultado.setText(ctrlr.getDisplay());
    }

    public void btnOperacao_onClick(View view) {

        String pOperacao = ((Button) view).getTag().toString();

        try {

            ctrlr.acionadaOperacao(pOperacao);

        } catch (CalculadoraException e) {

            e.printStackTrace();

        }

        // Toast.makeText(this, String.format("Operação pressionada: %s", pOperacao), Toast.LENGTH_SHORT).show();

        editResultado.setText(ctrlr.getDisplay());
    }

}
