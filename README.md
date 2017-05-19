# SimpleJavaRMI


## Interface
[*Cf. code/Interface.java*](https://github.com/toast254/SimpleJavaRMI/blob/master/code/Interface.java)

L'interface disponible met à disposition une fonction de calcul de la suite de [Fibonacci](https://fr.wikipedia.org/wiki/Suite_de_Fibonacci) pour un nombre donné.


## Client
[*Cf. code/AppClient.java*](https://github.com/toast254/SimpleJavaRMI/blob/master/code/AppClient.java)

Le client se connecte au serveur, appel la fonction de calcul sur le serveur et recupère le resultat.


## Serveur

Le serveur est composé de deux parties :

### Partie RMI
[*Cf. code/AppServeur.java*](https://github.com/toast254/SimpleJavaRMI/blob/master/code/AppServeur.java)

Cette partie fournit le point d'entrée pour les client.

### Partie traitement
[*Cf. code/Serveur.java*](https://github.com/toast254/SimpleJavaRMI/blob/master/code/Serveur.java)

Cette partie fournit l'implémentation de la fonction de l'interface.


# Autres exemples
  * http://www.jmdoudoux.fr/java/dej/chap-rmi.htm
  * http://www.info.univ-angers.fr/~richer/ens/m2cdsii/crs_rmi.pdf
  * http://m.heid.free.fr/expander/rmi/rmi.html
  * http://deptinfo.cnam.fr/Enseignement/CycleSpecialisation/SAR/Exercices_Samia_Bouzefrane.pdf
  * http://alain-defrance.developpez.com/articles/Java/J2SE/micro-rmi/
