# Ticket
## Docker Run Command

#### If you don't have network `ticket-api` please create it first
```
docker network create ticket-api
```

#### Docker run image
```
docker run --net ticket-api --name frontticket -p 8090:8090 -it ghcr.io/bastz/frontticket:master
```
### Absolutely do not change the code. Please run the code provided.
