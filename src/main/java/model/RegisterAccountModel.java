//package model;
//
//import entity.RegisterAccount;
//
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//public class RegisterAccountModel {
//    public boolean saveUser(RegisterAccount registerAccount){
//
//        try {
//            String sqlCommand = "insert into accounts (username, password, confirmPassword, email, phone, address, balance) values (?,?,?,?,?,?,?)";
//            PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement(sqlCommand);
//            preparedStatement.setString(1, registerAccount.getUsername());
//            preparedStatement.setString(2, registerAccount.getPassword());
//            preparedStatement.setString(3, registerAccount.getConfirmPassword());
//            preparedStatement.setString(4, registerAccount.getEmail());
//            preparedStatement.setString(5, registerAccount.getPhone());
//            preparedStatement.setString(6, registerAccount.getAddress());
//            preparedStatement.setInt(7, registerAccount.getBalance());
//            preparedStatement.execute();
//            return true;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//}
