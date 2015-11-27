package MULE.models;

import javafx.scene.image.Image;

/**
 * Created by Antonia on 11/27/2015.
 */
public class Mountain extends LandType {
    Mountain() {
        super(1.0, 1.0, 2.0, 1.0);
        setImage(new Image(getClass().getResource("/views/M.O.U.N.T.A.I.N..png").toString()));
    }
}
