package ptimos.lib;

import java.util.Scanner;

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

    public void userReadLine() {
        Object response = new Scanner(System.in).nextLine();
        this.verifyResponse(response);
    }

    public void verifyResponse(Object response) {
        // boolean checked = false;
        if (response.getClass().getName() == "java.lang.String" && ((String) response).length() == 1) {
            try {
                Integer responseNum = Integer.parseInt((String) response);
                this.manageResponseFight(responseNum);
            } catch (Exception e) {
                this.manageResponseMeet(response);
            }
        } else {
            this.errorResponse();
        }
    }

    public void errorResponse() {
        System.out.println("Le programme ne reconnait pas votre réponse");
    }

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
