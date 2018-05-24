package wxgaly.example.springboot.mapper;

import wxgaly.example.springboot.pojo.SysUser;

import java.util.List;


public interface SysUserMapperCustom {

    List<SysUser> queryUserSimplyInfoById(String id);
}