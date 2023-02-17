import java.util.Random;
import java.util.Scanner;

public class Main {

  static Scanner reader = new Scanner(System.in);
  static String winAchievedUser = "W";
  static String winAchievedBot = "W";
  static String choice;

  public static void main(String[] args) {
    int menuSelector;

    System.out.println("Welcome to Tic Tack Toe\n\n Select a Game mode");
    do {
      do {
        System.out.println("\n\nMAIN MENU\n\n1. Single Round\n2. First to 3");
        menuSelector = reader.nextInt();
        switch (menuSelector) {
          case 1:
            ONEROUND();
            break;
          case 2:
            FIRSTTOTHREE();
            break;
        }

      }while (!(choice.equalsIgnoreCase("AGAIN")));

    } while (!((menuSelector == 1) || (menuSelector == 2)));

  }

  public static void ONEROUND() {
    System.out.println("\nWelcome to Single Round TicTackToe\n\n");

    do {
      TICTACKTOE();
      System.out.println("Do you want to play again, if so type \"AGAIN. Otherwise type anything else to exit");
      choice = reader.next();
    }while (choice.equalsIgnoreCase("AGAIN"));
  }

  public static void FIRSTTOTHREE() {

    int scoreUser = 0;
    int scoreBot = 0;

    System.out.println("\nWelcome to First to Three TicTackToe\n\n");
    do {
      TICTACKTOE();

      if (winAchievedUser.equals("YES")) {
        System.out.println("YOU WIN THIS ROUND!!!\n");
        scoreUser++;
        System.out.println("Your Score: " + (scoreUser));
        System.out.println("Bot Score: " + (scoreBot));
      } else if (winAchievedBot.equals("YES")) {
        System.out.println("BOT WINS THIS ROUND YOU LOSE!!!\n");
        scoreBot++;
        System.out.println("Your Score: " + (scoreUser));
        System.out.println("Bot Score: " + (scoreBot));
      } else if (winAchievedBot.equals("TIE")) {
        System.out.println("TIE ROUND");
        System.out.println("Your Score: " + (scoreUser));
        System.out.println("Bot Score: " + (scoreBot));
      }

    } while (!(scoreBot == 3 || scoreUser == 3));

    System.out.println("End of Game\n");

    if (scoreBot == 3)
      System.out.println("YOU LOSE!!");

    else if (scoreUser == 3)
      System.out.println("YOU WIN!!");

  }// end of method

