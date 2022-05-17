package xyz.dongzi.dzchat.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 返回给用户的类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String id;

    private String username;

    private String picSmall;

    private String picNormal;

    private String nickname;

    private String qrcode;

    private String clientId;

    private String sign;

    private Date createtime;

    private String phone;
}
