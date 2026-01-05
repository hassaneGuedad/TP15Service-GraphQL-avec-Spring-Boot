# Banque Service - API Spring Boot GraphQL

## Présentation
Ce projet est une application de gestion de comptes bancaires et de transactions, développée en Java avec Spring Boot, GraphQL, Spring Data JPA, H2 Database et Lombok. Il permet de manipuler des comptes, d’effectuer des transactions (dépôts/retraits), et d’exposer des statistiques via une API GraphQL moderne et flexible.

## Fonctionnalités principales
- **Gestion des comptes** : création, consultation, statistiques globales.
- **Gestion des transactions** : ajout de dépôts/retraits, consultation par compte, statistiques globales.
- **API GraphQL** : requêtes et mutations pour toutes les opérations.
- **Base de données H2** : stockage en mémoire, console web accessible pour le développement.
- **Interface GraphiQL** : test interactif des requêtes GraphQL.

## Technologies utilisées
- Java 17
- Spring Boot 3.x
- Spring for GraphQL
- Spring Data JPA
- H2 Database (mode mémoire)
- Lombok
- Maven

## Installation et exécution
1. **Cloner le projet**
   ```bash
   git clone <url-du-repo>
   cd tp15
   ```
2. **Compiler et lancer l’application**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```
3. **Accéder aux interfaces**
   - Console H2 : [http://localhost:8082/h2-console](http://localhost:8082/h2-console)
     - JDBC URL : `jdbc:h2:mem:banque`
     - Username : `sa` (mot de passe vide)
   - Interface GraphiQL : [http://localhost:8082/graphiql](http://localhost:8082/graphiql)

## Exemples de requêtes GraphQL
### Récupérer tous les comptes
```graphql
query {
  allComptes {
    id
    solde
    dateCreation
    type
  }
}
```
### Ajouter un compte
```graphql
mutation {
  saveCompte(compte: { solde: 1500, dateCreation: "2024-11-18", type: COURANT }) {
    id
    solde
    type
  }
}
```
### Ajouter une transaction
```graphql
mutation {
  addTransaction(transaction: { compteId: 1, montant: 500, date: "2024-11-18", type: DEPOT }) {
    id
    montant
    type
    compte { id }
  }
}
```
### Statistiques globales
```graphql
query {
  totalSolde { count sum average }
  transactionStats { count sumDepots sumRetraits }
}
```

## Structure du projet
```
├── src/main/java/com/example/
│   ├── Compte.java
│   ├── CompteControllerGraphQL.java
│   ├── CompteRepository.java
│   ├── CompteRequest.java
│   ├── Transaction.java
│   ├── TransactionRepository.java
│   ├── TransactionRequest.java
│   ├── TypeCompte.java
│   ├── TypeTransaction.java
│   └── GraphQLExceptionHandler.java
├── src/main/resources/
│   ├── application.properties
│   └── graphql/schema.graphqls
└── pom.xml
```

## Auteur
- **Nom** : [Votre Nom]
- **Statut** : Étudiant
- **Contact** : [Votre Email]

## Remerciements
Merci à l’équipe pédagogique et à la communauté Spring pour la documentation et le support.

---
> _Projet réalisé dans le cadre d’un apprentissage universitaire sur les technologies Java, Spring Boot et GraphQL._

