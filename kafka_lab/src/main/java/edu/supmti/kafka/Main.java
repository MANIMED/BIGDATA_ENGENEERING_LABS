package edu.supmti.kafka;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Bonjour, Nous allons exploiter KAFKA");
        System.out.println("1 - Si vous voulez produire un message standard");
        System.out.println("2 - Si vous voulez produire un paiement d'un étudiant");
        System.out.println("3 - Si vous voulez Consommer un message standard");
        System.out.println("4 - Si vous voulez Consommer les paiements des étudiants");

        Scanner scanner = new Scanner(System.in);
        int reponse = scanner.nextInt();
        switch (reponse) {
            case 1:
                eventProducer.Produce();
                break;
            case 2 :
                PaiementProducer.Produce();
                break;
            case 3 : 
                 EventConsumer.Consume();
                break;
            case 4 :
                PaiementConsumer.Consume();
                break;
            default:
                System.out.println("Le numéro est incorrecte");
                break;
        }

    }
}