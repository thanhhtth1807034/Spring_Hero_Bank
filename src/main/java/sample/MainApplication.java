package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import stage.*;


public class MainApplication extends Application {

    private String accountName;
    private int accountBalance;

    private VBox vBox;
    private HBox titleBox;
    private HBox btnBox;
    private GridPane gridPaneContent;

    private Label lblTitle;
    private Label lblAcount;
    private Label lblBalance;
    private Label lblAccountName;
    private Label lblBalanceValue;
    private Button btnWithdraw;
    private Button btnDeposit;

    private Scene scene;
    private Stage mainStage;
    private WithdrawStage withdrawStage;
    private DepositStage depositStage;
    private LoginStage loginStage;
    private RegisterStage registerStage;

    private MainApplication mainApplication;//luư địa chỉ bộ nhớ

    private static boolean isLoggedIn = false;
    private static boolean isRegistered = false;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.mainApplication = this;
        this.mainStage = primaryStage;


        initComponent();


        if (isLoggedIn) {
            // show stage.
            this.mainStage.show();
        } else {
            this.loginStage = new LoginStage(this);
            this.loginStage.show();
        }

        if (isRegistered) {
            this.loginStage.show();
        } else {
//            this.registerStage = new RegisterStage(this);
//            this.registerStage.show();
        }


    }

    private void initComponent() {
        this.vBox = new VBox();

        this.titleBox = new HBox();
        this.lblTitle = new Label("Spring Hero Bank");
        this.lblTitle.setFont(Font.font(18));
        this.lblTitle.setTextFill(Color.web("#ff0cb4"));
        this.titleBox.getChildren().add(lblTitle);
        this.titleBox.setAlignment(Pos.TOP_LEFT);
        this.titleBox.setSpacing(10);

        this.gridPaneContent = new GridPane();
        this.lblAcount = new Label("Account:");
        this.lblBalance = new Label("Balance:");
        this.lblAccountName = new Label(this.accountName);
        this.lblBalanceValue = new Label(String.valueOf(this.accountBalance));
        this.gridPaneContent.add(this.lblAcount, 0, 0);
        this.gridPaneContent.add(this.lblAccountName, 1, 0);
        this.gridPaneContent.add(this.lblBalance, 0, 1);
        this.gridPaneContent.add(this.lblBalanceValue, 1, 1);
        this.gridPaneContent.setAlignment(Pos.CENTER);
        this.gridPaneContent.setPadding(new Insets(10));
        this.gridPaneContent.setVgap(10);
        this.gridPaneContent.setHgap(10);

        this.btnBox = new HBox();
        this.btnWithdraw = new Button("Withdraw");
        this.btnDeposit = new Button("Deposit");
        this.btnBox.getChildren().addAll(this.btnWithdraw, this.btnDeposit);
        this.btnBox.setAlignment(Pos.CENTER);
        this.btnBox.setSpacing(10);

        this.vBox.getChildren().addAll(this.titleBox, this.gridPaneContent, this.btnBox);
        this.vBox.setAlignment(Pos.CENTER);
        this.vBox.setSpacing(30);
        this.vBox.setPadding(new Insets(10, 10, 10, 10));

        this.scene = new Scene(this.vBox, 300, 200);
        this.mainStage.setScene(this.scene);


        this.withdrawStage = new WithdrawStage(mainApplication);
        this.depositStage = new DepositStage(mainApplication);

        btnDeposit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                depositStage.showAndWait();
            }
        });

        btnWithdraw.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                withdrawStage.showAndWait();
            }
        });


    }

    public static void main(String[] args) {
        launch(args);
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    public VBox getvBox() {
        return vBox;
    }

    public void setvBox(VBox vBox) {
        this.vBox = vBox;
    }

    public HBox getTitleBox() {
        return titleBox;
    }

    public void setTitleBox(HBox titleBox) {
        this.titleBox = titleBox;
    }

    public HBox getBtnBox() {
        return btnBox;
    }

    public void setBtnBox(HBox btnBox) {
        this.btnBox = btnBox;
    }

    public GridPane getGridPaneContent() {
        return gridPaneContent;
    }

    public void setGridPaneContent(GridPane gridPaneContent) {
        this.gridPaneContent = gridPaneContent;
    }

    public Label getLblTitle() {
        return lblTitle;
    }

    public void setLblTitle(Label lblTitle) {
        this.lblTitle = lblTitle;
    }

    public Label getLblAcount() {
        return lblAcount;
    }

    public void setLblAcount(Label lblAcount) {
        this.lblAcount = lblAcount;
    }

    public Label getLblBalance() {
        return lblBalance;
    }

    public void setLblBalance(Label lblBalance) {
        this.lblBalance = lblBalance;
    }

    public Label getLblAccountName() {
        return lblAccountName;
    }

    public void setLblAccountName(Label lblAccountName) {
        this.lblAccountName = lblAccountName;
    }

    public Label getLblBalanceValue() {
        return lblBalanceValue;
    }

    public void setLblBalanceValue(Label lblBalanceValue) {
        this.lblBalanceValue = lblBalanceValue;
    }

    public Button getBtnWithdraw() {
        return btnWithdraw;
    }

    public void setBtnWithdraw(Button btnWithdraw) {
        this.btnWithdraw = btnWithdraw;
    }

    public Button getBtnDeposit() {
        return btnDeposit;
    }

    public void setBtnDeposit(Button btnDeposit) {
        this.btnDeposit = btnDeposit;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Stage getMainStage() {
        return mainStage;
    }

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }

    public MainApplication getMainApplication() {
        return mainApplication;
    }

    public void setMainApplication(MainApplication mainApplication) {
        this.mainApplication = mainApplication;
    }

    public WithdrawStage getWithdrawStage() {
        return withdrawStage;
    }

    public void setWithdrawStage(WithdrawStage withdrawStage) {
        this.withdrawStage = withdrawStage;
    }

    public DepositStage getDepositStage() {
        return depositStage;
    }

    public void setDepositStage(DepositStage depositStage) {
        this.depositStage = depositStage;
    }

    public LoginStage getLoginStage() {
        return loginStage;
    }

    public void setLoginStage(LoginStage loginStage) {
        this.loginStage = loginStage;
    }

    public static boolean isIsLoggedIn() {
        return isLoggedIn;
    }

    public static void setIsLoggedIn(boolean isLoggedIn) {
        MainApplication.isLoggedIn = isLoggedIn;
    }

    public RegisterStage getRegisterStage() {
        return registerStage;
    }

    public void setRegisterStage(RegisterStage registerStage) {
        this.registerStage = registerStage;
    }

    public static boolean isIsRegistered() {
        return isRegistered;
    }

    public static void setIsRegistered(boolean isRegistered) {
        MainApplication.isRegistered = isRegistered;
    }
}
