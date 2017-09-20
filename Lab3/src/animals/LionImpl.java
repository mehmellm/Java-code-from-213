package animals;

public abstract class LionImpl implements Animal, Lion {
	public void eat() {
		System.out.println( "I'm a lion and I eat meat");
	}
	public void sleep() 
	{
		System.out.println( "I'm a lion and I sleep all day long" );
		
	}
	public void roar()
	{
		System.out.println( "I'm a lion and HEAR ME ROAR" );
	}
	public void beTheKing()
	{
		System.out.println( "I'm a lion and I'm the king of the jungle" );
	}
	
}

