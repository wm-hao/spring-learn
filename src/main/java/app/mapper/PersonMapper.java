package app.mapper;

import app.entity.Person;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhuhh
 * @since 2023年08月26日
 */
@Mapper
public interface PersonMapper extends BaseMapper<Person> {


    @Select("select * from person")
    @Results(id = "personMap",value ={
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "name",property = "name"),
            @Result(column = "age",property = "age"),
            @Result(column = "email",property = "email"),
            @Result(property = "orders",column = "id",
                    one = @One(select = "app.mapper.OrdersMapper.selectById",
                            fetchType = FetchType.LAZY))
    })
    List<Person> findAll();


}
