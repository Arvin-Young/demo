package com.example.demo.dao;

import com.example.demo.domain.SeckillUser;
import org.apache.ibatis.annotations.*;

@Mapper
public interface SecKillUserDao {
    @Select("select * from seckill_user where id = #{id}")
    SeckillUser getByid(@Param("id") long id);

    @Update("update seckill_user set password = #{password} where id = #{id}")
    void update(SeckillUser toBeUpdate);

    @Insert("insert into seckill_user (`id`, `nickname`, `password`, `salt`) values (#{id}, #{nickname}, #{password}, #{salt})")
    void save(SeckillUser toBeSave);
}
