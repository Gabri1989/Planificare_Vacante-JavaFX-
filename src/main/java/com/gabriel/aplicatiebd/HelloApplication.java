package com.gabriel.aplicatiebd;
import java.sql.Date;
import javafx.application.Application;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;


import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class HelloApplication extends Application {
    TextArea txtZona=new TextArea();
    Button countCountryButton = new Button("Incidenta tari");
    Button btCAUTA=new Button("CAUTA");
    Button countCityButton = new Button("Incidenta orase");
    Label lbTelefonTitlul=new Label("Suport IT:0741.789.123");
    Label lbContact=new Label("CONTACT: agentia365@suport.it");
    Label program=new Label("PROGRAM: L-V (10:00->18:00)");
    Label lbCountData=new Label("Select Tabel");
    Button bazaClienti=new Button("CLIENTI");
    Button countData=new Button("Afisare numar");
    Button bazaCazari=new Button("CAZARI");
    Button bazaRezervari=new Button("REZERVARI");
    Label lbChoiceBox=new Label("CLIENTI:");
    private List<TextField> textFields;
    Button updateButtonClienti = new Button("Update");
    Button updateButtonCazari = new Button("Update");
    Button updateButtonRezervari = new Button("Update");

    Button deleteButtonClienti = new Button("Delete");
    Button deleteButtonCazari = new Button("Delete");
    Button deleteButtonRezervari = new Button("Delete");

    ListView<String> listView = new ListView<>();
    Button btAfisareClienti=new Button("Afisare Clienti");
    Button btAfisareCazari=new Button("Afisare Cazari");
    Button btAfisareRezervari=new Button("Afisare Rezervari");
    private TableView<ObservableList<String>> tableView;
    private ObservableList<ObservableList<String>> data;

    TextField searchField = new TextField();
    Button searchCazari=new Button("Cauta");
    TextField searchCazariText=new TextField();
    Button searchButton = new Button("Cauta");
    ChoiceBox<String> columnChoiceBox = new ChoiceBox<>();
    ChoiceBox<String> columnChoiceCount = new ChoiceBox<>();
    ChoiceBox<String> columnChoiceBoxCazari = new ChoiceBox<>();
    Label lbCautaCazari=new Label("CAZARI:");

    private BorderPane border=new BorderPane();
    Label lbTitlu=new Label("AGENTIE DE TURISM");
    Label lbClient=new Label("Inregistrare clienti");
    Label lbNume=new Label("NUME");
    Label lbPren=new Label("PRENUME");
    Label lbbirth=new Label("Inregistrare");
    Label lbAdresa=new Label("ADRESA");
    Label lbTelefon=new Label("TELEFON");
    Label lbOras=new Label("ORAS");
    Button btAddClient = new Button("Adaugare Client");
    TextField txtAddPrenume=new TextField();
    TextField txtAddNume=new TextField();
    TextField txtAddAdresa=new TextField();
    TextField txtAddTelefon=new TextField();
    TextField txtAddbirthday=new TextField();
    private DatePicker checkInDatePicker1;
    private DatePicker checkOutDatePicker1;
    TextField txtAddOras=new TextField();
    Label addCazare=new Label("Inregistrari Cazari");
    Button btAddCazare=new Button("Adauga cazare");
    Label lbDenumire=new Label("DENUMIRE");
    Label lbHotelAdresa=new Label("ADRESA");
    Label lbOrasCazare=new Label("ORAS");
    Label lbTaraCazare=new Label("TARA");
    Label lbTransport=new Label("TRANSPORT");
    Label lbCost=new Label("COST");
    TextField txtHotelNume=new TextField();
    TextField txtHotelAdresa=new TextField();
    TextField txtHotelOras=new TextField();
    TextField txtHotelTara=new TextField();
    TextField txtHotelTransport=new TextField();
    TextField txtHotelCost=new TextField();

    TextField txtidClient=new TextField();
    TextField txtIdCazare=new TextField();
    DatePicker checkInDatePicker = new DatePicker();
    DatePicker checkOutDatePicker = new DatePicker();
    TextField txtPret=new TextField();
    Label lbRezervari=new Label("Rezervari");

    Button btRezervare=new Button("Adauga rezervare");
    Label lbIdClient=new Label("ID-CLIENT");
    Label lbIdCazare=new Label("ID-CLIENT");
    Label lbIntrare=new Label("CHECK-IN");
    Label lbIesire=new Label("CHECK-OUT");
    Label lbCostTotal=new Label("PRET TOTAL");
    Button showClientsButtonInterval = new Button("Afisare Clienti Interval");

    public HelloApplication() throws SQLException {
    }

    private VBox rightTop(){
        HBox nume=new HBox(lbDenumire,txtHotelNume);
        lbDenumire.setFont(new Font(15));
        nume.setSpacing(15);
        nume.setAlignment(Pos.BASELINE_RIGHT);
        HBox adresa=new HBox(lbHotelAdresa,txtHotelAdresa);
        lbHotelAdresa.setFont(new Font(15));
        adresa.setSpacing(15);
        adresa.setAlignment(Pos.BASELINE_RIGHT);
        HBox oras=new HBox(lbOrasCazare,txtHotelOras);
        lbOrasCazare.setFont(new Font(15));
        oras.setSpacing(15);
        oras.setAlignment(Pos.BASELINE_RIGHT);
        HBox tara=new HBox(lbTaraCazare,txtHotelTara);
        lbTaraCazare.setFont(new Font(15));
        tara.setSpacing(15);
        tara.setAlignment(Pos.BASELINE_RIGHT);
        HBox transport=new HBox(lbTransport,txtHotelTransport);
        lbTransport.setFont(new Font(15));
        transport.setSpacing(15);
        transport.setAlignment(Pos.BASELINE_RIGHT);
        HBox cost=new HBox(lbCost,txtHotelCost);
        lbCost.setFont(new Font(15));
        cost.setSpacing(15);
        cost.setAlignment(Pos.BASELINE_RIGHT);
        addCazare.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");
        var vbox=new VBox(10,addCazare,nume,adresa,oras,tara,transport,cost,btAddCazare,btAfisareCazari,updateButtonCazari,deleteButtonCazari,countCountryButton) ;
        vbox.setAlignment(Pos.BASELINE_CENTER);
        vbox.setPadding(new Insets(10));

        return vbox;
    }
    private VBox centerUp(){
        HBox idClient=new HBox(10);
        idClient.getChildren().addAll(lbIdClient,txtidClient);
        lbIdClient.setFont(new Font(15));
        idClient.setSpacing(15);
        idClient.setAlignment(Pos.BASELINE_CENTER);
        HBox idCazare=new HBox(10);
        idCazare.getChildren().addAll(lbIdCazare,txtIdCazare);
        lbIdCazare.setFont(new Font(15));
        idCazare.setSpacing(15);
        idCazare.setAlignment(Pos.BASELINE_CENTER);
        HBox idIntrare=new HBox(10);
        idIntrare.getChildren().addAll(lbIntrare,checkInDatePicker);
        lbIntrare.setFont(new Font(15));
        idIntrare.setSpacing(15);
        idIntrare.setAlignment(Pos.BASELINE_CENTER);
        HBox idIesire=new HBox(10);
        idIesire.getChildren().addAll(lbIesire,checkOutDatePicker);
        lbIesire.setFont(new Font(15));
        idIesire.setSpacing(15);
        idIesire.setAlignment(Pos.BASELINE_CENTER);
        HBox pretul=new HBox(10);
        pretul.getChildren().addAll(lbCostTotal,txtPret);
        lbCostTotal.setFont(new Font(15));
        pretul.setSpacing(15);
        pretul.setAlignment(Pos.BASELINE_CENTER);
        lbRezervari.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");
        var vbox=new VBox(10,lbRezervari,idClient,idCazare,idIntrare,idIesire,pretul,btRezervare,btAfisareRezervari,updateButtonRezervari,deleteButtonRezervari);
        vbox.setAlignment(Pos.BASELINE_CENTER);
        vbox.setPadding(new Insets(10));

        return vbox;
    }

    private HBox  leftTop()
    {
        HBox name=new HBox(lbNume,txtAddNume);
        lbNume.setFont(new Font(15));
        name.setSpacing(15);
        name.setAlignment(Pos.BASELINE_RIGHT);
        HBox prenume=new HBox(lbPren,txtAddPrenume);
        lbPren.setFont(new Font(15));
        prenume.setSpacing(15);
        prenume.setAlignment(Pos.BASELINE_RIGHT);
        HBox bith=new HBox(lbbirth,txtAddbirthday);
        lbbirth.setFont(new Font(15));
        bith.setSpacing(15);
        bith.setAlignment(Pos.BASELINE_RIGHT);
        HBox adresa=new HBox(lbAdresa,txtAddAdresa);
        lbAdresa.setFont(new Font(15));
        adresa.setSpacing(15);
        adresa.setAlignment(Pos.BASELINE_RIGHT);
        HBox telefon=new HBox(lbTelefon,txtAddTelefon);
        lbTelefon.setFont(new Font(15));
        telefon.setSpacing(15);
        telefon.setAlignment(Pos.BASELINE_RIGHT);
        HBox oras=new HBox(lbOras,txtAddOras);
        lbOras.setFont(new Font(15));
        oras.setSpacing(15);
        oras.setAlignment(Pos.BASELINE_RIGHT);
        lbClient.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");
        checkInDatePicker1 = new DatePicker();
        checkOutDatePicker1 = new DatePicker();
        VBox vbclientiInterval = new VBox(10);
        vbclientiInterval.getChildren().addAll(checkInDatePicker1, checkOutDatePicker1, showClientsButtonInterval);
        vbclientiInterval.setAlignment(Pos.BOTTOM_CENTER);
        VBox afisareInterval1=new VBox(10,tableView,vbclientiInterval);
        var vbox=new VBox(10,lbClient,name,prenume,bith,adresa,telefon,oras,btAddClient,btAfisareClienti,updateButtonClienti,deleteButtonClienti,countCityButton);
        HBox hbox=new HBox(10,vbox,afisareInterval1);
        vbox.setAlignment(Pos.BASELINE_CENTER);
        vbox.setPadding(new Insets(10));
        return hbox;
    }

    private int calculateTotalPrice(int referenceNumber) {
        LocalDate checkInDate = checkInDatePicker.getValue();
        LocalDate checkOutDate = checkOutDatePicker.getValue();
         referenceNumber = Integer.parseInt(txtPret.getText());
        long daysBetween = ChronoUnit.DAYS.between(checkInDate, checkOutDate);
        int totalPrice = (int) (daysBetween * referenceNumber);
        return totalPrice;
    }
    private void cautaDateClienti(String column, String searchQuery) throws SQLException {
        String dbURL = "jdbc:oracle:thin:@localhost:1521:GABYDB";
        String username = "GABI_USER";
        String password = "Adrian1989$";
        Connection connection = DriverManager.getConnection(dbURL, username, password);
        String sqlQuery = "SELECT * FROM CLIENTI WHERE " + column + " LIKE '%" + searchQuery + "%'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);
        StringBuilder result = new StringBuilder();
        listView.getItems().clear();
        while (resultSet.next()) {
            StringBuilder rowInfo = new StringBuilder();
            String columnValue = "";
            if (column.equals("NUME_CLIENT")) {
                columnValue = resultSet.getString("NUME_CLIENT");
            } else if (column.equals("PRENUME_CLIENT")) {
                columnValue = resultSet.getString("PRENUME_CLIENT");
            } else if (column.equals("Oras")) {
                columnValue = resultSet.getString("ORAS");
            }
            rowInfo.append("Nume: ").append(resultSet.getString("NUME_CLIENT")).append("\n");
            rowInfo.append("Prenume: ").append(resultSet.getString("PRENUME_CLIENT")).append("\n");
            rowInfo.append("Oras: ").append(resultSet.getString("ORAS")).append("\n");

            listView.getItems().add(rowInfo.toString());
        }
        statement.close();
    }
    private void cautaDateCazari(String column, String searchQuery) throws SQLException {
        String dbURL = "jdbc:oracle:thin:@localhost:1521:GABYDB";
        String username = "GABI_USER";
        String password = "Adrian1989$";
        Connection connection = DriverManager.getConnection(dbURL, username, password);
        String sqlQuery = "SELECT * FROM CAZARI WHERE " + column + " LIKE '%" + searchQuery + "%'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);
        StringBuilder result = new StringBuilder();
        listView.getItems().clear();
        while (resultSet.next()) {
            StringBuilder rowInfo = new StringBuilder();
            String columnValue = "";
            if (column.equals("NUME_CLIENT")) {
                columnValue = resultSet.getString("NUME_HOTEL");
            } else if (column.equals("PRENUME_CLIENT")) {
                columnValue = resultSet.getString("TARA_CAZARE");
            } else if (column.equals("Oras")) {
                columnValue = resultSet.getString("ORAS_CAZARE");
            }
            rowInfo.append("Nume: ").append(resultSet.getString("NUME_HOTEL")).append("\n");
            rowInfo.append("Tara: ").append(resultSet.getString("TARA_CAZARE")).append("\n");
            rowInfo.append("Oras: ").append(resultSet.getString("ORAS_CAZARE")).append("\n");
            listView.getItems().add(rowInfo.toString());

        }
        statement.close();
    }

    private void clearTextFields() {
        for (TextField textField : textFields) {
            textField.clear();
        }
    }
    private void administrareStergeButon(ObservableList<String> selectedRow, String tableName, String idColumnName) {
        String dbURL = "jdbc:oracle:thin:@localhost:1521:GABYDB";
        String username = "GABI_USER";
        String password = "Adrian1989$";

        if (selectedRow != null) {
            Alert confirmationDialog = new Alert(Alert.AlertType.CONFIRMATION);
            confirmationDialog.setTitle("CONFIRMARE");
            confirmationDialog.setHeaderText("STERGE " + tableName);
            confirmationDialog.setContentText("ESTI SIGUR CA VREI SA STERGI INREGISTRAREA DIN " + tableName + "?");

            Optional<ButtonType> result = confirmationDialog.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                try {
                    Connection connection = DriverManager.getConnection(dbURL, username, password);
                    PreparedStatement statement = connection.prepareStatement(
                            "DELETE FROM " + tableName + " WHERE " + idColumnName + " = ?");

                    statement.setInt(1, Integer.parseInt(selectedRow.get(0)));

                    statement.executeUpdate();
                    statement.close();

                    tableView.getItems().remove(selectedRow);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private void arataClientiInterval() {
        LocalDate checkInDate = checkInDatePicker1.getValue();
        LocalDate checkOutDate = checkOutDatePicker1.getValue();
        String dbURL = "jdbc:oracle:thin:@localhost:1521:GABYDB";
        String username = "GABI_USER";
        String password = "Adrian1989$";
        if (checkInDate != null && checkOutDate != null) {
            Date sqlCheckInDate = Date.valueOf(checkInDate);
            Date sqlCheckOutDate = Date.valueOf(checkOutDate);
            try (Connection connection = DriverManager.getConnection(dbURL, username, password);
                 PreparedStatement stmt = connection.prepareStatement("SELECT * FROM CLIENTI WHERE DATA_REGISTER BETWEEN ? AND ?")) {

                stmt.setDate(1, sqlCheckInDate);
                stmt.setDate(2, sqlCheckOutDate);

                ResultSet rs = stmt.executeQuery();
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();
                ObservableList<String> columns = FXCollections.observableArrayList();
                for (int i = 1; i <= columnCount; i++) {
                    columns.add(metaData.getColumnName(i));
                }
                tableView.getColumns().clear();
                ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();
                while (rs.next()) {
                    ObservableList<String> row = FXCollections.observableArrayList();
                    for (int i = 1; i <= columnCount; i++) {
                        row.add(rs.getString(i));
                    }
                    data.add(row);
                }
                tableView.setItems(data);

                for (int i = 0; i < columnCount; i++) {
                    final int columnIndex = i;
                    TableColumn<ObservableList<String>, String> column = new TableColumn<>(columns.get(i));
                    column.setCellValueFactory(cellData -> {
                        ObservableList<String> row = cellData.getValue();
                        if (row != null && row.size() > columnIndex) {
                            return new SimpleStringProperty(row.get(columnIndex));
                        } else {
                            return new SimpleStringProperty("");
                        }
                    });
                    tableView.getColumns().add(column);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void start(Stage stage) throws IOException, SQLException {
        //DatabaseManager dbM=new DatabaseManager();
        String dbURL = "jdbc:oracle:thin:@localhost:1521:GABYDB";
        String username = "GABI_USER";
        String password = "Adrian1989$";
        Connection connection = DriverManager.getConnection(dbURL, username, password);
        bazaClienti.setFont(new Font(20));
        bazaCazari.setFont(new Font(20));
        bazaRezervari.setFont(new Font(20));
        btCAUTA.setFont(new Font(20));
        searchField.setMaxWidth(70);
        lbChoiceBox.setFont(new Font(15));
        HBox choiceBox=new HBox(5,searchField,searchButton);
        VBox stanga=new VBox(5,lbChoiceBox,columnChoiceBox,choiceBox);
        stanga.setPadding(new Insets(10));
        stanga.setAlignment(Pos.CENTER);
        lbCautaCazari.setFont(new Font(15));
        VBox cautaCazari=new VBox(5,lbCautaCazari,columnChoiceBoxCazari,searchCazariText,searchCazari);
        lbTelefonTitlul.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: black;");
        lbContact.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: black;");
        program.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: black;");
        HBox hBoxtit=new HBox(20,lbTelefonTitlul,lbContact,program);
        hBoxtit.setPadding(new Insets(20));
        hBoxtit.setSpacing(20);


        showClientsButtonInterval.setOnAction(e -> arataClientiInterval());
        VBox vbSec=new VBox(10,stanga,listView);
        vbSec.setPadding(new Insets(10));
        VBox stangaButoane=new VBox(10,bazaClienti,bazaCazari,bazaRezervari,btCAUTA);
        stangaButoane.setAlignment(Pos.TOP_LEFT);
        textFields = new ArrayList<>();
        textFields.add(txtAddNume);
        textFields.add(txtAddPrenume);
        textFields.add(txtAddAdresa);
        textFields.add(txtAddbirthday);
        textFields.add(txtAddOras);
        textFields.add(txtAddTelefon);
        txtZona.setMaxWidth(150);
        txtZona.setMaxHeight(100);
        listView.setMaxHeight(300);
        listView.setMaxWidth(200);
        txtAddbirthday.setPromptText("year-month-day");
        tableView = new TableView<>();
        tableView.setMinWidth(700);
        tableView.setMaxHeight(300);
        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setHgrow(Priority.ALWAYS);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        Image backgroundImage = new Image("C:/spring_proiecte/aplicatieBD/back.png");
        BackgroundImage background=new BackgroundImage(backgroundImage,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        lbTitlu.setStyle("-fx-font-size: 26px; -fx-font-weight: bold; -fx-text-fill: blue;");
        deleteButtonClienti.setOnAction(event -> {
            ObservableList<String> selectedRow = tableView.getSelectionModel().getSelectedItem();
            administrareStergeButon(selectedRow, "CLIENTI", "ID_CLIENT");
        });

        deleteButtonCazari.setOnAction(event -> {
            ObservableList<String> selectedRow = tableView.getSelectionModel().getSelectedItem();
            administrareStergeButon(selectedRow, "CAZARI", "ID_CAZARE");
        });

        deleteButtonRezervari.setOnAction(event -> {
            ObservableList<String> selectedRow = tableView.getSelectionModel().getSelectedItem();
            administrareStergeButon(selectedRow, "REZERVARI", "ID_REZERVARE");
        });
        StackPane titlePane = new StackPane(lbTitlu);
        titlePane.setMinHeight(100);
        StackPane.setAlignment(lbTitlu, Pos.TOP_CENTER);
        HBox cautari=new HBox(10,vbSec,cautaCazari);
        VBox cautariC=new VBox(10,cautari,listView);
        cautariC.setAlignment(Pos.CENTER);

        bazaClienti.setOnAction(actionEvent -> {
            leftTop().setPadding(new Insets(10));
           border.setCenter(leftTop());
           border.setRight(tableView);

        });
        bazaCazari.setOnAction(actionEvent -> {
            rightTop().setPadding(new Insets(10));
            border.setCenter(rightTop());
            border.setRight(tableView);

        });
        bazaRezervari.setOnAction(actionEvent -> {
            centerUp().setPadding(new Insets(10));
            border.setCenter(centerUp());
            border.setRight(tableView);
        });
        btCAUTA.setOnAction(actionEvent -> {

            border.setCenter(cautariC);

        });

        updateButtonClienti.setOnAction(event -> {
            String updatedName = txtAddNume.getText();
            String updatedForname = txtAddPrenume.getText();
            String updateDataRegister=txtAddbirthday.getText();
            Date updateBirthday=Date.valueOf(updateDataRegister);
            String updatedAddress = txtAddAdresa.getText();
            String updatedPhone = txtAddTelefon.getText();
            String updateOras=txtAddOras.getText();
            ObservableList<String> selectedRow = tableView.getSelectionModel().getSelectedItem();
            if (selectedRow != null) {
                try {
                    PreparedStatement statement = connection.prepareStatement(
                            "UPDATE CLIENTI SET NUME_CLIENT = ?, PRENUME_CLIENT = ?, DATA_REGISTER = ?, ADRESA = ?, TELEFON  = ?,ORAS=? WHERE ID_CLIENT = ?");

                    statement.setString(1, updatedName);
                    statement.setString(2, updatedForname);
                    statement.setDate(3, updateBirthday);
                    statement.setString(4, updatedAddress);
                    statement.setString(5, updatedPhone);
                    statement.setString(6, updateOras);
                    statement.setInt(7, Integer.parseInt(selectedRow.get(0)));

                    statement.executeUpdate();
                    statement.close();
                    tableView.refresh();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        updateButtonRezervari.setOnAction(event -> {
            String updatedIdClient = txtidClient.getText();
            String updatedIdCazare = txtIdCazare.getText();
            LocalDate updatedCheckInDate = checkInDatePicker.getValue();
            LocalDate updatedCheckOutDate = checkOutDatePicker.getValue();
            Integer updatedPretRezervare = Integer.valueOf(txtPret.getText());

            ObservableList<String> selectedRow = tableView.getSelectionModel().getSelectedItem();


            if (selectedRow != null) {
                try {
                    PreparedStatement statement = connection.prepareStatement(
                            "UPDATE REZERVARI SET ID_CLIENT = ?, ID_CAZARE = ?, CHECK_IN_DATE = ?, CHECK_OUT_DATE = ?, PRET_REZERVARE = ? WHERE ID_REZERVARE = ?");

                    statement.setString(1, updatedIdClient);
                    statement.setString(2, updatedIdCazare);
                    statement.setDate(3, java.sql.Date.valueOf(updatedCheckInDate));
                    statement.setDate(4, java.sql.Date.valueOf(updatedCheckOutDate));
                    statement.setInt(5, updatedPretRezervare);
                    statement.setInt(6, Integer.parseInt(selectedRow.get(0)));

                    statement.executeUpdate();
                    statement.close();
                    tableView.refresh();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        updateButtonCazari.setOnAction(event -> {
            String updatedNumeHotel = txtHotelNume.getText();
            String updatedAdresaHotel = txtHotelAdresa.getText();
            String updatedOrasCazare = txtHotelOras.getText();
            String updatedTaraCazare = txtHotelTara.getText();
            String updatedNumeTransport = txtHotelTransport.getText();
            String updatedCostSejur = txtHotelCost.getText();

            ObservableList<String> selectedRow = tableView.getSelectionModel().getSelectedItem();

            if (selectedRow != null) {
                try {
                    PreparedStatement statement = connection.prepareStatement(
                            "UPDATE CAZARI SET NUME_HOTEL = ?, ADRESA_HOTEL = ?, ORAS_CAZARE = ?, TARA_CAZARE = ?, NUME_TRANSPORT = ?, COST_SEJUR = ? WHERE ID_CAZARE = ?");

                    statement.setString(1, updatedNumeHotel);
                    statement.setString(2, updatedAdresaHotel);
                    statement.setString(3, updatedOrasCazare);
                    statement.setString(4, updatedTaraCazare);
                    statement.setString(5, updatedNumeTransport);
                    statement.setString(6, updatedCostSejur);
                    statement.setInt(7, Integer.parseInt(selectedRow.get(0)));

                    statement.executeUpdate();
                    statement.close();
                    tableView.refresh();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        btAddCazare.setOnAction(actionEvent -> {
            try{
            String numeHotel=txtHotelNume.getText();
            String adresaHotel= txtHotelAdresa.getText();
            String orasCazare=txtHotelOras.getText();
            String taraCazare=txtHotelTara.getText();
            String numeTrans=txtHotelTransport.getText();
            String costSejur=txtHotelCost.getText();
                if (numeHotel.isEmpty() || adresaHotel.isEmpty() || orasCazare.isEmpty() || taraCazare.isEmpty() || numeTrans.isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText(" CAMP NULL EXISTENT ");
                    alert.showAndWait();
                    return;
                }
            String sql_hotel = "INSERT INTO CAZARI(ID_CAZARE,NUME_HOTEL,ADRESA_HOTEL,ORAS_CAZARE,TARA_CAZARE,NUME_TRANSPORT,COST_SEJUR)"
                    + "VALUES(CAZARI_S.nextval,?,?,?,?,?,?)";
            PreparedStatement statement2 = connection.prepareStatement(sql_hotel);
            statement2.setString(1,numeHotel);
            statement2.setString(2,adresaHotel);
            statement2.setString(3,orasCazare);
            statement2.setString(4,taraCazare);
            statement2.setString(5,numeTrans);
            statement2.setString(6,costSejur);
            statement2.executeUpdate();
            statement2.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        btAddClient.setOnAction(actionEvent -> {
            try {
                String nume = txtAddNume.getText();
                String prenume = txtAddPrenume.getText();
                String register = txtAddbirthday.getText();
                String adresa = txtAddAdresa.getText();
                String telefon = txtAddTelefon.getText();
                String oras = txtAddOras.getText();

                if (nume.isEmpty() || prenume.isEmpty() || register.isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText(" CAMP NULL SAU INVALID ");
                    alert.showAndWait();
                    return;
                }

                Date birthday = Date.valueOf(register);
                String sql = "INSERT INTO CLIENTI(ID_CLIENT,NUME_CLIENT,PRENUME_CLIENT,DATA_REGISTER,ADRESA,TELEFON,ORAS)"
                        + "VALUES(CLIENTI_S.nextval,?,?,?,?,?,?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, nume);
                statement.setString(2, prenume);
                statement.setDate(3, birthday);
                statement.setString(4, adresa);
                statement.setString(5, telefon);
                statement.setString(6, oras);
                statement.executeUpdate();
                statement.close();
                clearTextFields();
                txtZona.appendText("CLIENT ADAUGATA CU SUCCES");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        btRezervare.setOnAction(actionEvent -> {
            try{
                Integer idClient= Integer.valueOf(txtidClient.getText());
                Integer idCazare= Integer.valueOf(txtIdCazare.getText());
                String checkInDate = checkInDatePicker.getValue().toString();
                Date chIN=Date.valueOf(checkInDate);
                String checkOutDate = checkOutDatePicker.getValue().toString();
                Date chOUT=Date.valueOf(checkOutDate);

                Integer costTotal= calculateTotalPrice(Integer.parseInt(txtPret.getText()));
                if (idClient.toString().isEmpty() || idCazare.toString().isEmpty() || checkInDate.isEmpty() || checkOutDate.isEmpty()) {

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("   CAMP NULL  ");
                    alert.showAndWait();
                    return;
                }

                String sql_rezervare = "INSERT INTO REZERVARI(ID_REZERVARE,ID_CLIENT,ID_CAZARE,CHECK_IN_DATE,CHECK_OUT_DATE,PRET_REZERVARE)"
                        + "VALUES(REZERVARI_S.nextval,?,?,?,?,?)";
                PreparedStatement statement = connection.prepareStatement(sql_rezervare);
                statement.setInt(1,idClient);
                statement.setInt(2,idCazare);
                statement.setDate(3,chIN);
                statement.setDate(4,chOUT);
                statement.setInt(5,costTotal);
                statement.executeUpdate();
                statement.close();

            }catch (SQLException e) {
                e.printStackTrace();
            }
            txtZona.appendText("REZERVAREA INREGISTRATA CU SUCCES");
        });
        columnChoiceBox.getItems().addAll("NUME_CLIENT", "PRENUME_CLIENT", "Oras");
        columnChoiceBoxCazari.getItems().addAll("NUME_HOTEL","TARA_CAZARE","ORAS_CAZARE");
        columnChoiceCount.getItems().addAll("CAZARI","CLIENTI","REZERVARI");
        columnChoiceCount.setPadding(new Insets(10));

        countData.setOnAction(actionEvent -> {
            String selectedTable = columnChoiceCount.getValue();
            int count = 0;
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM " + selectedTable);
                if (resultSet.next()) {
                    count = resultSet.getInt(1);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(selectedTable);
            alert.setContentText("NUMARUL TOTAL DE INREGISTRARI ESTE: "+count);
            alert.showAndWait();
            alert.close();
        });
        HBox countTabels=new HBox(5,lbCountData,columnChoiceCount,countData);
        countTabels.setAlignment(Pos.CENTER);
        countTabels.setPadding(new Insets(10));
        searchButton.setOnAction(e -> {
            try {
                cautaDateClienti(columnChoiceBox.getValue(), searchField.getText());

            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        });
        searchCazari.setOnAction(actionEvent -> {
            try {
                cautaDateCazari(columnChoiceBoxCazari.getValue(), searchCazariText.getText());

            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

        btAfisareClienti.setOnAction(actionEvent -> {
            data = FXCollections.observableArrayList();
            tableView.getColumns().clear();
            try (
                 Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery("SELECT * FROM CLIENTI")) {
                int columnCount = resultSet.getMetaData().getColumnCount();
                ObservableList<String> columnNames = FXCollections.observableArrayList();
                for (int i = 1; i <= columnCount; i++) {
                    columnNames.add(resultSet.getMetaData().getColumnName(i));
                }
                for (int i = 0; i < columnNames.size(); i++) {
                    final int columnIndex = i;
                    TableColumn<ObservableList<String>, String> column = new TableColumn<>(columnNames.get(i));
                    column.setCellValueFactory(cellData -> {
                        ObservableList<String> rowData = cellData.getValue();
                        if (rowData.size() > columnIndex) {
                            return new SimpleStringProperty(rowData.get(columnIndex));
                        } else {
                            return new SimpleStringProperty("");
                        }
                    });
                    tableView.getColumns().add(column);
                }
                while (resultSet.next()) {
                    ObservableList<String> rowData = FXCollections.observableArrayList();
                    for (int i = 1; i <= columnCount; i++) {
                        rowData.add(resultSet.getString(i));
                    }
                    data.add(rowData);
                }

                tableView.setItems(data);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        btAfisareCazari.setOnAction(actionEvent -> {
            data = FXCollections.observableArrayList();
            tableView.getColumns().clear();
            try (
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery("SELECT * FROM CAZARI")) {

                // Get column names
                int columnCount = resultSet.getMetaData().getColumnCount();
                ObservableList<String> columnNames = FXCollections.observableArrayList();
                for (int i = 1; i <= columnCount; i++) {
                    columnNames.add(resultSet.getMetaData().getColumnName(i));
                }

                for (int i = 0; i < columnNames.size(); i++) {
                    final int columnIndex = i;
                    TableColumn<ObservableList<String>, String> column = new TableColumn<>(columnNames.get(i));
                    column.setCellValueFactory(cellData -> {
                        ObservableList<String> rowData = cellData.getValue();
                        if (rowData.size() > columnIndex) {
                            return new SimpleStringProperty(rowData.get(columnIndex));
                        } else {
                            return new SimpleStringProperty("");
                        }
                    });
                    tableView.getColumns().add(column);
                }
                while (resultSet.next()) {
                    ObservableList<String> rowData = FXCollections.observableArrayList();
                    for (int i = 1; i <= columnCount; i++) {
                        rowData.add(resultSet.getString(i));
                    }
                    data.add(rowData);
                }

                tableView.setItems(data);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        btAfisareRezervari.setOnAction(actionEvent -> {
            data = FXCollections.observableArrayList();
            tableView.getColumns().clear();
            try (
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery("SELECT * FROM REZERVARI")) {
                int columnCount = resultSet.getMetaData().getColumnCount();
                ObservableList<String> columnNames = FXCollections.observableArrayList();
                for (int i = 1; i <= columnCount; i++) {
                    columnNames.add(resultSet.getMetaData().getColumnName(i));
                }
                for (int i = 0; i < columnNames.size(); i++) {
                    final int columnIndex = i;
                    TableColumn<ObservableList<String>, String> column = new TableColumn<>(columnNames.get(i));
                    column.setCellValueFactory(cellData -> {
                        ObservableList<String> rowData = cellData.getValue();
                        if (rowData.size() > columnIndex) {
                            return new SimpleStringProperty(rowData.get(columnIndex));
                        } else {
                            return new SimpleStringProperty("");
                        }
                    });
                    tableView.getColumns().add(column);
                }
                while (resultSet.next()) {
                    ObservableList<String> rowData = FXCollections.observableArrayList();
                    for (int i = 1; i <= columnCount; i++) {
                        rowData.add(resultSet.getString(i));
                    }
                    data.add(rowData);
                }

                tableView.setItems(data);

            } catch (SQLException e) {
                e.printStackTrace();
            }

        });
        countCountryButton.setOnAction(actionEvent -> {
            try {
                Statement statement = connection.createStatement();
                String query = "SELECT TARA_CAZARE, COUNT(*) AS count FROM CAZARI GROUP BY TARA_CAZARE ORDER BY count DESC";
                ResultSet resultSet = statement.executeQuery(query);
                if (resultSet.next()) {
                    String country = resultSet.getString("TARA_CAZARE");
                    int count = resultSet.getInt("count");
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("TARA: " + country + " ARE " + count + " APARITII");
                    alert.showAndWait();
                }
                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });


        countCityButton.setOnAction(actionEvent -> {
            try {
                Statement statement = connection.createStatement();

                String query = "SELECT ORAS, COUNT(ORAS) AS count FROM CLIENTI GROUP BY ORAS ORDER BY count DESC";
                ResultSet resultSet = statement.executeQuery(query);
                if (resultSet.next()) {
                    String city = resultSet.getString("ORAS");
                    int count = resultSet.getInt("count");
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("ORASUL: " + city + " ARE " + count + " APARITII");
                    alert.showAndWait();
                }
                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

        HBox down=new HBox(10,countTabels,hBoxtit);
        border.setBackground(new Background(background));
        border.setTop(titlePane);
        border.setLeft(stangaButoane);
        border.setBottom(down);
        Scene scena = new Scene(border, 1300, 800);

        stage.setTitle("Aplicatie Mocanu Gabriel!");
        stage.setScene(scena);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}

