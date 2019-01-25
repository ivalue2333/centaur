package base.redis;

import redis.clients.jedis.JedisPubSub;

/**
 * Created by 13722 on 2017/11/2.
 */


/**
 *
 监听到订阅模式接受到消息时的回调 (onPMessage)
 监听到订阅频道接受到消息时的回调 (onMessage )
 订阅频道时的回调( onSubscribe )
 取消订阅频道时的回调( onUnsubscribe )
 订阅频道模式时的回调 ( onPSubscribe )
 取消订阅模式时的回调( onPUnsubscribe )

 */
public class RedisSubPubDemo extends JedisPubSub{

    @Override
    public void onMessage(String channel, String message) {
        System.out.println(channel + "," + message);
    }

    @Override
    public void onPMessage(String pattern, String channel, String message) {
        System.out.println(pattern + "," + channel + "," + message);

    }

    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        System.out.println("onSubscribe: channel[" + channel + "]," + "subscribedChannels[" + subscribedChannels + "]");
    }

    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {
        System.out.println(
                "onUnsubscribe: channel[" + channel + "], " + "subscribedChannels[" + subscribedChannels + "]");
    }

    @Override
    public void onPSubscribe(String pattern, int subscribedChannels) {
        System.out.println("onPSubscribe: pattern[" + pattern + "], " +
                "subscribedChannels[" + subscribedChannels + "]");
    }

    @Override
    public void onPUnsubscribe(String pattern, int subscribedChannels) {
        System.out.println("onPUnsubscribe: pattern[" + pattern + "]," +
                "subscribedChannels[" + subscribedChannels + "]");
    }

}
