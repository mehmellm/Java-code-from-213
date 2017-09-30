package animals;

public class LionImpl implements Animal, Lion 
{
	@Override
	public void eat() {
		System.out.println( "I'm a lion and I eat meat");
	}
	@Override
	public void sleep() 
	{
		System.out.println( "I'm a lion and I sleep all day long" );
		
	}
	@Override
	public void roar()
	{
		System.out.println( "I'm a lion and HEAR ME ROAR" );
	}
	@Override
	public void beTheKing()
	{
		System.out.println( "I'm a lion and I'm the king of the jungle" );
	}
	
}

