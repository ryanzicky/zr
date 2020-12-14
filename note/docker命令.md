1. 拉取镜像

   ```jsx
   docker pull docker.elastic.co/elasticsearch/elasticsearch:7.7.0
   ```

   

2. 运行容器

   ```jsx
   docker run -d --name es -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:7.7.0
   ```

3. 配置容器

   1. 进入容器

      ```jsx
      docker exec -it es /bin/bash
      ```

   2. 进行配置

      ```jsx
      # 显示文件
      ls
      结果如下：
      LICENSE.txt  README.textile  config  lib   modules
      NOTICE.txt   bin             data    logs  plugins
      
      # 进入配置文件夹
      cd config
      
      # 显示文件
      ls
      结果如下：
      elasticsearch.keystore  ingest-geoip  log4j2.properties  roles.yml  users_roles
      elasticsearch.yml       jvm.options   role_mapping.yml   users
      
      # 修改配置文件
      vi elasticsearch.yml
      
      # 加入跨域配置
      http.cors.enabled: true
      http.cors.allow-origin: "*"
      ```

   3. 重启容器

      ```jsx
      docker restart es
      ```



## docker启动jenkins

```jsx
docker run -d -p 80:8080 -p 50000:50000 -p 9091:9091 -v jenkins:/var/jenkins_home -v /usr/local/java/maven/maven3.6.3:/usr/local/maven -v /usr/local/java/jdk1.8.0_251:/usr/local/jdk --name jenkins jenkins/jenkins:2.235.5-lts-centos7
```

### 查看容器启动命令

```jsx
docker logs -f <container id>
```

#### 查看docker内存大小

```
du -sh * /var/lib/docker
```

#### linux查看内存

```
df -h
```

#### 查看docker磁盘使用情况

```
docker system df
```

#### 清理磁盘

```
docker system prune / docker system prune -a
```

#### 执行如下命令可以批量删除所有的孤儿 **volume**（即没有任何容器用到的 **volume**）

```
docker volume rm $(docker volume ls -q)
```

#### 清理后可以查看下目前使用的所有 **volume**：

```
docker volume ls
```

#### 使用 **docker inspect** 命令可以查看某个 **volume** 的具体信息，比如挂载在本机的那个目录路径下：

```
docker inspect edgex_log-data
```

#### 一键删除所有已经停止的容器：

```
docker container prune
```





