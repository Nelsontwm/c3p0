package com.dsjg.jdbcTest;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Test;

import com.dsjg.c3poUtils.C3p0Utils;

public class c3p0JdbcTest {

	// ����
	// ����
	// @Test
	public void insert() throws Exception {
		// ��������
		// �õ�����

		Connection con = C3p0Utils.getConnection();
		// ׼��sql���
		String sql = "insert into student values(?,?,?,?)";
		// ����Ԥ�������
		PreparedStatement pstm = con.prepareStatement(sql);
		// ����sql�����ֵ(���?����ռλ��)
		pstm.setInt(1, 55);
		pstm.setString(2, "����");
		pstm.setInt(3, 10);
		pstm.setString(4, "Ů");
		// ����ִ�����ӷ���
		int n = pstm.executeUpdate();
		if (n > 0) {
			System.out.println("��ô��ϲ���ӳɹ�");
		} else {
			System.out.println("����ʧ��");
		}
		// �ر�����
		C3p0Utils.release(con, pstm, null);

	}

	// ɾ��
	@Test
	public void delete() throws Exception {

		Connection conn = C3p0Utils.getConnection();
		// ׼��sql���
		String sql = "delete from student where sid = ?";

		PreparedStatement pstm = conn.prepareStatement(sql);

		// ����ֵ

		pstm.setInt(1, 22);
		int n = pstm.executeUpdate();
		if (n > 0) {
			System.out.println("ɾ���ɹ�");
		} else {
			System.out.println("ɾ��ʧ��");
		}
		// �ر�����(�ͷ���Դ)
		C3p0Utils.release(conn, pstm, null);
	}

}
