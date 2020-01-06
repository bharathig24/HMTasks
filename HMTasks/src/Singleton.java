
public class Singleton {
	private static Singleton obj = null;
	
	String sampleStr;
	private Singleton() {
		this.sampleStr = "Hello Singleton";
	}
	
	public static Singleton createObj() {
		if(obj == null) {
			obj = new Singleton();
			return obj;
		}
		return obj;
	}
}
