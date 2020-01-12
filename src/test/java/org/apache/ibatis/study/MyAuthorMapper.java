package org.apache.ibatis.study;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.domain.blog.Author;

import java.util.List;

/**
 * @Author lixiang
 * @CreateTime 2019/9/25
 **/
public interface MyAuthorMapper {

  List<Author> getAllAuthor (@Param("id") int id);
}
