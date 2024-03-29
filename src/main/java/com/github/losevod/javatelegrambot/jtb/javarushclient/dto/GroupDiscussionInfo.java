package com.github.losevod.javatelegrambot.jtb.javarushclient.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Group discussion info class.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class GroupDiscussionInfo extends GroupInfo{
    private UserDiscussionInfo userDiscussionInfo;
    private Integer commentsCount;
}
