# Lab 1 – Utilisation de la bibliothèque Hadoop en Java

Ce laboratoire a pour objectif de pratiquer quelques fonctions de base de la bibliothèque Hadoop (HDFS) en Java.

## Description

Le projet utilise **une seule classe `Main`**, qui appelle **trois fonctions** situées dans **trois classes différentes** :

- Afficher les détails d’un fichier
- Écrire dans un fichier
- Lire le contenu d’un fichier

## Exécution

Les actions sont choisies en passant un paramètre dans la **ligne de commande** lors de l’exécution du `.jar`.

### 1) Afficher les détails d’un fichier

```bash
hadoop jar HadoopFileStatut.jar D <filename>
hadoop jar HadoopFileStatut.jar W <filename> <messageToStore>
hadoop jar HadoopFileStatut.jar R <filename>

Exemples : 
hadoop jar HadoopFileStatut.jar D /user/hadoop/file.txt
hadoop jar HadoopFileStatut.jar W /user/hadoop/test.txt "Hello Hadoop"
hadoop jar HadoopFileStatut.jar R /user/hadoop/test.txt

Pré-requis

- Hadoop installé et configuré
- Java JDK
- Accès à HDFS
