package projects.GuessingGame;

public class GuessGame {
    Player p1;
    Player p2;
    Player p3;

    void startGame()
    {
        p1 = new Player();
        p2 = new Player();
        p3 = new Player();

        while (true) {
            
            System.out.println("\n\nI'm Thinking of a Number between 0 and 9");
            int number = (int) Math.random() * 10;

            System.out.println("Number to be guessed : "+ number);

            p1.guess();
            p2.guess();
            p3.guess();

            System.out.println("Player 1 guessed : "+p1.number);
            System.out.println("Player 2 guessed : "+p2.number);
            System.out.println("Player 3 guessed : "+p3.number);

            if(p1.number == number){
                System.out.println("Player 1 is a Winner");
                break;
            }
            else if(p2.number == number){
                System.out.println("Player 2 is a Winner");
                break;
            }
            else if(p3.number == number){
                System.out.println("Player 3 is a Winner");
                break;
            }
        }

    }

}
