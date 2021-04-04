# KasasaProject
Kasasa Loan System-Spring

REST Api Endpoints to calculate APR 

    APR = ((((fees+totalInterest)/principal)/term)*365)*100

    totalInterest=(principal*rateofInterest*term)/100

Application properties
      
      #MySQL DB with kasasaproject db name
      spring.datasource.url = jdbc:mysql://localhost:3306/kasasaproject
      // Usrname pass other hibernate properties
      # Hibernate ddl auto (create, create-drop, validate, update)
      #creates table based on model
      spring.jpa.hibernate.ddl-auto = create-drop
      


Basic Project Structure
        
        src
         |-------main
         |        |------------constants
         |        |------------controller- contoller layer
         |        |------------dal- Data Access layer/repo
         |        |------------exceptions- Exception/Validation handling
         |        |------------model- Model layer
         |        |------------service
         |        |------------utility
         |
         |-------test
                  |------------repository
                  |------------service
 
        

Dependencies:
1. Spring Boot
2. Spring Data JPA
3. MySQL Connector
4. Spring Hibernate
5. Mockito
6. Junit

Testing All endpoints on Postman

Test#1 Post request
![1](https://user-images.githubusercontent.com/44416146/113498434-888e4400-94d2-11eb-94c3-dbf2594610e0.PNG)

Test#2 Post request
![2](https://user-images.githubusercontent.com/44416146/113498436-8926da80-94d2-11eb-9d59-fbc291306770.PNG)

Test#3 Fetch All loans request for testing
![5](https://user-images.githubusercontent.com/44416146/113498438-89bf7100-94d2-11eb-89be-1a09acb6b07c.PNG)

Test#4 Fetch Loan by created id from MySQL Database request for testing
![6](https://user-images.githubusercontent.com/44416146/113498439-8a580780-94d2-11eb-8026-7caf04534774.PNG)

Test#5 Validation for given input JSON object
![validation1](https://user-images.githubusercontent.com/44416146/113498440-8a580780-94d2-11eb-8917-09b9af028298.PNG)

Test#6 Validation for Fetch Loan by Id
![validation3](https://user-images.githubusercontent.com/44416146/113498442-8b893480-94d2-11eb-91ea-96cf998b60dc.PNG)

Test#7 Validation for loan type input JSON object
![validation2](https://user-images.githubusercontent.com/44416146/113498441-8af09e00-94d2-11eb-864d-a865df595d91.PNG)

