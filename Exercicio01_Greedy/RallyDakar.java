package Exercicio01_Greedy;

import java.util.Arrays;

public class RallyDakar {
    /**
     * Relatório disponível em:
     *      https://docs.google.com/document/d/1cNyjwgEqqqxgKqZ2thHzrIp35_LhAbQHMGj5v1GYHmw/edit?usp=sharing
     * 
     * Vamos assumir um trajeto de comprimento n
     * , um "folego" (limite de distancia diário) de n
     * , com paradas espaçadas por quaisquer números
     * cuja diferença < n.
     * 
     * Para terminar o trajeto, existe uma solução ótima 
     * que, em uma distância de n acampa, no máximo, 1x
     * 
     * Passo 1:
     * Analisar distância ao próximo ponto
     * 
     * Passo 2:
     * Se essa distancia for <= ao folego atual, "perde" esse folego
     * e vai até o próximo ponto.
     * Do contrário, acampa.
     * 
     * Repetir enquanto não chegar no final.
    */

    
    public static void main(String[] args) {
        int comprimentoTrilha = 100;
        int quantidadePontosParada = 10;
        int folegoDiario = 30;
        try {
            switch (args.length) {
                case 3:
                    folegoDiario = Integer.parseInt(args[2]);
                case 2:
                    quantidadePontosParada = Integer.parseInt(args[1]);
                case 1:
                    comprimentoTrilha = Integer.parseInt(args[0]);
                    break;
                default:
                    System.out.println("Número de argumentos inválidos. Usando valores padrão.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao ler argumento. Usando valores padrão.");
        }
        String trilha = gerarTrilha(comprimentoTrilha);
        int[] pontosParada = gerarPontosParada(quantidadePontosParada, comprimentoTrilha, folegoDiario);

        System.out.println("Trilha: " + trilha);
        System.out.println("Comprimeto da trilha: " + comprimentoTrilha);
        System.out.println("Folego diário: " + folegoDiario);
        System.out.println("Pontos de parada: " + Arrays.toString(pontosParada));

        int[] pontosParadaOtimo = new int[pontosParada.length];
        int folegoAtual = folegoDiario;
        int pontoParadaAtual = 0;
        int quantidadeParadas = 0;
        for (int i = 0; i < pontosParada.length; i++) {
            if (pontosParada[i] - pontoParadaAtual <= folegoAtual) {
                folegoAtual -= pontosParada[i] - pontoParadaAtual;
                pontoParadaAtual = pontosParada[i];
            } else {
                folegoAtual = folegoDiario;
                pontoParadaAtual = pontosParada[i - 1];
                pontosParadaOtimo[quantidadeParadas] = pontoParadaAtual;
                quantidadeParadas++;
            }
        }
        String trilhaComParadas = "P" + 0;
        for (int i = 0; i < pontosParadaOtimo.length; i++) {
            if (pontosParadaOtimo[i] != 0) {
                trilhaComParadas += trilha.substring(0, pontosParadaOtimo[i])
                    + "P" + pontosParadaOtimo[i]
                    + trilha.substring(pontosParadaOtimo[i] + 1);
            }
        }
        trilhaComParadas += "P" + comprimentoTrilha;
        System.out.println("Pontos de parada ótimos: " + Arrays.toString(pontosParadaOtimo));
        System.out.println("Trilha com pontos de parada ótimos: " + trilhaComParadas);
    }

    static String gerarTrilha(int comprimentoTrilha) {
        String trilha = "";
        for (int i = 0; i < comprimentoTrilha; i++)
            trilha += "-";
        return trilha;
    }

    static int[] gerarPontosParada(int quantidadePontos, int comprimentoTrilha, int limiteDiario) {
        int[] pontosParada = new int[quantidadePontos];
        int multiplier = 0;
        for (int i = 0; i < quantidadePontos - 1; i++) {
            pontosParada[i] = (int) (multiplier * comprimentoTrilha / quantidadePontos);
            multiplier = i + 1;
        }
        pontosParada[quantidadePontos - 1] = comprimentoTrilha;
        return pontosParada;
    }
}
