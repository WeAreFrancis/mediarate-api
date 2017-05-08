# Mediarate API
## Prerequisites
- Docker
- Docker Compose
- Maven

## Run
```
export MEDIARATE_POSTGRES_USER=user
export MEDIARATE_POSTGRES_PASSWORD=password

mvn clean package
docker-compose up -d
```