import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class IssueParser {
    public List<Issue> parseIssues(String s) {
        Type listType = new TypeToken<ArrayList<Issue>>() {}.getType();
        List<Issue> issues = new Gson().fromJson(s, listType);
        return issues;
    }
}
