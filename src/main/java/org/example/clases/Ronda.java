package org.example.clases;

import javax.swing.*;
import java.util.List;

public class Ronda
{
    private int numeroRonda;
    private int cantEquipos;
    private int cantEquiposLlave;

    //Procedo a llamar a los constructores,Getters, y Setters en publico para poder llamarlos desde el main

    //Cons Vacio
    public Ronda()
    {

    }

    //Cons Sobrecargado

    public Ronda(int numeroRonda, int cantEquipos, int cantEquiposLlave)
    {
        this.numeroRonda = numeroRonda;
        this.cantEquipos = cantEquipos;
        this.cantEquiposLlave = cantEquiposLlave;
    }

    //Getter and Setter

    public int getNumeroRonda()
    {
        return numeroRonda;
    }

    public void setNumeroRonda(int numeroRonda)
    {
        this.numeroRonda = numeroRonda;
    }

    public int getCantEquipos()
    {
        return cantEquipos;
    }

    public void setCantEquipos(int cantEquipos)
    {
        this.cantEquipos = cantEquipos;
    }

    public int getCantEquiposLlave()
    {
        return cantEquiposLlave;
    }

    public void setCantEquiposLlave(int cantEquiposLlave)
    {
        this.cantEquiposLlave = cantEquiposLlave;
    }

    public void cuartosDeFinal(Llave llaveIzquierda, Llave llaveDerecha)
    {
        //Seteo el numero de la ronda
        this.numeroRonda = 3;
        //Pongo la cantida de equipos por llave como 4
        this.cantEquiposLlave = 4;
        Partido partido = new Partido();
        //Informo al usuario que comienzan los cuartos de final
        JOptionPane.showMessageDialog(null,"Comienzan los Cuartos de Final",
                                        "Cuartos", JOptionPane.INFORMATION_MESSAGE);

        //Procedo a simular los partidos
        for (int i = 0; i < cantEquiposLlave; i += 2)//Mediante este for hago que jueguen los equipos de la llave y frente al siguiente equipo de su misma llave
        {
            partido.simularPartido(llaveIzquierda.getEquiposTorneo().get(i), llaveIzquierda.getEquiposTorneo().get(i+1));
            partido.simularPartido(llaveDerecha.getEquiposTorneo().get(i), llaveDerecha.getEquiposTorneo().get(i+1));
        }

        //Mediante estas lineas remuevo los equipos que perdieron
        removerEquipos(llaveIzquierda.getEquiposTorneo());
        removerEquipos(llaveDerecha.getEquiposTorneo());
        //Actualizo a 2 equipos por llave ya que avanzaron a la semifinal
        this.cantEquiposLlave = 2;
    }

    public void removerEquipos(List<Equipo> equipos)
    {
        int contadorEquiposLlave = cantEquiposLlave;

        for (int i = 0; i <contadorEquiposLlave ; i++)//Usando el contador en lugar de la lista de equipos evito que el codigo no funciones
        {
            Equipo auxiliar = equipos.get(i);//Mediante este auxiliar puedo remover de la lista de equipos aquel que no tenga autorizacion mediante remove
            if (!auxiliar.isAutorizacion())
            {
                equipos.remove(auxiliar);//Gracias al auxiliar evito un error de referencia que ocurriria si usara equipo.get(i)
                contadorEquiposLlave--;
            }
        }
    }

    public void semifinal(Llave llaveIzquierda, Llave llaveDerecha)
    {
        //Pongo el numero de esta nueva ronda
        this.numeroRonda = 2;

        Partido partido = new Partido();
        //Informo al usuario que comienza la Semifinal
        JOptionPane.showMessageDialog(null,"Comienza la Semifinal",
                "Semifinal", JOptionPane.INFORMATION_MESSAGE);
        //Simulo los partidos de la semifinal
        partido.simularPartido(llaveIzquierda.getEquiposTorneo().get(0), llaveIzquierda.getEquiposTorneo().get(1));
        partido.simularPartido(llaveDerecha.getEquiposTorneo().get(0), llaveDerecha.getEquiposTorneo().get(1));
        //Remuevo los perdedores
        removerEquipos(llaveIzquierda.getEquiposTorneo());
        removerEquipos(llaveDerecha.getEquiposTorneo());
    }
    public void partidoFinal(Llave llaveIzquierda, Llave llaveDerecha)
    {
        //Pongo el numero de la ronda
        this.numeroRonda = 1;
        //Muestro que comienza el partido final
        JOptionPane.showMessageDialog(null,"Comienza la Gran Final",
                "Final", JOptionPane.INFORMATION_MESSAGE);

        //Simulo el partido final
        Partido partido = new Partido();
        Equipo equipo = partido.simularPartido(llaveIzquierda.getEquiposTorneo().get(0),llaveDerecha.getEquiposTorneo().get(0));
        //Muestro que equipo Gano
        JOptionPane.showMessageDialog(null, "Se a coronado Campeon " + equipo.getNombre(),"Campeon",JOptionPane.INFORMATION_MESSAGE);



    }
}
