### Using Docker to simplify development (optional)

You can use Docker to improve your JHipster development experience. A number of docker-compose configuration are available in the [src/main/docker](src/main/docker) folder to launch required third party services.

For example, to start a postgresql database in a docker container, run:

```
docker compose -f docker-compose.yml up -d
```

To stop it and remove the container, run:

```
docker compose -f docker-compose.yml down
```

# claurier - Mes notes
suppression des images (on force en cas de blocages) ->
docker rmi -f $(docker images -q)

créer les containers avec des logs ->
docker-compose -f src/main/docker/postgresql.yml up -d && docker-compose -f src/main/docker/postgresql.yml logs -f

http://localhost:9090/swagger-ui/index.html
http://localhost:9090/Produits/MargeProduit

# Micro-service Souscription Interlocuteur

L'application se base sur l'approche DDD dont les détails sont parcourus sur ce lien.

Cette application est une application MicroService basée sur SpringBoot.
Elle suit les préconisations de l'architecture logicielle de référence : l'architecture hexagonale.

Elle est composée d'un projet parent et de 4 sous-modules :

- Domain
- Application
- Exposition
- Infrastructure

Documentation pour l'architecture hexagonale: https://confluence.group.echnonet/pages/viewpage.action?pageId=47189819

L'artifact produit par le build est un fichier "JAR" autonome embarquant Tomcat.

1) Depuis votre IDE, dans la couche "Exposition" : lancer la Classe SouscriptionApplication (clic droit, Run).
   La Page de diagnostic : http://localhost:8189/diagnostic/index.html permet de vérifier que l'application est bien up,
   et donne diverses informations utiles (dont les différents endpoints disponibles).
   Les paramètres de l'application (port, contextPath, etc.)) peuvent être modifiés via les fichiers de configuration au
   format yaml :

- resources/application.yml contient les paramètres communs à tous les environnements. Ils sont variabilisés via la
  notation ${xxx}.
- resources/application-dev.yml contient ces mêmes paramètres eventuellement surchargés (si besoin) pour l'env local.

  (fichiers présents dans la couche exposition)

Le fichier resources/extraEnv.properties (dans la couche infrastructure) contient les valeurs des propriétés/paramètres
spécifiques à l'env local.

Pour les autres environnements (cloud), celles-ci sont définies dans le fichier 'env'/values.yaml

2) NB : PAS ENCORE TESTE ! Il est possible de voir unitairement la couverture de code de chaque module.
   Pour cela un reporting JaCoCo est créé à chaque phase de build
   Rendez-vous dans le répertoire _target/site/jacoco__ de chaque module et ouvrez le contenu dans le fichier _
   _index.html__.

Une tâche dans le pom parent vous permet de centraliser les différents rapports de chaque module.
Pour cela :

* Faites tourner une image docker de __sonarqube__
    * '''docker-pull sonarqube'''
    * '''docker run -d --name sonarqube -p 9000:9000 sonarqube'''
    * Vérifiez que votre sonarqube est bien initialisé avec la commande ```docker ps```
* À la racine de votre projet, lancez la commande suivante :
  mvn sonar:sonar -Dsonar.issuesreport.html.enable=true
  Vous devriez obtenir une url à la fin du rapport.
  [INFO] ANALYSIS SUCCESSFUL, you can browse http://localhost:9000/dashboard/index/com.bnpp.pf.your-project

* Cliquez sur le lien pour avoir l'intégralité de votre rapport.

3.) Accès au SwaggerUI de l'application
Depuis un problème de compatibilité entre Diagnostic et SwaggerUI avec la montée de version du parent "tech-parent",
pour accéder à toutes les opérations exposées par le back dans notre api:

- Depuis la page de Diagnostic de l'environnement, dans Consume puis Rest client puis swagger-service, l'url à prendre
  est dans Root URI

  4.) Intégration de l'APIM France : TODO.
