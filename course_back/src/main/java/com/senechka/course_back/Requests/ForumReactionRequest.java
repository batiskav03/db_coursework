package com.senechka.course_back.Requests;

public class ForumReactionRequest {
    private Long forumId;
    private String reactionType; // Например, "like", "dislike"

    public Long getForumId() {
        return forumId;
    }

    public void setForumId(Long forumId) {
        this.forumId = forumId;
    }

    public String getReactionType() {
        return reactionType;
    }

    public void setReactionType(String reactionType) {
        this.reactionType = reactionType;
    }
} 