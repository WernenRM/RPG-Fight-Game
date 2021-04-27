package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner read = new Scanner(System.in);


    static void batle() {

        int hpUsr = 150;
        int hpPC = 11;
        int countSpell = 1;
        int coutemy = 0;
        int atackUsuario;
        int atackMaquina;
        int i = 1;

        if (coutemy == 10)
        {
            coutemy = 0;
            hpUsr += 300;
            countSpell += 5;

            System.out.println( " PARABENS !!");
            System.out.println(" 10 inimigos derrotados, HP Maximo e atual aumentado");
            System.out.println(" Especiais aumentado para:" + countSpell);

        }
        while (hpUsr >0) {

            hpPC = 10 + 1;
            System.out.println("==================");
            System.out.println("INIMIGO nº" +i);
            System.out.println("==================\n");

            while (hpUsr > 0 && hpPC > 0) {

                imprimir(hpUsr, hpPC, countSpell);
                atackUsuario = attackUsr();
                switch (atackUsuario) {
                    case 1:
                        System.out.println("Dano do usuario por soco.");
                        hpPC -= 7;
                        break;
                    case 2:
                        System.out.println("Dano do usuario por especial.");
                        hpPC -= 20;
                        if(countSpell > 0) countSpell--;
                        else System.out.println("Sem especiais disponiveis. Tente outro golpe");
//                        clearScreen();

                        break;
                    default:
                        System.out.println("Opcao invalida.");
                        break;
                }

                if (countSpell > 0) {
                    if (hpPC > 0) {
                        atackMaquina = attackenemy();

                        switch (atackMaquina) {
                            case 1:
                                System.out.println("Dano do Inimgo por soco.");
                                hpUsr -= 2 + (int) (i / 10);
                                break;
                            case 2:
                                System.out.println("Dano do Inimgo por chute.");
                                hpUsr -= 3 + (int) (i / 10);
                                break;
                            case 3:
                                System.out.println("Dano do Inimgo por especial.");
                                hpUsr -= 4 + (int) (i / 20);
                                break;
                        }
                    } else {
                        System.out.println("Inimigo Derrotado.\n");
                    }
                }
            }

            if (countSpell > 0){
                i ++;
                coutemy ++;
            }
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static void imprimir (int hpUsr, int hpPC, int countSpell){

        System.out.println("===================");
        System.out.println("- HP Usuario: " + hpUsr);
        System.out.println("- HP Inimigo: " + hpPC);
        System.out.println("- Especiais disponiveis: " + countSpell);
        System.out.println("===================\n");
    }

    static int attackUsr() {

        System.out.println("Escolha seu ataque");
        System.out.println("1 - Soco");
        System.out.println("2 - Especial");
        return read.nextInt();

    }

    static int attackenemy() {

        Random gerador = new Random();
        return gerador.nextInt(3) + 1;// Retorna numero entre 1 e 3.
    }


    public static void main(String[] args) {
        int continued = 1;

        while (continued == 1) {

            batle();

            System.out.println("Fim de jogo. Deseja continuar? (1) Sim (2) Não");
            continued = read.nextInt();
        }
    }
}
