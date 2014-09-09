/*
 * Plik stworzony dnia 11 kwi 2014 przez krzysztofkos
 * 
 * Copyright ATREM S.A. ATREM 2014(C)
 */

package hudson.plugins.project_inheritance.projects.inheritance;

import hudson.Extension;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Extension
 public class JobViewInheritanceChecker extends RequestInheritanceChecker {
 
    private static final String JOB_MAIN_VIEW_REGEX        = ".*/job/[^/]+/";

    private static final String JOB_RUN_PAGE_REGEX         = "[0-9]+/.*";

    private static final String TEST_TREND_GRAPH_REGEX     = "test.*";

    private static final String FINDBUGS_TREND_GRAPH_REGEX = "findbugs.*";

    private static final String JACOCO_TREND_GRAPH_REGEX   = "jacoco.*";
    
    private static final String WARNINGS_GRAPH_REGEX   = "warnings.*";

    private static final String HTML_REPORT_REGEX   = "htmlReport.*";

    private static final String RELEASE_REGEX   = "release.*";

    private static final String EMAIL_TEMPLATE_TEST_REGEX   = "templateTest.*";

    public static final Pattern jobUriRegExp;

    static {
        StringBuilder regExpBuilder = new StringBuilder();
        regExpBuilder.append(JOB_MAIN_VIEW_REGEX);
        regExpBuilder.append("(");
        regExpBuilder.append(JOB_RUN_PAGE_REGEX);
        regExpBuilder.append("|");
        regExpBuilder.append(TEST_TREND_GRAPH_REGEX);
        regExpBuilder.append("|");
        regExpBuilder.append(FINDBUGS_TREND_GRAPH_REGEX);
        regExpBuilder.append("|");
        regExpBuilder.append(JACOCO_TREND_GRAPH_REGEX);
        regExpBuilder.append("|");
        regExpBuilder.append(WARNINGS_GRAPH_REGEX);
        regExpBuilder.append("|");
        regExpBuilder.append(HTML_REPORT_REGEX);
        regExpBuilder.append("|");
        regExpBuilder.append(RELEASE_REGEX);
        regExpBuilder.append("|");
        regExpBuilder.append(EMAIL_TEMPLATE_TEST_REGEX);
        regExpBuilder.append(")?");
        jobUriRegExp = Pattern.compile(regExpBuilder.toString());
    }

     /**
      * Checks if given URI is job main page or one of its specified subpages.
      */
    @Override
     public boolean isInheritanceRequired(String requestURI) {
        Matcher matcher = jobUriRegExp.matcher(requestURI);
        return matcher.matches();
    }
}
