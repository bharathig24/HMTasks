
public class CreateObjectForSingleton {

	public static void main(String[] args) {
//		Singleton s = new Singleton();     //Throw an error. Because we can't create object directly
		Singleton s = Singleton.createObj();
		System.out.println(s.sampleStr);
	}

}
