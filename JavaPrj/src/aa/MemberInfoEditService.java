package aa;

import java.util.List;


public class MemberInfoEditService {

   //ȭ���� �ε�� ��:
   public List<MemeberInfoEdit> getDogfoodList(){
      return getMemberList(1,"");
   }

   private List<MemeberInfoEdit> getMemberList(int i, String string) {
      return null;
   }
   
   //�˻��� ��û�� ��:
   public List<MemeberInfoEdit> getDogfoodList(String title){
      return getMemberList(1,title);
   }
   
   //���� �������� ��û�� ��:
   public List<MemeberInfoEdit> getDogfoodList(int page, String title){
      return getMemberList(1,title);
   }

   //�ֽż� ���ĸ� ��û�� ��:
   public List<MemeberInfoEdit> getDogfoodList(int page, String title, String orderCol, boolean asc){
      return null;

   }
      
/*   //���ż� ���ĸ� ��û�� ��:
   public List<MemeberInfoEdit> getDogfoodList(int page, String title, String orderCol, boolean desc){
      return null;

   }
   
   //������ ���ĸ� ��û�� ��:
   public List<MemeberInfoEdit> getDogfoodList(int page, String title, String orderCol, boolean abc){
      return null;

   }*/
    

}
