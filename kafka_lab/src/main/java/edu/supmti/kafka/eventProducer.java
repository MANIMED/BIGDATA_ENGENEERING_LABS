package edu.supmti.kafka;

import java.util.Properties;
import java.util.Scanner;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class eventProducer {
    public static void Produce() throws Exception {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Veuillez entrer le nom du Topic");
        String topicName = scanner.nextLine(); 

        Properties props = new Properties(); // acceder aux configurations du producteur

        props.put("bootstrap.servers", "localhost:9092"); // spécifierle serveur kafka
        // Definir un acquittement pour les requetes du producteur
        props.put("acks", "all");
        // Si la requete echoue, le producteur peut reessayer automatiquement
        props.put("retries", 0);
        // Specifier la taille du buffer size dans la config
        props.put("batch.size", 16384);
        // controle l espace total de mem dispo au producteur pour le buffering
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        Producer<String, String> producer = new KafkaProducer<String, String>(props);
        for (int i = 0; i < 10; i++)
            producer.send(new ProducerRecord<String, String>(topicName,
                    Integer.toString(i), Integer.toString(i)));
        System.out.println("Message envoye avec succes");
        producer.close();

    }

}