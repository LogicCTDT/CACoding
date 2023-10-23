package interface_adapter.clear_users;

// TODO Complete me

import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInState;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.clear_users.ClearState;
import interface_adapter.clear_users.ClearViewModel;
import interface_adapter.signup.SignupViewModel;
import use_case.clear_users.ClearOutputBoundary;
import use_case.clear_users.ClearOutputData;
import view.SignupView;

public class ClearPresenter implements ClearOutputBoundary {
    private final ClearViewModel clearViewModel;

    private ViewManagerModel viewManagerModel;
    private SignupViewModel signupViewModel;

    public ClearPresenter(ViewManagerModel viewManagerModel,
                          ClearViewModel clearViewModel, SignupViewModel signupViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.clearViewModel = clearViewModel;
        this.signupViewModel = signupViewModel;
    }

    @Override
    public void prepareSuccessView(ClearOutputData response) {
        // On success, switch to the logged in view.

        ClearState clearState = clearViewModel.getState();
        clearState.setUsers(response.getUsers());
        this.clearViewModel.setState(clearState);
        this.clearViewModel.firePropertyChanged();

        this.signupViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        ClearState clearState = clearViewModel.getState();
        clearState.setUsersError(error);
        clearViewModel.firePropertyChanged();
    }
}
