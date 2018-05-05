# Java

## 在linux当中为java配置环境变量


-------------------------------------------------------
<br>


```shell
[root@linux-node1 ~]# ls -l
total 177076
-rw-------. 1 root root      1589 Dec 28 07:50 anaconda-ks.cfg
-rw-r--r--  1 root root      1456 Dec 31 01:47 CentOS7.1-x86_644.cfg
drwxr-xr-x. 2 root root         6 Dec 28 08:34 Desktop
drwxr-xr-x. 2 root root         6 Dec 28 08:32 Documents
drwxr-xr-x. 2 root root         6 Dec 28 08:32 Downloads
-rw-r--r--. 1 root root      1637 Dec 29 02:25 initial-setup-ks.cfg
-rwxr--r--  1 root root 181310701 Mar 17 14:05 jdk-8u73-linux-x64.tar.gz
drwxr-xr-x. 2 root root         6 Dec 28 08:32 Music
drwxr-xr-x. 2 root root       194 Feb  9 01:44 Pictures
drwxr-xr-x. 2 root root         6 Dec 28 08:32 Public
drwxr-xr-x. 2 root root         6 Dec 28 08:32 Templates
drwxr-xr-x. 2 root root         6 Dec 28 08:32 Videos
[root@linux-node1 ~]# 
```

<br>

------------------------------------------------------------

#### 解压 jdk-8u73-linux-x64.tar.gz 到指定的目录

```shell
[root@linux-node1 ~]# tar -xf jdk-8u73-linux-x64.tar.gz -C /usr/local
[root@linux-node1 ~]# cd /usr/local/
[root@linux-node1 local]# ls
bin  etc  games  include  jdk1.8.0_73  lib  lib64  libexec  python34  sbin  share  src
[root@linux-node1 local]# 
[root@linux-node1 local]# mv jdk1.8.0_73/ jdk
[root@linux-node1 local]# cd jdk/
[root@linux-node1 jdk]# cd bin/
[root@linux-node1 bin]# ls
appletviewer  extcheck  jar        java   javadoc         javah  javapackager  javaws  jconsole  jdb    jhat   jjs   jmc      jps         jsadebugd  jstat   jvisualvm  native2ascii  pack200     rmic  rmiregistry  serialver   tnameserv  wsgen     xjc
ControlPanel  idlj      jarsigner  javac  javafxpackager  javap  java-rmi.cgi  jcmd    jcontrol  jdeps  jinfo  jmap  jmc.ini  jrunscript  jstack     jstatd  keytool    orbd          policytool  rmid  schemagen    servertool  unpack200  wsimport
[root@linux-node1 bin]# ./java -version
java version "1.8.0_73"
Java(TM) SE Runtime Environment (build 1.8.0_73-b02)
Java HotSpot(TM) 64-Bit Server VM (build 25.73-b02, mixed mode)
```

<br>
