import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Sample{  
	public static void main(String[] args) {
		Pattern p = Pattern.compile("X|Y");
		Matcher m = p.matcher("y");
		System.out.println(m.find());
//	p.pattern();
	}
}