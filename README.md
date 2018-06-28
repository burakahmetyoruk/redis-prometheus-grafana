# Monitoring Spring Data Redis Project with Prometheus and Grafana


Run Docker Compose File
----------------------
This docker compose file consist Redis, Redis-Exporter, Prometheus and Grafana.
If you already have Docker installed, just run docker-compose file and all set! Run docker-compose file with the command below:

    $ docker-compose up
    
Run Spring Boot Project
----------------------
This simple spring boot project has 3 functionalities.
1. Put 1 million random key,value pairs to Redis without any TTL.
1. Put a given key,value pair to Redis with given TTL in RedisService.java -> You can adjust TTL whatever you want in this class.
1. Delete key,value pair with given key.

Prometheus Dashboard
----------------------

You can use prometheus dashboard http://localhost:9090

Redis Exporter Metrics 
----------------------
You can reach redis exporter metrics from http://localhost:9121/metrics

Grafana Dashboard
----------------------

If you want to visualize redis metrics via grafana you have to add prometheus datasource. After adding datasource you can import this dashboard - https://grafana.com/dashboards/763 - to grafana
