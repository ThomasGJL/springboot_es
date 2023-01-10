# springboot_es

通过docker 部署 ES  

```
docker pull elasticsearch:7.7.0  
docker run --name elasticsearch -d -e ES_JAVA_OPTS="-Xms512m -Xmx512m" -e "discovery.type=single-node" -p 9200:9200 -p 9300:9300 elasticsearch:7.7.0  
```
