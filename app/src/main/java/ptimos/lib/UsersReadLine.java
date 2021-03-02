package ptimos.lib;

import java.util.Scanner;
import static org.fusesource.jansi.Ansi.*;

public class UsersReadLine {
    public boolean isStartFight;
    public boolean isWatching;
    public boolean isMoving;
    public boolean isLaunchCandy;
    public boolean isDancing;
    public boolean isShotArrow;
    public boolean isEscape;
    public boolean isExit;
    public boolean isChecking;
    public ColorsCustomer colorCmd = new ColorsCustomer();

    public void userReadLine() {
        Object response = new Scanner(System.in).nextLine();
        this.verifyResponse(response);
    }

    // vérifie le type et la taille de la réponse
    public void verifyResponse(Object response) {
        if (response.getClass().getName() == "java.lang.String" && ((String) response).length() == 1) {
            this.testConvertToInt(response);
        } else {
            this.errorResponse();
        }
    }

    // Essaie de convertir le réponse de l'utilisateur en int
    // Certianement mauvaise pratique en java
    // si la réponse ne peut pas etre convertit alors l'utilisateur est dans le menu et n'est pas en combat
    public void testConvertToInt(Object response) {
        try {
            Integer responseNum = Integer.parseInt((String) response);
            this.manageResponseFight(responseNum);
        } catch (Exception e) {
            this.manageResponseMeet(response);
        }
    }

    // message d'erreur
    public void errorResponse() {
        System.out.println(ansi().fg(this.colorCmd.red()).a("Le programme ne reconnait pas votre réponse").reset());
    }

    // gère les reponse utilisateur dans le menu
    public void manageResponseMeet(Object response) {
        switch ((String) response) {
            case "q" :
                System.out.println("Au revoir !");
                this.isExit = true;
                break;
            case "o" :
                this.isStartFight = true;
                break;
            case "n" :
                System.out.println("Vous partez à la recherche d'autre Ptimos");
                this.isEscape = true;
                break;
            case "r" :
                System.out.println("Vous regarder vos ptimos");
                this.isChecking = true;
                break;
            default : 
                System.out.println("Au revoir !");
        }
    }

    // gère les reponse utilisateur pendant le combat
    public void manageResponseFight(Integer response) {
        switch (response) {
            case 1 :
                this.isWatching = true;
                break;
            case 2 :
                this.isMoving = true;
                break;
            case 3 :
                this.isLaunchCandy = true;
                break;
            case 4 :
                this.isDancing = true;
                break;
            case 5 : 
                this.isShotArrow = true;
                break;
            case 0 :
                System.out.println("Vous partez à la recherche d'autre Ptimos");
                this.isEscape = true;
                break;
            default : 
                System.out.println("Vous partez à la recherche d'autre Ptimos");
                this.isEscape = true;
        }
    }
}
