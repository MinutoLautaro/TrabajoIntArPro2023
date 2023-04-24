package org.example.clases;

import org.example.enumeracion.Resultado;

public class Equipo
{
    //Declaro los atributos de la clase equipo
    private String nombre;
    private Resultado resultadoDelPartido;
    private int GolesAFavor;
    private boolean autorizacion = true; //La autorizacion ya en true para que los equipos puedan empezar jugando

    //Procedo a llamar a los constructores,Getters, y Setters en publico para poder llamarlos desde el main

    //Construcor vacio
    public Equipo()
    {

    }

    //Constructor para inicializar el equipo en un array list sin necesidad de especificar los otros atributos
    public Equipo(String nombre)
    {
        this.nombre = nombre;
    }

    //Constructor Sobrecargado
    public Equipo(String nombre, Resultado resultadoDelPartido, int golesAFavor, boolean autorizacion)
    {
        this.nombre = nombre;
        this.resultadoDelPartido = resultadoDelPartido;
        GolesAFavor = golesAFavor;
        this.autorizacion = autorizacion;
    }

    //Getter and Setter

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public Resultado getResultadoDelPartido()
    {
        return resultadoDelPartido;
    }

    public void setResultadoDelPartido(Resultado resultadoDelPartido)
    {
        this.resultadoDelPartido = resultadoDelPartido;
    }

    public int getGolesAFavor()
    {
        return GolesAFavor;
    }

    public void setGolesAFavor(int golesAFavor)
    {
        GolesAFavor = golesAFavor;
    }

    public boolean isAutorizacion()
    {
        return autorizacion;
    }

    public void setAutorizacion(boolean autorizacion)
    {
        this.autorizacion = autorizacion;
    }

    public void sumarGoles(double golesPartido)
    {
        this.GolesAFavor += golesPartido;
    }
}
