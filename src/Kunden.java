import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Kunden extends Application{

    private ObservableList<Kunde> data;
    public int cKunde = 0;

    public static void main(String[] args) {
        ConManger.connect();
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("Kunden.fxml"));
        Scene scene = new Scene(root, 1158, 493);
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        primaryStage.setTitle("Kunden");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public boolean exist(String id){
        try {
            ResultSet rs = ConManger.connection.createStatement().executeQuery("Select COUNT(*) AS count from Kunden where KundenID="+IDtext.getText().trim()+" ;");
            int count =0;
            while(rs.next()){
                count = rs.getInt("count");
           }
            if(count > 0){
                return true;
            }else{
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        }


    }

    public void buildData(){
        data = FXCollections.observableArrayList();
        data.clear();
        try{
            String SQL = "Select * from Kunden Order By KundenID";
            ResultSet rs = ConManger.connection.createStatement().executeQuery(SQL);
            while(rs.next()){
                Kunde k = new Kunde();
                k.kundenid.set(rs.getInt("kundenid"));
                k.kundenName.set(rs.getString("name"));
                k.telefon.set(rs.getInt("telefon"));
                k.email.set(rs.getString("email"));
                k.adresse.set(rs.getString("adresse"));
                data.add(k);
            }
            tableview.setItems(data);
            if(data.size() > 0){
                cKunde = data.size()-1;
                showByIndex(cKunde);
                addBt.setDisable(true);
            }else{
                newR();
            }

        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }
    }




    void showByIndex(int index){
        numText.setText(String.valueOf(index+1));
        IDtext.setText(String.valueOf(data.get(index).getKundenid()));
        nameText.setText(data.get(index).getKundenName());
        telText.setText(String.valueOf(data.get(index).getTelefon()));
        emailText.setText(data.get(index).getEmail());
        adressText.setText(data.get(index).getAdresse());
        tableview.getSelectionModel().select(cKunde);
        addBt.setDisable(true);
        newBt.setDisable(false);
        editBt.setDisable(false);

    }




    @FXML
    void initialize(){
        assert tableview != null : "fx:id=\"tableview\" was not injected: check your FXML file 'UserMaster.fxml'.";
        kundenID.setCellValueFactory(
                new PropertyValueFactory<Kunde,Integer>("kundenid"));
        kundenName.setCellValueFactory(
                new PropertyValueFactory<Kunde,String>("kundenName"));
        tel.setCellValueFactory(
                new PropertyValueFactory<Kunde,Integer>("telefon"));
        email.setCellValueFactory(
                new PropertyValueFactory<Kunde,String>("email"));
        adress.setCellValueFactory(
                new PropertyValueFactory<Kunde,String>("adresse"));

        buildData();
    }







    @FXML
    private TableView<Kunde> tableview;

    @FXML
    private TableColumn<Kunde, Integer> kundenID;

    @FXML
    private TableColumn<Kunde, String> kundenName;

    @FXML
    private TableColumn<Kunde, Integer> tel;

    @FXML
    private TableColumn<Kunde, String> email;

    @FXML
    private TableColumn<Kunde, String> adress;

    @FXML
    private Button close;

    @FXML
    private ImageView firstBt;

    @FXML
    private ImageView pBt;

    @FXML
    private TextField numText;

    @FXML
    private ImageView nBt;

    @FXML
    private ImageView lastBt;

    @FXML
    private TextField IDtext;

    @FXML
    private Button addBt;

    @FXML
    private Button editBt;

    @FXML
    private Button newBt;

    @FXML
    private Button delBt;

    @FXML
    private TextField nameText;

    @FXML
    private TextField telText;

    @FXML
    private TextField emailText;

    @FXML
    private TextArea adressText;

    @FXML
    void add(ActionEvent event) {
        if(!nameText.getText().trim().isEmpty() && !IDtext.getText().trim().isEmpty() && isInteger(IDtext.getText().trim()) && isInteger(telText.getText().trim()) && !exist(IDtext.getText().trim())){
            try {
                Statement st = ConManger.connection.createStatement();
                String insertString = "INSERT INTO Kunden(KundenID, name, Telefon, EMail, adresse) VALUES (" + IDtext.getText().trim() + ",' "+nameText.getText().trim()+"',"+telText.getText().trim()+ ",' "+emailText.getText().trim()+"',' "+adressText.getText().trim()+"')";
                 st.execute(insertString);
            }catch(SQLException ex){
                System.out.println(ex);
            }
            buildData();
            cKunde = data.size()-1;
            showByIndex(cKunde);
        }
    }

    @FXML
    void del(ActionEvent event) {
        if(numText.getText().trim() != "*" && data.size() > 0){
            try {
                Statement st = ConManger.connection.createStatement();
                String delString = "DELETE FROM Kunden WHERE Kundenid = "+data.get(cKunde).getKundenid();
                 st.execute(delString);
            }catch(SQLException ex){
                System.out.println(ex);
            }
            if(data.size() > 0){
                buildData();
                cKunde = data.size()-1;
                showByIndex(cKunde);
            }else{
                newR();
            }

        }
    }

    @FXML
    void edit(ActionEvent event) {
        if(!nameText.getText().trim().isEmpty() && !IDtext.getText().trim().isEmpty() && isInteger(IDtext.getText().trim()) && isInteger(telText.getText().trim())){
            try {
                Statement st = ConManger.connection.createStatement();
                String updateString =  "UPDATE Kunden  SET  name  = '"+nameText.getText().trim()+"', Telefon = " +telText.getText().trim()+ ", EMail = '"+emailText.getText().trim()+"', adresse = '"+adressText.getText().trim()+"' WHERE KundenID = "+data.get(cKunde).getKundenid();
                st.execute(updateString);
            }catch(SQLException ex){
                System.out.println(ex);
            }
            buildData();
            cKunde = data.size()-1;
            showByIndex(cKunde);
        }
    }

    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    @FXML
    void exit(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void first(MouseEvent event) {
        cKunde = 0;
        showByIndex(cKunde);
    }

    @FXML
    void last(MouseEvent event) {
        cKunde = data.size()-1;
        showByIndex(cKunde);
    }

    @FXML
    void newUser(ActionEvent event) {
        newR();
    }

    @FXML
    void next(MouseEvent event) {
        if(cKunde != data.size()-1){
            cKunde++;
            showByIndex(cKunde);
        }
    }

    @FXML
    void pre(MouseEvent event) {
        if(cKunde != 0) {
            cKunde--;
            showByIndex(cKunde);
        }
    }

    @FXML
    void selectRow(MouseEvent event) {
        cKunde = tableview.getSelectionModel().getSelectedIndex();
        showByIndex(cKunde);
    }

    void newR (){
        numText.setText("*");
        IDtext.setText("");
        nameText.setText("");
        telText.setText("");
        emailText.setText("");
        adressText.setText("");
        addBt.setDisable(false);
        newBt.setDisable(true);
        editBt.setDisable(true);
    }

}
