package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner read = new Scanner(System.in);


    static void batle() {

        int hpUsr = 150;
        int hpPC = 11;
        int countSpell = 5;
        int atackUsuario;
        int atackMaquina;

        while (hpUsr > 0 && hpPC > 0){

            imprimir(hpUsr,hpPC,countSpell);
            atackUsuario = attackUsr();
            switch (atackUsuario){
                case 1:
                    System.out.println("Dano do usuario por soco.");
                    hpPC -= 7;
                    break;
                case 2:
                    System.out.println("Dano do usuario por especial.");
                    hpPC -= 20;
                    countSpell--;
                    break;
                default:
                    System.out.println("Opcao invalida.");
                    break;
            }

            if (hpPC > 0) {
                atackMaquina = attackenemy();

                switch (atackMaquina) {
                    case 1:
                        System.out.println("Dano do Inimgo por soco.");
                        hpUsr -=2;
                        break;
                    case 2:
                        System.out.println("Dano do Inimgo por chute.");
                        hpUsr -=3;
                        break;
                    case 3:
                        System.out.println("Dano do Inimgo por especial.");
                        hpUsr -=4;
                        break;
                }
            }

            else {
                System.out.println("Inimigo Derrotado.");
            }
        }
    }

    static void imprimir (int hpUsr, int hpPC, int countSpell){

        System.out.println("===================");
        System.out.println("- HP Usuario: " + hpUsr);
        System.out.println("- HP Inimigo: " + hpPC);
        System.out.println("- ContagemEspecial" + countSpell);
        System.out.println("===================");
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
