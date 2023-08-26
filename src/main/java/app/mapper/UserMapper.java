package app.mapper;

import app.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

//@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
}
