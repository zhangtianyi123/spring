# Spring功能学习，测试，使用

# scope与spring并发请求

- scope介绍

scope描述对象在spring容器（IOC容器）中的生命周期，也可以理解为对象在spring容器中的创建方式。
1. **singleton**  此取值时表明容器中创建时只存在一个实例，所有引用此bean都是单一实例。controller,service,dao均默认单例
2. **prototype** 原型模式，会每次都重新生成一个新的对象给请求方（线程）
3. request 为每个HTTP请求创建一个全新的RequestPrecessor对象，当请求结束后，该对象的生命周期即告结束，如同java web中request的生命周期，可以看做prototype的一种特例
4. 如果java web中session的生命周期
5. global session 

- 经典的竞态条件，controller层测试并发的i++

基于默认spring为每个请求开一个线程，且controller是单例的，那么多个请求循环同时发到如下REST接口：
```
@RestController
public class SingleController {

	private int count = 0;
	
	@GetMapping("/test/single")
	public Integer send() throws InterruptedException{
		Thread.sleep(5000);
		count++;
		return count;
	}
}
```
[代码链接][1]

使用postman测试结果如下,证明了其单例和并发:

![image_1dj8c2doa40pks1fpblk15ff9.png-22.6kB][2]


- 使用原型scope：
```
@RestController
@Scope("prototype")
public class PrototypeController {

	private int count = 0;
	
	@GetMapping("/test/prototype")
	public Integer send() throws InterruptedException{
		Thread.sleep(5000);
		count++;
		return count;
	}
}
```

使用postman结果无论测试多少次，结果都是1,如果打印线程，也推断能每次打印不同的线程名。

- 测试单例并发下的竞态条件问题
对于内存堆变量有无数种手法解决其并发安全
对于数据库数据主要落实到数据库事务+数据库原子操作+乐观锁等机制
而对于缓存等中间件，redis单个操作原子，但是复合操作存在竞态条件，如下测试：

先后执行/getwait和/get 理论上只应该查询一次DB，但是由于存在竞态条件，所以查询两次
![image_1dj8f4map13nh1l7511h712ak7o016.png-69.2kB][3]

```
public String getGlobalDesc(String key) {
		if(StringUtils.isEmpty(key)) {
			return null;
		}
		
		String description = (String) cacheUtils.get(key);
		if(description != null) {
			return description;
		}
		
		description = getGlobalDescFromDB(key);
		cacheUtils.set(key, description);
		cacheUtils.expire(key, expireTime);
		
		return description;
	}
```
[代码链接][4]

高并发的版本
```
final ReadWriteLock rwLock = new ReentrantReadWriteLock();
	final Lock readLock = rwLock.readLock();
	final Lock writeLock = rwLock.writeLock();

	public String getGlobalDescSync(String key) {
		if (StringUtils.isEmpty(key)) {
			return null;
		}

		String description = null;
		readLock.lock();
		try {
			description = (String) CacheUtils.get(key);
		} finally {
			readLock.unlock();
		}

		if (description != null) {
			return description;
		}

		writeLock.lock();
		try {
			//高并发情况下为了节省DBConnecition 在临界区内二次验证
			description = (String) CacheUtils.get(key);
			if(description == null) {
				description = getGlobalDescFromDB(key);
				CacheUtils.set(key, description);
				CacheUtils.expire(key, expireTime);
			}
		} finally {
			writeLock.unlock();
		}
		return description;
	}
```
[代码链接][4]




  [1]: https://github.com/zhangtianyi123/spring/blob/master/spring/src/main/java/zty/practise/spring/SpringApp.java
  [2]: http://static.zybuluo.com/zhangtianyi/yi0etpkmh3mtfiqpembzyq6z/image_1dj8c2doa40pks1fpblk15ff9.png
  [3]: http://static.zybuluo.com/zhangtianyi/2e19y2e6flatr7nogoka8z5u/image_1dj8f4map13nh1l7511h712ak7o016.png
  [4]: https://github.com/zhangtianyi123/spring/blob/master/spring/src/main/java/zty/practise/spring/test/scope/GlobalizationByRedisService.java