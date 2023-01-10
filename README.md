# springboot_es

通过 docker 部署 ES  
  
```
docker pull elasticsearch:7.7.0  
docker run --name elasticsearch -d -e ES_JAVA_OPTS="-Xms512m -Xmx512m" -e "discovery.type=single-node" -p 9200:9200 -p 9300:9300 elasticsearch:7.7.0  
```
  
通过 docker 安装 elasticsearch-head  
  
```
docker pull mobz/elasticsearch-head:5  
docker create --name elasticsearch-head -p 9100:9100 mobz/elasticsearch-head:5  
```
  
如果 elasticsearch-head 连不上 elasticsearch, 需要修改：  
  
```
docker exec -it elasticsearch /bin/bash  
vi config/elasticsearch.yml  
```
  
加上两行： 

```
http.cors.enabled: true  
http.cors.allow-origin: "*"  

exit  
docker restart 容器id  
```

如 elasticsearch-head 无法正常显示，需要修改： 

找到vendor.js，修改文件里的两处：  

1、6886行  
contentType: "application/x-www-form-urlencoded  
改成  
contentType: “application/json;charset=UTF-8”  
  
2、7573行  
var inspectData = s.contentType === “application/x-www-form-urlencoded” &&  
改成  
var inspectData = s.contentType === “application/json;charset=UTF-8” &&  



