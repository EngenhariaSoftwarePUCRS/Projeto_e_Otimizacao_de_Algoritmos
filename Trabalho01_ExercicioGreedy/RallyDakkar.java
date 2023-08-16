package Trabalho01_ExercicioGreedy;

public class RallyDakkar {
    /*
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

    String trilha = gerarTrilha(30);
    int folegoDiario = 30;
    static int[] pontosParada = 
    { 0, 7, 14, 21, 28, 30 };

    public static void main(String[] args) {
        int daysPassed = 5;
        int pontoAtual = 100;
    }

    String gerarTrilha(int comprimentoTrilha) {
        String trilha = "";
        for (int i = 0; i < comprimentoTrilha; i++) {
            trilha.concat("-");
        }
        return trilha;
    }
}
