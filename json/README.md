
现在json数据格式已经成为互联网上面传递数据最常用的格式之一了,这个案例将会描述如何将java的数据类型转换成为json数据

首先, java本身并没有内置转换json数据的方法,要想将数据转换成为json格式需要在网上下载相应的jar包并导入到项目当中才可以

java转json数据类型所需要的jar包文件如下
* commons-beanutils-1.8.0.jar
* commons-collections-3.2.1.jar
* commons-lang-2.6.jar
* commons-logging-1.1.1.jar
* ezmorph-1.0.6.jar
* json-lib-2.4-jdk15.jar

## 将map集合转换成为json数据

```java

import java.util.HashMap;
import java.util.Map;

public class jsonTest {
    public static void main(String[] args){
        Map<Object, Object> map = new HashMap<Object, Object>(); 
        map.put("commodity", "apple");
        map.put(1, "hello world!");
        map.put("sex", "male");
        map.put("name", "seliencepuppet");
        JSONObject json = new JSONObject();
	json = JSONObject.fromObject(map);
	System.out.println(json);
    }
}
```

运行以上代码,会报一个错误json数据类型的key不能为数字必须为字符串
```error
Exception in thread "main" net.sf.json.JSONException: java.lang.ClassCastException: JSON keys must be strings.
	at net.sf.json.JSONObject._fromMap(JSONObject.java:1185)
	at net.sf.json.JSONObject.fromObject(JSONObject.java:163)
	at net.sf.json.JSONObject.fromObject(JSONObject.java:134)
	at com.hitrader.test.Test03.main(Test03.java:17)
Caused by: java.lang.ClassCastException: JSON keys must be strings.
	at net.sf.json.JSONObject._fromMap(JSONObject.java:1145)
	... 3 more
```
