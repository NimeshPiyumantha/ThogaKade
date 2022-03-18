package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Customer;
import util.CrudUtil;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ALoadAllCustomerFromController {
    public AnchorPane LoadAllContext;
    public TableView<Customer> tblCustomer;
    public TableColumn ColId;
    public TableColumn ColName;
    public TableColumn ColAddress;
    public TableColumn ColSalary;

    public void initialize() {
        ColId.setCellValueFactory(new PropertyValueFactory("id"));
        ColName.setCellValueFactory(new PropertyValueFactory("name"));
        ColAddress.setCellValueFactory(new PropertyValueFactory("address"));
        ColSalary.setCellValueFactory(new PropertyValueFactory("salary"));

        try {
            loadAllCustomers();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadAllCustomers() throws ClassNotFoundException, SQLException {
        ResultSet result = CrudUtil.execute("SELECT * FROM Customer");
        ObservableList<Customer> obList = FXCollections.observableArrayList();

        while (result.next()) {
            obList.add(
                    new Customer(
//                            result.getString("id"),
//                            result.getString("name"),
//                            result.getString("address"),
//                            result.getDouble("salary")

                            result.getString(1),
                            result.getString(2),
                            result.getString(3),
                            result.getDouble(4)
                    )
            );
        }
        tblCustomer.setItems(obList);
    }

    public void HomeOnAction(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) LoadAllContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../views/DashBoardFrom.fxml"))));
    }
}
