
/*
 * © [2021] Cognizant. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http:www.apache.orglicensesLICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.cognizant.collector.gitlab.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

/*
 * Constants
 *
 * @author Cognizant
 */
public class Constants {
    private Constants() {}
    public static final String PRIVATE_TOKEN = "PRIVATE-TOKEN";
    public static final String SOURCE ="source_gitlab_";

    public static final int RESULTS_PER_PAGE = 100;
//    public static final String X_NEXT_PAGE = "X-Next-Page";
    public static final String BRANCH_QUERY_PARAM_KEY = "ref_name";
    public static final String PER_PAGE_QUERY_PARAM_KEY = "per_page";
    public static final String PAGE_QUERY_PARAM_KEY = "page";
    public static final String SINCE_QUERY_PARAM_KEY = "since";

//    public static final int STATIC_LEVEL = 3;
//    public static final int STATIC_LEVEL_1 = 1;
//    public static final int STATIC_MONTHS = 3;
    public static final List<String> STATIC_FIELDS = new ArrayList<>(Arrays.asList("projectName", "branchName", "committerEmail"));

    public static final String CHART_FIELD_NAME = "name";
//    public static final String CHART_FIELD_VALUE = "value";
//    public static final String CHART_FIELD_CHILDREN = "children";
    public static final String CHART_FIELD_ID = "id";
    public static final String CHART_FIELD_DATE = "date";
//    public static final String CHART_FIELD_SERIES = "series";
//    public static final String CHART_FIELD_DATE_FORMAT_YMD = "%Y-%m-%d";
//    public static final String CHART_FIELD_DATE_FORMAT_STRING = "dd/MM/yyyy";
//    public static final String UNDERSCORE_ID = "_id";
//    public static final String DOLLAR_ID_S = "$_id.%s";
//    public static final String DOLLAR = "$%s";

    public static final LinkedHashMap<String, Object> STATIC_BAR_CHART_MAP = new LinkedHashMap<String, Object>(){{
        put(CHART_FIELD_ID, "committerEmail");
        put(CHART_FIELD_NAME, "committerName");
        put(CHART_FIELD_DATE, "committedDate");
    }};

}
