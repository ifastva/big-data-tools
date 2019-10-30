
![Figure 1](https://www.rabbitmq.com/img/tutorials/python-one-overall.png "Figure 1")

# Installation

brew install python

brew install rabbitmq

pip3 install pika --upgrade

# Edit vi .bash_profile
export HOMEBREW_RABBITMQ=/usr/local/Cellar/rabbitmq/3.8.0/sbin/
export PATH=$PATH:$HOMEBREW_RABBITMQ

# Starting servers  :rocket:

rabbitmq
- rabbitmq-server

# Dashboard Access :tv:

http://localhost:15672

# Commands

- List queues: sudo rabbitmqctl list_queues
- python3 send.py
- python3 receive.py

# Kafka Connector :tiger:

Creating a new conector

- curl -s -X POST -H 'Content-Type: application/json' --data @register-rabbitmq-connect.json http://localhost:9092/connectors


Updating an existing connector

- curl -s -X PUT -H 'Content-Type: application/json' --data @register-rabbitmq-connect.json http://localhost:9092/connectors/RabbitMQSourceConnector1/config



Starting the connector

- curl -i -X POST -H "Accept:application/json" -H  "Content-Type:application/json" http://localhost:9092/connectors/ -d @register-rabbitmq-connect.json



./kafka-avro-console-consumer --bootstrap-server localhost:9092 --topic rabbitmq_test


# References :book:

- https://www.dyclassroom.com/howto-mac/how-to-install-rabbitmq-on-mac-using-homebrew
- https://www.rabbitmq.com/tutorials/tutorial-two-python.html
- https://www.confluent.io/hub/confluentinc/kafka-connect-rabbitmq
