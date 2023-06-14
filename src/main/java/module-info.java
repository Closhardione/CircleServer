module com.example.powtorzenie_2_kolos {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.powtorzenie_2_kolos to javafx.fxml;
    exports com.example.powtorzenie_2_kolos;
}