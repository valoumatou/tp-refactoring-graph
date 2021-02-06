# tp-refactoring-graph

## Description

[tp-refactoring-graph](http://mborne.github.io/cours-patron-conception/annexe/tp-graph/index.html) associé au cours sur [les patrons de conception et principes de réfactoring](http://mborne.github.io/cours-patron-conception/).


## Principes

* La branche par défaut ("initial") permet de récupérer un projet maven pour commencer à travailler
* Les branches 0.1, 0.2, etc. correspondront aux corrections pour chaque question du TP
* junit et mockito sont présents pour permettre l'écriture de tests unitaires

## Organisation du code

Le projet contient deux points d'entrée :

* `cli.FindPath` : Calcul de plus court chemin en ligne de commande (CLI = *Command Line Interpreter*)
* `Application` : Application sous forme d'une API springboot

Le code est organisé en package :

* `model` : Modélisation des données de l'application
* ̀`io` : Lecture de graphe dans différents formats (entrées/sorties)
* `routing` : Implémentation de l'algorithme de calcul de plus court chemin
* `controllers` : Contrôleurs de l'application springboot
* `config` : Configuration de l'application springboot (initialisation des beans)

## Utilisation

### Calcul de chemin en ligne de commande

Lancer l'application "cli/FindPath.java" dans eclipse. Un message d'aide vous guidera pour configurer le point de départ et d'arrivée.

### Démarrage de l'API avec eclipse

* Lancer l'application "Application.java".
* Ouvrir http://localhost:8080/find-path?origin=1&destination=9557

### Démarrage de l'API en ligne de commande

1) Construire le jar

```bash
mvn clean package
```

2) Démarrer l'API

```bash
# Démarrer l'API avec le graphe ROUTE500 de démonstration
java -cp target -jar target/tp-refactoring-graph-0.1.0-SNAPSHOT.jar
# Tester l'API :
curl "http://localhost:8080/find-path?origin=1&destination=9557"
```

Remarque :

* Un extrait de [ROUTE500](http://professionnels.ign.fr/route500) est présent dans `src/main/resources/route500/idf/troncon_route.shp` à des fins de tests. Il est intégré dans le jar et est chargé par défaut
* Il est possible de charger un autre fichier à l'aide de l'option `graph.path` :

```bash
java -Dgraph.path=path/to/troncon_route.shp -jar target/tp-refactoring-graph-0.1.0-SNAPSHOT.jar
```


## Notes

* Log en mode debug : `-Dlogging.level.org.acme.graph=DEBUG`
* [VisualVM](https://visualvm.github.io/) pourra vous aider
* Génération de rapport de couverture : `mvn clean package jacoco:report`

