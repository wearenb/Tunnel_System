package com.example.tunnel.Dao;

public class RizhiDao {

/*粗略查询信息
    public Rizhi query(String tunnelname) {
        String sqlString = "SELECT * FROM 隧道日志";
        Connection connection =connect.getConnect() ;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        Rizhi log = null;
        try {
            preparedStatement = connection.prepareStatement(sqlString);
            preparedStatement.setString(1, name);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                log = new Rizhi();
                log.getName(name);
                log.getFenbu(rs.getString("password"));
               log.setGender(rs.getString("gender"));
               log.setBio(rs.getString("bio"));
                log.setAvatar(rs.getString("avatar"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeJDBC(rs, preparedStatement, connection);
        }

        back user;
    }*/
}
