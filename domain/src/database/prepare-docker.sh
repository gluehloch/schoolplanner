#!/bin/bash
export DOCKER_NAME='schoolplanner'
export DOCKER_DB_HOST='192.168.99.100'

# Die Testdatenbank laueft unter Port 3307. Damit gehe ich dem Konflikt mit
# der betoffice Datenbank aus dem Weg.
# docker run --expose=3306 -p 3307:3306 --name schoolplanner -e MYSQL_ALLOW_EMPTY_PASSWORD=true -d mariadb:latest
docker run --expose=3306 -p 3307:3306 --name ${DOCKER_NAME} -e MYSQL_ALLOW_EMPTY_PASSWORD=true -d mariadb:latest

# mysql -u root -h 192.168.99.100 -P 3307
mysql -u root -h ${DOCKER_DB_HOST} -P 3307 < mysql-prod.sql
mysql -u schoolsu --password=school -h ${DOCKER_DB_HOST} -P 3307 -D school < mysql.sql
