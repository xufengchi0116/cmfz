package com.baizhi.serviceImpl;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User selectUserById(String id) {
        User user = userDao.selectByPrimaryKey(id);
        return user;
    }

    //查询全部
    @Override
    public Map<String, Object> selectAll(Integer page, Integer rows) {
        Map<String, Object> map = new HashMap<>();

        Integer begin = (page - 1) * rows;
        List<User> list = userDao.selectAll(begin, rows);

        int count = userDao.count();
        map.put("page", page);
        map.put("rows", list);
        map.put("total", count % rows == 0 ? count / rows : count / rows + 1);
        map.put("records", count);
        return map;
    }

    //查询全部不分页
    public List<User> FindAll() {
        List<User> list = userDao.FindAll();
        return list;
    }
}
