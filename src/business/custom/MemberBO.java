package business.custom;

import business.SuperBO;
import util.MemberDetailsTM;

import java.util.List;

public interface MemberBO extends SuperBO {

    public List<MemberDetailsTM> getAllMembers() throws Exception;

    public boolean saveMember(String id,String name ,String nic, String address, String contact) throws Exception;

    public boolean deleteMember(String memberId) throws Exception;

    public boolean updateMember(String nic,String name , String address, String contact, String id) throws Exception;
}
