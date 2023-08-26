package app.mapper;

import app.entity.Orders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhuhh
 * @since 2023年08月26日
 */
@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {

}
