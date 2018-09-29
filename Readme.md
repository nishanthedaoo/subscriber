To Run project on local

mvn spring-boot:run

Swagger UI: http://localhost:8080/api/swagger-ui.html
API: http://localhost:8080/api/subscriptions

To Run on docker with Monitoring, meterx

1. mvn clean package

2.docker-compose up

3.//check Promethus 
http://localhost:9090/targets

4.http://localhost:3000/

4.1 add Promethus data source

4.2 import dashboard grafana/grafana-dashboard.json





TODO: , Security,  