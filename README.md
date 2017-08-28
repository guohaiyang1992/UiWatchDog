# UiWatchDog
## Ui卡顿监视工具，精确定位问题代码，让Ui告别卡顿。

---
功能：

 - 可设定打印Log的Tag
 - 可设定阻塞时长
 - 可详细且准确定位到问题代码，并且可以点击进行跳转对应问题代码行
 - 支持最小sdk版本为 8

 

---
使用方法:

 - 在你自己的Application内使用如下代码即可：

 ```java
 public class TestApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //设置tag  ,超时时间（ms） ,开启监听
       // tag,超时时间为可选项，如果不设置默认值分别为 UiWatchDog,1000(ms)
        UiWatchDog.getDefault().setTag("simon").setTimeOut(1000).watching();
    }
}
 ```

---

测试打印信息：

```java
simon:
|￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣
|  Ui Thread blocking more than 1000 ms in this postion: 
|       com.simon.uiwatchdog.MainActivity.onCreate(MainActivity.java:16)  
|_______________________________________________________________
```





---

引入方法：

 - 在你的Project的 build.gradle 按下面的操作配置仓库。
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

 - 然后在你对应的Modlule内的build.gradle内按下面的方式进行引入。

	

```
dependencies {
     compile 'com.github.guohaiyang1992:UiWatchDog:1.0'
	}
```
