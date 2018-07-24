package com.ict.toolsservice;

import com.google.gson.Gson;
import com.ict.toolsmodel.AbstractMessage;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.StatusCode;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author liuwei
 * @Title: SimpleEchoSocket
 * @ProjectName tools
 * @Description: Jetty also provides a Jetty WebSocket Client Library to write make talking to WebSocket servers easier.
 * @date 2018/7/23下午5:40
 */
@WebSocket(maxTextMessageSize = 64 * 1024)
public class SimpleEchoSocket {

    private static Logger logger = LoggerFactory.getLogger(SimpleEchoSocket.class);
    private final CountDownLatch closeLatch;

    private AbstractMessage content;

    private Session session;

    public SimpleEchoSocket(AbstractMessage content)
    {
        this.content = content;
        this.closeLatch = new CountDownLatch(1);
    }

    @OnWebSocketClose
    public void onClose(int statusCode, String reason)
    {
        logger.info("Connection closed: %d - %s%n",statusCode,reason);

        this.session = null;
    }

    @OnWebSocketConnect
    public void onConnect(Session session)
    {
        logger.info("Got connect: %s%n",session);
        this.session = session;
        String jsonStr = new Gson().toJson(content);
        logger.info("send message is: %s%n",jsonStr);
        try
        {
            Future<Void> fut;
            fut = session.getRemote().sendStringByFuture(jsonStr);
            fut.get(2,TimeUnit.SECONDS); // wait for send to complete.

            session.close(StatusCode.NORMAL,"I'm done");
        }
        catch (Throwable t)
        {
            t.printStackTrace();
        }
    }

    @OnWebSocketMessage
    public void onMessage(String msg)
    {
        logger.info("Got msg: %s%n",msg);
    }

    public boolean awaitClose(int duration, TimeUnit unit) throws InterruptedException
    {
        return this.closeLatch.await(duration,unit);
    }
}
