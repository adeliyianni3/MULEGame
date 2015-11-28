package MULE.models;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by Antonia on 11/27/2015.
 */
public class River extends LandType {
    River() {
        super(4.0, 2.0, 0.0, 0.0, 0.0);
        setImage(new Image(getClass().getResource("/views/R.I.V.E.R..png").toString()));
    }
}
