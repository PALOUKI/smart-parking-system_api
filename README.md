      
# Smart Parking System API

![Java](https://img.shields.io/badge/Java-17+-orange) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen) ![Maven](https://img.shields.io/badge/build-Maven-red) ![License](https://img.shields.io/badge/license-MIT-blue)

Ce projet est une API RESTful simple pour la gestion d'un système de parking intelligent, développée avec Spring Boot. Il gère les entrées et sorties des véhicules et attribue automatiquement une place de parking disponible.

## ✨ Fonctionnalités

-   **Gestion des Entrées** : Enregistre l'entrée d'un véhicule et lui attribue une place.
-   **Gestion des Sorties** : Enregistre la sortie d'un véhicule et libère sa place.
-   **Allocation Automatique** : Utilise une approche "premier arrivé, premier servi" pour trouver et attribuer une place libre.
-   **Architecture Événementielle** : Utilise les événements Spring (`ApplicationEvent`) pour découpler la logique d'entrée de la logique d'allocation de place, rendant le système plus modulaire et robuste.
-   **API REST** : Expose des endpoints clairs pour interagir avec le système.

## 🛠️ Technologies utilisées

-   **Langage** : Java 17+
-   **Framework** : Spring Boot 3.x
-   **Accès aux données** : Spring Data JPA / Hibernate
-   **Base de données** : mysql
-   **Build Tool** : Maven

## 🚀 Démarrage Rapide

Suivez ces étapes pour lancer le projet sur votre machine locale.

### Prérequis

-   JDK 17 ou supérieur
-   Maven 3.8+ 
-   Git

### Installation et Lancement

1.  **Clonez le dépôt**
    ```sh
    git clone https://github.com/PALOUKI/smart-parking-system_api.git
    cd smart-parking-system
    ```

2.  **Compilez le projet avec Maven**
    ```sh
    mvn clean install
    ```

3.  **Lancez l'application**
    ```sh
    mvn spring-boot:run
    ```
L'application sera disponible à l'adresse `http://localhost:8080`.

## ⚙️ Utilisation de l'API

Vous pouvez utiliser `curl` ou un client API comme Postman pour interagir avec les endpoints.

### 1. Faire entrer un véhicule

Envoyez une requête POST pour enregistrer l'entrée d'un véhicule. Le système lui trouvera une place libre.

-   **Endpoint** : `POST /api/parking/entry`
-   **Paramètre** : `vehiculeNumber` (plaque d'immatriculation)

**Exemple avec `curl` :**
```sh
curl -X POST "http://localhost:8080/api/parking/entry?vehiculeNumber=AB-123-CD"
```

Envoyez une requête POST pour enregistrer la sortie d'un véhicule. Le système libère la place pour un autre vehicule.

-   **Endpoint** : `POST /api/parking/exit`
-   **Paramètre** : `vehiculeNumber` (plaque d'immatriculation)



    
