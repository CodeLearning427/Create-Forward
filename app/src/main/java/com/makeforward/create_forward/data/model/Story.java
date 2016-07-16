package com.makeforward.create_forward.data.model;

public class Story {

    private String id;
    private String authorId;
    private String title;
    private String body;

    public Story() {
        this(null, null, null, null);
    }

    public Story(String authorId, String title, String body) {
        this(null, authorId, title, body);
    }

    public Story(String id, String authorId, String title, String body) {
        this.id = id;
        this.authorId = authorId;
        this.title = title;
        this.body = body;
    }


}
