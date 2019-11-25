
![Figure 1](https://www.rabbitmq.com/img/tutorials/python-one-overall.png "Figure 1")

# Installation :fire:

brew install python

brew install rabbitmq

pip3 install pika --upgrade

# Edit vi .bash_profile :pencil:
export HOMEBREW_RABBITMQ=/usr/local/Cellar/rabbitmq/3.8.0/sbin/
export PATH=$PATH:$HOMEBREW_RABBITMQ

# Starting servers  :rocket:

rabbitmq
- rabbitmq-server

# Dashboard Access :tv:

http://localhost:15672

# Commands :computer:

- List queues: rabbitmqctl list_queues
- python3 send.py
- python3 receive.py

# Kafka Connector :arrows_counterclockwise:

Creating a new conector

- curl -s -X POST -H 'Content-Type: application/json' --data @register-rabbitmq-connect.json http://localhost:8083/connectors



Updating an existing connector

- curl -s -X PUT -H 'Content-Type: application/json' --data @register-rabbitmq-connect.json http://localhost:8083/connectors/RabbitMQSourceConnector1/config


Starting the connector


- curl -i -X POST -H "Accept:application/json" -H  "Content-Type:application/json" http://localhost:8083/connectors/ -d @register-rabbitmq-connect.json

curl -i -X POST -H "Accept:application/json" -H "Content-Type:application/json" http://localhost:8083/connectors/ -d @blob.json


Verify if connector is installed

- curl -sS localhost:9092/connector-plugins | jq .[].class | grep RabbitMQSourceConnector

Delete existing connector

- curl -X DELETE localhost:8083/connectors/RabbitMQSourceConnector1
- curl -X DELETE localhost:8083/connectors/hdfs-sink
- curl -X DELETE localhost:8083/connectors/blob-sink


# Setting Confluent :eight_spoked_asterisk:


- export CONFLUENT_HOME=/Users/josejoaquinbarruecoblanco/BigData/confluent-5.3.1
- export PATH=/Users/josejoaquinbarruecoblanco/BigData/confluent-5.3.1/bin

- confluent local start --path /Users/josejoaquinbarruecoblanco/BigData/confluent-5.3.1

- confluent local stop


# References :book:

- https://www.dyclassroom.com/howto-mac/how-to-install-rabbitmq-on-mac-using-homebrew
- https://www.rabbitmq.com/tutorials/tutorial-two-python.html
- https://www.confluent.io/hub/confluentinc/kafka-connect-rabbitmq
