package com.simpleboard.board.Response;

import com.simpleboard.board.Entity.BoardEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ViewResponse {

    private final long seq;
    private final String title;
    private final String content;

    public ViewResponse (BoardEntity board) {
        this.seq = board.getSeq();
        this.title = board.getTitle();
        this.content = board.getContent();
    }

    @Builder
    public ViewResponse (long seq, String title, String content) {
        this.seq = seq;
        this.title = title;
        this.content = content;
    }

}
