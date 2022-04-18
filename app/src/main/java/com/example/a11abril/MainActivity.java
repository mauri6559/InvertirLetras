package com.example.a11abril;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //atributos-variables
    private TextView txtResultado, txtVerificar;
    private EditText etPalabra;
    private Button btnProcesar, btnMensaje;

    private String palabra;
    private String invertido = "";

    //metodos - funciones

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarVistas();
        /*
        al configurar un boton para decirle que este pendiente al evento clicj de ese boton en pantalla
        con el uso del metodo .setOnClickListener()
        Lo que ese mètodo esta esperando como parametro o argunmento es una funcion que serà
        la funciòn click que activara las funciones a realizar cuando se presione el boton.
        CuANDO SE PASA UNA FUNCION COMO PARAMENTRO ESTAS GENERALMENTE SON CONOCIDAD COMO FUNCINES ANONIMAS
        la idea es que esa funcion ejecute su proceimiento a partir del metodo que la recibe como parametro.
         */

        //this: ambito o contexto de la misma clase.  busca la respuesta en la clase

        btnProcesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Este metodo onclick solo existe en el ambito del boton btnProcesar, lo que se haga a ca solo sirve para ese boton
                recibirInformacion();
                invertirPalabra();
                Verificar();
            }
        });
        btnMensaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarMensaje();
            }
        });
    }

    private void Verificar() {
        //equals verifica si la caden
        if(this.palabra.equals(invertido)){
            txtVerificar.setText("es palindromo");
        }
        else{
            txtVerificar.setText("no es palindromo");
        }
    }


    private void mostrarMensaje() {
        //Para mostrar mensajes en pantalla, ustedes pueden usar una ventana emergente temporal llamada tost que basicamente sirve
        //para mostrar informacion al usuario acerca de cuertos procesos que hayan pasado confirmaciones, mostrar algun mesaje y
        //estatico || en los estaticos no se puede instanciar
        /*
        el toast tiene un metodo llamado makeText donde vamos a configurar lo que
        le vamos a mostrar, para ello deben pasar estos parametros
         - contexto (ambito) de la pantalla donde se va a dibujar ese mesaje
         - cadena de caracteres: el mesaje a mostrar.
         - una constante de duracion del mensaje en pantalle para que durea mas o menos
         Finalmente deben decirle al toast  que se meustre con es configuracion y para ello usan el metodo o evento .show()
         */
        //cuando s constante todo esta definido en mayusculas
        Toast.makeText(this, "Hola mundo", Toast.LENGTH_SHORT).show();

    }

    private void invertirPalabra() {
        //Una anera directa de inveritr una cadena
        //Netamente codigo java
        //palabra = new StringBuilder(palabra).reverse().toString();

        //la idea es que traten la cadena strind como si fuera un array donde cada cadena esta en una posicion del array partiendo desde cero
        //para tal efecto los strings tienen un efecto que les permiten devolver un caracter de una posicion como si fuera un array
        //el metodo se llama charat(indice)

        for (int i  = this.palabra.length() - 1; i >= 0 ; i--){
            invertido = invertido + this.palabra.charAt(i); //invertido += this.palabra.charAt(i);
        }
        txtResultado.setText(invertido);



    }


    private void recibirInformacion() {
        palabra = etPalabra.getText().toString();
    }

    private void inicializarVistas() {
        txtResultado = findViewById(R.id.txtResultado);
        txtVerificar = findViewById(R.id.txtVerificar);
        etPalabra = findViewById(R.id.etPalabra);
        etPalabra = findViewById(R.id.etPalabra);
        btnProcesar = findViewById(R.id.btnProcesar);
        btnMensaje = findViewById(R.id.btnMensaje);
    }


}

//commit indicamos lo que queremos guardar.
//push manda todo a la nube
//update quiero bajar y actualizar todo lo que este en la nube a mi computadora. la primera vez sube todo