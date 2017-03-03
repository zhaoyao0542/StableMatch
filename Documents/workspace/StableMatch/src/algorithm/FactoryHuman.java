/**
 * Created by 00074567 on 2017/2/20.
 */

package algorithm;

public class FactoryHuman {
    static int mannumber  = 0;
    static int womannuber = 0;
    public Human creatHuman(char gender)
    {
        switch (gender)
        {
            case 'm':
                mannumber++;
                return new Human("m"+mannumber);
            case 'w':
                womannuber++;
                return new Human("w"+womannuber);
            default:
                break;
        }
        return new Human("");
    }
}
