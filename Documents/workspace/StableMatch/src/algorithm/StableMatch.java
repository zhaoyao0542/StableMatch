/**
 * 
 * @author zhaoyao
 *
 */

package algorithm;
import java.util.*;

/**
 * 类StableMatch包含男人与女人的信息列表，及长度n
 * 构造函数的入参需要提供上述信息
 * 
 * @version 1.0 1 Mar 2017
 * @author 	zhao yao
 */
public class StableMatch {
    public Map<String, Human> manlist;
    public Map<String, Human> womanlist;
    public int n;

    public StableMatch(Map<String, Human> manlist, Map<String, Human> womanlist,int n)
    {
        this.manlist = manlist;
        this.womanlist = womanlist;
        this.n = n;
    };
//  实现算法的执行过程
    public void exe()
    {
        Queue<String> freeman = new LinkedList<String>();
        Iterator<Map.Entry<String, Human>> it = this.manlist.entrySet().iterator();
//      初始化男人队列，刚开始都是自由的
        while(it.hasNext())
        {
            Map.Entry<String, Human> entry = (Map.Entry<String, Human>)it.next();
            freeman.add(entry.getKey());      //返回对应的键
        }
//      实现稳定匹配算法
        while (!freeman.isEmpty())
        {
//            从队列头取出第一个男人名，在map中找到信息
            String name = freeman.element();
            Human man = manlist.get(name);
            if (man.isfree)
            {

//              从其中意的女人名单中依次找非单身的date
                while(man.it_expect.hasNext())
                {
                    Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>)man.it_expect.next();
                    Human woman = womanlist.get(entry.getKey());
                    if (woman.isfree)
                    {
                        woman.date(man.name);
                        man.date(woman.name);
                        freeman.remove();
                        break;
                    }
                    else
                    {
//                        查看此人的排名是否比在约对象高
                        Human dateman = manlist.get(woman.company);
                        Map<String, Integer> womanexpectlist = woman.getexpectlist();

                        if (womanexpectlist.get(man.name) > womanexpectlist.get(dateman.name))
                        {
                            woman.part(dateman.name);
                            dateman.part(woman.name);
                            freeman.add(dateman.name);
                            woman.date(man.name);
                            man.date(woman.name);
                            freeman.remove();
                            break;
                        }

                    }

                }

            }
        }
    }
    public void printResult()
    {
        Iterator<Map.Entry<String, Human>> it = this.manlist.entrySet().iterator();
//      打印出男人以及其伴侣
        while(it.hasNext())
        {
            Map.Entry<String, Human> entry = (Map.Entry<String, Human>)it.next();
            System.out.println(entry.getValue().name+"<--->"+entry.getValue().company);      //返回对应的键
        }
        
    }
}
