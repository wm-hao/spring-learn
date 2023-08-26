package app.service;

import app.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhuhh
 * @since 2023年08月26日
 */
public interface AdminService extends IService<Admin> {
    boolean addNewAdmin(Admin admin) throws Exception;
}
