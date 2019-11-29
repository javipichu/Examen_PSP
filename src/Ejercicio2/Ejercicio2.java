/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

import java.util.Random;

/**
 *
 * @author JAVIER ALVAREZ OTERO 6462
 */
public class Ejercicio2 {

    public static void main(String[] args) {
        System.out.println("Empieza el main");
        Hilo a = new Hilo("1");
        Hilo b = new Hilo("2");
        Hilo c = new Hilo("3");

        try {
            a.start();
            a.join();
            b.start();
            b.join();
            c.start();
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
                    Thread.sleep(new Random().nextInt(3) * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
