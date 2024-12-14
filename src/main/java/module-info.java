module com.atomic_libary_tester {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.atomic_libary_tester to javafx.fxml;
    exports com.atomic_libary_tester;
}
