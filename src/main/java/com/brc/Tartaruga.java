package com.brc;

public class Tartaruga {
    
    private Floor floor;
    private boolean canetaParaCima = true;
    private String direcao = "Direita";
    private String caminho = "*";
    private String simboloTartaruga = "T";

    public Tartaruga(Floor floor) {
        this.floor = floor;
    }

    public String getDirecao() {
        return this.direcao;
    }

    public boolean getCanetaParaCima() {
        return this.canetaParaCima;
    }

    public void alterarEstadoCaneta() {
        canetaParaCima = (canetaParaCima) ? false : true; 
    }

    public void alterarDirecao() {
        direcao = (direcao.equals("Direita") ? "Esquerda" : "Direita");
    }

    public void andar () {
        int[] localizacaoTartaruga = floor.acharCaractere("T");
        int linhaTartaruga = localizacaoTartaruga[0];
        int colunaTartaruga = localizacaoTartaruga[1];
        
        try {
            if (!canetaParaCima) {
                floor.colocar(caminho, linhaTartaruga, colunaTartaruga);
                floor.colocar(simboloTartaruga, linhaTartaruga, colunaTartaruga + 1);
            }
            else {
                floor.remover(simboloTartaruga);
                floor.colocar("T", linhaTartaruga, colunaTartaruga + 1);
            }
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Fim do floor."); return;
        }
        
    }

    public int[] encontrar() {
        int[] localizacao = floor.acharCaractere("T");
        return localizacao;
    }

}
