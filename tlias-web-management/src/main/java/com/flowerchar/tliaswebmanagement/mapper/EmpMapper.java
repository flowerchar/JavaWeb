package com.flowerchar.tliaswebmanagement.mapper;

import com.flowerchar.tliaswebmanagement.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    @Select("select count(*) from emp")
     Long count();


//    @Select("select * from emp limit #{start},#{pageSize}")
//     List<Emp> page(@Param("start") Integer start,@Param("pageSize") Integer pageSize);

    List<Emp> list(@Param("name") String name,@Param("gender") Short gender,@Param("begin") LocalDate begin,@Param("end") LocalDate end);

    void delete(@Param("ids") List<Integer> ids);

    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time)" +
            "values (#{username}, #{name}, #{gender} ,#{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    void insert(Emp emp);

    @Select("select * from emp where id=#{id}")
    Emp getById(Integer id);


    void update(Emp emp);

    @Select("select * from emp where username=#{username} and password=#{password}")
    Emp getByUsernameAndPassword(Emp emp);

    @Delete("delete from emp where dept_id=#{deptId}")
    void deleteByDeptId(Integer deptId);
}
