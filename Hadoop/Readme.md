# Installing components


### My SQL


- brew install mysql.
- brew tap homebrew/services.
- brew services start mysql.
- mysqladmin -u root password 'yourpassword'

- Conector
 - $ tar zxvf mysql-connector-java-5.1.44.tar.gz
 - $ sudo cp mysql-connector-java-5.1.44/mysql-connector-java-5.1.44-bin.jar /usr/local/Cellar/hive/2.1.1/libexec/lib/

- Create core tables
 - mysql > source /usr/local/Cellar/hive/3.1.2/libexec/scripts/metastore/upgrade/mysql/hive-schema-3.1.0.mysql.sql
###### Creating Metastore
mysql   
mysql> CREATE DATABASE metastore  
mysql> USE metastore;   
mysql> CREATE USER 'hiveuser'@'localhost' IDENTIFIED BY 'password';   
mysql> GRANT SELECT,INSERT,UPDATE,DELETE,ALTER,CREATE ON metastore.* TO 'hiveuser'@'localhost';


# Starting stopping HDFS services
- hstart
- hstop

http://localhost:9870/dfshealth.html#tab-overview

# Starting Hive

Hive

# Starting mysql
mysql-u root -p

# Starting Metastore

hive --service metastore &

# Loading connector
confluent local load hdfs-sink -- -d quickstart-hdfs.properties

curl -X DELETE localhost:8083/connectors/HdfsSinkConnector

# Creating table
``` SQL
CREATE  EXTERNAL TABLE sw66_data
ROW FORMAT
SERDE 'org.apache.hadoop.hive.serde2.avro.AvroSerDe'
STORED AS
INPUTFORMAT 'org.apache.hadoop.hive.ql.io.avro.AvroContainerInputFormat'
OUTPUTFORMAT 'org.apache.hadoop.hive.ql.io.avro.AvroContainerOutputFormat'
LOCATION  'hdfs:///topics/rabbitmqtest3/partition=0/'
TBLPROPERTIES ('avro.schema.literal'='{
  "namespace": "default",
  "name": "sw66_data",
  "type": "record",
  "fields": [
    {
      "name":"id",
      "type":"int",
      "doc":"ID machine"
    },
    {
      "name":"message",
      "type":"string",
      "doc":"Body"
    }
  ]
}');

```

```
LOAD DATA LOCAL INPATH 'hdfs://topics/rabbitmqtest3/partition=0/' INTO TABLE sw66_data;


```


# Formats
"format.class": "io.confluent.connect.hdfs.parquet.ParquetFormat",
cc
# Connector

format.class
The format class to use when writing data to the store. Format classes implement the io.confluent.connect.storage.format.Format interface.

These classes are available by default:

- io.confluent.connect.hdfs.avro.AvroFormat
- io.confluent.connect.hdfs.json.JsonFormat
- io.confluent.connect.hdfs.parquet.ParquetFormat
- io.confluent.connect.hdfs.string.StringFormat

# Useful links

- https://gist.github.com/viecode09/ad56b09bea4da59b4240d45b666321cf
- http://localhost:9870/dfshealth.html#tab-overview
- https://docs.confluent.io/current/connect/kafka-connect-hdfs/index.html
- https://www.confluent.io/blog/kafka-connect-deep-dive-converters-serialization-explained
