# SimpleJavaRMI


## Interface
[*Cf. code/Interface.java*](https://github.com/toast254/SimpleJavaRMI/blob/master/code/Interface.java)

L'interface disponible est le calcul de la suite de [Fibonacci](https://fr.wikipedia.org/wiki/Suite_de_Fibonacci) pour un nombre donné.


## Client
[*Cf. code/AppClient.java*](https://github.com/toast254/SimpleJavaRMI/blob/master/code/AppClient.java)

Le client se connecte au serveur, appel la fonction de calcul sur le serveur et recupere le resultat.


## Serveur

Le serveur est composé de deux parties :

### Partie RMI
[*Cf. code/AppServeur.java*](https://github.com/toast254/SimpleJavaRMI/blob/master/code/AppServeur.java)

Cette partie fournit le point d'entrée pour les client.

### Partie traitement
[*Cf. code/Serveur.java*](https://github.com/toast254/SimpleJavaRMI/blob/master/code/Serveur.java)

Cette partie fournit l'implementation de la fonction de l'interface.
