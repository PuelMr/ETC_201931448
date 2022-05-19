module org.calma.ETC {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.calma.ETC to javafx.fxml;
    exports org.calma.ETC;
}