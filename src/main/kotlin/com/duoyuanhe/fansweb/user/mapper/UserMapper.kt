package com.duoyuanhe.fansweb.user.mapper

import com.duoyuanhe.fansweb.user.model.User
import com.duoyuanhe.fansweb.user.model.UserInfo
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update

@Mapper
interface UserMapper {
    /**
     * 插入用户信息
     * @param user 用户实体
     * @return 插入成功的记录数
     */
    @Insert("INSERT INTO user (phone_number, email, password) VALUES (#{phoneNumber}, #{email}, #{password})")
    fun insertUser(user: User): Int

    /**
     * 根据手机号查询用户
     * @param phone 手机号
     * @return 用户实体
     */
    @Select("SELECT id, email, phone_number as phoneNumber, password FROM user WHERE phone_number = #{phone}")
    fun findByPhone(phone: String): User?

    /**
     * 根据邮箱查询用户
     * @param email 邮箱
     * @return 用户实体
     */
    @Select("SELECT id, email, phone_number, password FROM user WHERE email = #{email}")
    fun findByEmail(email: String): User?

    @Update("UPDATE user SET avatar = #{avatar}, nickname = #{nickName}, bri = #{bri}, gender = #{gender}, address = #{address}, creator_id = #{creatorId} WHERE id = #{id}")
    fun save(userInfo: UserInfo, id: Int): Int
}