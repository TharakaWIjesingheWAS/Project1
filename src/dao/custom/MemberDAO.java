package dao.custom;

import dao.CrudDAO;
import dao.SuperDAO;
import entity.Member;

import java.util.List;

public interface MemberDAO extends CrudDAO<Member,String> {

    List<Member> findAllMembers() throws Exception;
    boolean saveMember(Member memberDetails) throws Exception;
    boolean deleteMember(String memberId) throws Exception;
    boolean updateMember(Member memberDetails) throws Exception;
    String getLastMemberId() throws Exception;

}
