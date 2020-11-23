
package tabuleiro;

import tabuleiro.CasaAzar;
import tabuleiro.CasaSorte;
import tabuleiro.Tabuleiro;

import tabuleiro.Jogador;
import tabuleiro.Tabuleiro;
import tabuleiro.JogoView;
import tabuleiro.TabuleiroView;
import tabuleiro.Dado;
import tabuleiro.Casa;
import tabuleiro.CasaAzar;
import tabuleiro.CasaNeutra;
import tabuleiro.CasaSorte;

public class TabuleiroView {
    private static int resultadoSorteio = 0;
    private static Tabuleiro tabuleiro;
    private static int qtdJogadores;
    private static Jogador jogador;
    
    
    public static void showSituacaoAtual(Tabuleiro tab){
        for (int i = 0; i < tab.getQtdCasas(); i++) {
            //if (tab.getCasaOcupada(i) != null) {
            //    System.out.println("casa "+i+": "+tab.getCasaOcupada(i)+" ->"+tab.getJogadoresCasa(i));
            //}
            CasaView.desenhaCasa(tab.getCasa(i), tab.getJogadoresCasa(i));
            
        }
        System.out.println("============");
        JogoView.continuar();
    }
    
    public static void movimentaJogador (Tabuleiro tab) {
           Dado dado = new Dado(); // Cria um objeto dado.
           resultadoSorteio = dado.jogar(); // Chama o método jogar() da classe dado, e joga o valor salvo à variável resultadoSorteio.
           System.out.println("O valor sorteado para o jogador foi "+resultadoSorteio); // Mostra na tela o valor sorteado no dado.
           tabuleiro.getJogadoresCasa(qtdJogadores); // Pega a posição atual do jogador.
           jogador.avanca(qtdJogadores+resultadoSorteio); //Avança o jogador incrementando com o valor sorteado pelo Dado.
                   
           if (tabuleiro.getJogadoresCasa(qtdJogadores)== CasaNeutra){ // Se a casa for neutra, pega o incremento implementado nela.
           System.out.println("O jogador irá avançar/retroceder "+CasaNeutra.getIncremento()+" casas.");
           showSituacaoAtual(tabuleiro); // Atualiza o tabuleiro
           } else
                       if (tabuleiro.getJogadoresCasa(qtdJogadores) == CasaAzar){ // Se a casa for azar, pega o incremento implementado nela.
           System.out.println("O jogador irá avançar/retroceder "+CasaAzar.getIncremento()+" casas.");
           showSituacaoAtual(tabuleiro); // Atualiza o tabuleiro
                       } else {
                                System.out.println("O jogador irá avançar/retroceder "+CasaSorte.getIncremento()+" casas."); // Se a casa for sorte, pega o incremento implementado nela.
                                showSituacaoAtual(tabuleiro); // Atualiza o tabuleiro
                       }
           
    }
}
