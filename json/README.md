
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

正确的代码应该是如下
```java

import java.util.HashMap;
import java.util.Map;

public class jsonTest {
    public static void main(String[] args){
        Map<Object, Object> map = new HashMap<Object, Object>(); 
        map.put("commodity", "apple");
        map.put("1", "hello world!");
        map.put("sex", "male");
        map.put("name", "seliencepuppet");
        JSONObject json = new JSONObject();
	json = JSONObject.fromObject(map);
	System.out.println(json);
    }
}
```

再次运行就能够将map集合转化成为json数据格式了
```json
{"commodity":"apple","1":"hello world!","sex":"male","name":"seliencepuppet"}
```

是不是和上面的数据一模一样


## 将list集合转换成为json数据
```java
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Test04 {
    public static void main(String[] args) {
    	List<Object> list = new ArrayList<Object>();
    	list.add("123");
    	list.add(true);
   	list.add("hello world!");
    	list.add("go");
    	System.out.println("list value is: " + list);
    	JSONArray json = new JSONArray();
    	json = JSONArray.fromObject(list);
        System.out.println("to transfer json value is: " + json);
    }
}
```

再次运行就能够将list集合转化成为json数据格式了
```result
list value is: [123, true, hello world!, go]
to transfer json value is: ["123",true,"hello world!","go"]
```

## 使用list集合和map集合创建一个多条数据的json数组
```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

public class Test05 {
    public static void main(String[] args) {
	Map<Object, Object> map01 = new HashMap<Object, Object>();		
	Map<Object, Object> map02 = new HashMap<Object, Object>();
	Map<Object, Object> map03 = new HashMap<Object, Object>();
	Map<Object, Object> map04 = new HashMap<Object, Object>();

	map01.put("aaa", 111);
	map02.put("bbb", 222);
	map03.put("ccc", 333);
	map04.put("ddd", 444);
		
	List<Map> list = new ArrayList<Map>();
	list.add(map01);
	list.add(map02);
	list.add(map03);
	list.add(map04);

	List<JSONObject> jsonList = new ArrayList<>(); 
	for (Map map : list) {
	    jsonList.add(JSONObject.fromObject(map));
	}
	System.out.println(jsonList);
    }
}
```
