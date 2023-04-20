package com.brc;

import java.util.InputMismatchException;
import java.util.Scanner;

//TODO: rename System.out's
public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int LINHAS = 20;
    private static final int COLUNAS = 20;
    private static Floor floor = new Floor(LINHAS, COLUNAS);
    private static Tartaruga tartaruga = new Tartaruga(floor);
    private static boolean active = true;
    private static int option;
    
    public static void main(String[] args) {
        prepararExecucao();
        executar();
    }

    public static void mostrarComandos() {
        System.out.println("1- Andar");
        System.out.println("2- Virar caneta");
        System.out.println("3- Virar direita");
        System.out.println("4- Virar esquerda");
        System.out.println("9- Sair");
    }

    public static void mostrarStatus() {
        System.out.printf("[%d°]%n", floor.getAnguloAtual());
        System.out.printf("[%s]%n", (tartaruga.getCanetaParaCima()) ? "Caneta para cima" : "Caneta para baixo");
    }

    public static void clearConsole() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  
    
    public static int tratarEntrada() {
        int entrada = -1;
        try {
            entrada = scanner.nextInt();
        } catch (InputMismatchException e) {
            entrada = 9;
        }
        return entrada;
    }

    public static void executar() {
        while (active) {
            clearConsole();
            floor.mostrar();
            mostrarStatus();
            mostrarComandos();
            option = tratarEntrada();
            switch (option) {
                case 1:
                    tartaruga.andar(); break;
                case 2:
                    tartaruga.alterarEstadoCaneta(); break;
                case 3:
                    floor.rotacionarAntiHorario(); break;
                case 4:
                    floor.rotacionarHorario(); break;
                case 9: active = false;
            }
        }
    }

    public static void prepararExecucao() {
        floor.preencher(" ");
        floor.colocar(tartaruga.getSimbolo(), 0, 0);
    }

}
