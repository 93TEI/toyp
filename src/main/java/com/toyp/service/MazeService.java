package com.toyp.service;

import com.toyp.domain.Posts.Maze;
import com.toyp.domain.Posts.MazeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Queue;

@RequiredArgsConstructor
@Service
public class MazeService {

    private final MazeRepository mr;

    public int[][] createMaze(int n, int m, String name){
        class Location{
            int row, col;
            Location(int row, int col){
                this.row = row;
                this.col = col;
            }
        }

        int[][] graph = new int[n][m];
        int[][] visited = new int[n][m];
        int[] xArr = {1,0,-1,0};
        int[] yArr = {0,1,0,-1};
        int cnt = 0;

        // 향해 좌표의 확률 정해주기
        for(int i =0; i< n; i++){
            for(int j=0; j<m; j++){
                graph[i][j] = (int) (Math.random()*10 >= 4 ? 1 : 0);
            }
        }
        // 시작점 출항 확률 정해주기
        graph[0][0] = (int)(Math.random()*10 >= 3 ? 1 : 0);

        Queue<Location> q = new LinkedList<>();
        if(graph[0][0] == 1) {
            q.add(new Location(0, 0));
            visited[0][0] = 1;
        }else{
            System.out.println("시작도 못하고 가라앉은 배...");
            return graph;
        }

        while(!q.isEmpty()){
            Location curLoc = q.poll();

            for(int i=0;i<4;i++){
                if(curLoc.row + xArr[i] >= 0 && curLoc.row + xArr[i] < n && curLoc.col + yArr[i] >= 0 && curLoc.col +yArr[i] < m){
                    if (graph[curLoc.row + xArr[i]][curLoc.col + yArr[i]] != 0 && visited[curLoc.row + xArr[i]][curLoc.col + yArr[i]] != 1){
                        q.add(new Location(curLoc.row + xArr[i],curLoc.col + yArr[i]));
                        graph[curLoc.row + xArr[i]][curLoc.col + yArr[i]] = graph[curLoc.row][curLoc.col] + 1 ;
                        visited[curLoc.row + xArr[i]][curLoc.col + yArr[i]] = 1;
                        cnt = graph[curLoc.row + xArr[i]][curLoc.col + yArr[i]];
                    }
                }
            }
        }
        System.out.println("향해한 기간 : "+cnt+"일");

        mr.save(new Maze(name,n,m,cnt));

        return graph;
    }
}
