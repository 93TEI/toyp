package com.toyp.web.Dto;

import com.toyp.domain.Posts.Maze;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MazeDto {
    private String name;
    private int row;
    private int col;
    private int day;
    // date 구현할 것

    @Builder
    public MazeDto(String name, int row, int col, int day){
        this.name = name;
        this.row = row;
        this.col = col;
        this.day = day;
    }

    public Maze toEntity(){
        return Maze.builder()
                .name(name)
                .row(row)
                .col(col)
                .day(day).build();
    }
}