  public static void TICTACKTOE() {

    char marker = 'X';
    char placer = 'O';
    int userInput = 0;
    int bot = 0;
    String validUser = "e";
    String validBot = "e";
    char[][] board = { { ' ', ' ', ' ' },
        { ' ', ' ', ' ' },
        { ' ', ' ', ' ' } };

    // welcome message

    System.out.println(
        "\n\nYour objective is to beat your opponent by placing three X's or O's, whichever you choose in a straight line or diagoal on the 3x3 grid.\n");

    // printing real grid
    printBoard(board);

    // printing example grid
    System.out.println("");
    System.out.println("  1  |  2  |  3  ");
    System.out.println("----- ----- -----");
    System.out.println("  4  |  5  |  6  ");
    System.out.println("----- ----- -----");
    System.out.println("  7  |  8  |  9  ");

    System.out.println("\n\nThis is the TIC TACK TOE grid.");

    do {
      do {
        System.out.println("\nEnter a number that correspondes to the spot on the grid you want to play on.");
        userInput = reader.nextInt();

        while (userInput > 9 || userInput < 1) {
          System.out.println("Invalid number. Enter a valid number");
          userInput = reader.nextInt();
        }

        /*-----------CHECKING IF POSITION IS AVALIABLE FOR USER-------------------*/

        switch (userInput) {
          // is position 1 avaliable
          case 1:
            if (board[0][0] == ' ') {
              validUser = ("AVALIABLE");
              board[0][0] = marker;
            } else
              validUser = ("UNAVALIABLE");
            break;

          // is position 2 avaliable
          case 2:
            if (board[0][1] == ' ') {
              validUser = ("AVALIABLE");
              board[0][1] = marker;
            } else
              validUser = ("UNAVALIABLE");
            break;

          // is position 3 avaliable
          case 3:
            if (board[0][2] == ' ') {
              validUser = ("AVALIABLE");
              board[0][2] = marker;
            } else
              validUser = ("UNAVALIABLE");
            break;

          // is position 4 avaliable
          case 4:
            if (board[1][0] == ' ') {
              validUser = ("AVALIABLE");
              board[1][0] = marker;
            } else
              validUser = ("UNAVALIABLE");
            break;

          // is position 5 avaliable
          case 5:
            if (board[1][1] == ' ') {
              validUser = ("AVALIABLE");
              board[1][1] = marker;
            } else
              validUser = ("UNAVALIABLE");
            break;

          // is position 6 avaliable
          case 6:
            if (board[1][2] == ' ') {
              validUser = ("AVALIABLE");
              board[1][2] = marker;
            } else
              validUser = ("UNAVALIABLE");
            break;
          // is position 7 avaliable
          case 7:
            if (board[2][0] == ' ') {
              validUser = ("AVALIABLE");
              board[2][0] = marker;
            } else
              validUser = ("UNAVALIABLE");
            break;

          // is position 8 avaliable
          case 8:
            if (board[2][1] == ' ') {
              validUser = ("AVALIABLE");
              board[2][1] = marker;
            } else
              validUser = ("UNAVALIABLE");
            break;

          // is position 9 avaliable
          case 9:
            if (board[2][2] == ' ') {
              validUser = ("AVALIABLE");
              board[2][2] = marker;
            } else
              validUser = ("UNAVALIABLE");
            break;
        }// end of switch case

        if (validUser.equals("UNAVALIABLE"))
          System.out.println("\nYou entered a number thats taken already, enter another number");

      } while (validUser.equals("UNAVALIABLE"));

      /*------ CHECKING FOR A WINNER FOR USER -----------------*/

      // Row wins

      if ((board[0][0] == marker && board[0][1] == marker && board[0][2] == marker) ||
          (board[1][0] == marker && board[1][1] == marker && board[1][2] == marker) ||
          (board[2][0] == marker && board[2][1] == marker && board[2][2] == marker)) {
        winAchievedUser = ("YES");
      }

      // Column wins

      else if ((board[0][0] == marker && board[1][0] == marker && board[2][0] == marker) ||
          (board[0][1] == marker && board[1][1] == marker && board[2][1] == marker) ||
          (board[0][2] == marker && board[1][2] == marker && board[2][2] == marker))
        winAchievedUser = ("YES");

      // Diagonal wins

      else if ((board[0][0] == marker && board[1][1] == marker && board[2][2] == marker) ||
          (board[0][2] == marker && board[1][1] == marker && board[2][0] == marker)) {
        winAchievedUser = ("YES");
      }

      // tie game after user plays

      else if ((board[0][0] == placer || board[0][0] == marker) && (board[0][1] == placer || board[0][1] == marker)
          && (board[0][2] == placer || board[0][2] == marker) && (board[1][0] == placer || board[1][0] == marker)
          && (board[1][1] == placer || board[1][1] == marker) && (board[1][1] == placer || board[1][2] == marker)
          && (board[2][0] == placer || board[2][0] == marker) && (board[2][1] == placer || board[2][1] == marker)
          && (board[2][2] == placer || board[2][2] == marker)) {

        winAchievedUser = ("TIE");
      }

      else
        winAchievedUser = ("NO");

      /* PRINTING BOARD FOR USER */

      if (validUser.equals("AVALIABLE")) {
        System.out.println("");
        printBoard(board);
        System.out.println("");
      }

      if (winAchievedUser.equals("YES"))
        System.out.println("\nYOU WIN!!!");

      else if (winAchievedUser.equals("TIE"))
        System.out.println("TIE GAME");

      else {

        /*-----------CHECKING IF POSITION IS AVALIABLE FOR BOT-------------------*/
        do {
          // generating random placement for bot

          bot = (int) (9 * Math.random() + 1);

          switch (bot) {
            // is position 1 avaliable
            case 1:
              if ((board[0][0] == ' ') && (winAchievedUser.equals("NO"))) {
                validBot = ("AVALIABLE");
                board[0][0] = placer;
              } else
                validBot = ("UNAVALIABLE");
              break;

            // is position 2 avaliable
            case 2:
              if ((board[0][1] == ' ') && (winAchievedUser.equals("NO"))) {
                validBot = ("AVALIABLE");
                board[0][1] = placer;
              } else
                validBot = ("UNAVALIABLE");
              break;

            // is position 3 avaliable
            case 3:
              if ((board[0][2] == ' ') && (winAchievedUser.equals("NO"))) {
                validBot = ("AVALIABLE");
                board[0][2] = placer;
              } else
                validBot = ("UNAVALIABLE");
              break;

            // is position 4 avaliable
            case 4:
              if ((board[1][0] == ' ') && (winAchievedUser.equals("NO"))) {
                validBot = ("AVALIABLE");
                board[1][0] = placer;
              } else
                validBot = ("UNAVALIABLE");
              break;

            // is position 5 avaliable
            case 5:
              if ((board[1][1] == ' ') && (winAchievedUser.equals("NO"))) {
                validBot = ("AVALIABLE");
                board[1][1] = placer;
              } else
                validBot = ("UNAVALIABLE");
              break;

            // is position 6 avaliable
            case 6:
              if ((board[1][2] == ' ') && (winAchievedUser.equals("NO"))) {
                validBot = ("AVALIABLE");
                board[1][2] = placer;
              } else
                validBot = ("UNAVALIABLE");
              break;
            // is position 7 avaliable
            case 7:
              if ((board[2][0] == ' ') && (winAchievedUser.equals("NO"))) {
                validBot = ("AVALIABLE");
                board[2][0] = placer;
              } else
                validBot = ("UNAVALIABLE");
              break;

            // is position 8 avaliable
            case 8:
              if ((board[2][1] == ' ') && (winAchievedUser.equals("NO"))) {
                validBot = ("AVALIABLE");
                board[2][1] = placer;
              } else
                validBot = ("UNAVALIABLE");
              break;

            // is position 9 avaliable
            case 9:
              if ((board[2][2] == ' ') && (winAchievedUser.equals("NO"))) {
                validBot = ("AVALIABLE");
                board[2][2] = placer;
              } else
                validBot = ("UNAVALIABLE");
              break;
          }// end of switch case
        } while (validBot.equals("UNAVALIABLE"));
        /*------ CHECKING FOR A WINNER FOR BOT-----------------*/

        // Row wins

        if ((board[0][0] == placer && board[0][1] == placer && board[0][2] == placer) ||
            (board[1][0] == placer && board[1][1] == placer && board[1][2] == placer) ||
            (board[2][0] == placer && board[2][1] == placer && board[2][2] == placer)) {
          winAchievedBot = ("YES");
        }

        // Column wins

        else if ((board[0][0] == placer && board[1][0] == placer && board[2][0] == placer) ||
            (board[0][1] == placer && board[1][1] == placer && board[2][1] == placer) ||
            (board[0][2] == placer && board[1][2] == placer && board[2][2] == placer))
          winAchievedBot = ("YES");

        // Diagonal wins

        else if ((board[0][0] == placer && board[1][1] == placer && board[2][2] == placer) ||
            (board[0][2] == placer && board[1][1] == placer && board[2][0] == placer)) {
          winAchievedBot = ("YES");
        }
        // tie game after bot plays

        else if ((board[0][0] == placer || board[0][0] == marker) && (board[0][1] == placer || board[0][1] == marker)
            && (board[0][2] == placer || board[0][2] == marker) && (board[1][0] == placer || board[1][0] == marker)
            && (board[1][1] == placer || board[1][1] == marker) && (board[1][1] == placer || board[1][2] == marker)
            && (board[2][0] == placer || board[2][0] == marker) && (board[2][1] == placer || board[2][1] == marker)
            && (board[2][2] == placer || board[2][2] == marker)) {
          winAchievedBot = ("TIE");
        } else
          winAchievedBot = ("NO");

      }

      /*---------OUTPUTING-------------*/
      if (validBot.equals("AVALIABLE") && winAchievedUser.equals("NO")) {
        System.out.println("\nBot chose: " + (bot) + "\n");
        printBoard(board);
        System.out.println("\n---------------------------");
      }

    } while (!(winAchievedUser.equals("YES") || winAchievedBot.equals("YES") || winAchievedBot.equals("TIE")));

    if (winAchievedBot.equals("YES")) {
      System.out.println("\nYOU LOSE!!!, BOT WINS!!");
    }

    else if (winAchievedBot.equals("TIE"))
      System.out.println("TIE GAME");

  }// end of TIC TACK TOE method

  /*----------------TIC TACK TOE BOARD-----------------------*/
  public static void printBoard(char[][] board) {

    System.out.println("  " + board[0][0] + "  |  " + board[0][1] + "  |  " + board[0][2]);
    System.out.println("----- ----- -----");
    System.out.println("  " + board[1][0] + "  |  " + board[1][1] + "  |  " + board[1][2]);
    System.out.println("----- ----- -----");
    System.out.println("  " + board[2][0] + "  |  " + board[2][1] + "  |  " + board[2][2]);
    
  }//end of main method
}// end of class