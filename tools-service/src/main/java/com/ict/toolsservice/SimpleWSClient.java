package com.ict.toolsservice;

import com.ict.toolsmodel.AbstractMessage;
import com.ict.toolsmodel.IotEdgeMessage;
import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;

import java.net.URI;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

/**
 * @author liuwei
 * @Title: SimpleWSClient
 * @ProjectName tools
 * @Description: Jetty based websocket client
 * @date 2018/7/23下午6:30
 */
public class SimpleWSClient {

    private String wsURL ;
    private WebSocketClient client ;
    private SimpleEchoSocket socket ;

    public SimpleWSClient(IotEdgeMessage content, String wsURL) {
        this.wsURL = wsURL;
        client = new WebSocketClient();
        socket = new SimpleEchoSocket(content);
    }

    public void sendMessage(IotEdgeMessage content){

        try
        {
            client.start();

            URI wsEndPoint = new URI(wsURL);
            ClientUpgradeRequest request = new ClientUpgradeRequest();
            //request.setHeader( "Authorization", "Basic: " + Base64.getEncoder().encodeToString(content.getToken().getBytes()));
            client.connect(socket,wsEndPoint,request);
            System.out.printf("Connecting to : %s%n",wsURL);

            // wait for closed socket connection.
            socket.awaitClose(5,TimeUnit.SECONDS);
        }
        catch (Throwable t)
        {
            t.printStackTrace();
        }
        finally
        {
            try
            {
                client.stop();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

    }
}
