package org.example.clases;

import org.example.enumeracion.Resultado;

import javax.swing.*;

public class Partido
{
    private double golesLocal;
    private double golesVisita;

    //Procedo a llamar a los constructores,Getters, y Setters en publico para poder llamarlos desde el main

    //Cons vacio

    public Partido()
    {

    }

    //cons Sobrecargado

    public Partido(double golesLocal, double golesVisita)
    {
        this.golesLocal = golesLocal;
        this.golesVisita = golesVisita;
    }

    //Getter and Setter

    public double getGolesLocal()
    {
        return golesLocal;
    }

    public void setGolesLocal(double golesLocal)
    {
        this.golesLocal = golesLocal;
    }

    public double getGolesVisita()
    {
        return golesVisita;
    }

    public void setGolesVisita(double golesVisita)
    {
        this.golesVisita = golesVisita;
    }

    //Funcion para simular los partidos
    public Equipo simularPartido(Equipo equipoLocal, Equipo equipoVisitante)
    {
        //golesLocal = Math.floor(Math.random() * 5);//Simulo los goles del partido de forma aleatoria
        //golesVisita = Math.floor(Math.random() * 5);//Multiplico por 5 para que no solo haya entre 0 y 1 gol, y uso el floor para redondear el numero
        golesLocal  = 2;//Harcodeo los goles para siempre tener el mismo resultado en todos los partidos
        golesVisita = 3;

        JOptionPane.showMessageDialog(null,equipoLocal.getNombre() + " " + this.golesLocal + " - " + this.golesVisita + " " + equipoVisitante.getNombre(),
                                        "Resultado del partido",JOptionPane.INFORMATION_MESSAGE);//Añado el marcador del partido con los goles de cada equipo


        equipoLocal.sumarGoles(this.golesLocal);
        equipoVisitante.sumarGoles(this.golesVisita);
        //Sumo los goles a cada equipo

        if (this.golesLocal > this.golesVisita)
        {
            equipoVisitante.setAutorizacion(false); //Si pierde el equipo visitante su autorizacion para seguir jugando pasa a false, de esta forma no puede continuar
            equipoLocal.setResultadoDelPartido(Resultado.Ganador); //Le damos el resultado del partido al equipo local como ganador mediante el enum
            equipoVisitante.setResultadoDelPartido(Resultado.Perdedor);//Igual que la line anterior pero con el resultado como perdedor

            JOptionPane.showMessageDialog(null,"Gano: " + equipoLocal.getNombre(), "Resultado", JOptionPane.INFORMATION_MESSAGE);
            return equipoLocal;//Retornamos el equipo ganador
        }else if (this.golesLocal == this.golesVisita)//En caso de que haya un empate se ejecuta
        {
            JOptionPane.showMessageDialog(null,"Se jugara el desempate entre " +
                                            equipoLocal.getNombre() + " - " + equipoVisitante.getNombre()
                                            , "Empate", JOptionPane.INFORMATION_MESSAGE);
            equipoLocal.setResultadoDelPartido(Resultado.Empate);
            equipoVisitante.setResultadoDelPartido(Resultado.Empate);

            simularPartido(equipoLocal,equipoVisitante);//Volvemos a simular el partido
        }else
        {
            equipoLocal.setAutorizacion(false);
            equipoVisitante.setResultadoDelPartido(Resultado.Ganador);
            equipoLocal.setResultadoDelPartido(Resultado.Perdedor);

            JOptionPane.showMessageDialog(null,"Gano: " + equipoVisitante.getNombre(), "Resultado", JOptionPane.INFORMATION_MESSAGE);
            return equipoVisitante;
        }

        return null;
    }
}
