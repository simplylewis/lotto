import java.util.Iterator;
import java.util.TreeSet;


class EuroMillionsLine extends SomeLine
{
    private AllLines _theNumbers;
    private AllLines _theStars;
    private TreeSet<Integer> _theseNumbers;
    private TreeSet<Integer> _theseStars;
    
    EuroMillionsLine(AllLines theNumbers, AllLines theStars)
    {
        _theNumbers = theNumbers;
        _theStars   = theStars;
        
		_theseNumbers = populateLine(_theNumbers);
		_theseStars   = populateLine(_theStars);

    } // OneLine

	private TreeSet<Integer> populateLine(AllLines allLines) {
		TreeSet<Integer> ts = new TreeSet<Integer>();
		
		allLines.populate(ts);
		
		return ts;
	}

    public String toString()
    {
    	StringBuffer buf = new StringBuffer();
        Iterator<Integer> it = _theseNumbers.iterator();
        
        while (it.hasNext())
        {
            buf.append(numAsString(it.next()));
        }

        buf.append(" - ");
        
        it = _theseStars.iterator();
        
        while (it.hasNext())
        {
            buf.append(numAsString(it.next()));
        }
        
        return buf.toString();
    } // toString

}