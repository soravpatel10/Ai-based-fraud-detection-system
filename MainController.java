package ui;

import ai.ZScoreFraudDetector;
import dao.TransactionDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import service.DetectionService;

public class MainController {

    @FXML private Button runBtn;

    public void initialize(){
        runBtn.setOnAction(e -> {
            new DetectionService(new ZScoreFraudDetector(), new TransactionDAO()).start();
        });
    }
}
