package controller;

import entity.Account;
//import entity.RegisterAccount;
import model.AccountModel;
//import model.RegisterAccountModel;

public class RegisterController {
    private AccountModel registerAccountModel = new AccountModel();

    public void create(Account registerAccount) {
        registerAccountModel.saveUser(registerAccount);
    }
}
