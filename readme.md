# Harvest

A realtime streaming process for location information data, including aggregation and visualization.


# architecture

* kafka
* spark
    * structured streaming | continuous process
* cassandra
* leaflet

# installation

## kafka

```bash
brew install kafka
```

```
==> zookeeper
To have launchd start zookeeper now and restart at login:
  brew services start zookeeper
Or, if you don't want/need a background service you can just run:
  zkServer start
==> kafka
To have launchd start kafka now and restart at login:
  brew services start kafka
Or, if you don't want/need a background service you can just run:
  zookeeper-server-start /usr/local/etc/kafka/zookeeper.properties & kafka-server-start /usr/local/etc/kafka/server.properties
```

## spark

```bash
brew install apache-spark
```

## cassandra

```bash
brew install cassandra
```

## leaflet

https://leafletjs.com/

# execution

## kafka

https://blog.amedama.jp/entry/2017/04/29/184607

```bash
# topicの作成
kafka-topics --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test
kafka-topics --list --zookeeper localhost:2181
# producer (console)の作成
kafka-console-producer --broker-list localhost:9092 --topic test


> bin/connect-standalone.sh config/connect-standalone.properties config/connect-file-source.properties config/connect-file-sink.properties

```

```bash

```

```bash

```

```bash

```


## nc

```bash
nc -lk 9999

```

## spark

```bash
/usr/local/Cellar/apache-spark/2.4.0/bin/spark-shell 


```

* spark-shell実行時にkafkaのdependencyをオプションとして追加する
    * https://spark.apache.org/docs/latest/structured-streaming-kafka-integration.html

## cassandra


https://stackoverflow.com/questions/50037285/writing-spark-structure-streaming-data-into-cassandra

# notes

geomesaすごそう

mongodbにgeospatial indexあった

