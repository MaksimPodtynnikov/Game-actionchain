package sample;

import casino.ActionChain;
import casino.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public TextField name;
    public Button addMoney;
    public TextField money;
    @FXML
    ImageView view;
    ActionChain action=null;
    Player player1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        view.setImage(new Image("монетка.png"));
        view.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            if (player1!=null) {
                onStart();
                player1.pay(1);
                if (action == null) return;//если цепочка обработки отсутствует
                if (action.process()) init();//продолжить играть и проверить наличия монетки у игрока
                else action = null;//завершить игру, сделав обработку недоступной
                money.setText(player1.getNumber().toString());
            }
        });
    }

    public void createPlayer()
    {
        player1=new Player(name.getText(),10);
        money.setText(player1.getNumber().toString());
        addMoney.setDisable(false);
    }
    public void onPay(ActionEvent actionEvent) {
        player1.addNumber(1);
        money.setText(player1.getNumber().toString());
    }

    public void onStart() {
        if(!init()) return;//проверка ликвидности
        view.setImage(new Image("мешочек.png"));//загрузка автомата
        action=new ActionChain(player1,view);//запуск механизма розыгрыша
    }

    public boolean init(){

        if(player1.getNumber()==0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Средств на счете недостаточно!");
            alert.show();
            action=null;
            view.setImage(new Image("монетка.png"));
            return false;
        }
        else return true;
    }

}
