package com.Bernie;

import com.Bernie.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * create by: Bernie
 * description: StudentMapperTest
 * create time: 2020/10/20 23:07
 */
public class StudentMapperTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws IOException {
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml"));
    }

    @Test
    public void showDefaultCacheConfiguration() {
        System.out.println("本地缓存范围：" + sqlSessionFactory.getConfiguration().getLocalCacheScope());
        System.out.println("二级缓存是否启用：" + sqlSessionFactory.getConfiguration().isCacheEnabled());
    }

    /**
     *   <setting name="localCacheScope" value="SESSION"/>
     *   <setting name="cacheEnabled" value="true"/>
     * @throws Exception
     */
    @Test
    public void testLocalCache() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession(); // 自动提交事务
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        System.out.println(studentMapper.getStudentById(1));
        System.out.println(studentMapper.getStudentById(1));
        System.out.println(studentMapper.getStudentById(1));

        sqlSession.close();
    }
}
