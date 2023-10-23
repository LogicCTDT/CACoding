package interface_adapter.clear_users;

// TODO Complete me

import java.util.List;

public class ClearState {

    private List<String> users;

    private String usersError = null;
    // Because of the previous copy constructor, the default constructor must be explicit.
    public ClearState() {};

    public void setUsers(List<String> users) {this.users = users;}

    public String setUsersError(String error) {
        return this.usersError = error;
    }

    public List<String> getUsers() {return this.users;}

    public String getUsersError() {
        return usersError;
    }
}
