# Lab 1 – Utilisation de la bibliothèque Hadoop en Java

Ce laboratoire a pour objectif de pratiquer quelques fonctions de base de la bibliothèque Hadoop (HDFS) en Java.

## Description

Le projet utilise **une seule classe `Main`**, qui appelle **trois fonctions** situées dans **trois classes différentes** :

* Afficher les détails d’un fichier
* Écrire dans un fichier
* Lire le contenu d’un fichier

## Exécution

Les actions sont choisies en passant un paramètre dans la **ligne de commande** lors de l’exécution du `.jar`.

### Commandes disponibles

```bash
hadoop jar HadoopFileStatut.jar D <filename>
hadoop jar HadoopFileStatut.jar W <filename> <messageToStore>
hadoop jar HadoopFileStatut.jar R <filename>
```

### Exemples

```bash
hadoop jar HadoopFileStatut.jar D /user/hadoop/file.txt
hadoop jar HadoopFileStatut.jar W /user/hadoop/test.txt "Hello Hadoop"
hadoop jar HadoopFileStatut.jar R /user/hadoop/test.txt
```

### Pré-requis

* Hadoop installé et configuré
* Java JDK
* Accès à HDFS

---

# Lab 2 – MapReduce : Calcul du nombre d’occurrences de mots

Ce laboratoire a pour objectif de développer un programme **MapReduce** en Java pour Hadoop, permettant de calculer le nombre d’occurrences de chaque mot présent dans un fichier texte.

## Description

Le projet est composé de **trois classes Java** :

| Classe        | Rôle                                                                          |
| ------------- | ----------------------------------------------------------------------------- |
| `WordMapper`  | Analyse le texte, découpe les lignes en mots et produit des paires *(mot, 1)* |
| `WordReducer` | Regroupe les clés identiques et additionne les occurrences                    |
| `WordCount`   | Configure le Job MapReduce et lance l'exécution sur Hadoop                    |

Le programme reçoit **deux paramètres** lors de l’exécution via la commande `hadoop jar` :

* `inputFile` : chemin du fichier d’entrée dans HDFS
* `outputDirectory` : dossier de sortie dans HDFS (ne doit pas exister)

Le traitement MapReduce génère en sortie :

* Un fichier `_SUCCESS` indiquant le bon déroulement du job
* Un fichier `part-r-00000` contenant le résultat final du comptage

---

## Commande d’exécution

```bash
hadoop jar ReduceMap.jar <inputFile> <outputDirectory>
```

## Exemple d'exécution

```bash
hadoop jar ReduceMap.jar /input/achats.txt /ResultAchat
```

### Contenu attendu dans le dossier de sortie `/ResultAchat`

```bash
hdfs dfs -ls /ResultAchat
```

Exemple de sortie :

```
/ResultAchat/_SUCCESS
/ResultAchat/part-r-00000
```

### Affichage du résultat

```bash
hdfs dfs -cat /ResultAchat/part-r-00000
```

Exemple de contenu du fichier résultat :

```
Amex         10
Anchorage     3
Aurora        1
Austin        3
Baby          4
Beach         1
Bernardino    1
Books         5
Boston        1
Buffalo       1
CDs           2
Cameras       4
Cash         10
```

---

### Suppression du dossier de sortie si déjà existant

```bash
hdfs dfs -rm -r /ResultAchat
```



# LAB 3 = Projet Kafka - Production et Consommation de Messages

##  Description

Ce projet illustre l'utilisation de **Apache Kafka** pour la production et la consommation de messages en Java, dans un environnement Docker.

J'ai développé quatre classes principales :

- **EventProducer** : Produit 10 messages standards dans une boucle `for`.
- **EventConsumer** : Consomme les messages standards produits.
- **PaiementProducer** : Produit un message de paiement en saisissant le nom de l'étudiant et le montant.
- **PaiementConsumer** : Consomme les paiements des étudiants.

---

##  Exécution du projet

Pour lancer l'application, utilisez la commande suivante :

```bash
java -jar hadoop.jar
```

Une fois exécutée, l'application affiche le menu suivant :

```
Bonjour, Nous allons exploiter KAFKA

1 - Si vous voulez produire un message standard
2 - Si vous voulez produire un paiement d'un étudiant
3 - Si vous voulez Consommer un message standard
4 - Si vous voulez Consommer les paiements des étudiants
```

L'utilisateur choisit l'option souhaitée pour exécuter l'action correspondante.

---

##  Utilisation avec Docker

Pour que le système fonctionne correctement :

- Il est nécessaire d'ouvrir **deux terminaux Docker** :
  - Un terminal pour la **production des messages**
  - Un autre terminal pour la **consommation des messages**

Cela permet d'observer en temps réel l'échange entre producteurs et consommateurs Kafka.

---

##  Architecture générale

```
[Producer] ---> Kafka Broker ---> [Consumer]
```

Deux types de flux sont gérés :
- Messages standards
- Paiements des étudiants

---

##  Objectifs atteints

- Mise en place de Kafka avec Docker
- Implémentation de producteurs et consommateurs Java
- Gestion de plusieurs types de messages
- Interaction via un menu console

---

##  Structure des classes

```
EventProducer.java
EventConsumer.java
PaiementProducer.java
PaiementConsumer.java
```

---

##  Remarques

- Kafka fonctionne sur le port 9092 exposé dans Docker.
- Assurez-vous que le broker Kafka est bien démarré avant l'exécution.
- Chaque terminal Docker joue un rôle spécifique (producer / consumer).

