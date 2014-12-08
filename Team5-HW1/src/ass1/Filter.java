package ass1;

public class Filter {
	
	static public String cleanParameter(String value) {
		   if (value != null) {
		      value = value.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
		      value = value.replaceAll("\\(", "&#40;").replaceAll("\\)", "&#41;");
		      value = value.replaceAll("\"", "&quot;").replaceAll("&", "&amp;");
		      value = value.replaceAll("#", "&#35;");
		      value = value.replaceAll("'", "&#39;");
		      value = value.replaceAll("eval\\((.*)\\)", "");
		      value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
		   }
		   return value;
		}
}
