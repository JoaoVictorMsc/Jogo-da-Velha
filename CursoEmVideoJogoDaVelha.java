
import java.util.Scanner;

public class CursoEmVideoJogoDaVelha {
   public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
       int jogadas = 0;
       String jogadorAtual = "X";
       String[][] tabuleiro = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};
       boolean vitoria = false;

       while(jogadas < 9 && !vitoria){
         desenharTabuleiro(tabuleiro);
         System.out.println("Vai jogar [" + jogadorAtual + "] em qual posição ?");
         String escolha = sc.nextLine();

         boolean jogadaValida = false;
         for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
               if(tabuleiro[i][j].equals(escolha)){
                  tabuleiro[i][j] = jogadorAtual;
                  jogadaValida = true;
               }
            }
         }

         if (jogadaValida) {
                jogadas++;
                vitoria = verificarVitoria(tabuleiro, jogadorAtual);

                if (!vitoria) {
                    jogadorAtual = (jogadorAtual.equals("X")) ? "O" : "X";
                }
            } else {
                System.out.println("Posição inválida! Pressione Enter...");
                sc.nextLine();
            }
      }
      desenharTabuleiro(tabuleiro);
        if (vitoria) {
            System.out.println("PARABÉNS! O Jogador [" + jogadorAtual + "] venceu!");
        } else {
            System.out.println("EMPATE (Deu Velha)!");
        }
        
        sc.close();

   }

      public static void desenharTabuleiro (String[][] m){
         // Simula limpeza de tela no console
         System.out.print("\033[H\033[2J");
         System.out.flush();

         for(int i = 0; i < m.length; i++){
            System.out.println("+---+---+---+");
            for(int j = 0; j < m[i].length; j++){
               System.out.printf("| %-1s ", m[i][j]);
            }
            System.out.println("|");
         }
         System.out.println("+---+---+---+");
      }

      public static boolean verificarVitoria(String[][] m, String jogador){
         // Linhas e Colunas
         for (int i = 0; i < 3; i++){
            if((m[i][0].equals(jogador) && m[i][1].equals(jogador) && m[i][2].equals(jogador)) ||
               (m[0][i].equals(jogador) && m[1][i].equals(jogador) && m[2][i].equals(jogador))) return true;
         }
         // Diagonais
         return (m[0][0].equals(jogador) && m[1][1].equals(jogador) && m[2][2].equals(jogador)) ||
                (m[0][2].equals(jogador) && m[1][1].equals(jogador) && m[2][0].equals(jogador));
      }
}