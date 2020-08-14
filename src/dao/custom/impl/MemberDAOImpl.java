package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.MemberDAO;
import dbConnection.DBConnection;
import entity.Member;
import util.MemberDetailsTM;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAOImpl implements MemberDAO {

        @Override
        public String getLastMemberId() throws Exception{
            ResultSet rst = CrudUtil.execute("SELECT *FROM Member ORDER BY member_id DESC LIMIT 1");
            if (rst.next()){
                return rst.getString(1);
            }else {
                return null;
            }
    }

    @Override
    public List<Member> findAll() throws Exception{
            ResultSet rst = CrudUtil.execute("SELECT * FROM Member");
            ArrayList<MemberDetailsTM> members = new ArrayList<>();
            while (rst.next()){
                members.add(new MemberDetailsTM(rst.getString(1),
                        rst.getString(2),
                        rst.getString(3),
                        rst.getString(4),
                        rst.getString(5)));
            }
        return null;
    }

    @Override
    public Member find(String key) throws Exception {
        return null;
    }

    @Override
    public boolean save(Member entity) throws Exception {
        return false;
    }

    @Override
    public boolean update(Member entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String key) throws Exception {
        return false;
    }

    @Override
    public List<Member> findAllMembers() throws Exception {
        return null;
    }

    @Override
    public boolean saveMember(Member memberDetails) throws Exception{
            return CrudUtil.execute("INSERT INTO Member VALUES (?,?,?,?,?)",memberDetails.getId(),memberDetails.getName(),memberDetails.getNic(),memberDetails.getAddress(),memberDetails.getContact());
    }

    @Override
    public boolean deleteMember(String memberId) throws Exception{
            return CrudUtil.execute("DELETE FROM Member WHERE id=?") ;
    }

    @Override
    public boolean updateMember(Member memberDetails) throws Exception{
            return CrudUtil.execute("UPDATE Member SET nic=?,name=?,address=?,contact=?,WHERE id=?");
    }
}
