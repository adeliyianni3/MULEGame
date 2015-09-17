/**
 * Created by Lauren on 9/16/2015.
 */
public class Town {

    private Store[][] stores = new Store[][];

    public Town(){
        stores[0][0]= new Store("store");
        stores[0][1]= new Store("pub");
        stores[1][0]= new Store("land office");
        stores[1][1]= new Store("assay office");
    }
    public Store whatStore(int row, int col){
        return stores[row][col];
    }

}
