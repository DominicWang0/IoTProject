package com.laurence0.mybatis.test;

import com.laurence0.mybatis.mapper.MajorMapper;
import com.laurence0.mybatis.pojo.Major;
import com.laurence0.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @version 1.0
 * @Author Dominic Wang
 * @Date 2024/5/23 10:02
 * @注释
 */
public class Test {
    @org.junit.Test
    public void testInsert() throws IOException {
        //获取配置文件的输入流
        InputStream is= Resources.getResourceAsStream("mybatis-config.xml");
        //获取SqlSessionFactory对象
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlsessonfactory=builder.build(is);
        //获取SqlSession对象
        SqlSession sqlSession=sqlsessonfactory.openSession();
        //获取Mapper中的代理实现类对象
        MajorMapper majormapper=sqlSession.getMapper(MajorMapper.class);
        int result=majormapper.insertMajor();
        System.out.println(result);
        //commit动作一定要有 否则 添加的数据会回滚 导致数据看不见 你以为是添加失败 其实是添加后数据撤回了
        sqlSession.commit();
        //关闭sqlsession对象
        sqlSession.close();
    }
    @org.junit.Test
    public void testUpdate(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        MajorMapper majormapper=sqlSession.getMapper(MajorMapper.class);
        majormapper.updateMajor();
        sqlSession.close();
    }
    @org.junit.Test
    public void testDelete(){
        SqlSession sqlSession=SqlSessionUtil.getSqlSession();
        MajorMapper majormapper=sqlSession.getMapper(MajorMapper.class);
        majormapper.deleteMajor();
        sqlSession.close();
    }
    @org.junit.Test
    public void testSelectOne(){
        SqlSession sqlSession=SqlSessionUtil.getSqlSession();
        MajorMapper majormapper=sqlSession.getMapper(MajorMapper.class);
        majormapper.selectOneMajor();
        sqlSession.close();
    }
    @org.junit.Test
    public void testSelectAll(){
        SqlSession sqlSession=SqlSessionUtil.getSqlSession();
        MajorMapper majormapper=sqlSession.getMapper(MajorMapper.class);
        List<Major> list=majormapper.selectAllMajor();
        list.stream().forEach(item -> System.out.println(item));
        sqlSession.close();
    }

}
