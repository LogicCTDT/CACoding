package use_case.clear_users;

// TODO Complete me

import entity.User;

import java.util.Collection;
import java.util.List;

public interface ClearUserDataAccessInterface {

    boolean existsByName(String identifier);

    Collection<User> getAll();
}
