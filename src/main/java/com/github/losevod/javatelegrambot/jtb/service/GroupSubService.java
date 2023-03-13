package com.github.losevod.javatelegrambot.jtb.service;

import com.github.losevod.javatelegrambot.jtb.javarushclient.dto.GroupDiscussionInfo;
import com.github.losevod.javatelegrambot.jtb.repository.entity.GroupSub;

import java.util.List;
import java.util.Optional;

/**
 * Service for manipulating with {@link GroupSub}
 */
public interface GroupSubService {
    GroupSub save(String chatId, GroupDiscussionInfo groupDiscussionInfo);
    Optional<GroupSub> findById(Integer id);
    GroupSub save(GroupSub groupSub);
    List<GroupSub> findAll();
}
