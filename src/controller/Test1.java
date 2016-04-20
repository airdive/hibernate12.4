package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import orm.HibernateSessionFactory;
import orm.Userinfo;

public class Test1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Userinfo Userinfo = new Userinfo();
		Userinfo.setUsername("gaohongyan");
		Userinfo.setPassword("mypassword");
		Userinfo.setAge(50l);

		// 使用Hibernate对象将要持久化实体类对象
		HibernateSessionFactory.getSession().beginTransaction();
		// 保存实体类以将这个实体类通过hibernate映射机制转成数据库中的一条记录
		HibernateSessionFactory.getSession().save(Userinfo);
		// 提交事务
		HibernateSessionFactory.getSession().getTransaction().commit();
		// 关闭Session，释放数据库的连接资源
		HibernateSessionFactory.getSession().close();

	}

}
