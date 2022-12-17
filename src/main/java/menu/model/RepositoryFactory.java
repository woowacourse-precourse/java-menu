package menu.model;

public class RepositoryFactory {
    private static final MemberRepository memberRepository = new MemberRepository();
    private static final MenuRepository menuRepository = new MenuRepository();

    public static MemberRepository getMemberRepository() {
        return memberRepository;
    }

    public static MenuRepository getMenuRepository() {
        return menuRepository;
    }
}
