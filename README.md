# ticketBooking
ticket booking sample REST webApp` for cloudbees

steps to run:
1. build the application using maven clean install
2. the above step creates a jar file
3. run this spring boot REST application

requests are given below:

To purchase a ticket
curl --location 'http://localhost:8080/purchaseTicket' \
--header 'Content-Type: application/json' \
--data-raw '{
    "from": "Lucknow",
    "to": "Bangalore",
    "price": 10,
    "userEmail": "ankur@gmail.com"
}'


To get a ticket details
curl --location --request GET 'http://localhost:8080/getTicketDetails?emailAddress=ankur%40gmail.com' \
--header 'Content-Type: application/json' \
--data-raw '{
    "from": "Lucknow",
    "to": "Bangalore",
    "price": 10,
    "userEmail": "ankur@gmail.com"
}'


To get all tickets
curl --location --request GET 'http://localhost:8080/getAllTickets' \
--header 'Content-Type: application/json' \
--data-raw '{
    "from": "Lucknow",
    "to": "Bangalore",
    "price": 10,
    "userEmail": "ankur@gmail.com"
}'

To remove a ticket
curl --location --request DELETE 'http://localhost:8080/removeTicket?emailAddress=ankur%40gmail.com' \
--header 'Content-Type: application/json' \
--data-raw '{
    "from": "Lucknow",
    "to": "Bangalore",
    "price": 10,
    "userEmail": "ankur@gmail.com"
}'
