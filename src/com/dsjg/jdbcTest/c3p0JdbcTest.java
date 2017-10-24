package com.dsjg.jdbcTest;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Test;

import com.dsjg.c3poUtils.C3p0Utils;

public class c3p0JdbcTest {

	// 测试
	// 增加
	// @Test
	public void insert() throws Exception {
		// 加载驱动
		// 得到连接

		Connection con = C3p0Utils.getConnection();
		// 准备sql语句
		String sql = "insert into student values(?,?,?,?)";
		// 创建预编译对象
		PreparedStatement pstm = con.prepareStatement(sql);
		// 设置sql里面的值(这个?叫做占位符)
		pstm.setInt(1, 55);
		pstm.setString(2, "秋香");
		pstm.setInt(3, 10);
		pstm.setString(4, "女");
		// 现在执行增加方法
		int n = pstm.executeUpdate();
		if (n > 0) {
			System.out.println("那么恭喜增加成功");
		} else {
			System.out.println("增加失败");
		}
		// 关闭连接
		C3p0Utils.release(con, pstm, null);

	}

	// 删除
	@Test
	public void delete() throws Exception {

		Connection conn = C3p0Utils.getConnection();
		// 准备sql语句
		String sql = "delete from student where sid = ?";

		PreparedStatement pstm = conn.prepareStatement(sql);

		// 设置值

		pstm.setInt(1, 22);
		int n = pstm.executeUpdate();
		if (n > 0) {
			System.out.println("删除成功");
		} else {
			System.out.println("删除失败");
		}
		// 关闭连接(释放资源)
		C3p0Utils.release(conn, pstm, null);
	}

}
