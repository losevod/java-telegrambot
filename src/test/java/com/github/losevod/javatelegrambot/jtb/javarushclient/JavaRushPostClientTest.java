package com.github.losevod.javatelegrambot.jtb.javarushclient;

import com.github.losevod.javatelegrambot.jtb.javarushclient.dto.PostInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("Integration-level testing for JavaRushPostClient")
class JavaRushPostClientTest {

    private final JavaRushPostClient postClient = new JavaRushPostClientImpl("https://javarush.com/api/1.0/rest");

    @Test
    public void shouldProperlyGetNew15Posts() {
        //when
        List<PostInfo> newPosts = postClient.findNewPosts(30, 2935);

        //then
        Assertions.assertEquals(15, newPosts.size());
    }
}
