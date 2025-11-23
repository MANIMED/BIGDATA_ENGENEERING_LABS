package edu.supmti.kafka;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.*;
import org.apache.kafka.streams.kstream.*;
import java.util.*;

public class WordCount {
    public static void Start() {
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "word-count-app");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        StreamsBuilder builder = new StreamsBuilder();

        String input, output; 
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez indiquer le nom du Topic Input");
        input = scanner.nextLine();
         System.out.println("Veuillez indiquer le nom du Topic Output");
        output = scanner.nextLine();
        KStream<String, String> textLines = builder.stream(input, Consumed.with(Serdes.String(), Serdes.String()));
        // Word count logic goes here
        textLines
                .flatMapValues(value -> Arrays.asList(value.toLowerCase().split("\\W+")))
                .groupBy((key, word) -> word)
                .count(Materialized.as("word-counts-store"))
                .toStream()
                .mapValues(count -> Long.toString(count))
                .to(output, Produced.with(Serdes.String(), Serdes.String()));
        // End of word count logic
        KafkaStreams streams = new KafkaStreams(builder.build(), props);
        streams.start();
        Runtime.getRuntime().addShutdownHook(new Thread(streams::close));
    }
}