package animals;

public class PenguinImpl implements Animal, Penguin {
	@Override
	public void eat() {
		System.out.println( "I'm a penguin and I eat fish");
	}
	@Override
	public void sleep() 
	{
		System.out.println( "I'm a lion and I sleep in the cold" );
		
	}
	@Override
	public void waddle()
	{
		System.out.println( "I'm a penguin and I waddle around in the cold" );
	}
	
}