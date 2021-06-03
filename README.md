# product-service project

Simple Java microservice using Quarkus framework

## Overview

This service manages a small product domain with following operations:
- get a product 
- get all product 
- create a product 

But it's rather an argument to discover how we can design a Java microservice with Quarkus :)

## Technical topics

- OAuth2 authentication (client credentials flow) with Keycloack
- JSON request validation with Hibernate validator
- MongoDB as storage
- Unit tests and coverage 
- Docker image build 
- Kubernetes template generation

## Build

### local

`./mvnw clean package -Dquarkus.profile=local`

`java -jar target/quarkus-app/quarkus-run.jar`.

### docker-compose

#### build image for JVM
`./mvnw clean package -Dquarkus.container-image.build=true -Dquarkus.container-image.image=my-registry.com/jami/quarkus/product-service -Dquarkus.profile=docker`

#### build native image
__It will download Quarkus Mandrel image builder (about 700mb)__

`./mvnw clean package -Pnative -Dquarkus.native.container-build=true -Dquarkus.native.builder-image=quay.io/quarkus/ubi-quarkus-mandrel:21.0.0.0-Final-java11 -Dquarkus.container-image.build=true -Dquarkus.container-image.image=my-registry.com/jami/quarkus/product-service -Dquarkus.profile=docker`

__Run__
__It will download MongoDB and Keycloak images (about 1.1Gb)__

`docker-compose up -d`

