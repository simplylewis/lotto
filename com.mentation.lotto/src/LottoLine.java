import java.util.Iterator;
import java.util.TreeSet;


class LottoLine extends SomeLine
{
    private TreeSet<Integer> _numbers;
    LottoLine(AllLines balls)
    {
        _numbers = new TreeSet<Integer>();
        
        balls.populate(_numbers);
        
    } // OneLine

    public String toString()
    {
        StringBuffer buf = new StringBuffer();

        Iterator<Integer> it = _numbers.iterator();
        
        while (it.hasNext())
        {
            buf.append(numAsString(it.next()));
        }

        return buf.toString();
    } // toString

}