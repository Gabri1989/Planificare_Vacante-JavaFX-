module com.gabriel.aplicatiebd {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.gabriel.aplicatiebd to javafx.fxml;
    exports com.gabriel.aplicatiebd;
}