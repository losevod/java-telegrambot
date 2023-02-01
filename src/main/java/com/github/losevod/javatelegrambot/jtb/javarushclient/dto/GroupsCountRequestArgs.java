package com.github.losevod.javatelegrambot.jtb.javarushclient.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.nonNull;

/**
 * Request arguments for count group requests
 */
@Builder
@Getter
public class GroupsCountRequestArgs {

    private final GroupFilter filter;
    private final String query;
    private final GroupInfoType type;

    public Map populateQueries() {
        Map queries = new HashMap<>();
        if (nonNull(query)) {
            queries.put("query", query);
        }
        if (nonNull(filter)) {
            queries.put("filter", filter);
        }
        if (nonNull(type)) {
            queries.put("status", type);
        }
        return queries;
    }

}
