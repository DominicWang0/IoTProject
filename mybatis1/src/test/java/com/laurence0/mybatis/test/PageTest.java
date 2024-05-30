package com.laurence0.mybatis.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.laurence0.mybatis.mapper.MajorMapper;
import com.laurence0.mybatis.pojo.Major;
import com.laurence0.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @version 1.0
 * @Author Dominic Wang
 * @Date 2024/5/30 11:03
 * @注释
 */
public class PageTest {

    @Test
    public void testPage() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        MajorMapper mapper = sqlSession.getMapper(MajorMapper.class);
        Page<Object> page = PageHelper.startPage(2, 2);
        List<Major> list = mapper.selectAllMajor();
        PageInfo<Major> pageInfo = new PageInfo<>(list, 5);
        list.stream().forEach(System.out::println);
        System.out.println(pageInfo);
        sqlSession.close();
    }
}
