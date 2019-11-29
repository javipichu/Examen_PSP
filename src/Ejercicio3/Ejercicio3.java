/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio3;


import java.util.Random;

/**
 *
 * @author JAVIER ALVAREZ OTERO 6462
 */
public class Ejercicio3 extends Thread {
    
    static int cont=2;
    Ejercicio3 hilo;
   
    
    Ejercicio3(String name) {
        super(name);
    }
    public static void main(String[] args) {
        System.out.println("Empieza el main");
        Hilo a = new Hilo("1");
        Hilo b = new Hilo("2");
        Hilo c = new Hilo("3");
        a.start();
        b.start();
        c.start();

        try {
            a.join();
            b.join();
            c.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Acaba el main");

    }

    public static class Hilo extends Thread {

        private String nombre;

        public Hilo(String nombre) {
            this.nombre = nombre;
        }

        @Override
        public void run() {
         

        for (int i = 0; i < 26; i++) {
                System.out.println("Hilo " + nombre + ":" + i);
            try {
                sleep((long) Math.random() * 1000 + 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //El método yield da apaso a otro hilo al ser llamado
            yield();
        }

    }
    }

}
