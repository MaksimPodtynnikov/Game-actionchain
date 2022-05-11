package casino;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Optional;

public class PositiveHandler extends Handler{

    public PositiveHandler(Handler processor, Player player) {
        super(processor,player);
    }

    public boolean process(Integer request,ImageView img) {
        if(request!=SUCCESS) return super.process(request,img);// не свой запрос передается дальше по цепочке
        else {//свой, обрабатывается здесь
            img.setImage(new Image("win.png"));
            player1.addNumber(2);
                return true;
        }
    }
}
