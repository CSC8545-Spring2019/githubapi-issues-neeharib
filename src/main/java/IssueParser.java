import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class IssueParser {
    public List<Issue> parseIssues(String s) {
        List<Issue> issues = new ArrayList<Issue>();
        Type listType = new TypeToken<ArrayList<Issue>>() {
        }.getType();
        try {
            issues = new Gson().fromJson(s, listType);
        } catch (Exception e) {
            System.out.println("Invalid Response from GitHubRestClient");
        }
        return issues;
    }
}
