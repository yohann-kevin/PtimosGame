package ptimos.lib;

import java.util.Scanner;

public class UsersReadLine {
    public boolean isStartFight;

    public void userReadLine() {
        Object response = new Scanner(System.in).nextLine();
        this.verifyResponse(response);
    }

    public void verifyResponse(Object response) {
        boolean checked = false;
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
                break;
            case "o" :
                System.out.println("Le jeux continue");
                this.isStartFight = true;
                break;
            case "n" :
                System.out.println("Vous partez à la recherche d'autre Ptimos");
                break;
            default : 
                System.out.println("Au revoir !");
        }
    }

    public void manageResponseFight(Integer response) {
        switch (response) {
            case 1 :
                System.out.println("Observer");
                break;
            case 2 :
                System.out.println("Se rapprocher");
                break;
            case 3 :
                System.out.println("lancer friandise");
                break;
            case 4 :
                System.out.println("Faire une danse impressionante");
                break;
            case 5 : 
                System.out.println("Tirer un flechette");
                break;
            case 0 :
                System.out.println("Vous partez");
                break;
            default : 
                System.out.println("Vous partez");
        }
    }
}
