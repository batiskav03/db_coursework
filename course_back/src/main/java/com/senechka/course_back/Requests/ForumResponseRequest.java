package com.senechka.course_back.Requests;

public class ForumResponseRequest {
    private Long forumId;
    private String responseContent;

    public Long getForumId() {
        return forumId;
    }

    public void setForumId(Long forumId) {
        this.forumId = forumId;
    }

    public String getResponseContent() {
        return responseContent;
    }

    public void setResponseContent(String responseContent) {
        this.responseContent = responseContent;
    }
} 