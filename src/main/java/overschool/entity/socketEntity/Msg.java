package overschool.entity.socketEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Msg {
    private int type;//聊天类型，0：群聊；1：单聊;
    private String fromUser;//发送者.
    private String toUser;//接受者. session.getId();
    private String msg;//消息.
}
