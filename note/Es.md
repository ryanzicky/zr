[ES官网](https://www.elastic.co/)

#### 安装es 
[ES](https://www.elastic.co/cn/downloads/elasticsearch)  

***使用yum安装方式***
```
whereis elasticsearch
安装路径为 elasticsearch: /etc/elasticsearch /usr/share/elasticsearch
```

```
配置es
进入es配置文件夹 cd /etc/elasticsearch/

1. 设置jvm启动参数
vim jvm.options
-Xms512m
-Xmx512m

2. 设置es配置
vim elasticsearch.yml
network.host: 0.0.0.0
cluster.initial_master_nodes: ["node-1", "node-2"]\
```

```
启动es
进入es安装文件夹 cd /etc/share/elasticsearch
创建es用户 adduser es
设置密码 passwd es
设置权限 chown -R es:es /etc/share/elasticsearch

切换到es用户 su es
启动 ./elasricsearch

测试es是否启动成功 curl http://localhost:9200
{
  "name" : "node-1",
  "cluster_name" : "elasticsearch",
  "cluster_uuid" : "BsQGd0JGScigKZ82n5gnSw",
  "version" : {
    "number" : "7.10.1",
    "build_flavor" : "default",
    "build_type" : "rpm",
    "build_hash" : "1c34507e66d7db1211f66f3513706fdf548736aa",
    "build_date" : "2020-12-05T01:00:33.671820Z",
    "build_snapshot" : false,
    "lucene_version" : "8.7.0",
    "minimum_wire_compatibility_version" : "6.8.0",
    "minimum_index_compatibility_version" : "6.0.0-beta1"
  },
  "tagline" : "You Know, for Search"
}
```


#### 安装kibana
[Kibana](https://www.elastic.co/cn/downloads/kibana)
```
whereis kibana
kibana: /etc/kibana /usr/share/kibana

cd /etc/kibana
server.port: 5601 # 端口
server.host: 0.0.0.0 # 访问ip
elasticsearch.hosts: ["http://localhost:9200"] # es节点地址
```


#### Sniffer(嗅探器)

