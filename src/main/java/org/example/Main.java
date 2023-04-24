package org.example;

import org.example.clases.*;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args)
    {
        JOptionPane.showMessageDialog(null,"Bienvenidos al torneo de futbol en Java!","Bienvenida",JOptionPane.INFORMATION_MESSAGE);

        //Creo la lista de equipos de la cual el Jugador seleccionara su equipo
        ArrayList<Equipo> listaDeEquipos = new ArrayList<>();

        Equipo e1 = new Equipo("Boca");
        Equipo e2 = new Equipo("River");
        Equipo e3 = new Equipo("Racing");
        Equipo e4 = new Equipo("Newells");
        Equipo e5 = new Equipo("Gimnaisa LP");
        Equipo e6 = new Equipo("Independiente");
        Equipo e7 = new Equipo("Estudiantes LP");
        Equipo e8 = new Equipo("Rosario Central");

        //Agrego los equipos al array creado anteriormente
        listaDeEquipos.add(e1);
        listaDeEquipos.add(e2);
        listaDeEquipos.add(e3);
        listaDeEquipos.add(e4);
        listaDeEquipos.add(e5);
        listaDeEquipos.add(e6);
        listaDeEquipos.add(e7);
        listaDeEquipos.add(e8);

        Jugador jugador = new Jugador();
        jugador.elegirEquipo(listaDeEquipos);

        //Creo y llamo la llave derecha
        Llave llaveDerecha = new Llave();
        llaveDerecha.armarLLave(listaDeEquipos,0);

        //Creo y llamo la llave izquierda
        Llave llaveIzquierda = new Llave();
        llaveIzquierda.armarLLave(listaDeEquipos,4);

       //Instancio un objeto Ronda para poder acceder a los metodos creados
        Ronda ronda = new Ronda();
        //Procedo a llamar a los cuartos, semis y la final

        //Cuartos
        ronda.cuartosDeFinal(llaveIzquierda,llaveDerecha);
        //Sumo puntos debajo de cada ronda
        jugador.sumarPuntos();
        //Semifinal
        ronda.semifinal(llaveIzquierda,llaveDerecha);
        jugador.sumarPuntos();
        //Final
        ronda.partidoFinal(llaveIzquierda,llaveDerecha);
        jugador.sumarPuntos();

        JOptionPane.showMessageDialog(null,"Has obtenido " +  jugador.getPuntos() + "  puntos por elegir a " +
                                       jugador.getSeleccionJ().getNombre(),
                                        "Puntos",JOptionPane.INFORMATION_MESSAGE);
    }
}