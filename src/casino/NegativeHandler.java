package casino;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Optional;

public class NegativeHandler extends Handler {
    public NegativeHandler(Handler processor, Player player) {
        super(processor,player);
    }

    public boolean process(Integer request,ImageView img) {
            img.setImage(new Image("fail.png"));
                return true;
    }
}
