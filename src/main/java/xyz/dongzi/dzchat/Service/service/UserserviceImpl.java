package xyz.dongzi.dzchat.Service.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import xyz.dongzi.dzchat.Service.Userservice;
import xyz.dongzi.dzchat.mapper.TbUserMapper;
import xyz.dongzi.dzchat.pojo.TbUser;
import xyz.dongzi.dzchat.pojo.TbUserExample;
import xyz.dongzi.dzchat.pojo.vo.User;

import java.util.List;

@Service
public class UserserviceImpl implements Userservice {

    @Autowired
    private TbUserMapper userMapper;

    @Override
    public User login(String username, String password) {
        // 校验
        if(StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)) {

            TbUserExample example = new TbUserExample();
            TbUserExample.Criteria criteria = example.createCriteria();

            criteria.andUsernameEqualTo(username);

            List<TbUser> userList = userMapper.selectByExample(example);
            if(userList != null && userList.size() == 1) {
                // 对密码进行校验
                String encodingPassword = DigestUtils.md5DigestAsHex(password.getBytes());
                if(encodingPassword.equals(userList.get(0).getPassword())) {
                    User user = new User();
                    BeanUtils.copyProperties(userList.get(0), user);
                    return user;
                }
            }
        }

        return null;
    }
}
