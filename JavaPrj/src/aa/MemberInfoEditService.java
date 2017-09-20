package aa;

import java.util.List;


public class MemberInfoEditService {

   //화면이 로드될 때:
   public List<MemeberInfoEdit> getDogfoodList(){
      return getMemberList(1,"");
   }

   private List<MemeberInfoEdit> getMemberList(int i, String string) {
      return null;
   }
   
   //검색을 요청할 때:
   public List<MemeberInfoEdit> getDogfoodList(String title){
      return getMemberList(1,title);
   }
   
   //다음 페이지를 요청할 때:
   public List<MemeberInfoEdit> getDogfoodList(int page, String title){
      return getMemberList(1,title);
   }

   //최신순 정렬를 요청할 때:
   public List<MemeberInfoEdit> getDogfoodList(int page, String title, String orderCol, boolean asc){
      return null;

   }
      
/*   //과거순 정렬를 요청할 때:
   public List<MemeberInfoEdit> getDogfoodList(int page, String title, String orderCol, boolean desc){
      return null;

   }
   
   //가나다 정렬를 요청할 때:
   public List<MemeberInfoEdit> getDogfoodList(int page, String title, String orderCol, boolean abc){
      return null;

   }*/
    

}
