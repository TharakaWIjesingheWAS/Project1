package business.custom.impl;

import business.custom.MemberBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.MemberDAO;
import entity.Member;
import util.MemberDetailsTM;

import java.util.ArrayList;
import java.util.List;

public class MemberBOImpl implements MemberBO {

    private MemberDAO memberDAO = DAOFactory.getInstance().getDAO(DAOType.Member);

    public List<MemberDetailsTM> getAllMembers() throws Exception{
        List<Member> allMembers = memberDAO.findAll();
        List<MemberDetailsTM> members = new ArrayList<>();
        for (Member member: allMembers){
            members.add(new MemberDetailsTM(member.getId(),member.getNic(),member.getName(),member.getAddress(),member.getContact()));
        }
        return members;
    }

    public boolean saveMember(String id,String name ,String nic, String address, String contact) throws Exception{
        return memberDAO.save(new Member(id,name,nic,address,contact));
    }

    public boolean deleteMember(String memberId) throws Exception{
        return memberDAO.delete(memberId);
    }

    public boolean updateMember(String nic,String name , String address, String contact, String id) throws Exception{
        return memberDAO.update(new Member(id,nic,name,address,contact));
    }

    public String getNewMemberID() throws Exception{
        String lastMemberId= memberDAO.getLastMemberId();
        if (lastMemberId == null){
            return "M001";
        }else {
            int maxId = Integer.parseInt(lastMemberId.replace("M",""));
            maxId = maxId+1;
            String id = "";
            if (maxId < 10) {
                id="M00" + maxId;
            } else if (maxId < 100) {
                id = "M0" + maxId;
            } else {
                id = "M" + maxId;
            }
            return id;
        }
    }
}
