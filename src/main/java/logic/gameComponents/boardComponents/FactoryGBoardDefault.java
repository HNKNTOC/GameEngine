package logic.gameComponents.boardComponents;


/**
 * Created by Nikita on 19.02.2016.
 */
public class FactoryGBoardDefault implements FactoryGBoard {
    @Override
    public GBoard createGBoard(int x,int y) {
        return new GBoard(x,y);
    }
}
