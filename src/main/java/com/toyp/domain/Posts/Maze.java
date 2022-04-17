package com.toyp.domain.Posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Maze {
    // 예약어가 같을 때 충돌이 일어난다. 컬럼의 이름을 유니크하게 해야함 겹치지 않게
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_m;

    private String name_m;

    private int row_m;

    private int col_m;

    private int day_m;

    @Builder
    public Maze(String name, int row, int col, int day){
        this.name_m = name;
        this.row_m = row;
        this.col_m = col;
        this.day_m = day;
    }

}
