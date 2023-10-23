package use_case.clear_users;

// TODO Complete me

import entity.User;
import use_case.clear_users.ClearInputData;
import use_case.clear_users.ClearOutputBoundary;
import use_case.clear_users.ClearOutputData;
import use_case.clear_users.ClearUserDataAccessInterface;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ClearInteractor implements ClearInputBoundary{

    final ClearUserDataAccessInterface userDataAccessObject;
    final ClearOutputBoundary ClearPresenter;

    public ClearInteractor(ClearUserDataAccessInterface userDataAccessInterface,
                           ClearOutputBoundary ClearOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.ClearPresenter = ClearOutputBoundary;
    }

    @Override
    public void execute() throws IOException {

        //Implement clear function. sucessful output should be all usernames
            Collection<User> users = userDataAccessObject.getAll();

            List<String> allUser = new ArrayList<>();

            for (User username : users) {
                allUser.add(username.getName());
            }
            File myObj = new File("users.csv");
            myObj.delete();
            File csvFile = new File("users.csv");
            csvFile.createNewFile();


            //DOwn here is the stuff that might need to change
            ClearOutputData clearOutputData = new ClearOutputData(allUser, false);
            ClearPresenter.prepareSuccessView(clearOutputData);

        }
    }

