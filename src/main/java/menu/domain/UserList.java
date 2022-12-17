package menu.domain;

import java.util.List;

public class UserList {

    private final List<Remark> userList;

    private UserList(List<Remark> userList) {
        this.userList = userList;
    }

    public static UserList from(List<Remark> userList) {
        return new UserList(userList);
    }

    public List<Remark> getUserList() {
        return userList;
    }


    @Override
    public String toString() {
        return userList.toString();
    }
}
