module sio.code_secret {
    requires javafx.controls;
    requires javafx.fxml;


    opens sio.code_secret to javafx.fxml;
    exports sio.code_secret;
}