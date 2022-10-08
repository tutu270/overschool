package socketService;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import overschool.entity.socketEntity.Msg;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@ServerEndpoint(value = "/websocket/{nickname}")
@Component
public class WebSocketService {

    private static CopyOnWriteArrayList<WebSocketService> webSocketSet = new CopyOnWriteArrayList<WebSocketService>();
    private static Map<String, Session> map = new HashMap<String, Session>();
    private Session session;
    private String nickname;

    @OnOpen
    public void onOpen(Session session, @PathParam("nickname") String nickname) {
        this.session = session;
        this.nickname = nickname;
        map.put(session.getId(), session);
        webSocketSet.add(this);
        for (WebSocketService item : webSocketSet) {
            if (item.session.getId().equals(this.session.getId())) {
                this.session.getAsyncRemote().sendText(nickname + "上线了,（我的频道号是" + session.getId() + "）");
                continue;
            }
            item.session.getAsyncRemote().sendText(nickname + "上线了,（ta的频道号是" + session.getId() + "）");
            //发送消息.
        }

    }

    @OnClose
    public void onClose(Session session) {
        webSocketSet.remove(this);//从set中移除.
        map.remove(session.getId());
    }

    @OnMessage
    public void onMessage(String message, Session session, @PathParam("nickname") String nickname) {
        //message 不是普通的string ，而是我们定义的SocketMsg json字符串.
        try {
            Msg socketMsg = new ObjectMapper().readValue(message, Msg.class);

            //单聊.
            if (socketMsg.getType() == 1) {

                //单聊：需要找到发送者和接受者即可.
                socketMsg.setFromUser(session.getId());//发送者.
                //socketMsg.setToUser(toUser);//这个是由客户端进行设置.
                Session fromSession = map.get(socketMsg.getFromUser());
                Session toSession = map.get(socketMsg.getToUser());
                if (toSession != null) {
//					发送消息.
                    fromSession.getAsyncRemote().sendText(nickname + "：" + socketMsg.getMsg());
                    toSession.getAsyncRemote().sendText(nickname + "：" + socketMsg.getMsg());
                } else {
                    fromSession.getAsyncRemote().sendText("系统消息：对方不在线或者您输入的频道号有误");
                }
            } else {
                //群发给每个客户端.
                broadcast(socketMsg, nickname);
            }

        } catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }

    private void broadcast (Msg msg, String nickname){
            for (WebSocketService item : webSocketSet) {
                if (item.session.getId().equals(this.session.getId())) {
                    continue;
                }
                item.session.getAsyncRemote().sendText(nickname + "：" + msg.getMsg());
                //发送消息.
            }


    }

}
