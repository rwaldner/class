import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;


public class Main {

	public static void println (String str) {
		System.out.println(str);
	}

	public static void main (String[] args) throws IOException {
		Main m = new Main();
		m.run();
	}

	private SortedMap<String, String> getAsSortedMap (Properties props) {
		SortedMap<String,String> sortedProperties = new TreeMap<String,String>();
		for (final String name: props.stringPropertyNames()) {
			sortedProperties.put(name, props.getProperty(name));
		}
		return sortedProperties;
	}
	
	public void run () throws IOException {
		showTimeAndDate();
		showJdkOrJre();
		showLocaleInfo();
		showSystemProperties();
		showVersionInfo();
	}

	private void showJdkOrJre() {
		println("");
		println("JDK or JRE");
		println("------------");
		JavaCompiler c = ToolProvider.getSystemJavaCompiler();
		if (c == null) {
		    println("JRE");
		} else {
		    println("JDK");
		}
		
	}

	private void showTimeAndDate() {
		Date d = new Date();
	    DateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
	    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    DateFormat timeFormat = new SimpleDateFormat("HH:mm:ssZ");
		println("");
		println("Time and Date");
		println("------------");
		println("Date and Time: " + dateTimeFormat.format(d));
		println("Date: " + dateFormat.format(d));
		println("Time: " + timeFormat.format(d));
	}

	private void showVersionInfo() throws IOException {
		println("");
		println("Version info");
		println("------------");

		Properties versionProps = new Properties();
		InputStream in = getClass().getResourceAsStream("/version.properties");
		if (in != null) {
			versionProps.load(in);
			in.close();

			Set<String> versionPropKeys = versionProps.stringPropertyNames();
			Iterator<String> iter = versionPropKeys.iterator();
			while (iter.hasNext()) {
				String key = iter.next();
				String value = versionProps.getProperty(key);
				println(key + " = " + value);
			}
		} else {
			println("No version.properties file found");
		}
	}

	private void showSystemProperties() {
		println("");
		println("System Properties");
		println("-----------------");

		Properties props = System.getProperties();
		SortedMap<String,String> sortedSystemProperties = getAsSortedMap(props);
        Set<String> keySet = sortedSystemProperties.keySet();
        Iterator<String> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            String propertyName = iterator.next();
            String propertyValue = props.getProperty(propertyName);
            println(propertyName + ": " + propertyValue + "");
        }
	}

	private void showLocaleInfo() {
		println("");
		println("Locale info");
		println("-----------------");
		println("Default locale   = " + Locale.getDefault().toString());
		println("Country          = " + Locale.getDefault().getCountry());
		println("Display Country  = " + Locale.getDefault().getDisplayCountry());
		println("Language         = " + Locale.getDefault().getLanguage());
		println("Display Language = " + Locale.getDefault().getDisplayLanguage());
		println("Display Name     = " + Locale.getDefault().getDisplayName());
		println("Script           = " + Locale.getDefault().getScript());
		println("Display Script   = " + Locale.getDefault().getDisplayScript());
		println("ISO3 Country     = " + Locale.getDefault().getISO3Country());
		println("ISO3 Language    = " + Locale.getDefault().getISO3Language());
		println("LanguageTag      = " + Locale.getDefault().toLanguageTag());
	}
}
