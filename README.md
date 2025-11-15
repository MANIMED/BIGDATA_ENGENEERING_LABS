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

# Lab 3 – MapReduce : Calcul du nombre d’occurrences de mots

Ce laboratoire a pour objectif de développer un programme **MapReduce** en Java pour Hadoop, permettant de calculer le nombre d’occurrences de chaque mot présent dans un fichier texte.

## Description

Le projet est composé de **trois classes Java** :

| Classe        | Rôle |
|--------------|------|
| `WordMapper` | Analyse le texte, découpe les lignes en mots et produit des paires *(mot, 1)* |
| `WordReducer` | Regroupe les clés identiques et additionne les occurrences |
| `Main`       | Configure le Job MapReduce et lance l'exécution sur Hadoop |

Le programme reçoit **deux paramètres** lors de l’exécution via la commande `hadoop jar` :

- `inputFile` : chemin du fichier d’entrée dans HDFS  
- `outputDirectory` : dossier de sortie dans HDFS (ne doit pas exister)

Le traitement MapReduce génère en sortie :

- Un fichier `_SUCCESS` indiquant le bon déroulement du job
- Un fichier `part-r-00000` contenant le résultat final du comptage

---

## Commande d’exécution

```bash
hadoop jar ReduceMap.jar <inputFile> <outputDirectory>

## Exemple d'exécution du programme MapReduce

La commande suivante exécute le programme en utilisant un fichier d'entrée présent dans HDFS et stocke les résultats dans un dossier de sortie :

```bash
hadoop jar ReduceMap.jar /input/achats.txt /ResultAchat

Contenu attendu dans le dossier de sortie /ResultAchat
```bash
hdfs dfs -ls /ResultAchat

/ResultAchat/_SUCCESS
/ResultAchat/part-r-00000

```bash
hdfs dfs -cat /ResultAchat/part-r-00000

Exemple de sortie 
Amex    10
Anchorage 3
Aurora  1
Austin  3
Baby    4
Beach   1
Bernardino  1
Books   5
Boston  1
Buffalo 1
CDs     2
Cameras 4
Cash    10
