**To Run project on local**

mvn spring-boot:run

Swagger UI: usernamer:user, password:user http://localhost:8080/api/swagger-ui.html

API Endpoint: http://localhost:8080/api/subscriptions

CURL Commands with Http Basic Auth

curl -X GET -u user:user --header 'Accept: application/json' 'http://localhost:8080/api/subscriptions'

curl -X GET -u user:user --header 'Accept: text/html' 'http://localhost:8080/api/subscriptions/1'

curl -X POST -u user:user --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{ \ 
   "id": 4, \ 
   "monthlyPrice": 444, \ 
   "name": "sub 4" \ 
 }' 'http://localhost:8080/api/subscriptions'
 
 curl -X PUT -u user:user --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{ \ 
    "id": 1, \ 
    "monthlyPrice": 222, \ 
    "name": "sub 2" \ 
  }' 'http://localhost:8080/api/subscriptions/1'

**To Run on docker with Monitoring, meterx**

1. mvn clean package

2. docker-compose up

3. Hit service curl -X GET -u user:user --header 'Accept: application/json' 'http://localhost:8080/api/subscriptions'

3.1 check Promethus targets are UP
http://localhost:9090/targets

4.Login Grafana http://localhost:3000/
user:admin username:admin

4.1 add Promethus data source

4.2 import dashboard grafana/grafana-dashboard.json





TODO: Reactive