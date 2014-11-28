import java.util.Random;
import java.util.TreeSet;
import java.lang.Math;

@SuppressWarnings("serial")
class AllLines extends Random
{
	private int _availableNumbers[];
	private int _excludedFor = 1;
	private int _low;
	private int _high;
	private int _offset;
	private int _range;
	private int _howMany;
	
	/**
	 * @param howMany TODO
	 * @param _low
	 * @param _high
	 */
	public AllLines(int low, int high, int howMany) {
		super();
		_low    = low;
		_high   = high;
		_range  = _high - _low + 1;
		_offset = 1 + _low - 1;
		_availableNumbers = new int[_range];
		_howMany = howMany;
		
		int idx;

		for (idx = 0; idx < _availableNumbers.length; idx++)
		{
			_availableNumbers[idx] = 0;
		}
	}


	public void setExclusion(int excluded)
	{
		_excludedFor = excluded;
	} // setExclusion


	private void endOfTheLine()
	{
		int idx;

		for (idx = 0; idx < _availableNumbers.length; idx++)
		{
			_availableNumbers[idx] --;
		}
	} // endOfTheLine


	public int getNumber()
	{
		int num;

		while (true)
		{
			num = (int)Math.abs((nextLong() % _range)) + _offset;

			if (!isExcluded(num))
			{
				useNumber(num);

				// System.out.println("getNumber returned "+Integer.toString(num));

				return num;
			}
		}
	} // getNumber


	protected void useNumber(int num)
	{
		_availableNumbers[num - 1] = _excludedFor;
	} // useNumber


	protected boolean isExcluded(int num)
	{
		return (_availableNumbers[num - 1] > 0);
	} // isExcluded


	public int getRange() {
		return _range;
	}


	public int getHowMany() {
		return _howMany;
	}


	public void populate(TreeSet<Integer> numbers) {
		for (int idx = 0; idx < getHowMany(); idx++)
        {
            numbers.add(new Integer(getNumber()));
        }

        endOfTheLine();
	}

} // AllLInes
