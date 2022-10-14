package overschool.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MsgUtil {
    int code;   //错误码
    String Message; //消息提示
    Map<String, Object> data = new HashMap<String, Object>();   //数据

    //无权访问
    public static MsgUtil denyAccess(String message) {
        MsgUtil result = new MsgUtil();
        result.setCode(300);
        result.setMessage(message);
        return result;
    }

    //操作成功
    public static MsgUtil success(String message) {
        MsgUtil result = new MsgUtil();
        result.setCode(200);
        result.setMessage(message);
        return result;
    }

    //客户端操作失败
    public static MsgUtil fail(String message) {
        MsgUtil result = new MsgUtil();
        result.setCode(400);
        result.setMessage(message);
        return result;
    }

    public MsgUtil add(String key, Object value) {
        this.data.put(key, value);
        return this;
    }


}
