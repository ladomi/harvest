# Harvest

A realtime streaming process for location information data, including aggregation and visualization.


# Architecture

* kafka
* spark (structured streaming)
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

# notes

geomesaすごそう

mongodbにgeospatial indexあった

