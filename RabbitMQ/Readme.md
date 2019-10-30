
# Installation

brew install python

brew install rabbitmq

pip3 install pika --upgrade

# Edit vi .bash_profile
export HOMEBREW_RABBITMQ=/usr/local/Cellar/rabbitmq/3.8.0/sbin/
export PATH=$PATH:$HOMEBREW_RABBITMQ
# Starting servers

rabbitmq
- rabbitmq-server

# Dashboard Access

http://localhost:15672

# Commands

- List queues: sudo rabbitmqctl list_queues
