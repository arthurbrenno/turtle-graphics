package com.brc;

public class Floor {
    private int linhas;
    private int colunas;
    private int anguloAtual = 0;
    private String caracterDePreenchimento;
    private String[][] matriz;
    private String[][] matrizAux;
    
    public Floor(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.matriz = new String[linhas][colunas];
        this.matrizAux = new String[linhas][colunas];
    }

    public int getLinhas() {
        return this.linhas;
    }

    public int getColunas() {
        return this.colunas;
    }

    public String[][] getMatriz() {
        return this.matriz;
    }

    public int getAnguloAtual() {
        return this.anguloAtual;
    }

    public void preencher(String caractere) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = caractere;
            }
        }
        caracterDePreenchimento = caractere;
    }
    //METODO TEMPORARIO
    public void preencherOrdemCrescente() {
        int incremento = 1;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = String.valueOf(incremento++);
            }
        }
    }

    public void mostrar() {
        for (int i = 0; i < matriz.length; i++) {
            System.out.printf("%2s", "|");
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("%5s", matriz[i][j]);
            }
            System.out.printf("%5s%n", "|");
        }
    }

    public void transpor() {
        for (int j = 0; j < matriz.length; j++) {
            for (int i = 0; i < matriz.length; i++) {
                matrizAux[j][i] = matriz[i][j];
            }
        }
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = matrizAux[i][j];
            }
        }
    }

    public void refletirX() {
        String[] temp;
        for (int i = 0; i < matriz.length / 2; i++) {
            temp = matriz[i];
            matriz[i] = matriz[matriz[i].length - i - 1];
            matriz[matriz[i].length - i - 1] = temp;
        }
    }

    public void refletirY() {
        String temp;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length / 2; j++) {
                temp = matriz[i][j];
                matriz[i][j] = matriz[i][matriz[i].length - j - 1];
                matriz[i][matriz[i].length - j - 1] = temp;
            }
        }
    }

    public void rotacionarAntiHorario() {
        this.transpor();
        this.refletirX();
        anguloAtual += 90;
    }

    public void rotacionarHorario() {
        this.transpor();
        this.refletirY();
        anguloAtual -= 90;
    }

    public void copiarMatriz(String[][] matriz, int anguloMatriz) {
        this.matriz = matriz;
        this.anguloAtual = anguloMatriz;
    }

    public void zerarAngulo() {
        while (anguloAtual > 0 || anguloAtual < 0) {
            if (anguloAtual > 0) {
                this.rotacionarHorario();
            }
            else {
                this.rotacionarAntiHorario();
            }
        }
    }

    public int[] acharCaractere(String caractere) {
        int[] posicao = new int[2];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j].equals(caractere)) {
                    posicao[0] = i;
                    posicao[1] = j;
                }
            }
        }
        return posicao;
    }

    public void colocar(String caractere, int linha, int coluna) {
        matriz[linha][coluna] = caractere;
    }

    public void remover(String elemento) {
        int[] localizacao = this.acharCaractere(elemento);
        matriz[localizacao[0]][localizacao[1]] = caracterDePreenchimento;
    }

}
