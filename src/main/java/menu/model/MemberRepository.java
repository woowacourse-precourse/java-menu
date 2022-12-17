package menu.model;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
    private final List<Member> members = new ArrayList<>();

    public void addMembers(List<Member> memberData) {
        members.addAll(memberData);
    }

    public List<Member> getAll() {
        return members;
    }
}
