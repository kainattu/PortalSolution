
### For referace

https://medium.com/@chrischuck35/how-to-create-a-mysql-instance-with-docker-compose-1598f3cc1bee

execute this commad to start container
$> docker-compose up 


### For PostgreSQL
version: '3.3'
services:
  db:
    image: postgres
    restart: always
    environment:
      POSTGRES_PASSWORD: password


