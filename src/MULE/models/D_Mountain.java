package MULE.models;

import javafx.scene.image.Image;

/**
 * Created by Antonia on 11/27/2015.
 */
public class D_Mountain extends LandType {
    D_Mountain(){
        super(1.0, 1.0, 3.0, 1.0, 0.0, 0.0);
        setImage(new Image(getClass().getResource("/views/D.M.O.U.N.T.A.I.N..png").toString()));
    }
}
