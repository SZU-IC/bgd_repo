### REDIS ###
一、操作
1、key操作
 
    keys、exists、del、rename、move、type、expire、ttl、persist、scan


2、String型操作
 1.set
    
    set key value [ex seconds | px milliseconds] [NX | XX]
 2.setex | psetex (同上ex)
    
    set key value ex seconds
 3.setnx (同上nx)
    
    set key value nx

 4.getset key value
    
    将key的值设为value，并返回旧值

 5.mset/msetnx key value [key value]

 6.mget key [key]

 7.append key value

    127.0.0.1:6379> set s abc
    OK
    127.0.0.1:6379> append s defg
    (integer) 7
    127.0.0.1:6379> get s
    "abcdefg"

 8.incr/decr key
    
    将key存储的数值增一或减一，这个数值只能是整数，不能是小数。
    如果key不存在，先初始化为0，然后再执行增一或减一操作。

 9.incrbyfloat

 10.strlen key

 11.getrange key start end
    
    返回 key 中字符串值的子字符串，字符串的截取范围由 start 和 end 两个偏移量决定，包括 start 和 end 在内。

 12.setrange key offset value 
 
    用 value 参数替换给定 key 所储存的字符串值 str，从偏移量 offset 开始。

3、Hash型value操作
 1.hset key field value[field value]
    
    不存在，则创建，返回1
    存在相同的key和field，覆盖旧值，返回0
 
 2.hget key field(不存在返回nil)

 3.hmset key field1 value1 field2 value2...

 4.hmget key filed1 filed2...

 5.hgetall key

 6.hsetnx key filed value

 7.hdel key filed

 8.hexists key filed
    存在返回1，不存在返回0

 9.hincrby/hincrbyfloat key filed increment 

 10.hkeys/hvals key
    
    返回键中所有的域或值

 11.hlen key
 
    返回哈希表key中域的大小

 12.hstrlen key filed

    返回哈希表 key 中， 与给定域 field 相关联的值的字符串长度（string length）


3、List型操作
    
    List按照插入的顺序进行排序，底层实际是一个无头节点的双向链表，所以对列表头和列表尾的操作效率较高，对中间元素的操作效率较低。
 
 1.lpush / rpush key value

 2.llen key：链表长度

 3.lindex key index
 
    返回列表中小表为index的元素

 4.lset key index value
    
    将列表下标为index的设为value

 5.lrange key start end
    
    返回列表 key 中指定区间[start, stop]内的元素，即包含两个端点

 6.lpushx/rpushx key value
 
    将值 value 插入到列表 key 的表头/表尾，当且仅当 key 存在并且是一个列表
    如果不是列表就什么也不做，返回0

 7.LINSERT key BEFORE|AFTER pivot value

    将值 value 插入到列表 key 当中，位于元素 pivot 之前或之后,pivot不存在什么都不做。

 8.lpop/rpop key [count]   //  blpop/brpop：阻塞式弹出

    从左边/右边弹出几个元素

 9.rpoplpush source destination

    命令 RPOPLPUSH 在一个原子时间内，执行以下两个动作：
    将列表 source 中的最后一个元素(尾元素)弹出，并返回给客户端。
    将 source 弹出的元素插入到列表 destination ，作为 destination 列表的的头元素。如果 source 不存在，值 nil 被返回，并且不执行其他动作。
    如果 source 和 destination 相同，则列表中的表尾元素被移动到表头，并返回该元素，可以把这种特殊情况视作列 表的旋转(rotation)操作。

 10.lrem key count value

    根据参数 count 的值，移除列表中与参数 value 相等的元素。count 的值可以是以下几种：
    count > 0 : 从表头开始向表尾搜索，移除与 value 相等的元素，数量为 count 。
    count < 0 : 从表尾开始向表头搜索，移除与 value 相等的元素，数量为 count 的绝对值。
    count = 0 : 移除表中所有与 value 相等的值。
 
 11.ltrim key start stop

    对一个列表进行修剪(trim)，就是说，让列表只保留指定区间内的元素，不在指定区间之内的元素都将被删除


4、Set型value操作命令

    Set中的Value都是String类型，元素具有无序性与不可重复性。

 1.sadd key member [member...]
    
 2.smembers key 

    返回key中所有的成员

 3.scard key

    返回set集合的长度

 4.sismember key member

    判断 member 元素是否集合 key 的成员。

 5.SMOVE source destination member

    将member从source集合移到destination集合
    
 6.srem key member

 7.srandmember key [count]

    返回集合中的 count 个随机元素。count 默认值为 1

 8.spop key [count]

    移除并返回集合中的 count 个随机元素。count 必须为正数，且默认值为 1。

 9.SDIFF key [key …] 或 SDIFFSTORE destination key [key …]

    返回第一个集合与其它集合之间的差集。差集，difference。

 10.SINTER key [key …] 或 SINTERSTORE destination key [key …]

    返回多个集合间的交集。交集，intersection。

 11.SUNION key [key …] 或 SUNIONSTORE destination key [key …]

    返回多个集合间的并集。并集，union。
     
5、ZSet有序集合类型操作

    有序 Set 中的每一个元素都有一个分值 score，Redis 会根据 score 的值对集合进行由小到大的排序。

 1.ZADD key score member [[score member] [score member] …]

    将一个或多个 member 元素及其 score 值加入到有序集 key 中的适当位置。

 2.ZRANGE key start stop [WITHSCORES] 或 ZREVRANGE key start stop [WITHSCORES]

    返回有序集 key 中，指定区间内的成员。zrange 命令会按 score 值递增排序， zrevrange 命令会按score 递减排序。
    
 3.ZRANGEBYSCORE key min max [WITHSCORES] [LIMIT offset count] ZREVRANGEBYSCORE key max min [WITHSCORES] [LIMIT offset count]

    返回有序集 key 中，所有 score 值介于 min 和 max 之间(包括等于 min 或 max )的成员。

 4.zcard

    返回集合的长度

 5.ZCOUNT key min max

    返回有序集 key 中， score 值在 min 和 max 之间(默认包括 score 值等于 min或 max )的成员的数量。

 6.zscore key member

    返回有序集 key 中，成员 member 的 score 值。

 7.ZINCRBY key increment member

    为有序集 key 的成员 member 的 score 值加上增量 increment 。increment 值可以是整数值或双精度浮点数。

 8.ZRANK key member 或 ZREVRANK key member

    返回有序集 key 中成员 member 的排名。zrank 命令会按 score 值递增排序，zrevrank 命令会按 score 递减排序。
    score最小的排名为0

 9.ZREM key member [member …]

    移除有序集 key 中的一个或多个成员，不存在的成员将被忽略。

 
