class NumbersJudge
{
	public String numberJudge(Data data)
	{
		int hit = 0;
		int blow = 0;
		
		char[] gameNumbers = data.getGameNumbers();
		char[] inputNumbers = data.getInputNumbers();
		
		for(int i = 0; i < gameNumbers.length; i++)
		{
			for(int j = 0; j < inputNumbers.length; j++)
			{
				if(gameNumbers[i] == inputNumbers[j])
				{
					if(i == j)
					{
						hit++;
					}
					else{
						blow++;
					}
				}
			}
		}
		
		String answer;
		
		if(hit == 3)
		{
			answer = hit + "Hit!!";
		}
		else{
			answer = hit + "Hit-" + blow + "Blow";
		}
		return answer;
	}
}
