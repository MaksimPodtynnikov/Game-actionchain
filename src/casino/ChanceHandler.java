package casino;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Optional;

public class ChanceHandler extends Handler{
    public ChanceHandler(Handler processor, Player player) {
        super(processor, player);
    }
    public boolean process(Integer request, ImageView img) {
        if(request!=CHANCE) return super.process(request,img);// не свой запрос передается дальше по цепочке
        else {//свой, обрабатывается здесь
            img.setImage(new Image("chance.jpg"));
            player1.addNumber(1);
                return true;

        }
    }
}
