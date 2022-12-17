package com.simpleboard.board.Response;

import com.simpleboard.board.Entity.BoardEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ViewResponse {

    private final String title;
    private final String content;

    public ViewResponse (BoardEntity board) {
        this.title = board.getTitle();
        this.content = board.getContent();
    }

    @Builder
    public ViewResponse (String title, String content) {
        this.title = title;
        this.content = content;
    }

}
