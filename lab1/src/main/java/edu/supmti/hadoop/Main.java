package edu.supmti.hadoop;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        if(args.length == 0)
        {
            System.out.println("Vous devez saisir au moins 2 paramêtres. Le premier pour l'action ( D ou R ou W), le deuxième pour le nom de fichier ( Sans espaces )");
        }
        else
        {
        switch(args[0])
        {
        case "D" : 
            HadoopFileStatus.details(args[1]);
            break;
        case "R" :
            HadoopFileRead.Read(args[1]);
            break;
        case "W" :
            HadoopFileWrite.write(args[1], args[2]);
            break;
        }
        }


        
    }
}