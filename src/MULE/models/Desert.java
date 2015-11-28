package MULE.models;

import javafx.scene.image.Image;

/**
 * Created by Antonia on 11/27/2015.
 */
public class Desert extends LandType {
    Desert() {
        super(0.0, 0.0, 1.0, 0.0, 0.0);
        setImage(new Image(getClass().getResource("/views/D.E.S.E.R.T..png").toString()));
    }
}
