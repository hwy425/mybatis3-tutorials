package com.ricky.codelab.mybatis.sample;

import java.io.InputStream;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.ricky.codelab.mybatis.sample.model.Author;

public class AuthorMapperDemo {

	public static void main(String[] args) {
		
		String resource = "mybatis-config.xml";
		
		//使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = AuthorMapperDemo.class.getClassLoader().getResourceAsStream(resource);
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);

        SqlSession session = sessionFactory.openSession();
        try{
        	Author author = (Author) session.selectOne("com.ricky.codelab.mybatis.sample.AuthorMapper.selectUserById", 1);
            System.out.println(author);
        }finally{
            session.close();
        }
	}

}