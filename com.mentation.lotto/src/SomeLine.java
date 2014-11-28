class SomeLine {

	protected String numAsString(int num)
	{
		if (num < 10)
		{
			return " 0" + Integer.toString(num);
		}
		else
		{
			return " " + Integer.toString(num);
		}
	} // numAsString
	
	protected String numAsString(Integer num) {
		return numAsString(num.intValue());
	}

}
