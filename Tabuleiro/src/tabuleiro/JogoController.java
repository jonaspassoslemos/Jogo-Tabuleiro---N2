package tabuleiro;
import tabuleiro.Jogador;
import tabuleiro.MuitosJogadoresException;
import tabuleiro.Tabuleiro;
import tabuleiro.JogoView;
import tabuleiro.TabuleiroView;
import tabuleiro.Dado;
import tabuleiro.Casa;
import tabuleiro.CasaAzar;
import tabuleiro.CasaNeutra;
import tabuleiro.CasaSorte;

public class JogoController {
    private static int qtdJogadores;
    private static Tabuleiro tabuleiro;
    private static int jogadorAtual = 0;
    private static boolean finalizado = false;
    
    
    
  

    public static void iniciarJogo() { //
        
         
        tabuleiro = new Tabuleiro(5,20,20); //cria o tabuleiro com 5 casas, 20% de sorte e 20% de azar.
        qtdJogadores = JogoView.intQtdJogadores(2, 6); // Limita a quant de jogadores entre 2 e 6.
        registrarJogadores(); // Chama o método para registro dos jogadores.

       while(! finalizado) { // Enquanto não finalizado .....
                                                      
           iniciarJogada();
           proximoJogador();
           TabuleiroView.showSituacaoAtual(tabuleiro);
       }

    }
    private static void proximoJogador() {
        jogadorAtual++;
        if(jogadorAtual == qtdJogadores) {
            jogadorAtual = 0;
        }
    }
    public static void registrarJogadores() {
        for (int i = 1; i <= qtdJogadores; i++) {
            String n = JogoView.InformeJogador(i);
            try {
                tabuleiro.addJogador(new Jogador(n));
            } catch (MuitosJogadoresException e) {
                e.printStackTrace();
            }
        }
    }
    private static void iniciarJogada() {
        JogoView.mostraJogadorAtual(tabuleiro.getJogadores().get(jogadorAtual));
    }

    public static void iniciarJogoOld() {
           
        Tabuleiro tab = new Tabuleiro(50,20,20);
        try {
            tab.addJogador(new Jogador("Jean1"));
            tab.addJogador(new Jogador("Jean2"));
            Jogador a = null;
            try {
                a.getNome();
            } catch (NullPointerException e) {
                System.out.println("ops, tu tentou usar um null como jogador");
            }

            tab.addJogador(new Jogador("Jean3"));
            tab.addJogador(new Jogador("Jean4"));
            tab.addJogador(new Jogador("Jean5"));

            tab.addJogador(new Jogador("Jean6"));
            tab.addJogador(new Jogador("Jean7"));
        } catch (MuitosJogadoresException e) {
            System.out.println(e.getMessage());
        }
         catch (NullPointerException e) {
            System.out.println("ops, tu tentou usar um null como jogador");
        }
        finally {
            System.out.println("depois de tudo");
        }
        for(int i = 0; i < tab.getJogadores().size(); i++) {
            System.out.println(tab.getJogadores().get(i));
        }
    }
    
public static void finalizaJogo() { // Método para finalizar o jogo.
int casas; 
casas = tabuleiro.getQtdCasas(); // Pega a quantidade de casas que tem no jogo e atribui na variável casas.
if (tabuleiro.getJogadoresCasa(qtdJogadores) == casas) { // Se a posição atual do jogador for igual ao total de casas (ele esta na ultima casa), ele venceu o jogo.
System.out.println("Parabéns, você venceu! ");
System.exit(0); // Encerra o programa.
}


}
    
}


