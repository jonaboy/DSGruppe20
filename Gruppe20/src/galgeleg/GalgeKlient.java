/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galgeleg;

import transport.soap.Brugeradminklient;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 *
 * @author Johnny
 */
public class GalgeKlient {
    
    public static String guess;
    
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:9943/galgeleg?wsdl");
        QName qname = new QName("http://galgeleg/", "GalgelogikService");
        Service service = Service.create(url, qname);
        GalgeI game = service.getPort(GalgeI.class);
        game.nulstil();
        System.out.println("Welcome to Hangman - Guess a word!");
        Scanner scanner = new Scanner(System.in);
        
        Brugeradminklient bak = new Brugeradminklient();
        
        while(true){
            //login method
            System.out.println("Enter username: ");
            String username = scanner.nextLine();

            System.out.println("Enter password: ");
            String password = scanner.nextLine();
            
            if(bak.Login(username, password)){break;}
            else{System.out.println("Wrong credentials, try again!");}
        } 
        
        
        System.out.println("Welcome to Galgeleg!");
        
        while (true) {
            guess = scanner.nextLine();
//                if (guess.length() != 1) {
//                    
//                }
            game.gætBogstav(guess);
            System.out.println(game.logStatus());
            
            if (game.erSpilletVundet()) {
                System.out.println("Congratulations you won! You guessed the word: " + game.getOrdet());
                System.out.println("Type Y to play again");
                if (guess.equalsIgnoreCase("Y")){
                    game.nulstil();
                    System.out.println(game.logStatus());
                    System.out.println("Guess a word!");
                }
            }
            else if (game.erSpilletTabt()) {
                System.out.println("You lost! The word was: " + game.getOrdet());
                System.out.println("Type Y to play again");
                if (guess.equalsIgnoreCase("Y")){
                    game.nulstil();
                    System.out.println(game.logStatus());
                    System.out.println("Guess a word!");
                }
            }
        }
    }
}
