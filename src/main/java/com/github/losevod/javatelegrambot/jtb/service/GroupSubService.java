package com.github.losevod.javatelegrambot.jtb.service;

import com.github.losevod.javatelegrambot.jtb.javarushclient.dto.GroupDiscussionInfo;
import com.github.losevod.javatelegrambot.jtb.repository.entity.GroupSub;

/**
 * Service for manipulating with {@link GroupSub}
 */
public interface GroupSubService {
    GroupSub save(String chatId, GroupDiscussionInfo groupDiscussionInfo);
}
