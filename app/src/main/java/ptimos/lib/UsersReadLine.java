package ptimos.lib;

import java.util.Scanner;

public class UsersReadLine {
    boolean isResponseMeet;
    public boolean isStartFight;
    boolean isResponseFight;

    public void userReadLine() {
        Object response = new Scanner(System.in).nextLine();
        this.verifyResponse(response);
    }

    public void verifyResponse(Object response) {
        boolean checked = false;
        if (response.getClass().getName() == "java.lang.String" && ((String) response).length() == 1) this.isResponseMeet = true;
        if (this.isResponseMeet) {
            this.manageResponseMeet(response);
        } else {
            this.errorResponse();
        }
    }

    public void errorResponse() {
        System.out.println("Le programme ne reconnait pas votre réponse");
        // this.init();
    }

    public void manageResponseMeet(Object response) {
        switch ((String) response) {
            case "q" :
                System.out.println("Au revoir !");
                break;
            case "o" :
                System.out.println("Le jeux continue");
                this.isStartFight = true;
                // Arena arena = new Arena(this.player, this.ptimo);
                // arena.startCapture();
                break;
            case "n" :
                System.out.println("Vous partez à la recherche d'autre Ptimos");
                break;
            default : 
                System.out.println("Au revoir !");
        }
    }
}
