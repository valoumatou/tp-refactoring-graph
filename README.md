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

## Remarque

Un extrait de [ROUTE500](http://professionnels.ign.fr/route500) est présent dans `src/test/resources/idf/troncon_route.shp` à des fins de tests.

## Utilisation

### En mode ligne CLI

Lancer l'application `cli.FindPath` dans eclipse.

### En mode API

1) Construire le jar :

```bash
mvn clean package
```

2) Démarrer l'API

```bash
# Option 1 : Charger le graphe de démonstration
java -cp target -jar target/tp-refactoring-graph-0.1.0-SNAPSHOT.jar
# -> ouvrir http://localhost:8080/find-path?origin=a&destination=c

# Option 2 : Charger l'extrait ROUTE500
java -Dgraph.path=src/test/resources/route500/idf/troncon_route.shp -jar target/tp-refactoring-graph-0.1.0-SNAPSHOT.jar
# -> Ouvrir http://localhost:8080/find-path?origin=1&destination=1000
```


### En mode API sous eclipse

Lancer "Application.java" par exemple avec les paramètres suivant dans "VM Arguments" :

```bash
-Dgraph.path=${project_loc}/src/test/resources/route500/idf/troncon_route.shp
```

## Notes

* Log en mode debug : `-Dlogging.level.org.acme.graph=DEBUG`
* [VisualVM](https://visualvm.github.io/) pourra vous aider
* Génération de rapport de couverture : `mvn clean package jacoco:report`

