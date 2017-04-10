package com.plipapps.clubespro_draftpick;

import android.app.AlertDialog;
import android.content.Context;

/**
 * Created by CC on 09/04/2017.
 */

public class Equipo {
    private  Usuario usuario;
    private String nombre;
    Jugador arquero;
    Jugador[] defensores;
    Jugador[] mediocampista;
    Jugador[] delantero;
    private Context context;

    public Equipo(String nombre, int formacion, Usuario usuario, Context context){//formacion 1(1 delantero, 5 mediocampistas,4 defensores) y formacion (2 delantero, 4 mediocampistas,4 defensores)
        this.context = context;
        this.usuario = usuario;
        this.nombre = nombre;
        if(formacion == 1){
            defensores = new Jugador[4];
            mediocampista = new Jugador[5];
            delantero = new Jugador[1];
        }else{
            defensores = new Jugador[4];
            mediocampista = new Jugador[4];
            delantero = new Jugador[2];
        }
    }

    public void setJugador(Jugador jugador) {
        int contadorMediocapista = 0;
        int contadorDefensor = 0;
        int contadorDelantero = 0;
        int contadorArquero = 0;
        if (jugador.getPosicion1() == "MCO" || jugador.getPosicion1() == "MCD" || jugador.getPosicion1() == "MI" || jugador.getPosicion1() == "MD" || jugador.getPosicion2() == "MCO" || jugador.getPosicion2() == "MCD" || jugador.getPosicion2() == "MI" || jugador.getPosicion2() == "MD") {
            if (contadorMediocapista != mediocampista.length) {
                mediocampista[contadorMediocapista] = jugador;
                contadorMediocapista++;
            } else if (contadorMediocapista == mediocampista.length) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
                builder.setMessage("Ya completaste a todos tus mediocampistas")
                        .setTitle("ERROR");
                AlertDialog dialog = builder.create();
            }

            } else if (jugador.getPosicion1() == "LD" || jugador.getPosicion1() == "LI" || jugador.getPosicion1() == "DFC" || jugador.getPosicion2() == "LD" || jugador.getPosicion2() == "LI" || jugador.getPosicion2() == "DFC") {
            if (contadorDefensor != defensores.length) {
                defensores[contadorDefensor] = jugador;
                contadorDefensor++;
            } else if (contadorDefensor == defensores.length) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
                builder.setMessage("Ya completaste a todos tus defensores")
                        .setTitle("ERROR");
                AlertDialog dialog = builder.create();
             }
            } else if (jugador.getPosicion1() == "DC" || jugador.getPosicion1() == "DC") {
            if (contadorDelantero != delantero.length) {
                delantero[contadorDelantero] = jugador;
                contadorDelantero++;
            } else if (contadorDefensor == defensores.length) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
                builder.setMessage("Ya completaste a todos tus delanteros")
                        .setTitle("ERROR");
                AlertDialog dialog = builder.create();
            }
            } else if (jugador.getPosicion1() == "PO" || jugador.getPosicion2() == "PO") {
            if (contadorArquero != 1) {
                arquero = jugador;
                contadorArquero++;
            } else if (contadorArquero == 1) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
                builder.setMessage("Ya tenes un arquero")
                        .setTitle("ERROR");
                AlertDialog dialog = builder.create();
            }

            }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
