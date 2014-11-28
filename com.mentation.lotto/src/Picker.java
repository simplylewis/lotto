import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * The Picker class provides the mechanisms to select a subset
 * of size n distinct Integers from a source set of Integers.
 * Once a subset has been chosen this is removed from the source
 * set.
 * 
 * The source set can have additional sets added to it.
 *  
 * @author lewisf
 */
public class Picker {
	private TreeSet <Integer> _numbers = new TreeSet <Integer> ();
	
	public Picker(TreeSet <Integer> numbers ) {
		addNumbers(numbers);
	}

	public void addNumbers(Set <Integer> numbers) {
		_numbers.addAll(numbers);
	}
	
	public Set <Integer> pick(int count)
	throws LottoException {

		if (_numbers.size() < count) {
			throw new LottoException("Not enought numbers available");
		}
		
		TreeSet <Integer> picked = new TreeSet <Integer> ();
		Random random  = new Random();
		
		while (count > 0) {
			int nextNumber = random.nextInt(_numbers.size());
			
			Iterator<Integer> it = _numbers.iterator();

			Integer aNumber = null;
			
			while (it.hasNext() && nextNumber >= 0) {
				aNumber = it.next();
				nextNumber --;
			}
			
			_numbers.remove(aNumber);
			picked.add(aNumber);
			
			count --;
		}
		
		return picked;
	}
	
	public static void main(String[] args) {
		int lineCount = 1;
		
		if (args.length > 0) {
			lineCount = Integer.parseInt(args[0]);
		}
		
		TreeSet <Integer> numbers = new TreeSet <Integer> ();
		
		for (int i = 1; i < 46; i++) {
			numbers.add(new Integer(i));
		}
		
		Picker picker = new Picker(numbers);
		
		for (int i = 0; i < lineCount; i++) {
			try {
				System.out.println(picker.pick(6));
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
