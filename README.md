# contact-info

Projects aim to same the contact info.
Used Technologies -
Springboot, H2 in-memory DB, Spring DataJPA

clone the project.

Run the application

1. Request to add record

curl --location --request POST 'http://localhost:8080/v1/contactinfo' \
--header 'Content-Type: application/json' \
--data-raw '{
    "firstName": "Hemant",
    "lastName": "Dhage",
    "email": "hemantdhage20@gmail.com",
    "phoneNumber": 123456789,
    "status": "Active"
}'

2. Request to Update
curl --location --request PUT 'http://localhost:8080/v1/contactinfo/1' \
--header 'Content-Type: application/json' \
--data-raw '{
    "firstName": "Niraj",
    "lastName": "Dhage",
    "email": "hemantdhage20@gmail.com",
    "phoneNumber": 9890278659,
    "status": "Active"
}'

3. Request to get by id
curl --location --request GET 'http://localhost:8080/v1/contactinfo/1' \
--data-raw ''

4. Request to getall

curl --location --request GET 'http://localhost:8080/v1/contactinfo' \
--data-raw ''

5. Request to delete by Id
curl --location --request DELETE 'http://localhost:8080/v1/contactinfo/1' \
--data-raw ''
