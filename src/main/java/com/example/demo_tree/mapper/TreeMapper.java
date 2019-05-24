package com.example.demo_tree.mapper;

import com.example.demo_tree.entrity.TreeEntrity;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface TreeMapper {

    @MapKey("id")
    HashMap<String, TreeEntrity> selectList();

    List<TreeEntrity>  seleYj();
}
