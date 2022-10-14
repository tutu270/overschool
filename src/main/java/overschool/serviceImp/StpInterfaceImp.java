package overschool.serviceImp;

import cn.dev33.satoken.stp.StpInterface;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StpInterfaceImp implements StpInterface {
    /**
     * 返回一个账号所拥有的权限码集合
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        List<String> list = new ArrayList<String>();
        String userId = loginId.toString();
        if (userId.equals("1")) {
            list.add("user:*");
        } else if (userId.equals("2")) {
            list.add("user:info");
        }
        return list;
    }

    /**
     * 返回一个账号所拥有的角色标识集合 (权限与角色可分开校验)
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        List<String> list = new ArrayList<String>();
        if (loginId.equals("1")) {
            list.add("admin");
            list.add("super-admin");
        }
        return list;
    }
}


