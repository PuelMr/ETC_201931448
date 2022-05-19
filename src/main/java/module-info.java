module com.example.etc_201931448 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.etc_201931448 to javafx.fxml;
    exports com.example.etc_201931448;
}