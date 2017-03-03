/**
 * Created by 00074567 on 2017/2/20.
 */

package algorithm;

public class FactoryHuman {
    static int mannumber  = 0;
    static int womannumber = 0;
    public Human creatHuman(char gender)
    {
        switch (gender)
        {
            case 'm':
                mannumber++;
                return new Human("m"+mannumber);
            case 'w':
                womannumber++;
                return new Human("w"+womannumber);
            default:
                break;
        }
        return new Human("");
    }
}
