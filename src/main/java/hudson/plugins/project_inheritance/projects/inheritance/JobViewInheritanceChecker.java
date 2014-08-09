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

    /**
     * Checks if given URI is job main page or one of its specified subpages.
     */
    @Override
    public boolean isInheritanceRequired(String requestURI) {
        // just allow everything
        return true;
    }

}
