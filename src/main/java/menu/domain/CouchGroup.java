package menu.domain;

import menu.utils.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;

public class CouchGroup {

    private final List<Couch> couches;

    private CouchGroup(List<Couch> couches) {
        validateGroup(couches);
        this.couches = couches;
    }

    public static CouchGroup from(List<Couch> couches) {
        return new CouchGroup(couches);
    }

    private void validateGroup(List<Couch> couches) {
        if (isDuplicateName(couches)) {
            throw new IllegalArgumentException(ErrorMessage.COUCH_NAME_DUPLICATE.getMessage());
        }
        if (isOutOfRange(couches)) {
            throw new IllegalArgumentException(ErrorMessage.COUCH_GROUP_OUT_OF_RANGE.getMessage());
        }
    }

    private boolean isOutOfRange(List<Couch> couches) {
        return (couches.size() < 2) || (couches.size() > 5);
    }

    private boolean isDuplicateName(List<Couch> couches) {
        Set<Couch> distinct = new HashSet<>(couches);
        return couches.size() != distinct.size();
    }

    public int size() {
        return couches.size();
    }

    public Couch get(int index) {
        return couches.get(index);
    }

    public String toMessage() {
        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        couches.stream()
                .map(Couch::toMessage)
                .forEach(joiner::add);
        return joiner.toString();
    }
}
