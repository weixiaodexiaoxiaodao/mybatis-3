package org.apache.ibatis.study;

import org.apache.ibatis.BaseDataTest;
import org.apache.ibatis.domain.blog.Author;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import javax.sql.DataSource;
import java.io.Reader;
import java.util.List;

/**
 * @Author lixiang
 * @CreateTime 2019/9/25
 **/
public class StudyTest extends BaseDataTest {

  private static SqlSessionFactory sqlMapper;

  @BeforeAll
   void setup() throws Exception {
    createBlogDataSource();
    final String resource = "org/apache/ibatis/study/MapperConfig.xml";
    final Reader reader = Resources.getResourceAsReader(resource);
    sqlMapper = new SqlSessionFactoryBuilder().build(reader);
  }

  @Test
  public void testToken(){
    try {
      setup();
    } catch (Exception e) {
      e.printStackTrace();
    }
    //Configuration c = new Configuration();
    SqlSession session = sqlMapper.openSession();
    MyAuthorMapper mapper = session.getMapper(MyAuthorMapper.class);
    List<Author> allAuthor = mapper.getAllAuthor(1);
    System.out.println(allAuthor);
    session.close();

  }
}
