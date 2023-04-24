package org.example.clases;

import java.util.ArrayList;
import java.util.List;
public class Llave
{
    private List<Equipo> equiposTorneo;
    private String instancia;

    //Procedo a llamar a los constructores,Getters, y Setters en publico para poder llamarlos desde el main

    //Cons vacio


    public Llave()
    {

    }

    //Cons Sobrecargado

    public Llave(List<Equipo> equiposTorneo, String instancia)
    {
        this.equiposTorneo = equiposTorneo;
        this.instancia = instancia;
    }

    //Getter and Setter

    public List<Equipo> getEquiposTorneo()
    {
        return equiposTorneo;
    }

    public void setEquiposTorneo(List<Equipo> equiposTorneo)
    {
        this.equiposTorneo = equiposTorneo;
    }

    public String getInstancia()
    {
        return instancia;
    }

    public void setInstancia(String instancia)
    {
        this.instancia = instancia;
    }

    //Esta es una funcion para crear las diferentes llaves del torneo
    public void armarLLave(List<Equipo> listaGeneral, int indiceInicial)
    {
        List<Equipo> equiposLlave = new ArrayList<>();
        for (int i = indiceInicial; i < indiceInicial + 4; i++)
        {
            equiposLlave.add(listaGeneral.get(i));
        }

        this.equiposTorneo = equiposLlave;
    }
}
