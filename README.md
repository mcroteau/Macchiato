# Macchiato

### Simple J2ee blog sample ... you can't even update 

Start H2 Database:
`cd exec/`

Run following command: 
`java -jar h2-1.4.200.jar`

Open browser and browse to `http://localhost:8082/login.do`

Update **JDBC URL** 

jdbc:h2:~/{{PROJECT_DIR}}/exec/cafe

Click **Connect**.

Now run Macchiato: 

`mvn jetty:run`

Browse to : `http://localhost:8080/macchiato`