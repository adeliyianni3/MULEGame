package MULE.models;

import javafx.scene.image.Image;

/**
 * Created by Antonia on 11/27/2015.
 */
public class T_Mountain extends LandType {
    T_Mountain() {
        super(1.0, 1.0, 4.0, 1.0);
        setImage(new Image(getClass().getResource("/views/T.M.O.U.N.T.A.I.N..png").toString()));
    }
}
