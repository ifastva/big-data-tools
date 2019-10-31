
# Insatallation :fire:

brew cask install java

brew install kafka

# Creating a topic :cyclone:
- kafka-topics --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test

# Starting servers :rocket:

zookeeper:
- zookeeper-server-start /usr/local/etc/kafka/zookeeper.properties

Kafka
- kafka-server-start /usr/local/etc/kafka/server.properties

Producer & consumer
- kafka-console-producer --broker-list localhost:9092 --topic test
- kafka-console-producer --broker-list localhost:9092 --topic rabbitmq_test

- kafka-console-consumer --bootstrap-server localhost:9092 --topic test --from-beginning
- kafka-console-consumer --bootstrap-server localhost:9092 --topic rabbitmq_test --from-beginning
