import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("-------------------------------------------");
        System.out.println("Bem vindo ao jogo de pedra, papel e tesoura");
        System.out.println("-------------------------------------------");

        int countWinsPlayer =0;
        int countWinsCPU = 0;
        int draw = 0;

        String choicePlayer;
        boolean okValidation = false; 
        int continuePlay = 0;

        while (continuePlay == 0) {
            
            do {
                    System.out.println("Escolha pedra, papel ou tesoura: ");
                    choicePlayer = sc.next();
                    okValidation = ValidationChoice(choicePlayer);
                
            } while (okValidation == false);
      

            System.out.println(GameResult(choicePlayer));
            if (GameResult(choicePlayer) == "empate") {
                draw++;
            } else if (GameResult(choicePlayer) == "Jogador ganhou"){
                countWinsPlayer++;
            } else {
                countWinsCPU++;
            }

            System.out.print("Keep playing?, 0 for Keep playing or 1 for exit: ");

            continuePlay = sc.nextInt();
            if (continuePlay == 1)
                break; 

            System.out.print("\033[H\033[2J");  
            System.out.flush();  
        }

        System.out.println("Total de partidas jogadas: " + (countWinsCPU + continuePlay + draw));
        System.out.println("Total partidas vencidas pelo jogador: " + countWinsPlayer);
        System.out.println("Total partidas vencidas pela CPU: " + countWinsCPU);
        System.out.println("Total de empates: " + draw);
        if (countWinsPlayer > countWinsCPU && countWinsPlayer > draw) {
            System.out.println("O player venceu mais partidas. ");
        } else if (countWinsCPU > countWinsPlayer && countWinsCPU > draw){
            System.out.println("A cpu venceu mais.");
        } else {
            System.out.println("O jogo ficou empatado em numero de vitorias para cpu e player");
        }
    }

    public static boolean ValidationChoice(String choicePlayer) {
        
        String lowerChoicePlayer = choicePlayer.toLowerCase();

        if(lowerChoicePlayer.equals("pedra") || lowerChoicePlayer.equals("papel") 
            || lowerChoicePlayer.equals("tesoura")){
            return true;
        }
        return false;
    }

    public static String GameResult(String choicePlayer) {

        String options[] = {"pedra", "papel", "tesoura"};
        Random random = new Random();

        int index = random.nextInt(options.length);
        String cpuOption = options[index];
        System.out.println(cpuOption);

        if (choicePlayer.equals(cpuOption)) {
            return "empate";
        } else if   (choicePlayer.equals("pedra") && cpuOption.equals("tesoura") 
                    || choicePlayer.equals("tesoura") && cpuOption.equals("papel")
                    || choicePlayer.equals("papel") && cpuOption.equals("pedra")){
            return "Jogador ganhou";
        } else {
            return "maquina ganhou";
        }
    }
}
