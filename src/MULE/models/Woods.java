package MULE.models;

import javafx.scene.image.Image;

/**
 * Created by Antonia on 11/27/2015.
 */
public class Woods extends LandType {
    Woods() {
        super(1.0, 0.0, 0.0, 1.0, 3.0);
        setImage(new Image(getClass().getResource("/views/W.O.O.D.S..png").toString()));
    }
}
