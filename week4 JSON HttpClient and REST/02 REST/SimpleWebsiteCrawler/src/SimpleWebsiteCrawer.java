import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleWebsiteCrawer {
    public static void main(String[] args) throws Exception {
        // String url = args[1];
        // String needle = args[2];
        String url = "http://ebusiness.free.bg";
        //String needle = "Револвираща";
        String needle = "Аначков";

        ArrayList<String> visited = new ArrayList<String>();
        String website = "";
        int index = url.indexOf('/');
        if (index != -1)
            for (int i = 1; i < 3; i++)
                index = url.indexOf('/', index + 1);
        if (index != -1) {
            website = url.substring(index);
        }
        System.out.println(checkContainsNeedle(url, needle, visited, website));
    }
    
    

    private static String checkContainsNeedle(String url, String needle, ArrayList<String> visited, String website) {
        visited.add(url);
        URL page;
        StringBuffer response = new StringBuffer();
        try {
            page = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) page.openConnection();

            connection.setRequestMethod("GET"); // actually by default is 'GET'

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            // response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
        } catch (Exception e) {
        }

        if (response.toString().contains(needle)) {
            return url;
        } else {
            ArrayList<String> links = getAllLinks(response.toString());
            ArrayList<String> uniques = new ArrayList<String>();
            for (String u : links) {
                int index = u.indexOf('/');
                if (index != -1)
                    for (int i = 1; i < 3; i++)
                        index = u.indexOf('/', index + 1);
                String h = "";
                if (index != -1) {
                    h = u.substring(index);
                }
                if (h == website && !(visited.contains(u)))
                    uniques.add(u);
            }

            for (String u : uniques) {
                String result = checkContainsNeedle(u, needle, visited, website);
                if (result != "no")
                    return result; 
            }
            return "no";
        }
    }

    //
    private static ArrayList<String> getAllLinks(String content) {
        ArrayList<String> resultList = new ArrayList<>();
        String regex = "<a.*?href=\"((?!javascript).*?)\".*?>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            resultList.add(matcher.group(1));
        }
        return resultList;
    }
}
