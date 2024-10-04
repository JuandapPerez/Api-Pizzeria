package com.proyectosjuan.gestionpizzas.persistence;

public class Main {

    public static void main(String[] args) {

        int[][] dosDimensiones = new int[3][3];

        for (int i = 0; i < dosDimensiones.length; i++) {

            for (int j = 0; j < dosDimensiones[i].length; j++) {

                dosDimensiones[i][j] = (int) (Math.random() * 1000);
                System.out.print("["+dosDimensiones[i][j]+"]"+" ");
            }
            System.out.println();
        }


        int[][][] tresDimensiones = new int[3][3][3];

        for (int i = 0; i < tresDimensiones.length; i++) {
            for (int j = 0; j < tresDimensiones[i].length; j++) {
                for (int k = 0; k < tresDimensiones[i][j].length; k++) {
                    tresDimensiones[i][j][k] = (int) (Math.random() * 1000);
                    System.out.println("[" + i + "][" + j + "][" + k + "] = " + tresDimensiones[i][j][k]);
                }
            }
        }


    }
}
