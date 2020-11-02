package com.cognizant.collector.gitlab.component;

import com.cognizant.collector.gitlab.clients.GitLabClient;
import com.cognizant.collector.gitlab.constants.Constants;
import com.cognizant.collector.gitlab.beans.common.GitlabProperties;
import feign.Response;
import feign.jackson.JacksonDecoder;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 784420 on 10/15/2019 2:28 PM
 */
@Component
@Slf4j
@AllArgsConstructor
public class GitLabCommonUtility {

    private final JacksonDecoder decoder = new JacksonDecoder();
    private final HttpHeaders headers = new HttpHeaders();
    private GitLabClient client;
    private GitlabProperties properties;

    @PostConstruct
    private void postConstructMethod() {
        headers.add(Constants.PRIVATE_TOKEN, properties.getToken());
    }

    /**
     * Getting the response for the {@code uri} full uri from the mentioned git lab client
     *
     * @param uri     full uri to get the response
     * @param type    return type of the body
     * @param headers headers for the request
     * @param <T>     return type
     * @return return the response with mentioned body type
     * @throws IOException if any issue, while parsing the response body. it will throw the exception
     */
    public <T> ResponseEntity<T> getResponse(URI uri, Type type, HttpHeaders headers) throws IOException {
        if (headers == null) headers = this.headers;
        Response response = client.getResponse(uri, headers);
        HttpHeaders httpHeaders = new HttpHeaders();
        response.headers().forEach((key, value) -> httpHeaders.put(key, new ArrayList<>(value)));
        T object = (T) decoder.decode(response, type);
        return ResponseEntity.status(response.status()).headers(httpHeaders).body(object);
    }

    /**
     * @param type            return type of the response body
     * @param projectNameOrId name or id of the project to get the commit details
     * @param branch          branch name
     * @param perPageCount    response per page count (GitLab will not allow more than 100)
     * @param pageNum         number of teh page to get response (if it > 1 it is applicable otherwise it wil get default response without page number)
     * @param since           since date to fetch commits from server
     * @param <T>             return type
     * @return return the response with mentioned body type
     * @throws IOException if any issue, while parsing the response body. it will throw the exception
     */
    public <T> ResponseEntity<T> getCommitResponse(Type type, Object projectNameOrId, String branch, int perPageCount, int pageNum, String since) throws IOException {
        Map<String, String> map = new HashMap<>();
        map.put(Constants.BRANCH_QUERY_PARAM_KEY, branch);
        map.put(Constants.PER_PAGE_QUERY_PARAM_KEY, String.valueOf(perPageCount));
        map.put(Constants.SINCE_QUERY_PARAM_KEY, since);
        if (pageNum > 1) map.put(Constants.PAGE_QUERY_PARAM_KEY, String.valueOf(pageNum));

        Response response = client.getCommits(projectNameOrId, headers, map);
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpStatus status = HttpStatus.resolve(response.status());
        response.headers().forEach((key, value) -> httpHeaders.put(key, new ArrayList<>(value)));
        T object = (T) decoder.decode(response, type);
        return new ResponseEntity(object, httpHeaders, status);
    }

    /**
     * @return http headers
     */
    public HttpHeaders getHeaders() {
        return headers;
    }
}
