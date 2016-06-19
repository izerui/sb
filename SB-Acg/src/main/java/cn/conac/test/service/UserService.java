package cn.conac.test.service;

import cn.conac.test.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.conac.test.dao.UserDao;
import com.sb.hyh.service.base.GenericService;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 */
@Service
@Transactional
public class UserService extends GenericService<User, Long> {

	@Autowired
	private UserDao userDao;

}
