package com.toyp.web;

import com.toyp.service.MazeService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MazeController {

    private final MazeService ms;

    @GetMapping("/maze")
    public int[][] maze(@RequestParam(value = "name") String name, @RequestParam("row") int row, @RequestParam("col") int col, Model model){
        // 미로 사이즈 input받아서 만들어주기
        // ex : http://localhost:8080/maze?name=Tei&row=9&col=10
        return ms.createMaze(row,col,name);
    }

}
