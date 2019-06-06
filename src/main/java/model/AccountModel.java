package model;

import entity.Account;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AccountModel {

    // Tìm theo account và password. Ps: không bao giờ được viết như thế này khi làm thật.
    public Account findByAccountAndPassword(String username, String password) {
        try {
            String sqlCommand = "select * from accounts where username = ? and password = ?";
            PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement(sqlCommand);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String rsAccount = resultSet.getString(1);
                String rsPassword = resultSet.getString(2);
                String rsConfirmPassword = resultSet.getString(3);
                String rsEmail = resultSet.getString(4);
                String rsPhone = resultSet.getString(5);
                String rsAddress = resultSet.getString(6);
                int rsBalance = resultSet.getInt(7);
//                int rsStatus = resultSet.getInt(4);
                Account existAccount = new Account();
                existAccount.setUsername(rsAccount);
                existAccount.setPassword(rsPassword);
                existAccount.setConfirmPassword(rsConfirmPassword);
                existAccount.setEmail(rsEmail);
                existAccount.setPhone(rsPhone);
                existAccount.setAddress(rsAddress);
                existAccount.setBalance(rsBalance);
//                existAccount.setStatus(rsStatus);
                return existAccount;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean saveUser(Account account) {
//        try {
//            String sqlCommand = "insert into accounts (account, password, balance, status) values (?,?,?,?)";
//            PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement(sqlCommand);
//            preparedStatement.setString(1, account.getUsername());
//            preparedStatement.setString(2, account.getPassword());
//            preparedStatement.setInt(3, account.getBalance());
//            preparedStatement.setInt(4, account.getStatus());
//            preparedStatement.execute();
//            return true;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return false;
        try {
            String sqlCommand = "insert into accounts (username, password, confirmPassword, email, phone, address, balance) values (?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement(sqlCommand);
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getPassword());
            preparedStatement.setString(3, account.getConfirmPassword());
            preparedStatement.setString(4, account.getEmail());
            preparedStatement.setString(5, account.getPhone());
            preparedStatement.setString(6, account.getAddress());
            preparedStatement.setInt(7, account.getBalance());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}

