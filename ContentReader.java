
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;



public class ContentReader {

	public static void main(String args[]) {
		
       if(args.length!=2) {
			System.out.println("----\nInvalid Arguments: Plase use java ContentReader <URL> <htmlCssClassName>");
            System.out.println("For example:\njava ContentReader https://www.apple.com/mac/ chapternav-label");
            System.out.println("\t or\njava ContentReader https://www.apple.com/ipad/ chapternav-label\n\n\n");
            
			System.exit(0);
		}
			
		List<String> headerList = getTextForHtmlCssClass(args[0],args[1]);
		headerList.forEach(System.out::println);	
	}
	
	public static List<String> getTextForHtmlCssClass(String urlString, String htmlCssClass) {
		URL url=null;
		InputStream is = null;
		BufferedReader br=null;
		String line;
		List <String>headerList = new ArrayList<String>();

		try {
			url = new URL(urlString);
			is = url.openStream(); 
			br = new BufferedReader(new InputStreamReader(is));

			while ((line = br.readLine()) != null) {
				if (line.contains(htmlCssClass)) 
					headerList.add(line.replaceAll("\\<.*?>", "").trim());
				
			}
		} catch (MalformedURLException mue) {
			System.out.println("Invalid URL::"+mue.getMessage());			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (is != null)
					is.close();
			} catch (IOException ioe) {
				// nothing to see here
			}
		}
		return headerList;
	}
}
