package use_case.clear_users;

// TODO Complete me

import java.util.List;

public class ClearOutputData {

    private final List<String> username;
    private boolean useCaseFailed;

    public ClearOutputData(List<String> username, boolean useCaseFailed) {
        this.username = username;
        this.useCaseFailed = useCaseFailed;
    }

    public List<String> getUsers() {
        return username;
    }
}
