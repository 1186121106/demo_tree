package com.example.demo_tree;

import com.example.demo_tree.entrity.TreeEntrity;
import com.example.demo_tree.mapper.TreeMapper;
import javafx.scene.Parent;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.security.util.Length;

import javax.annotation.Resource;
import java.util.*;

@RestController
public class TestController {

    @Resource
    TreeMapper treeMapper;

    @RequestMapping(value = "/test")
    public    List<TreeEntrity> test()
    {
        HashMap<String, TreeEntrity> maps =   treeMapper.selectList();

        Iterator<Map.Entry<String, TreeEntrity>> iterator = maps.entrySet().iterator();
        List<TreeEntrity>  list=new ArrayList<>();
        while (iterator.hasNext()){
            Map.Entry<String, TreeEntrity> next = iterator.next();
            TreeEntrity value = next.getValue();
            list.add(value);
        }

        List<TreeEntrity> treeEntrities = treeMapper.seleYj();

        List listdata=new ArrayList<TreeEntrity>();
            for (int j = 0; j < treeEntrities.size(); j++) {
                TreeEntrity parent = treeEntrities.get(j);
                aaa(parent,list);
            }

            return treeEntrities;

    }

    public void  aaa(TreeEntrity  parent,List<TreeEntrity> list) {

        for (int i = 0; i <list.size() ; i++) {
            TreeEntrity childen = list.get(i);
            if(parent.getId()==childen.getPid()){
                parent.getChildren().add(childen);
                aaa(childen,list);
            }
        }
    }
}
