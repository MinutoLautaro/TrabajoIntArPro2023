package org.example.clases;

import javax.swing.*;
import java.util.List;

public class Jugador
{
    private Equipo seleccionJ;
    private int puntos;

    //Procedo a llamar a los constructores,Getters, y Setters en publico para poder llamarlos desde el main

    //Cons Vacio


    public Jugador()
    {

    }

    //Cons Sobrecargado
    public Jugador(Equipo seleccionJ, int puntos)
    {
        this.seleccionJ = seleccionJ;
        this.puntos = puntos;
    }

    //Getter and Setter

    public Equipo getSeleccionJ()
    {
        return seleccionJ;
    }

    public void setSeleccionJ(Equipo seleccionJ)
    {
        this.seleccionJ = seleccionJ;
    }

    public int getPuntos()
    {
        return puntos;
    }

    public void setPuntos(int puntos)
    {
        this.puntos = puntos;
    }

    //Creo el metedo en publico para que el jugador pueda elegir su equipo
    public void elegirEquipo(List<Equipo> listaDeEquipos)
    {
        String listaEquipoSeleccion = "Equipos: \n";
        for (int i = 0; i < listaDeEquipos.size(); i++)
        {
            listaEquipoSeleccion += (i + 1) + ". " + listaDeEquipos.get(i).getNombre() + "\n";
        }
        JOptionPane.showMessageDialog(null,listaEquipoSeleccion, "Seleccion",JOptionPane.INFORMATION_MESSAGE);

        int indiceEquipo = 0;

        do {
            indiceEquipo = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el numero del equipo deseado","Seleccione su equipo",JOptionPane.INFORMATION_MESSAGE)) - 1;
        }while (indiceEquipo < 0 || indiceEquipo > 8); //Mediante un DO hago que el usuario seleccione el equipo mediante el numero de su posicion en el Array List restando 1 a su seleccion

        //JOptionPane.showMessageDialog(null,"El valor seleccionado es " + indiceEquipo); Con esta linea corrobore que la seleccion del equipo corresponda con su posicion en el Array
        JOptionPane.showMessageDialog(null,"El equipo seleccionado es: " + listaDeEquipos.get(indiceEquipo).getNombre(), "Tu seleccion",JOptionPane.INFORMATION_MESSAGE);
        //Mientras que esta linea muestra al usuario que la seleccion de equipo se ejecuto correctamente
        this.seleccionJ = listaDeEquipos.get(indiceEquipo);//Le añadimos el equipo seleccionado al jugador
    }

    public void sumarPuntos()
    {
        if(seleccionJ.isAutorizacion())
        {
            puntos++;
        }
    }
}
