package com.laurence0.mybatis.mapper;

import com.laurence0.mybatis.pojo.Major;

import java.util.List;

/**
 * @version 1.0
 * @Author Dominic Wang
 * @Date 2024/5/23 09:46
 * @注释
 */
public interface MajorMapper {

    int insertMajor();

    int deleteMajor();

    int updateMajor();

    Major selectOneMajor();

    List<Major> selectAllMajor();
}
