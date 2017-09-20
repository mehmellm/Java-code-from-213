package animals;

public abstract class PenguinImple implements Animal, Penguin {
	public void eat() {
		System.out.println( "I'm a penguin and I eat fish");
	}
	public void sleep() 
	{
		System.out.println( "I'm a lion and I sleep in the cold" );
		
	}
	public void waddle()
	{
		System.out.println( "I'm a penguin and I waddle around in the cold" );
	}
	
}
