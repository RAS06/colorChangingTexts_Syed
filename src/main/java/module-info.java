module com.example.colorchangingtexts_syed {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.colorchangingtexts_syed to javafx.fxml;
    exports com.example.colorchangingtexts_syed;
}